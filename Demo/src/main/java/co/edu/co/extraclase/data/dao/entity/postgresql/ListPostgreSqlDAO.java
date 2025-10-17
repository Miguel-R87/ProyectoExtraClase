package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.ListDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ListEntity;

public class ListPostgreSqlDAO extends SqlConnection implements ListDAO{

	public ListPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(ListEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListEntity> findByFilter(ListEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ListEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
