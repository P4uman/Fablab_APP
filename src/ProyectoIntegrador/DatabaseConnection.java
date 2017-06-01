package ProyectoIntegrador;
import java.sql.*;
public class DatabaseConnection {

	private String surl = "jdbc:oracle:thin:@localhost:1521:XE";
	private Connection connection;

	public DatabaseConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(surl,"PROYECTOINTEGRADOR","a1234*");
			System.out.println (" - Conexion con ORACLE establecida -");
			
		} catch (Exception e) {
			System.out.println ("-Error de Conexion con ORACLE-");
			e.printStackTrace();
		}
	}

	
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
