package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.ProjectStatusDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ProjectStatusEntity;

public final class ProjectStatusPostgreSqlDAO extends SqlConnection implements ProjectStatusDAO {

	protected ProjectStatusPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProjectStatusEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectStatusEntity> findByFilter(ProjectStatusEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectStatusEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
