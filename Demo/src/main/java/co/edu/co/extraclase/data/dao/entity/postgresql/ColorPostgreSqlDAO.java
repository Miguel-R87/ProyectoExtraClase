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
import co.edu.co.extraclase.data.dao.entity.ColorDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ColorEntity;

public final class ColorPostgreSqlDAO extends SqlConnection implements ColorDAO {

	public ColorPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<ColorEntity> findByFilter(final ColorEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		try (var preparedStatement = this.getConnection().prepareStatement(sql)){
			for(int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index+1, parametersList.get(index));
			}
			return executeSentenceFindByFilter(preparedStatement);
		} catch(final ExtraClaseException exception){
			throw exception;
		} catch(final SQLException exception){
			var userMessage = "a";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch(final Exception exception){
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}


	private String createSentenceFindByFilter(final ColorEntity filterEntity, final List<Object> parametersList) {
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  C.\"colorId\" AS \"idC\", ");
		sql.append("  C.\"nombre\" AS \"nombreC\", ");
		sql.append("  C.\"codigoHex\" AS \"hexC\" ");
		sql.append("FROM \"Color\" AS C ");
		createWhereClauseFindByFilter(sql , parametersList, filterEntity);
		return sql.toString();

	}

	public void createWhereClauseFindByFilter(final StringBuilder sql , final List<Object> parametersList, final ColorEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ColorEntity());
		final var conditions = new ArrayList<String>();
		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId())
				,"C.\"colorId\" = ",filterEntityValidated.getId());
		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName())
				, "C.\"nombre\" = ",filterEntityValidated.getName());
		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getHexCode()),
				"C.\"codigoHex\" = ",filterEntityValidated.getHexCode());

		if(!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}

	private void addCondition (final List<String> conditions, final List<Object> parametersList, final boolean condition, final String clause,
							   final Object value) {
		if (condition) {
			conditions.add(clause + " ?");
			parametersList.add(value);
		}
	}

	private List<ColorEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listColor = new ArrayList<ColorEntity>();
		try(var resultSet = preparedStatement.executeQuery()){
			while (resultSet.next()){
				var color = new ColorEntity();
				color.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idC")));
				color.setName(resultSet.getString("nombreC"));
				color.setHexCode(resultSet.getString("hexC"));
				listColor.add(color);
			}
		} catch(final SQLException exception) {
			var userMessage = "a";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		} catch(final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}

		return listColor;
	}

	@Override
	public ColorEntity findById(final UUID id) {
		return findByFilter(new ColorEntity(id)).stream().findFirst().orElse(new ColorEntity());

	}

}
