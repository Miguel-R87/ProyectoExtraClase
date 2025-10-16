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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListDAO getListDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationDAO getNotificationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationTypeDAO getNotificationTypeDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriorityDAO getPriorityDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDAO getProjectDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectStatusDAO getProjectStatusDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectUserDAO getProjectUserDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDAO getStatusDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDAO getTaskDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskUserDAO getTaskUserDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitOfMeasureDAO getUnitOfMeasureDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
