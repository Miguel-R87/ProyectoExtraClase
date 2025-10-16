package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.data.dao.entity.ColorDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ColorEntity;

public final class ColorPostgreSqlDAO extends SqlConnection implements ColorDAO {

	protected ColorPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ColorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColorEntity> findByFilter(ColorEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
