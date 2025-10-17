package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.SqlConnectionHelper;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskUserEntity> findByFilter(TaskUserEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public TaskUserEntity findById(UUID id) {
        final var sql = new StringBuilder();
        var taskUser = new TaskUserEntity();

        sql.append("SELECT ");
        sql.append("tu.usuarioTareaId, ");
        sql.append("pu.usuarioProyectoId, ");
        sql.append("p.proyectoId, ");
        sql.append("p.nombre AS nombreProyecto, ");
        sql.append("u.usuarioId, ");
        sql.append("u.primerNombre AS nombreUsuario, ");
        sql.append("t.tareaId, ");
        sql.append("t.titulo AS nombreTarea, ");
        sql.append("tu.fechaAsignacion, ");
        sql.append("tu.fechaFinalizacion, ");
        sql.append("tu.esCreador, ");
        sql.append("tu.comentario ");
        sql.append("FROM UsuarioTarea tu ");
        sql.append("INNER JOIN UsuarioProyecto pu ON tu.usuarioProyecto = pu.usuarioProyectoId ");
        sql.append("INNER JOIN Tarea t ON tu.tarea = t.tareaId ");
        sql.append("INNER JOIN Proyecto p ON pu.proyecto = p.proyectoId ");
        sql.append("INNER JOIN Usuario u ON pu.usuario = u.usuarioId ");
        sql.append("WHERE tu.usuarioTareaId = ?;");

        try (final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
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

                    taskUser.setTaskUserId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioTareaId")));
                    taskUser.setProjectUser(projectUser);
                    taskUser.setTask(task);
                    taskUser.setAssignmentDate(resultSet.getTimestamp("fechaAsignacion").toLocalDateTime());
                    taskUser.setCompletionDate(resultSet.getTimestamp("fechaFinalizacion").toLocalDateTime());
                    taskUser.setCreator(resultSet.getBoolean("esCreador"));
                    taskUser.setComment(resultSet.getString("comentario"));
                }
            }

        } catch (final SQLException exception) {
            var userMessage = "Se presentó un problema tratando de encontrar la información del UsuarioTarea. Intente de nuevo.";
            var technicalMessage = "SQLException al buscar UsuarioTarea: " + exception.getMessage();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "Se presentó un problema inesperado tratando de encontrar la información del UsuarioTarea.";
            var technicalMessage = "Excepción inesperada al buscar UsuarioTarea: " + exception.getMessage();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }

        return taskUser;
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
