package db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourse {

	private ComboPooledDataSource cpds;

	public DataSourse() {
		cpds = new ComboPooledDataSource();
		// cpds.setDriverClass("org.postgresql.Driver"); // loads the jdbc driver
		cpds.setJdbcUrl("jdbc:postgresql://10.0.1.251/edr");
		cpds.setUser("edr");
		cpds.setPassword("1q2w3e4r");

		// the settings below are optional -- c3p0 can work with defaults
		cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}


}
