package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.data.dao.entity.ProjectDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ProjectEntity;
import co.edu.co.extraclase.entity.ProjectStatusEntity;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class ProjectPostgreSqlDAO extends SqlConnection implements ProjectDAO {

	public ProjectPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<ProjectEntity> findByFilter(final ProjectEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);

		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
			for (int index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
		} catch (final ExtraClaseException exception) {
			throw exception;
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	private String createSentenceFindByFilter(final ProjectEntity filterEntity, final List<Object> parameterList) {
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  P.\"id\" AS \"idP\", ");
		sql.append("  P.\"nombre\" AS \"nombreP\", ");
		sql.append("  P.\"descripcion\" AS \"descripcionP\", ");
		sql.append("  P.\"fechaCreacion\" AS \"fechaCreacionP\", ");
		sql.append("  EP.\"id\" AS \"idEP\", ");
		sql.append("  EP.\"nombre\" AS \"nombreEP\", ");
		sql.append("  EP.\"descripcion\" AS \"descripcionEP\" ");
		sql.append("FROM \"Proyecto\" AS P ");
		sql.append("INNER JOIN \"EstadoProyecto\" AS EP ON P.\"estadoProyecto\" = EP.\"id\" ");

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);

		return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
											   final ProjectEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProjectEntity());
		final var conditions = new ArrayList<String>();

		addCondition(conditions, parameterList,
				!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"P.\"id\" = ", filterEntityValidated.getId());

		addCondition(conditions, parameterList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"P.\"nombre\" = ", filterEntityValidated.getName());

		addCondition(conditions, parameterList,
				filterEntityValidated.getProjectStatus() != null
						&& !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProjectStatus().getId()),
				"EP.\"id\" = ", filterEntityValidated.getProjectStatus().getId());

		if (!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}

	private void addCondition(final List<String> conditions, final List<Object> parameterList, final boolean condition,
							  final String clause, final Object value) {
		if (condition) {
			conditions.add(clause + " ?");
			parameterList.add(value);
		}
	}

	private List<ProjectEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listProject = new ArrayList<ProjectEntity>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				var projectStatus = new ProjectStatusEntity();
				projectStatus.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idEP")));
				projectStatus.setName(resultSet.getString("nombreEP"));
				projectStatus.setDescription(resultSet.getString("descripcionEP"));

				var project = new ProjectEntity();
				project.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idP")));
				project.setName(resultSet.getString("nombreP"));
				project.setDescription(resultSet.getString("descripcionP"));
				project.setCreationDate(resultSet.getTimestamp("fechaCreacionP").toLocalDateTime());
				project.setProjectStatus(projectStatus);
				listProject.add(project);
			}
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
		return listProject;
	}


	@Override
	public void create(final ProjectEntity entity) {
		final var sql = new StringBuilder();
		sql.append("INSERT INTO \"Proyecto\" (\"id\", \"nombre\", \"descripcion\", \"fechaCreacion\", \"estadoProyecto\") ");
		sql.append("VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?) ");
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setString(2, entity.getName());
			preparedStatement.setString(3, entity.getDescription());
			preparedStatement.setObject(4, entity.getProjectStatus().getId());
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_REGISTRATION_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT_REGISTRATION_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_REGISTRATION_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT__REGISTRATION_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public void update(final ProjectEntity entity) {
		final var sql = new StringBuilder();
		sql.append("UPDATE \"Proyecto\" ");
		sql.append("SET \"nombre\" = ?, \"descripcion\" = ?, \"estadoProyecto\" = ? ");
		sql.append("WHERE \"id\" = ? ");

		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setObject(3, entity.getProjectStatus().getId());
			preparedStatement.setObject(4, entity.getId());
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_UPDATE_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT_UPDATE_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_PROJECT_UPDATE_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROJECT__UPDATE_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public ProjectEntity findById(final UUID id) {
		return findByFilter(new ProjectEntity(id)).stream().findFirst().orElse(new ProjectEntity());

	}
}
