package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.TaskDAO;
import co.edu.co.extraclase.entity.TaskEntity;

public final class TaskPostgreSqlDAO extends SqlConnection implements TaskDAO{

	protected TaskPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(TaskEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TaskEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskEntity> findByFilter(TaskEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TaskEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
