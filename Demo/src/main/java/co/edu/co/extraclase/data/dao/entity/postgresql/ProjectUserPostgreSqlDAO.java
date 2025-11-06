package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.data.dao.entity.ProjectUserDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ProjectEntity;
import co.edu.co.extraclase.entity.ProjectUserEntity;
import co.edu.co.extraclase.entity.UserEntity;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class ProjectUserPostgreSqlDAO extends SqlConnection implements ProjectUserDAO {

	public ProjectUserPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final ProjectUserEntity entity) {
		final var sql = new StringBuilder();
		sql.append("INSERT INTO \"ProyectoUsuario\" (\"id\", \"idProyecto\", \"idUsuario\") ");
		sql.append("VALUES (?, ?, ?) ");

		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getProject().getId());
			preparedStatement.setObject(3, entity.getUser().getId());
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_USER_REGISTRATION_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT_USER_REGISTRATION_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_USER_REGISTRATION_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT_USER__REGISTRATION_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public List<ProjectUserEntity> findByFilter(final ProjectUserEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);

		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			for (int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index + 1, parametersList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_USER_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_USER_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_USER_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	private String createSentenceFindByFilter(final ProjectUserEntity filterEntity, final List<Object> parametersList) {
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  PU.\"id\" AS \"idPU\", ");
		sql.append("  P.\"id\" AS \"idProyecto\", P.\"nombre\" AS \"nombreProyecto\", P.\"descripcion\" AS \"descripcionProyecto\", ");
		sql.append("  U.\"id\" AS \"idUsuario\", U.\"nombre\" AS \"nombreUsuario\", U.\"correo\" AS \"correoUsuario\" ");
		sql.append("FROM \"ProyectoUsuario\" AS PU ");
		sql.append("INNER JOIN \"Proyecto\" AS P ON PU.\"idProyecto\" = P.\"id\" ");
		sql.append("INNER JOIN \"Usuario\" AS U ON PU.\"idUsuario\" = U.\"id\" ");

		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
											   final ProjectUserEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProjectUserEntity());
		final var conditions = new ArrayList<String>();

		if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId())) {
			conditions.add("PU.\"id\" = ?");
			parametersList.add(filterEntityValidated.getId());
		}

		if (filterEntityValidated.getProject() != null &&
				!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProject().getId())) {
			conditions.add("PU.\"idProyecto\" = ?");
			parametersList.add(filterEntityValidated.getProject().getId());
		}

		if (filterEntityValidated.getUser() != null &&
				!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getUser().getId())) {
			conditions.add("PU.\"idUsuario\" = ?");
			parametersList.add(filterEntityValidated.getUser().getId());
		}

		if (!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}

	private List<ProjectUserEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listProjectUser = new ArrayList<ProjectUserEntity>();

		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				var projectUser = new ProjectUserEntity();

				projectUser.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPU")));

				var project = new ProjectEntity();
				project.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idProyecto")));
				project.setName(resultSet.getString("nombreProyecto"));
				project.setDescription(resultSet.getString("descripcionProyecto"));
				projectUser.setProject(project);

				var user = new UserEntity();
				user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idUsuario")));
				user.setUsername(resultSet.getString("nombreUsuario"));
				user.setEmail(resultSet.getString("correoUsuario"));
				projectUser.setUser(user);

				listProjectUser.add(projectUser);
			}
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_USER_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_USER_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_USER_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}

		return listProjectUser;
	}

	@Override
	public void update(final ProjectUserEntity entity) {
		final var sql = new StringBuilder();
		sql.append("UPDATE \"ProyectoUsuario\" ");
		sql.append("SET \"idProyecto\" = ?, \"idUsuario\" = ? ");
		sql.append("WHERE \"id\" = ? ");

		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setObject(1, entity.getProject().getId());
			preparedStatement.setObject(2, entity.getUser().getId());
			preparedStatement.setObject(3, entity.getId());
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_USER_UPDATE_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT_USER_UPDATE_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_USER_UPDATE_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT_USER__UPDATE_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public ProjectUserEntity findById(final UUID id) {
		return findByFilter(new ProjectUserEntity(id)).stream().findFirst().orElse(new ProjectUserEntity());
	}
}