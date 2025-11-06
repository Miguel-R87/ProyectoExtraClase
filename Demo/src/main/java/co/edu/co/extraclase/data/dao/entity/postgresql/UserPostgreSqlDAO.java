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
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.UserDAO;
import co.edu.co.extraclase.entity.UserEntity;

public final class UserPostgreSqlDAO extends SqlConnection implements UserDAO{

	public UserPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        
        final var sql = new StringBuilder();
        sql.append("INSERT INTO \"Usuario\" (");
        sql.append("\"usuarioId\", ");
        sql.append("\"primerNombre\", ");
        sql.append("\"apellido\", ");
        sql.append("\"nombreUsuario\", ");
        sql.append("\"email\", ");
        sql.append("\"emailConfirmado\", ");
        sql.append("\"fechaRegistro\", ");
        sql.append("\"passwordHash\", ");
        sql.append("\"estado\", ");
        sql.append("\"esSuperUsuario\", ");
        sql.append("\"superUsuarioConfirmado\") ");
        sql.append("SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getEmail());
			preparedStatement.setBoolean(6, entity.isEmailConfirmed());
			preparedStatement.setObject(7, entity.getRegistrationDate());
			preparedStatement.setString(8, entity.getPasswordHash());
			preparedStatement.setBoolean(9, entity.isAccountStatus());
			preparedStatement.setBoolean(10, entity.isSuperUser());
			preparedStatement.setBoolean(11, entity.isSuperUserConfirmed());
			
			preparedStatement.executeUpdate();
		
    	} catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_REGISTRATION_FAILED_SQL_EXCEPTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_REGISTRATION_SQL_EXCEPTION.getContent() +exception.getMessage();
            
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_REGISTRATION_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_REGISTRATION_FAILED.getContent()+ exception.getMessage();
            
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
    }

	@Override
	public void update(final UserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("UPDATE \"Usuario\" ");
		sql.append("SET \"usarioId\" = ?, ");
		sql.append("    \"primerNombre\" = ?, ");
		sql.append("    \"apellido\" = ?, ");
		sql.append("    \"nombreUsuario\" = ?, ");
		sql.append("    \"email\" = ?, ");
		sql.append("    \"emailConfirmado\" = ?, ");
		sql.append("    \"fechaRegistro\" = ?, ");
		sql.append("    \"passwordHash\" = ?, ");
		sql.append("    \"estado\" = ?, ");
		sql.append("    \"esSuperUsuario\" = ?, ");
		sql.append("    \"superUsuarioConfirmado\" = ? ");

		sql.append("WHERE \"usuarioId\" = ?; " );
			
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getEmail());
			preparedStatement.setBoolean(6, entity.isEmailConfirmed());
			preparedStatement.setObject(7, entity.getRegistrationDate());
			preparedStatement.setString(8, entity.getPasswordHash());
			preparedStatement.setBoolean(9, entity.isAccountStatus());
			preparedStatement.setBoolean(10, entity.isSuperUser());
			preparedStatement.setBoolean(11, entity.isSuperUserConfirmed());
			
			preparedStatement.executeUpdate();
		
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_UPDATE_USER_FAILED_SQL_EXCEPTION.getTitle()+" "+ MessagesEnum.USER_ERROR_UPDATE_USER_FAILED_SQL_EXCEPTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UPDATE_USER_FAILED_SQL_EXCEPTION.getTitle()+""+MessagesEnum.TECHNICAL_ERROR_UPDATE_USER_FAILED_SQL_EXCEPTION.getContent();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UPDATE_USER_FAILED.getTitle()+""+MessagesEnum.USER_ERROR_UPDATE_USER_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UPDATE_USER_FAILED.getTitle()+""+MessagesEnum.TECHNICAL_ERROR_UPDATE_USER_FAILED.getContent();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public List<UserEntity> findByFilter(final UserEntity filterEntity) {
		var parametersList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		
			try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
				
				for (int index = 0; index < parametersList.size(); index++) {
					preparedStatement.setObject(index + 1, parametersList.get(index));
				}
				
				return executeSentenceFindByFilter(preparedStatement);
				
			}catch (final ExtraClaseException exception) {
				throw exception;
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SEARCH_USER_FAILED_SQL_EXCEPTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_USER_FAILED_SQL_EXCEPTION.getContent() +exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SEARCH_USER_FAILED.getContent();
			var technicalMessage =MessagesEnum.TECHNICAL_ERROR_SEARCH_USER_FAILED.getContent()  + exception.getMessage();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
		}
	}
	
	private String createSentenceFindByFilter(final UserEntity filterEntity, final List<Object> parameterList) {
		final var sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("\"usuarioId\" , ");
		sql.append("\"primerNombre\" , ");
		sql.append("\"apellido\" , ");
		sql.append("\"nombreUsuario\" , ");
		sql.append("\"email\" , ");
		sql.append("\"emailConfirmado\" , ");
		sql.append("\"fechaRegistro\" , ");
		sql.append("\"passwordHash\" , ");
		sql.append("\"estado\" , ");
		sql.append("\"esSuperUsuario\" , ");
		sql.append("\"superUsuarioConfirmado\" ");
		sql.append("FROM \"Usuario\"  ");
		
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        
        return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final UserEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UserEntity());
		final var conditions = new ArrayList<String>();

		addCondition(conditions, parameterList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "\"usuarioId\" = ? ",
		filterEntityValidated.getId());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstName()), "\"primerNombre\" = ? ",
		filterEntityValidated.getFirstName());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getLastName()), "\"apellido\" = ? ",
		filterEntityValidated.getLastName());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getUsername()), "\"nombreUsuario\" = ? ",
		filterEntityValidated.getUsername());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getEmail()), "\"email\" = ? ",
		filterEntityValidated.getEmail());
		
		addCondition(conditions, parameterList,
		filterEntityValidated.isEmailConfirmed(), "\"emailConfirmado\" = ? ",
		filterEntityValidated.isEmailConfirmed());
		
		addCondition(conditions, parameterList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getRegistrationDate()), "\"fechaRegistro\" = ? ",
		filterEntityValidated.getRegistrationDate());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getPasswordHash()), "\"passwordHash\" = ? ",
		filterEntityValidated.getPasswordHash());
		
		addCondition(conditions, parameterList,
		!filterEntityValidated.isAccountStatus(), "\"estado\" = ? ",
		filterEntityValidated.isAccountStatus());
		
		addCondition(conditions, parameterList,
		!filterEntityValidated.isSuperUser(), "\"esSuperUsuario\" = ? ",
		filterEntityValidated.isSuperUser());
		
		addCondition(conditions, parameterList,
		!filterEntityValidated.isSuperUserConfirmed(), "\"superUsuarioConfirmado\" = ? ",
		filterEntityValidated.isSuperUserConfirmed());
		
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
	
