package co.edu.co.extraclase.data.dao.factory;
import java.sql.Connection;
import java.sql.SQLException;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.SqlConnectionHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;
import co.edu.co.extraclase.data.dao.entity.ColorDAO;
import co.edu.co.extraclase.data.dao.entity.ListDAO;
import co.edu.co.extraclase.data.dao.entity.NotificationDAO;
import co.edu.co.extraclase.data.dao.entity.NotificationTypeDAO;
import co.edu.co.extraclase.data.dao.entity.PriorityDAO;
import co.edu.co.extraclase.data.dao.entity.ProjectDAO;
import co.edu.co.extraclase.data.dao.entity.ProjectStatusDAO;
import co.edu.co.extraclase.data.dao.entity.ProjectUserDAO;
import co.edu.co.extraclase.data.dao.entity.StatusDAO;
import co.edu.co.extraclase.data.dao.entity.TaskDAO;
import co.edu.co.extraclase.data.dao.entity.TaskUserDAO;
import co.edu.co.extraclase.data.dao.entity.UnitOfMeasureDAO;
import co.edu.co.extraclase.data.dao.entity.UserDAO;
import co.edu.co.extraclase.data.dao.factory.postgresql.PostgreSqlDAOFactory;



public abstract class DAOFactory {
    protected Connection connection;
    protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;

    public static PostgreSqlDAOFactory getFactory() {
    	
    	if (FactoryEnum.POSTGRESQL.equals(factory)) {
    		return new PostgreSqlDAOFactory(); 
		}else {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
    }
    
    
    
    public abstract ColorDAO getColorDAO();
    
    public abstract ListDAO getListDAO();
    
    public abstract NotificationDAO getNotificationDAO();
    
    public abstract NotificationTypeDAO getNotificationTypeDAO();
    
    public abstract PriorityDAO getPriorityDAO();
    
    public abstract ProjectDAO getProjectDAO();
    
    public abstract ProjectStatusDAO getProjectStatusDAO();
    
    public abstract ProjectUserDAO getProjectUserDAO();
    
    public abstract StatusDAO getStatusDAO();
    
    public abstract TaskDAO getTaskDAO();
    
    public abstract TaskUserDAO getTaskUserDAO();
    
    public abstract UnitOfMeasureDAO getUnitOfMeasureDAO();
    
    public abstract UserDAO getUserDAO();
    
    protected abstract void openConnection();
    
    public final void initTransaction(){
        SqlConnectionHelper.ensureTransactionIsNotStarted(connection);

        try{
            connection.setAutoCommit(false);
        } catch (final SQLException exception){
            var userMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        }

    }

    public final void commitTransaction(){
        
    	SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try{
            connection.setAutoCommit(false);
        } catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        }
    }

    public final void rollbackTransaction(){
        SqlConnectionHelper.ensureTransactionIsStarted(connection);
        try{
            connection.rollback();
        } catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        }
    }

    public final  void closeConnection(){
        SqlConnectionHelper.ensureConnectionIsOpen(connection);

        try{
            connection.close();
        } catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            throw ExtraClaseException.create(exception, userMessage, techincalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            var techincalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            throw ExtraClaseException.create(exception,userMessage, techincalMessage);
        }



    }
}