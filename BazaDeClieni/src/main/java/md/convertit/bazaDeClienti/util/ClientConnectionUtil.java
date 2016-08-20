package md.convertit.bazaDeClienti.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ClientConnectionUtil {
	
	private static final Logger log = Logger.getLogger(ClientConnectionUtil.class.getName());
	
	private static Connection connection;
	private static String host = "jdbc:mysql://localhost:3306/clist";
	private static String dbClientName = "root";
	private static String dbClientPassword = "convertit";
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			log.info("loaded mysql driver");
		} catch (ClassNotFoundException e) {
			log.severe(String.format("Class not found: %s",e.getMessage()));
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// obtin conexiunea de la DriverManager
		connection = DriverManager.getConnection(host,dbClientName,dbClientPassword );
		log.info("loaded connection");
		return connection;
	}
	

}
