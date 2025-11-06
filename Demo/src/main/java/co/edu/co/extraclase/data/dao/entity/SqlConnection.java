package co.edu.co.extraclase.data.dao.entity;

import java.sql.Connection;
import co.edu.co.extraclase.crosscuting.helper.SqlConnectionHelper;

public abstract class SqlConnection {

    private Connection connection;

    protected SqlConnection(final Connection connection) {	
        setConnection(connection);
    }

    protected Connection getConnection() {
        return connection;
    }

    private void setConnection(final Connection connection) {
    	SqlConnectionHelper.ensureConnectionIsOpen(connection);
    	this.connection = connection;
    }    
}
