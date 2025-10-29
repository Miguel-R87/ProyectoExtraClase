package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import co.edu.co.extraclase.data.dao.entity.UserDAO;
import co.edu.co.extraclase.entity.UserEntity;


public class UserPostgreSqlDAO extends SqlConnection implements UserDAO{

	public UserPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        
        final var sql = new StringBuilder();
        sql.append("INSERT INTO \"Usario\" (");
        sql.append("\"usuarioId\", ");
        sql.append("\"primerNombre\", ");
        sql.append("\"apellido\", ");
        sql.append("\"nombreUsuario\", ");
        sql.append("\"email\", ");
        sql.append("\"confirmacionEmail\", ");
        sql.append("\"fechaRegistro\", ");
        sql.append("\"passwordHash\", ");
        sql.append("\"estado\", ");
        sql.append("\"esSuperUsuario\", ");
        sql.append("\"confirmacionSuperUsuario\") ");
        sql.append("SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getEmail());
			preparedStatement.setBoolean(6, entity.isEmailConfirmation());
			preparedStatement.setObject(7, entity.getRegistrationDate());
			preparedStatement.setString(8, entity.getPasswordHash());
			preparedStatement.setBoolean(9, entity.isAccountStatus());
			preparedStatement.setBoolean(10, entity.isSuperUser());
			preparedStatement.setBoolean(11, entity.isSuperUserConfirmation());
			
			preparedStatement.executeUpdate();
		
        }
        catch (final SQLException exception) {
            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo usuario. Intente de nuevo.";
            var technicalMessage = "SQLException al insertar Usuario: " + exception.getMessage();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo usuario.";
            var technicalMessage = "Excepción inesperada al insertar Usuario: " + exception.getMessage();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }

	}

	@Override
	public void update(final UserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("UPDATE \"Usario\" ");
		sql.append("SET \"usarioId\" = ?, ");
		sql.append("    \"primerNombre\" = ?, ");
		sql.append("    \"apellido\" = ?, ");
		sql.append("    \"nombreUsuario\" = ?, ");
		sql.append("    \"email\" = ?, ");
		sql.append("    \"confirmacionEmail\" = ?, ");
		sql.append("    \"fechaRegistro\" = ?, ");
		sql.append("    \"passwordHash\" = ?, ");
		sql.append("    \"estado\" = ?, ");
		sql.append("    \"esSuperUsuario\" = ?, ");
		sql.append("    \"confirmacionSuperUsuario\" = ? ");

		sql.append("WHERE \"usuarioId\" = ?; " );
			
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getEmail());
			preparedStatement.setBoolean(6, entity.isEmailConfirmation());
			preparedStatement.setObject(7, entity.getRegistrationDate());
			preparedStatement.setString(8, entity.getPasswordHash());
			preparedStatement.setBoolean(9, entity.isAccountStatus());
			preparedStatement.setBoolean(10, entity.isSuperUser());
			preparedStatement.setBoolean(11, entity.isSuperUserConfirmation());
			
			preparedStatement.executeUpdate();
		
        }
        catch (final SQLException exception) {
            var userMessage = "Se ha presentado un problema tratando de actualizar la información del nuevo usuario. Intente de nuevo.";
            var technicalMessage = "SQLException al actualizar Usuario: " + exception.getMessage();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "Se ha presentado un problema inesperado tratando de actualizar la información del nuevo usuario.";
            var technicalMessage = "Excepción inesperada al actualizar Usuario: " + exception.getMessage();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
	}

	@Override
	public List<UserEntity> findAll() {
		return findByFilter(new UserEntity());
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
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
	
	private String createSentenceFindByFilter(final UserEntity filterEntity, final List<Object> parameterList) {
		final var sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("\"u.usuarioId\" AS usuarioId , ");
		sql.append("\"u.primerNombre\" , ");
		sql.append("\"u.apellido\" , ");
		sql.append("\"u.nombreUsuario\" , ");
		sql.append("\"u.email\" , ");
		sql.append("\"u.confirmacionEmail\" , ");
		sql.append("\"u.fechaRegistro\" , ");
		sql.append("\"u.passwordHash\" , ");
		sql.append("\"u.estado\" , ");
		sql.append("\"u.esSuperUsuario\" , ");
		sql.append("\"u.confirmacionSuperUsuario\" ");
		sql.append("FROM \"Usuario\" ");
		
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        
        return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final UserEntity filterEntity) {
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UserEntity());
		final var conditions = new ArrayList<String>();

		addCondition(conditions, parameterList,
		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "\"u.usuarioId\" = ? ",
		filterEntityValidated.getId());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstName()), "\"u.primerNombre\" = ? ",
		filterEntityValidated.getFirstName());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getLastName()), "\"u.apellido\" = ? ",
		filterEntityValidated.getLastName());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getUsername()), "\"u.nombreUsuario\" = ? ",
		filterEntityValidated.getUsername());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getEmail()), "\"u.email\" = ? ",
		filterEntityValidated.getEmail());
		
		addCondition(conditions, parameterList,
		filterEntityValidated.isEmailConfirmation(), "\"u.confirmacionEmail\" = ? ",
		filterEntityValidated.isEmailConfirmation());
		
		addCondition(conditions, parameterList,
		!DateTimeHelper.isDefaultDate(filterEntityValidated.getRegistrationDate()), "\"u.fechaRegistro\" = ? ",
		filterEntityValidated.getRegistrationDate());
		
		addCondition(conditions, parameterList,
		!TextHelper.isEmptyWithTrim(filterEntityValidated.getPasswordHash()), "\"u.passwordHash\" = ? ",
		filterEntityValidated.getPasswordHash());
		
		addCondition(conditions, parameterList,
		!filterEntityValidated.isAccountStatus(), "\"u.estado\" = ? ",
		filterEntityValidated.isAccountStatus());
		
		addCondition(conditions, parameterList,
		!filterEntityValidated.isSuperUser(), "\"u.esSuperUsuario\" = ? ",
		filterEntityValidated.isSuperUser());
		
		addCondition(conditions, parameterList,
		!filterEntityValidated.isSuperUserConfirmation(), "\"u.confirmacionSuperUsuario\" = ? ",
		filterEntityValidated.isSuperUserConfirmation());
		
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
		
		var listState = new ArrayList<UserEntity>();
		
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
            	
				listState.add(user);

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
		return listState;
		
	}
			
		
	

	@Override
	public UserEntity findById( final UUID id) {
		return findByFilter(new UserEntity(id)).stream().findFirst().orElse(new UserEntity()); 
	}
	
}
