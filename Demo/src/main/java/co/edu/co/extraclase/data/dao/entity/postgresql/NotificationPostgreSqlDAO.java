package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.*;
import co.edu.co.extraclase.data.dao.entity.NotificationDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.NotificationEntity;
import co.edu.co.extraclase.entity.NotificationTypeEntity;
import co.edu.co.extraclase.entity.TaskUserEntity;

public final class NotificationPostgreSqlDAO extends SqlConnection implements NotificationDAO {

	public NotificationPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	public void create(final NotificationEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("INSERT INTO \"Notificacion\" ");
        sql.append("(\"notificacionId\", \"usuarioTareaId\", \"mensaje\", \"fechaDisparo\", \"tipoId\") ");
        sql.append("VALUES (?, ?, ?, ?, ?)");

        try (var preparedStatement = getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getTaskUser().getId());
			preparedStatement.setString(3, entity.getMessage());
			preparedStatement.setObject(4, entity.getTriggerDate());
			preparedStatement.setObject(5, entity.getNotificationType().getId());
        } catch (final SQLException exception){
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception){
			var userMessage = "";
			var technicalMessage = "b";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
    }

	@Override
	public List<NotificationEntity> findByFilter(final NotificationEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
			for (int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index + 1, parametersList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
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

	private String createSentenceFindByFilter(final NotificationEntity filterEntity, final List<Object> parametersList) {
		final var sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("  N.\"id\" AS \"idN\", ");
			sql.append("  N.\"mensaje\" AS \"mensajeN\", ");
			sql.append("  N.\"fechaDisparo\" AS \"fechaDisparoN\", ");
			sql.append("  UT.\"idUsuarioTarea\" AS \"idUT\", ");
			sql.append("  UT.\"descripcion\" AS \"descripcionUT\", ");
			sql.append("  TN.\"idTipoNotification\" AS \"idTN\", ");
			sql.append("  TN.\"nombre\" AS \"nombreTN\" ");
			sql.append("FROM \"Notificacion\" AS N ");
			sql.append("INNER JOIN \"UsuarioTarea\" AS UT ON N.\"idUsuarioTarea\" = UT.\"id\" ");
			sql.append("INNER JOIN \"TipoNotificacion\" AS TN ON N.\"idTipoNotificacion\" = TN.\"id\" ");
			createWhereClauseFindByFilter(sql, parametersList, filterEntity);
			return sql.toString();

	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList , final NotificationEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new NotificationEntity());
		final var conditions = new ArrayList<String>();
		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"N.\"id\" = ", filterEntityValidated.getId());

		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getTaskUser().getId()),
				"N.\"idUsuarioTarea\" = ", filterEntityValidated.getTaskUser().getId());

		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getNotificationType().getId()),
				"N.\"idTipoNotificacion\" = ", filterEntityValidated.getNotificationType().getId());

		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getMessage()),
				"N.\"mensaje\" = ", filterEntityValidated.getMessage());

		addCondition(conditions, parametersList, !DateTimeHelper.isDefaultDate(filterEntityValidated.getTriggerDate()),
				"N.\"fechaDisparo\" = ", filterEntityValidated.getTriggerDate());

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

	private List<NotificationEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){
		var listNotification = new ArrayList<NotificationEntity>();
		try (var resultSet = preparedStatement.executeQuery()){
			var notificationType = new NotificationTypeEntity();
			notificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTN")));
			notificationType.setName(resultSet.getString("nombreTN"));

			var taskUser = new TaskUserEntity();
			taskUser.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idUT")));
			taskUser.setAssignmentDate(resultSet.getTimestamp("fechaAsignacionUT").toLocalDateTime());

			var notification = new NotificationEntity();
			notification.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idN")));
			notification.setMessage(resultSet.getString("mensajeN"));
			notification.setTriggerDate(resultSet.getTimestamp("fechaDisparoN").toLocalDateTime());
			notification.setTaskUser(taskUser);
			notification.setNotificationType(notificationType);

			listNotification.add(notification);
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "b";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
		return listNotification;
	}

	@Override
	public NotificationEntity findById(final UUID id) {
		return findByFilter(new NotificationEntity(id)).stream().findFirst().orElse(new NotificationEntity());

	}





}
