package pw.data.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de establecer la conexión con MySQL.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */

public class DBConnection {
	protected static String url;
	protected static String user;
	protected static String password;
	protected static String name;
	protected static Connection connection = null;
	
	public DBConnection() {
		
	}
	
	@SuppressWarnings("static-access")
	public DBConnection(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	/*
	public static Properties getSQLProperties(){
		Properties sql_properties = new Properties();
		try{
			FileInputStream sql_properties_file = new FileInputStream("sql.properties");
			sql_properties.load(sql_properties_file);
		}
		catch (IOException e) {
			System.out.println("La conexion ha fallado.");
			e.printStackTrace();
		}
		return sql_properties;
	}
	
	public static Properties cargarProperties() {
		Properties p = new Properties();
		try{	
		    p.load(new FileReader("config.properties"));
		    
		    url = new String(p.getProperty("url"));
		    user = new String(p.getProperty("user"));
		    password = new String(p.getProperty("password"));
		    name = new String(p.getProperty("name"));
		}catch(IOException e) {
			System.err.println("La conexión ha fallado!");
			e.printStackTrace();
		}
		return p;
	}
	*/
	public static Connection getConnection(){
		Connection connection = null;
		//cargarProperties();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("Conexión establecida con la base de datos.");
		} 
		catch (SQLException e) {
			System.err.println("La conexión a la base de datos ha fallado!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("No se ha encontrado el JDBC Driver.");
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if(DBConnection.connection != null && !DBConnection.connection.isClosed()) {
				DBConnection.connection.close();
				System.out.println("Se ha cerrado la conexión a la base de datos!");
			}
		} catch (SQLException e) {
			System.err.println("Error mientras se cerraba la base de datos.");
			e.printStackTrace();
		}
	}
}