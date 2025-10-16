package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.data.dao.entity.UnitOfMeasureDAO;
import co.edu.co.extraclase.entity.UnitOfMeasureEntity;

public final class UnitOfMeasurePostgreSqlDAO extends SqlConnection implements UnitOfMeasureDAO {

	protected UnitOfMeasurePostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UnitOfMeasureEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnitOfMeasureEntity> findByFilter(UnitOfMeasureEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitOfMeasureEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
