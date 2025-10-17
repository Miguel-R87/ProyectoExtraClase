package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.PriorityDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.PriorityEntity;

public class PriorityPostgreSqlDAO extends SqlConnection implements PriorityDAO {

	public PriorityPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PriorityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PriorityEntity> findByFilter(PriorityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriorityEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
