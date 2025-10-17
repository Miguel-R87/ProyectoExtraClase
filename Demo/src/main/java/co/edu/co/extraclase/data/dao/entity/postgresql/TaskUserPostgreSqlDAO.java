package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.TaskUserDAO;
import co.edu.co.extraclase.entity.TaskUserEntity;

public class TaskUserPostgreSqlDAO extends SqlConnection implements TaskUserDAO{

	public TaskUserPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(TaskUserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TaskUserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskUserEntity> findByFilter(TaskUserEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskUserEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TaskUserEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
