package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.co.extraclase.data.dao.entity.NotificationTypeDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.NotificationTypeEntity;
import java.util.UUID;

public class NotificationTypePostgreSqlDAO extends SqlConnection implements NotificationTypeDAO {

	public NotificationTypePostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NotificationTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificationTypeEntity> findByFilter(NotificationTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationTypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
