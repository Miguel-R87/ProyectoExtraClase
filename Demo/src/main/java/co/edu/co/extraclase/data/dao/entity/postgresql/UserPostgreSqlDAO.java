package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.SqlConnectionHelper;
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
        sql.append("INSERT INTO Usario (usuarioId, primerNombre, apellido, nombreUsuario, email, confirmacionEmail, fechaRegistro, passwordHash, estado, esSuperUsuario, confirmacionSuperUsuario) ");
        sql.append("SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
        
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getUserId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getEmail());
			preparedStatement.setBoolean(6, entity.EmailConfirmation());
			preparedStatement.setObject(7, entity.getRegistrationDate());
			preparedStatement.setString(8, entity.getPasswordHash());
			preparedStatement.setBoolean(9, entity.AccountStatus());
			preparedStatement.setBoolean(10, entity.SuperUser());
			preparedStatement.setBoolean(11, entity.SuperUserConfirmation());
			
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
		sql.append("UPDATE Usario " );
		sql.append("SET usarioId = ?, " );
		sql.append("primerNombre = ?, " );
		sql.append("apellido = ?, " );
		sql.append("nombreUsuario = ?, " );
		sql.append("email = ?, " );
		sql.append("confirmacionEmail = ?, " );
		sql.append("fechaRegistro = ?, " );
		sql.append("passwordHash = ?, " );
		sql.append("estado = ?, " );
		sql.append("esSuperUsuario = ?, " );
		sql.append("confirmacionSuperUsuario = ? " );
		sql.append("WHERE usuarioId = ?; " );
			
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getUserId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getEmail());
			preparedStatement.setBoolean(6, entity.EmailConfirmation());
			preparedStatement.setObject(7, entity.getRegistrationDate());
			preparedStatement.setString(8, entity.getPasswordHash());
			preparedStatement.setBoolean(9, entity.AccountStatus());
			preparedStatement.setBoolean(10, entity.SuperUser());
			preparedStatement.setBoolean(11, entity.SuperUserConfirmation());
			
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
		return null;
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findById( final UUID id) {
final var sql = new StringBuilder();
		
		var user = new UserEntity(); 
		
		sql.append("SELECT" );
		sql.append(" usuarioId, " );
		sql.append(" primerNombre, " );
		sql.append(" apellido, " );
		sql.append(" nombreUsuario, " );
		sql.append(" email, " );
		sql.append(" confirmacionEmail, " );
		sql.append(" fechaRegistro, " );
		sql.append(" passwordHash, " );
		sql.append(" estado, " );
		sql.append(" esSuperUsuario, " );
		sql.append(" confirmacionSuperUsuario " );
		sql.append("FROM Usario; " );
		

        try (final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id); 
            
            try (var resultSet = preparedStatement.executeQuery()) {
            	user.setUserId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("usuarioId")));
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
            	
            	
            }
        
        }
            catch (final SQLException exception) {
                var userMessage = "Se ha presentado un problema tratando de encontrar la información de un usuario. Intente de nuevo.";
                var technicalMessage = "SQLException al buscar Usuario: " + exception.getMessage();
                throw ExtraClaseException.create(exception, userMessage, technicalMessage);
            } catch (final Exception exception) {
                var userMessage = "Se ha presentado un problema inesperado tratando de encontrar la información de un usuario.";
                var technicalMessage = "Excepción inesperada al buscar Usuario: " + exception.getMessage();
                throw ExtraClaseException.create(exception, userMessage, technicalMessage);
            }
            
		
		return user;
	}

}
