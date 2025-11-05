package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.SqlConnectionHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.TaskDAO;
import co.edu.co.extraclase.entity.ListEntity;
import co.edu.co.extraclase.entity.PriorityEntity;
import co.edu.co.extraclase.entity.StatusEntity;
import co.edu.co.extraclase.entity.TaskEntity;

public class TaskPostgreSqlDAO extends SqlConnection implements TaskDAO{

	public TaskPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(TaskEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("INSERT INTO \"Tarea\" (\"tareaId\", \"titulo\", \"descripcion\", \"fechaCreacion\", \"fechaLimite\", \"lista\", \"estado\", \"prioridad\")");
		sql.append("SELECT ?, ?, ?, ?, ?, ?, ?, ? ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
        	preparedStatement.setObject(1, entity.getId());
        	preparedStatement.setString(2, entity.getTitle());
        	preparedStatement.setString(3, entity.getDescription());
        	preparedStatement.setObject(4, entity.getCreationDate());
        	preparedStatement.setObject(5, entity.getExpiryDate());
        	preparedStatement.setObject(6, entity.getList());
        	preparedStatement.setObject(7, entity.getStatus());
        	preparedStatement.setObject(8, entity.getPriority());

			preparedStatement.executeUpdate();

        }	catch (final SQLException exception) {
        	var userMessage = "Se ha presentado un problema tratando de registrar la información de la nueva tarea. Intente de nuevo.";
        	var technicalMessage = "SQLException al insertar Tarea: " + exception.getMessage();
        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	var userMessage = "Se ha presentado un problema inesperado tratando de registrar la información de la nueva tarea.";
        	var technicalMessage = "Excepción inesperada al insertar Tarea: " + exception.getMessage();
        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
      }
    }

	@Override
	public List<TaskEntity> findByFilter(TaskEntity filterEntity) {
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
	
	private String createSentenceFindByFilter(final TaskEntity filterEntity, final List<Object> parameterList) {
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
        sql.append("\"t.tareaId\" AS tareaId, ");
        sql.append("\"t.titulo\", ");
        sql.append("\"t.descripcion\", ");
        sql.append("\"t.fechaCreacion\", ");
        sql.append("\"t.fechaLimite\", ");
        
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
                
        sql.append("FROM \"Tarea\" t ");
        sql.append("INNER JOIN \"Estado\" e ON \"e.estadoId\" = \"t.estadoId\" ");
        sql.append("INNER JOIN \"Prioridad\" p ON \"p.prioridadId\" = \"t.prioridadId\"");
        sql.append("INNER JOIN \"Lista\" l ON \"l.listaId\" = \"t.listaId\"");
        sql.append("INNER JOIN ");
        
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        
        return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameList, final TaskEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new TaskEntity());
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "\"t.tareaId\" = ? ",
		filterEntityValidated.getId());
		
		addCondition(conditions, parameList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getTitle()), "\"t.titulo\" = ? ",
		filterEntityValidated.getTitle());
		
		addCondition(conditions, parameList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()), "\"t.descripcion\" = ? ",
		filterEntityValidated.getDescription());
		
		addCondition(conditions, parameList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getCreationDate()), "\"t.fechaCreacion\" = ? ",
		filterEntityValidated.getCreationDate());
		
		addCondition(conditions, parameList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getExpiryDate()), "\"t.fechaLimite\" = ? ",
		filterEntityValidated.getExpiryDate());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getList().getId()), "\"l.listaId\" = ? ",
		filterEntityValidated.getList().getId());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getStatus().getId()), "\"e.estadoId\" = ? ",
		filterEntityValidated.getStatus().getId());
		
		addCondition(conditions, parameList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getPriority().getId()), "\"p.prioridad\" = ? ",
		filterEntityValidated.getPriority().getId());
		
		
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
	
	private List<TaskEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listTask = new ArrayList<TaskEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				var list = new ListEntity();
                list.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("listaId")));
                list.setName(resultSet.getString("nombreLista"));

                var status = new StatusEntity();
                status.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("estadoId")));
                status.setName(resultSet.getString("nombreEstado"));
                
                var priority = new PriorityEntity();
                priority.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("prioridadId")));
                priority.setName(resultSet.getString("nombrePrioridad"));

                var task = new TaskEntity();
                task.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("tareaId")));
                task.setTitle(resultSet.getString("titulo"));
                task.setDescription(resultSet.getString("descripcion"));
                task.setCreationDate(resultSet.getTimestamp("fechaCreacion").toLocalDateTime());
                task.setExpiryDate(resultSet.getTimestamp("fechaLimite").toLocalDateTime());
                task.setList(list);
                task.setStatus(status);
                task.setPriority(priority);
                
                listTask.add(task);

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
		return listTask;
		
	}


	@Override
	public void update(TaskEntity entity) {
SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("UPDATE \"Tarea\" " );
		sql.append("SET \"tareaId\" = ?, " );
		sql.append("\"titulo\" = ?, " );
		sql.append("\"descripcion\" = ?, " );
		sql.append("\"fechaCreacion\" = ?, " );
		sql.append("\"fechaLimite\" = ?, " );
		sql.append("\"lista\" = ?, " );
		sql.append("\"estado\" = ?, " );
		sql.append("\"prioridad\" = ?, " );
		
		sql.append("WHERE \"tareaId\" = ?; " );
			
		
		 try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
	        	preparedStatement.setObject(1, entity.getId());
	        	preparedStatement.setString(2, entity.getTitle());
	        	preparedStatement.setString(3, entity.getDescription());
	        	preparedStatement.setObject(4, entity.getCreationDate());
	        	preparedStatement.setObject(5, entity.getExpiryDate());
	        	preparedStatement.setObject(6, entity.getList());
	        	preparedStatement.setObject(7, entity.getStatus());
	        	preparedStatement.setObject(8, entity.getPriority());

				preparedStatement.executeUpdate();

	        }	catch (final SQLException exception) {
	        	var userMessage = "Se ha presentado un problema tratando de actualizar la información de una Tarea. Intente de nuevo.";
	        	var technicalMessage = "SQLException al actualizar Tarea: " + exception.getMessage();
	        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	        } catch (final Exception exception) {
	        	var userMessage = "Se ha presentado un problema inesperado tratando de actualizar la información de una Tarea.";
	        	var technicalMessage = "Excepción inesperada al actualizar Tarea: " + exception.getMessage();
	        	throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	      }
	}

	@Override
	public TaskEntity findById(UUID id) {
		return findByFilter(new TaskEntity(id)).stream().findFirst().orElse(new TaskEntity());

	}
		
	}


