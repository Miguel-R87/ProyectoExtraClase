package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.NotificationDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.NotificationEntity;

public class NotificationPostgreSqlDAO extends SqlConnection implements NotificationDAO {

	public NotificationPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NotificationEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificationEntity> findByFilter(NotificationEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
