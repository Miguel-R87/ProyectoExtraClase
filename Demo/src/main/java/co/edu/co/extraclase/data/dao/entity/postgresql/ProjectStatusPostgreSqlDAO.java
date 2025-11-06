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
import co.edu.co.extraclase.data.dao.entity.ProjectStatusDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ProjectStatusEntity;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class ProjectStatusPostgreSqlDAO extends SqlConnection implements ProjectStatusDAO {

	public ProjectStatusPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<ProjectStatusEntity> findByFilter(final ProjectStatusEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		try (var preparedStaement = this.getConnection().prepareStatement(sql)){
			for(int index = 0; index < parameterList.size(); index++){
				preparedStaement.setObject(index+1, parameterList.get(index));
			}
			return executeSentenceFindByFilter(preparedStaement);
		} catch (final ExtraClaseException exception){
			throw exception;
		} catch(final SQLException exception){
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_STATUS_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_STATUS_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_STATUS_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_STATUS_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	private String createSentenceFindByFilter(final ProjectStatusEntity filterEntity, final List<Object> parametersList) {
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  PS.\"id\" AS \"idPS\", ");
		sql.append("  PS.\"nombre\" AS \"nombrePS\", ");
		sql.append("  PS.\"descripcion\" AS \"descripcionPS\" ");
		sql.append("FROM \"EstadoProyecto\" AS PS ");
		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
											   final ProjectStatusEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProjectStatusEntity());
		final var conditions = new ArrayList<String>();

		addCondition(conditions, parametersList,
				!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"PS.\"id\" = ", filterEntityValidated.getId());

		addCondition(conditions, parametersList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"PS.\"nombre\" = ", filterEntityValidated.getName());

		addCondition(conditions, parametersList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()),
				"PS.\"descripcion\" = ", filterEntityValidated.getDescription());

		if (!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}

	private void addCondition(final List<String> conditions, final List<Object> parametersList, final boolean condition,
							  final String clause, final Object value) {
		if (condition) {
			conditions.add(clause + " ?");
			parametersList.add(value);
		}
	}

	private List<ProjectStatusEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listProjectStatus = new ArrayList<ProjectStatusEntity>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				var projectStatus = new ProjectStatusEntity();
				projectStatus.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPS")));
				projectStatus.setName(resultSet.getString("nombrePS"));
				projectStatus.setDescription(resultSet.getString("descripcionPS"));
				listProjectStatus.add(projectStatus);
			}
		} catch (final SQLException exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_STATUS_FAILED_SQL_EXCEPTION.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_STATUS_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = MessagesEnum.USER_ERROR_SEARCH_PROJECT_STATUS_FAILED.getContent();
			String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_PROJECT_STATUS_FAILED.getContent() + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
		return listProjectStatus;
	}

	@Override
	public ProjectStatusEntity findById(final UUID id) {
		return findByFilter(new ProjectStatusEntity(id)).stream().findFirst().orElse(new ProjectStatusEntity());

	}
}