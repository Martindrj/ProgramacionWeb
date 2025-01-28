package pw.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import pw.bussiness.dto.DTOusuario;
import pw.data.common.DBConnection;


/**
 * Clase DAOusuario.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DAOusuario extends DBConnection {
	
	/**
	 * Guarda un usuario en la base de datos.
	 * @param DTOusuario Tipo DTOusuario con toda la informacion del usuario
	 * @return none.
	 */
	public void Guardar(DTOusuario DTOusuario, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,DTOusuario.getNombreApellidos());
			ps.setString(2,DTOusuario.getCorreo());
			ps.setString(3,DTOusuario.getPassword());
			ps.setString(4,DTOusuario.getRol());
			ps.setDate(5,conversionDate(DTOusuario.getFechaNacimiento()));
			ps.setDate(6,conversionDate(DTOusuario.getFechaInscripcion()));
		
			ps.executeUpdate();	
			if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifica el usuario en la base de datos.
	 * @param DTOusuario Tipo DTOusuario con toda la informacion del usuario.
	 * @param correo Cadena de texto con el correo del usuario a modificar.
	 * @return none.
	 */
	public void Modificar(DTOusuario DTOusuario,String correo, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,DTOusuario.getNombreApellidos());
			ps.setString(2,DTOusuario.getCorreo());
			ps.setString(3,DTOusuario.getPassword());
			ps.setString(4,DTOusuario.getRol());
			ps.setDate(5,DTOusuario.conversionDate(DTOusuario.getFechaNacimiento()));
			ps.setDate(6,DTOusuario.conversionDate(DTOusuario.getFechaInscripcion()));
			ps.setString(7,correo);
			
			ps.executeUpdate();	
			if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Borra el usuario en la base de datos.
	 * @param DTOusuario Tipo DTOusuario con toda la informacion del usuario.
	 * @return boolean True si lo ha podido borrar, False en caso contrario.
	 */
	public boolean Borrar(DTOusuario DTOusuario, java.util.Properties prop){
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("BorrarUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			
			ps.setString(1,DTOusuario.getCorreo());
			
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
			return true;
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Obtiene todos los usuarios en la base de datos.
	 * @param none.
	 * @return listaUsuarios Tipo ArrayList <DTOusuario> Vector con todos los usuarios en la base de datos.
	 */
	public ArrayList <DTOusuario> ListaUsuarios(java.util.Properties prop){
		ArrayList <DTOusuario> listaUsuarios = new ArrayList <DTOusuario>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerUsuarios");
			PreparedStatement ps = con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	int ID= rs.getInt("ID");
		    	String nombre = rs.getString("nombreApellidos");
		    	String correo = rs.getString("correo");
		    	String password = rs.getString("password");
		    	String rol = rs.getString("rol");
		    	LocalDate fechaNacimiento = java.time.LocalDate.parse(rs.getDate("fechaNacimiento").toString());
		    	LocalDate fechaInscripcion = java.time.LocalDate.parse(rs.getDate("fechaInscripcion").toString());
		    	
		    	DTOusuario aux = new DTOusuario(ID, nombre, correo, password, rol, fechaNacimiento, fechaInscripcion);
		  
		    	listaUsuarios.add(aux);
		    }
		    if (ps != null) {
		    	ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	/**
	 * Obtiene un usuario en la base de datos.
	 * @param email Cadena de texto con el correo del usuario.
	 * @return DTOusuario Tipo DTOusuario con la informacion del usuario.
	 */
	public DTOusuario buscarUsuario(String email, java.util.Properties prop){
		DTOusuario DTOusuario = new DTOusuario();
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerUsuariosCorreo");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	int ID= rs.getInt("ID");
		    	String nombre = rs.getString("nombreApellidos");
		    	String correo = rs.getString("correo");
		    	String password = rs.getString("password");
		    	String rol = rs.getString("rol");
		    	LocalDate fechaNacimiento = java.time.LocalDate.parse(rs.getDate("fechaNacimiento").toString());
		    	LocalDate fechaInscripcion = java.time.LocalDate.parse(rs.getDate("fechaInscripcion").toString());
		    	
		    	DTOusuario aux = new DTOusuario(ID, nombre, correo, password, rol, fechaNacimiento, fechaInscripcion);
		    	return aux;
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return DTOusuario;
	}	
	
	public java.sql.Date conversionDate(LocalDate localdate) {
		java.sql.Date date = java.sql.Date.valueOf( localdate );
		return  date; 
	}
}