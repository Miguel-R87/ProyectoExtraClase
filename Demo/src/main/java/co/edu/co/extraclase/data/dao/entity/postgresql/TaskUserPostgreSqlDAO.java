package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.SqlConnectionHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.TaskUserDAO;
import co.edu.co.extraclase.entity.ProjectEntity;
import co.edu.co.extraclase.entity.ProjectUserEntity;
import co.edu.co.extraclase.entity.TaskEntity;
import co.edu.co.extraclase.entity.TaskUserEntity;
import co.edu.co.extraclase.entity.UserEntity;

public class TaskUserPostgreSqlDAO extends SqlConnection implements TaskUserDAO{

	public TaskUserPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(TaskUserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("INSERT INTO UsuarioTarea (usuarioTareaId, usuarioProyecto, tarea, fechaAsignacion, fechaFinalizacion, esCreador, comentario ");
		sql.append("SELECT ?, ?, ?, ?, ?, ?, ? ");
		
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
        	preparedStatement.setObject(1, entity.getTaskUserId());
        	preparedStatement.setObject(2, entity.getProjectUser().getProjectUserId());
        	preparedStatement.setObject(3, entity.getTask().getTaskId());
        	preparedStatement.setObject(4, entity.getAssignmentDate());
        	preparedStatement.setObject(5, entity.getCompletionDate());
        	preparedStatement.setBoolean(6, entity.isCreator());
        	preparedStatement.setString(7, entity.getComment());

			preparedStatement.executeUpdate();

        }	catch (final SQLException exception) {
        	var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo usuarioTarea. Intente de nuevo.";
        	var technicalMessage = "SQLException al insertar UsuarioTarea: " + exception.getMessage();
        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	var userMessage = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo usuarioTarea.";
        	var technicalMessage = "Excepción inesperada al insertar UsuarioTarea: " + exception.getMessage();
        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
      }
    }

	@Override
	public List<TaskUserEntity> findAll() {
		return findByFilter(new TaskUserEntity());
	}

	@Override
	public List<TaskUserEntity> findByFilter(TaskUserEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
			
			for (int index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		}catch (final ExtraClaseException exception) {
			throw exception;
		}catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "" + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);

		}catch (Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);

		}
	}
	
	private String createSentenceFindByFilter(final TaskUserEntity filterEntity, final List<Object> parameterList) {
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
        sql.append("ut.usuarioTareaId, ");
        sql.append("up.usuarioProyectoId, ");
        sql.append("p.proyectoId, ");
        sql.append("p.nombre AS nombreProyecto, ");
        sql.append("u.usuarioId, ");
        sql.append("u.primerNombre AS nombreUsuario, ");
        sql.append("t.tareaId, ");
        sql.append("t.titulo AS nombreTarea, ");
        sql.append("ut.fechaAsignacion, ");
        sql.append("ut.fechaFinalizacion, ");
        sql.append("ut.esCreador, ");
        sql.append("ut.comentario ");
        
        sql.append("FROM UsuarioTarea tu ");
        sql.append("INNER JOIN UsuarioProyecto pu ON tu.usuarioProyecto = pu.usuarioProyectoId ");
        sql.append("INNER JOIN Tarea t ON tu.tarea = t.tareaId ");
        sql.append("INNER JOIN Proyecto p ON pu.proyecto = p.proyectoId ");
        sql.append("INNER JOIN Usuario u ON pu.usuario = u.usuarioId ");
        
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        
        return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameList, final TaskUserEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new TaskUserEntity());
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getTaskUserId()), "ut.usuarioTareaId = ? ",
		filterEntityValidated.getTaskUserId());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProjectUser().getProjectUserId()), "up.usuarioProyectoId = ? ",
		filterEntityValidated.getProjectUser().getProjectUserId());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getTask().getTaskId()), "t.tareaId = ? ",
		filterEntityValidated.getTask().getTaskId());
		
		addCondition(conditions, parameList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getAssignmentDate()), "ut.fechaAsigancion = ? ",
		filterEntityValidated.getAssignmentDate());
		
		addCondition(conditions, parameList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getCompletionDate()), "ut.fechaFinalizacion = ? ",
		filterEntityValidated.getCompletionDate());
		
		addCondition(conditions, parameList,
		!BooleanHelper.isDefaultBoolean(filterEntityValidated.isCreator()), " ut.esCreador = ? ",
		filterEntityValidated.isCreator());
		
		addCondition(conditions, parameList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getComment()), "ut.comentario = ? ",
		filterEntityValidated.getComment());
		
		if (!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		
		}
	}
	
	private void addCondition(final List<String> conditions, final List<Object> parameterList, final boolean condition,
			final String clause, final Object value) {
		if (condition) {
			conditions.add(clause);
			parameterList.add(value);
		}
	}
	
	private List<TaskUserEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listTaskUser = new ArrayList<TaskUserEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				var projectUser = new ProjectUserEntity();
                projectUser.setProjectUserId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioProyectoId")));

                var project = new ProjectEntity();
                project.setProjectId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("proyectoId")));
                project.setName(resultSet.getString("nombreProyecto"));

                var user = new UserEntity();
                user.setUserId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioId")));
                user.setFirstName(resultSet.getString("nombreUsuario"));

                var task = new TaskEntity();
                task.setTaskId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("tareaId")));
                task.setTitle(resultSet.getString("nombreTarea"));

                var taskUser = new TaskUserEntity();
                taskUser.setTaskUserId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioTareaId")));
                taskUser.setProjectUser(projectUser);
                taskUser.setTask(task);
                taskUser.setAssignmentDate(resultSet.getTimestamp("fechaAsignacion").toLocalDateTime());
                taskUser.setCompletionDate(resultSet.getTimestamp("fechaFinalizacion").toLocalDateTime());
                taskUser.setCreator(resultSet.getBoolean("esCreador"));
                taskUser.setComment(resultSet.getString("comentario"));
            	
				listTaskUser.add(taskUser);

			}
		}catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "" + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "" + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);

		}
		return listTaskUser;
		
	}
	

	@Override
    public TaskUserEntity findById(UUID id) {
		return findByFilter(new TaskUserEntity()).stream().findFirst().orElse(new TaskUserEntity());
	}

	@Override
	public void update(TaskUserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("UPDATE TaskUser " );
		sql.append("SET usarioTareaId = ?, " );
		sql.append("usuarioProjecto = ?, " );
		sql.append("tarea = ?, " );
		sql.append("fechaAsignacion = ?, " );
		sql.append("fechaFinalizacion = ?, " );
		sql.append("esCreador = ?, " );
		
		sql.append("WHERE usuarioTareaId = ?; " );
			
		
		 try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
	        	preparedStatement.setObject(1, entity.getTaskUserId());
	        	preparedStatement.setObject(2, entity.getProjectUser());
	        	preparedStatement.setObject(3, entity.getTask());
	        	preparedStatement.setObject(4, entity.getAssignmentDate());
	        	preparedStatement.setObject(5, entity.getCompletionDate());
	        	preparedStatement.setBoolean(6, entity.isCreator());
	        	preparedStatement.setString(7, entity.getComment());

				preparedStatement.executeUpdate();

	        }	catch (final SQLException exception) {
	        	var userMessage = "Se ha presentado un problema tratando de actualizar la información del nuevo usuarioTarea. Intente de nuevo.";
	        	var technicalMessage = "SQLException al actualizar UsuarioTarea: " + exception.getMessage();
	        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	        } catch (final Exception exception) {
	        	var userMessage = "Se ha presentado un problema inesperado tratando de actualizar la información del nuevo usuarioTarea.";
	        	var technicalMessage = "Excepción inesperada al actualizar UsuarioTarea: " + exception.getMessage();
	        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	      }
	}
}
