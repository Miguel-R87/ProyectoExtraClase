package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import co.edu.co.extraclase.entity.ColorEntity;
import co.edu.co.extraclase.entity.ListEntity;
import co.edu.co.extraclase.entity.PriorityEntity;
import co.edu.co.extraclase.entity.ProjectEntity;
import co.edu.co.extraclase.entity.ProjectStatusEntity;
import co.edu.co.extraclase.entity.ProjectUserEntity;
import co.edu.co.extraclase.entity.StatusEntity;
import co.edu.co.extraclase.entity.TaskEntity;
import co.edu.co.extraclase.entity.TaskUserEntity;
import co.edu.co.extraclase.entity.UnitOfMeasureEntity;
import co.edu.co.extraclase.entity.UserEntity;

public class TaskUserPostgreSqlDAO extends SqlConnection implements TaskUserDAO{

	public TaskUserPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(TaskUserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("INSERT INTO \"UsuarioTarea\" (\"usuarioTareaId\", \"usuarioProyecto\", \"tarea\", \"fechaAsignacion\", \"fechaFinalizacion\", \"esCreador\", \"comentario\" ");
		sql.append("SELECT ?, ?, ?, ?, ?, ?, ? ");
		
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
        	preparedStatement.setObject(1, entity.getId());
        	preparedStatement.setObject(2, entity.getProjectUser().getId());
        	preparedStatement.setObject(3, entity.getTask().getId());
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
		sql.append("\"ut.usuarioTareaId\" AS usuarioTareaId, ");
        
		sql.append("\"up.usuarioProyectoId\" AS usuarioProyectoId, ");
		sql.append("\"up.usuario\" AS usuario, ");
		sql.append("\"up.proyecto\" AS proyecto, ");
		sql.append("\"up.esAdmin\" AS esAdmin, ");
		sql.append("\"up.fechaEntrada\" AS fechaEntrada, ");
		sql.append("\"up.fechaSalida\" AS fechaSalida, ");
		        
		sql.append("\"u.usuarioId\" AS usuarioId, ");
		sql.append("\"u.primerNombre\" AS primerNombre, ");
		sql.append("\"u.apellido\" AS apellido, ");
		sql.append("\"u.nombreUsuario\" AS nombreUsuario, ");
		sql.append("\"u.email\" AS email, ");
		sql.append("\"u.confirmacionEmail\" AS confirmacionEmail, ");
		sql.append("\"u.fechaRegistro\" AS fechaRegistro, ");
		sql.append("\"u.passwordHash\" AS passwordHash, ");
		sql.append("\"u.estado\" AS estadoUsuario, ");
		sql.append("\"u.esSuperUsuario\" AS esSuperUsuario, ");
		sql.append("\"u.confirmacionSuperUsuario\" AS confirmacionSuperUsuario, ");
				
		sql.append("\"p.proyectoId\" AS proyectoId, ");
		sql.append("\"p.nombre\" AS nombreProyecto, ");
		sql.append("\"p.descripcion\" AS descripcionProyecto, ");
		sql.append("\"p.fechaCreacion\" AS fechaCreacionProyecto, ");
		sql.append("\"p.estadoProyecto\" AS estadoProyecto, ");
				
		sql.append("\"ep.estadoProyectoId\" AS estadoProyectoId, ");
		sql.append("\"ep.nombre\" AS nombreEstadoProyecto, ");
		sql.append("\"ep.descripcion\" AS descripcionEstadoProyecto, ");

		sql.append("\"t.tareaId\" AS tareaId, ");
		sql.append("\"t.titulo\" AS nombreTarea, ");
		sql.append("\"t.descripcion\" AS descripcionTarea, ");
		sql.append("\"t.fechaCreacion\" AS fechaCreacion, ");
		sql.append("\"t.fechaLimite\" AS fechaLimite, ");
		sql.append("\"t.lista\" AS listaTarea, ");
		sql.append("\"t.estado\" AS estadoTarea, ");
		sql.append("\"t.prioridad\" AS prioridadTarea, ");
		        
		sql.append("\"l.listaId\" AS listaId, ");
		sql.append("\"l.nombre\" AS nombreLista, ");
		sql.append("\"l.proyecto\", ");
		sql.append("\"l.fechaCreacion\" AS fechaCreacionLista, ");
		        
		sql.append("\"e.estadoId\" AS estadoId, ");
		sql.append("\"e.nombre\" AS nombreEstado, ");
		sql.append("\"e.descripcion\" AS descripcionEstado, ");
		sql.append("\"e.color\", ");
		        
		sql.append("\"c.colorId\" AS colorId, ");
		sql.append("\"c.nombre\" AS nombreColor, ");
		sql.append("\"c.codigoHex\" AS codigoHex, ");
		        
		sql.append("\"pr.prioridadId\" AS prioridadId, ");
		sql.append("\"pr.nombre\" AS nombrePrioridad, ");
		sql.append("\"pr.descripcion\" AS descripcionPrioridad, ");
		sql.append("\"pr.tiempoRespuesta\" AS tiempoRespuesta, ");
		sql.append("\"pr.unidadMedida\", ");
		sql.append("\"pr.color\", ");
		        
		sql.append("\"udm.unidadMedidaId\" AS unidadMedidaId, ");
		sql.append("\"udm.nombre\" AS nombreUnidadMedida, ");
		sql.append("\"udm.descripcion\" AS descripcionUnidadMedida, ");
		        
		sql.append("\"ut.usuarioProyecto\", ");
		sql.append("\"ut.tarea\", ");
		sql.append("\"ut.fechaAsignacion\", ");
		sql.append("\"ut.fechaFinalizacion\", ");
		sql.append("\"ut.esCreador\", ");
		sql.append("\"ut.comentario\" ");

		sql.append("FROM \"UsuarioTarea\" tu ");
		sql.append("INNER JOIN \"UsuarioProyecto\" up ON \"tu.usuarioProyectoId\" = \"up.usuarioProyectoId\" ");
		sql.append("INNER JOIN \"Tarea\" t ON \"tu.tareaId\" = \"t.tareaId\" ");
		sql.append("INNER JOIN \"Lista\" l ON \"l.listaId\" = \"t.listaId\" ");
		sql.append("INNER JOIN \"Estado\" e ON \"e.estadoId\" = \"t.estadoId\" ");
		sql.append("INNER JOIN \"Color\" c ON \"c.colorId\" = \"e.colorId\" ");
		sql.append("INNER JOIN \"Prioridad\" pr ON \"pr.prioridadId\" = \"t.prioridadId\" ");
		sql.append("INNER JOIN \"UnidadMedida\" udm ON \"udm.unidadMedidaId\" = \"pr.unidadMedidaId\" ");
		sql.append("INNER JOIN \"Proyecto\" p ON \"up.proyectoId\" = \"p.proyectoId\" ");
		sql.append("INNER JOIN \"EstadoProyecto\" ep ON \"ep.estadoProyectoId\" = \"p.estadoProyectoId\" ");
		sql.append("INNER JOIN \"Usuario\" u ON \"up.usuarioId\" = \"u.usuarioId\" ");

        
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        
        return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameList, final TaskUserEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new TaskUserEntity());
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "\"ut.usuarioTareaId\" = ? ",
		filterEntityValidated.getId());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProjectUser().getId()), "\"up.usuarioProyectoId\" = ? ",
		filterEntityValidated.getProjectUser().getId());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getTask().getId()), "\"t.tareaId\" = ? ",
		filterEntityValidated.getTask().getId());
		
		addCondition(conditions, parameList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getAssignmentDate()), "\"ut.fechaAsigancion\" = ? ",
		filterEntityValidated.getAssignmentDate());
		
		addCondition(conditions, parameList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getCompletionDate()), "\"ut.fechaFinalizacion\" = ? ",
		filterEntityValidated.getCompletionDate());
		
		addCondition(conditions, parameList,
		!BooleanHelper.isDefaultBoolean(filterEntityValidated.isCreator()), " \"ut.esCreador\" = ? ",
		filterEntityValidated.isCreator());
		
		addCondition(conditions, parameList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getComment()), "\"ut.comentario\" = ? ",
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
				var user = new UserEntity();
				user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioId")));
            	user.setFirstName(resultSet.getString("primerNombre"));
            	user.setLastName(resultSet.getString("apellido"));
            	user.setUsername(resultSet.getString("nombreUsuario"));
            	user.setEmail(resultSet.getString("email"));
            	user.setEmailConfirmation(resultSet.getBoolean("confirmacionEmail"));
            	user.setRegistrationDate((LocalDateTime) resultSet.getObject("fechaRegistro"));
            	user.setPasswordHash(resultSet.getString("passwordHash"));
            	user.setAccountStatus(resultSet.getBoolean("estado"));
            	user.setSuperUser(resultSet.getBoolean("esSuperUsuario"));
            	user.setSuperUserConfirmation(resultSet.getBoolean("confirmacionSuoerUsuario"));
            	
            	var projectStatus = new ProjectStatusEntity();
				projectStatus.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("proyectoEstadoId")));
				projectStatus.setName(resultSet.getString("nombreEstadoProyecto"));
				projectStatus.setDescription(resultSet.getString("descripcionEstadoProyecto"));
				
				var project = new ProjectEntity();
				project.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("projectoId")));
				project.setName(resultSet.getString("nombreProyecto"));
				project.setDescription(resultSet.getString("descripcionProyecto"));
				project.setCreationDate((LocalDateTime) resultSet.getObject("fechaCreacionProyecto"));
				project.setProjectStatus(projectStatus);
				
				var projectUser = new ProjectUserEntity();
                projectUser.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioProyectoId")));
                projectUser.setUser(user);
                projectUser.setProject(project);

                var list = new ListEntity();
                list.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("listaId")));
                list.setName(resultSet.getString("nombreLista"));
                list.setProject(project);
                list.setCreationDate((LocalDateTime) resultSet.getObject("fechaCreacionLista"));
                
                var color = new ColorEntity();
                color.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("colorId")));
                color.setName(resultSet.getString("nombreColor"));
                color.setHexCode(resultSet.getString("codigoHex"));
                
                var status = new StatusEntity();
                status.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("estadoId")));
                status.setName(resultSet.getString("nombreEstado"));
                status.setDescription(resultSet.getString("descripcionEstado"));
                status.setColor(color);
                
                var unitOfMeasure = new UnitOfMeasureEntity();
                unitOfMeasure.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("unidadMedidaId")));
                unitOfMeasure.setName(resultSet.getString("nombreUnidadMedida"));
                unitOfMeasure.setDescription(resultSet.getString("descripcionUnidadMedida"));
                
                var priority = new PriorityEntity();
                priority.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("prioridadId")));
                priority.setName(resultSet.getString("nombrePrioridad"));
                priority.setDescription(resultSet.getString("descripcionPrioridad"));
                priority.setResponseTime(resultSet.getInt("tiempoRespuesta"));
                priority.setUnitOfMeasure(unitOfMeasure);
                priority.setColor(color);
                
                var task = new TaskEntity();
                task.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("tareaId")));
                task.setTitle(resultSet.getString("titulo"));
                task.setDescription(resultSet.getString("descripcion"));
                task.setCreationDate(resultSet.getTimestamp("fechaCreacion").toLocalDateTime());
                task.setExpiryDate(resultSet.getTimestamp("fechaLimite").toLocalDateTime());
                task.setList(list);
                task.setStatus(status);
                task.setPriority(priority);

                var taskUser = new TaskUserEntity();
                taskUser.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioTareaId")));
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
		sql.append("UPDATE \"UsuarioTarea\" " );
		sql.append("SET \"usarioTareaId\" = ?, " );
		sql.append("\"usuarioProjecto\" = ?, " );
		sql.append("\"tarea\" = ?, " );
		sql.append("\"fechaAsignacion\" = ?, " );
		sql.append("\"fechaFinalizacion\" = ?, " );
		sql.append("\"esCreador\" = ?, " );
		
		sql.append("WHERE \"usuarioTareaId\" = ?; " );
			
		
		 try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
	        	preparedStatement.setObject(1, entity.getId());
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
