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
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.StatusDAO;
import co.edu.co.extraclase.entity.ColorEntity;
import co.edu.co.extraclase.entity.StatusEntity;

public final class StatusPostgreSqlDAO extends SqlConnection implements StatusDAO{

	public StatusPostgreSqlDAO(Connection connection) {
		super(connection);
	}


	@Override
	public List<StatusEntity> findByFilter(StatusEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		try(var preparedStatement = this.getConnection().prepareStatement(sql)){
			for (int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index + 1, parametersList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
		} catch (final ExtraClaseException exception){
			throw exception;
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

	private String createSentenceFindByFilter(final StatusEntity filterEntity, final List<Object> parametersList) {
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  S.\"idEstado\" AS \"idS\", ");
		sql.append("  S.\"nombre\" AS \"nombreS\", ");
		sql.append("  S.\"descripcion\" AS \"descripcionS\", ");
		sql.append("  C.\"idColor\" AS \"idC\", ");
		sql.append("  C.\"nombre\" AS \"nombreC\", ");
		sql.append("  C.\"codigoHex\" AS \"hexC\" ");
		sql.append("FROM \"Estado\" AS S ");
		sql.append("INNER JOIN \"Color\" AS C ON S.\"color\" = C.\"idColor\" ");
		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql , final List<Object> parametersList,
											   final StatusEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StatusEntity());
		final var conditions = new ArrayList<String>();

		addCondition(conditions, parametersList,
				!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"S.\"idEstado\" = ", filterEntityValidated.getId());

		addCondition(conditions, parametersList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"S.\"nombre\" = ", filterEntityValidated.getName());

		addCondition(conditions, parametersList,
				!TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()),
				"S.\"descripcion\" = ", filterEntityValidated.getDescription());

		addCondition(conditions, parametersList, filterEntityValidated.getColor() != null &&
						!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getColor().getId()),
				"S.\"color\" = ", filterEntityValidated.getColor().getId());

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

	private List<StatusEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){
		var listStatus = new ArrayList<StatusEntity>();
		try(var resultSet = preparedStatement.executeQuery()){
			while(resultSet.next()){
				var status = new StatusEntity();
				status.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idS")));
				status.setName(resultSet.getString("nombreS"));
				status.setDescription(resultSet.getString("descripcionS"));

				var color = new ColorEntity();
				color.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idC")));
				color.setName(resultSet.getString("nombreC"));
				color.setHexCode(resultSet.getString("hexC"));
				status.setColor(color);

				listStatus.add(status);
			}
		} catch (final SQLException exception){
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception){
			var userMessage = "";
			var technicalMessage = "b";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
		return listStatus;
	}


	@Override
	public StatusEntity findById(UUID id) {
		return findByFilter(new StatusEntity(id)).stream().findFirst().orElse(new StatusEntity());

	}
}
