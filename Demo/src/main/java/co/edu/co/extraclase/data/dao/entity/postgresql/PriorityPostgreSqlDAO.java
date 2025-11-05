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
import co.edu.co.extraclase.data.dao.entity.PriorityDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ColorEntity;
import co.edu.co.extraclase.entity.PriorityEntity;
import co.edu.co.extraclase.entity.UnitOfMeasureEntity;

public class PriorityPostgreSqlDAO extends SqlConnection implements PriorityDAO {

	public PriorityPostgreSqlDAO(Connection connection) {
		super(connection);
	}


	@Override
	public List<PriorityEntity> findByFilter(PriorityEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		try(var preparedStatement = this.getConnection().prepareStatement(sql)){
			for (int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index + 1, parametersList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
		}catch (final ExtraClaseException exception){
			throw exception;
		} catch (final SQLException exception){
			var userMessage = "";
			var technicalMessage = "";
			throw  ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception){
			var userMessage = "";
			var technicalMessage = "b";
			throw  ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	private String createSentenceFindByFilter(final PriorityEntity filterEntity, final List<Object> parametersList) {
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  P.\"id\" AS \"idP\", ");
		sql.append("  P.\"nombre\" AS \"nombreP\", ");
		sql.append("  P.\"descripcion\" AS \"descripcionP\", ");
		sql.append("  P.\"tiempoRespuesta\" AS \"tiempoRespuestaP\", ");
		sql.append("  C.\"idColor\" AS \"idC\", ");
		sql.append("  C.\"nombre\" AS \"nombreC\", ");
		sql.append("  C.\"codigoHex\" AS \"hexC\", ");
		sql.append("  U.\"idUnidad\" AS \"idUM\", ");
		sql.append("  U.\"nombre\" AS \"nombreUM\" ");
		sql.append("FROM \"Prioridad\" AS P ");
		sql.append("INNER JOIN \"Color\" AS C ON P.\"color\" = C.\"idColor\" ");
		sql.append("INNER JOIN \"UnidadDeMedida\" AS U ON P.\"unidadDeMedida\" = U.\"idUnidad\" ");
		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
											   final PriorityEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new PriorityEntity());
		final var conditions = new ArrayList<String>();
		addCondition(conditions, parametersList,
				!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"P.\"id\" = ", filterEntityValidated.getId());

		addCondition(conditions, parametersList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"P.\"nombre\" = ", filterEntityValidated.getName());

		addCondition(conditions, parametersList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()),
				"P.\"descripcion\" = ", filterEntityValidated.getDescription());

		addCondition(conditions, parametersList,
				filterEntityValidated.getResponseTime() > 0,
				"P.\"tiempoRespuesta\" = ", filterEntityValidated.getResponseTime());

		addCondition(conditions, parametersList, filterEntityValidated.getColor() != null &&
						!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getColor().getId()),
				"P.\"color\" = ", filterEntityValidated.getColor().getId());

		addCondition(conditions, parametersList, filterEntityValidated.getUnitOfMeasure()!= null &&
						!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getUnitOfMeasure().getId()),
				"P.\"unidadDeMedida\" = ", filterEntityValidated.getUnitOfMeasure().getId());

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

	private List<PriorityEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){
		var listPriorities = new ArrayList<PriorityEntity>();
		try(var resultSet = preparedStatement.executeQuery()){
			while (resultSet.next()){
				var priority = new PriorityEntity();
				priority.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idP")));
				priority.setName(resultSet.getString("nombreP"));
				priority.setDescription(resultSet.getString("descripcionP"));
				priority.setResponseTime(resultSet.getInt("tiempoRespuestaP"));

				var unit = new UnitOfMeasureEntity();
				unit.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idUM")));
				unit.setName(resultSet.getString("nombreUM"));
				priority.setUnitOfMeasure(unit);

				var color = new ColorEntity();
				color.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idC")));
				color.setName(resultSet.getString("nombreC"));
				color.setHexCode(resultSet.getString("hexC"));
				priority.setColor(color);

				listPriorities.add(priority);
			}
		}
			catch (final SQLException exception){
				var userMessage = "";
				var technicalMessage = "b";
				throw  ExtraClaseException.create(exception, userMessage, technicalMessage);
			} catch (final Exception exception){
				var userMessage = "";
				var technicalMessage = "";
				throw  ExtraClaseException.create(exception, userMessage, technicalMessage);
			}
			return listPriorities;
		}


	@Override
	public PriorityEntity findById(UUID id) {
		return findByFilter(new PriorityEntity(id)).stream().findFirst().orElse(new PriorityEntity());

	}
}
