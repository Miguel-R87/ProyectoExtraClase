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
import co.edu.co.extraclase.data.dao.entity.UnitOfMeasureDAO;
import co.edu.co.extraclase.entity.UnitOfMeasureEntity;

public class UnitOfMeasurePostgreSqlDAO extends SqlConnection implements UnitOfMeasureDAO {

	public UnitOfMeasurePostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<UnitOfMeasureEntity> findAll() {
		return findByFilter(new UnitOfMeasureEntity());
	}

	@Override
	public List<UnitOfMeasureEntity> findByFilter(UnitOfMeasureEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		
	 		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
				
				for (int index = 0; index < parametersList.size(); index++) {
					preparedStatement.setObject(index + 1, parametersList.get(index));
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
	
	private String createSentenceFindByFilter(final UnitOfMeasureEntity filterEntity, final List<Object> parameterList) {
		final var sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("udm.unidadMedidaId, ");
		sql.append("udm.nombre, ");
		sql.append("udm.descripcion ");
		
		sql.append("FROM UnidadDeMedida ");
		
		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        
        return sql.toString();
		
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final UnitOfMeasureEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UnitOfMeasureEntity());
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getUnitOfMeasureId()), "udm.unidadMedidaId = ?",
		filterEntityValidated.getUnitOfMeasureId());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()), "udm.nombre = ?",
		filterEntityValidated.getName());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()), "udm.descripcion = ?",
		filterEntityValidated.getDescription());
		
		if(!conditions.isEmpty()) {
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
	
	private List<UnitOfMeasureEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listUnitOfMeasure = new ArrayList<UnitOfMeasureEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				var unitOfMeasure = new UnitOfMeasureEntity();
				unitOfMeasure.setUnitOfMeasureId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("unidadMedidaId")));
				unitOfMeasure.setName(resultSet.getString("nombre"));
				unitOfMeasure.setDescription(resultSet.getString("descripcion"));
				
				listUnitOfMeasure.add(unitOfMeasure);

			}
		}catch (SQLException exception) {
			var userMessage = "";
			var technicalMessage = "" + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}catch (Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
		return listUnitOfMeasure;
	}
	
	

	@Override
	public UnitOfMeasureEntity findById(UUID id) {
		return findByFilter(new UnitOfMeasureEntity(id)).stream().findFirst().orElse(new UnitOfMeasureEntity());
	}

}
