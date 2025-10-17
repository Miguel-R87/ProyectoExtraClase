package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.StatusDAO;
import co.edu.co.extraclase.entity.StatusEntity;

public class StatusPostgreSqlDAO extends SqlConnection implements StatusDAO{

	public StatusPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StatusEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusEntity> findByFilter(StatusEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