private List<UserEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		
		var users = new ArrayList<UserEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				var user = new UserEntity();
				user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioId")));
            	user.setFirstName(resultSet.getString("primerNombre"));
            	user.setLastName(resultSet.getString("apellido"));
            	user.setUsername(resultSet.getString("nombreUsuario"));
            	user.setEmail(resultSet.getString("email"));
            	user.setEmailConfirmed(resultSet.getBoolean("emailConfirmado"));
            	user.setRegistrationDate(resultSet.getTimestamp("fechaRegistro").toLocalDateTime());
            	user.setPasswordHash(resultSet.getString("passwordHash"));
            	user.setAccountStatus(resultSet.getBoolean("estado"));
            	user.setSuperUser(resultSet.getBoolean("esSuperUsuario"));
            	user.setSuperUserConfirmed(resultSet.getBoolean("superUsuarioConfirmado"));
            	
				users.add(user);

			}
		} catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SEARCH_USER_FAILED_SQL_EXCEPTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_USER_FAILED_SQL_EXCEPTION + exception.getMessage();
	        throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SEARCH_USER_FAILED.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SEARCH_USER_FAILED.getContent();
	        throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	    }
		return users;
		
	}

@Override
public UserEntity findById(final UUID id) {
	return findByFilter(new UserEntity(id)).stream().findFirst().orElse(new UserEntity());
}
}
