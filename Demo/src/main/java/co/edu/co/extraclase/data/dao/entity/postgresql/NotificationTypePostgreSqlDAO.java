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
import co.edu.co.extraclase.data.dao.entity.NotificationTypeDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.NotificationTypeEntity;

public final class NotificationTypePostgreSqlDAO extends SqlConnection implements NotificationTypeDAO {

	public NotificationTypePostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<NotificationTypeEntity> findByFilter(final NotificationTypeEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
			for (int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index + 1, parametersList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
		} catch (final ExtraClaseException exception){
			throw exception;
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "b";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}
	private String createSentenceFindByFilter(final NotificationTypeEntity filterEntity,
											  final List<Object> parametersList){
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  TN.\"idTipoNotificacion\" AS \"idTN\", ");
		sql.append("  TN.\"nombre\" AS \"nombreTN\", ");
		sql.append("  TN.\"descripcion\" AS \"descripcionTN\" ");
		sql.append("FROM \"TipoNotificacion\" AS TN ");
		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
											   final NotificationTypeEntity filterEntity){
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new NotificationTypeEntity());
		final var conditions = new ArrayList<String>();

		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"TN.\"idTipoNotificacion\" = ", filterEntityValidated.getId());
		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"TN.\"nombre\" = ", filterEntityValidated.getName());
		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()),
				"TN.\"descripcion\" = ", filterEntityValidated.getDescription());

		if(!conditions.isEmpty()) {
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

	private List<NotificationTypeEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){
		var listNotificationType = new ArrayList<NotificationTypeEntity>();
		try(var resultSet = preparedStatement.executeQuery()){
			while(resultSet.next()){
				var notificationType = new NotificationTypeEntity();
				notificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTN")));
				notificationType.setName(resultSet.getString("nombreTN"));
				notificationType.setDescription(resultSet.getString("descripcionTN"));
				listNotificationType.add(notificationType);}
			} catch (final SQLException exception){
				var userMessage = "";
				var technicalMessage = "b";
				throw ExtraClaseException.create(exception, userMessage, technicalMessage);
			} catch (final Exception exception){
				var userMessage = "";
				var technicalMessage = "";
				throw ExtraClaseException.create(exception, userMessage, technicalMessage);
			}
			return listNotificationType;
		}

	@Override
	public NotificationTypeEntity findById(final UUID id) {
		return findByFilter(new NotificationTypeEntity(id)).stream().findFirst().orElse(new NotificationTypeEntity());

	}
	}
