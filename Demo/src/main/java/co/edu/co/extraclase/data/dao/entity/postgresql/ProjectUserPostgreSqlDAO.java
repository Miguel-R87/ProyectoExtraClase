package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.ProjectUserDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ProjectEntity;

public class ProjectUserPostgreSqlDAO extends SqlConnection implements ProjectUserDAO {

	public ProjectUserPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(ProjectEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProjectEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectEntity> findByFilter(ProjectEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProjectEntity entity) {
		// TODO Auto-generated method stub
		
	}



}
