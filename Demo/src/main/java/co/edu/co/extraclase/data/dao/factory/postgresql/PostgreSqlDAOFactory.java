package co.edu.co.extraclase.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
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
import co.edu.co.extraclase.data.dao.entity.postgresql.ColorPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.ListPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.NotificationPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.NotificationTypePostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.PriorityPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.ProjectPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.ProjectStatusPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.ProjectUserPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.StatusPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.TaskPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.TaskUserPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.UnitOfMeasurePostgreSqlDAO;
import co.edu.co.extraclase.data.dao.entity.postgresql.UserPostgreSqlDAO;
import co.edu.co.extraclase.data.dao.factory.DAOFactory;


public class PostgreSqlDAOFactory extends DAOFactory {

	public PostgreSqlDAOFactory() {
		 openConnection();
	} 
	
	@Override
	protected void openConnection() {
		try {
		this.connection = DriverManager.getConnection("");
		} catch(final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_CLOSED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_CLOSED.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_CLOSED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_CLOSED.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
	}
	
	@Override
	public ColorDAO getColorDAO() {
		return new ColorPostgreSqlDAO(connection); 
	}

	@Override
	public ListDAO getListDAO() {
		return new ListPostgreSqlDAO(connection);
	}

	@Override
	public NotificationDAO getNotificationDAO() {
		return new NotificationPostgreSqlDAO(connection);
	}

	@Override
	public NotificationTypeDAO getNotificationTypeDAO() {
		return new NotificationTypePostgreSqlDAO(connection);
	}

	@Override
	public PriorityDAO getPriorityDAO() {
		return new PriorityPostgreSqlDAO(connection);
	}

	@Override
	public ProjectDAO getProjectDAO() {
		return new ProjectPostgreSqlDAO(connection);
	}

	@Override
	public ProjectStatusDAO getProjectStatusDAO() {
		return new ProjectStatusPostgreSqlDAO(connection);
	}

	@Override
	public ProjectUserDAO getProjectUserDAO() {
		return new ProjectUserPostgreSqlDAO(connection);
	}

	@Override
	public StatusDAO getStatusDAO() {
		return new StatusPostgreSqlDAO(connection);
	}

	@Override
	public TaskDAO getTaskDAO() {
		return new TaskPostgreSqlDAO(connection);
	}

	@Override
	public TaskUserDAO getTaskUserDAO() {
		return new TaskUserPostgreSqlDAO(connection);	
	}

	@Override
	public UnitOfMeasureDAO getUnitOfMeasureDAO() {
		return new UnitOfMeasurePostgreSqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserPostgreSqlDAO(connection); 
	}

	

}
