package pw.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pw.bussiness.dto.DTOpista;
import pw.bussiness.gestores.Dificultad;
import pw.data.common.DBConnection;


/**
 * Clase DAOpista.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DAOpista extends DBConnection {
	
	/**
	 * Guarda una pista en la base de datos.
	 * @param DTOpista Tipo DTOpista con toda la informacion de la pista
	 * @return none.
	 */
	public void Guardar(DTOpista DTOpista, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarPista");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,DTOpista.getNombre());
			
			if(DTOpista.getEstado()) 
				ps.setInt(2,0);	//0=Disponible
			else 
				ps.setInt(2,1);	//1=No disponible
			
			if(DTOpista.getDificultad()==Dificultad.infantil)
				ps.setInt(3,0);	//0=Infantil
			else if(DTOpista.getDificultad()==Dificultad.familiar)
				ps.setInt(3,1);	//1=Familiar
			else 
				ps.setInt(3,2);	//2=Adulto
			
			ps.setInt(4,DTOpista.getMaxKarts());
			
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
	 * Modifica la pista en la base de datos.
	 * @param pista Tipo DTOpista con toda la informacion de la pista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return none.
	 */
	public void Modificar(DTOpista DTOpista, String nombre, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarPista");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,DTOpista.getNombre());
			
			if (DTOpista.getEstado())
				ps.setInt(2,0);	//0=Disponible
			else
				ps.setInt(2,1);	//1=No disponible
			
			if(DTOpista.getDificultad()==Dificultad.infantil)
				ps.setInt(3,0);	//0=Infantil
			else if(DTOpista.getDificultad()==Dificultad.familiar)
				ps.setInt(3,1);	//1=Familiar
			else 
				ps.setInt(3,2);	//2=Adulto
			
			ps.setInt(4,DTOpista.getMaxKarts());
			ps.setString(5, nombre);
			
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
	 * Modifica la pista en la base de datos.
	 * @param pista Tipo DTOpista con toda la informacion de la pista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return none.
	 */
	public boolean Modificar(DTOpista DTOpista, int id, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarPistaID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,DTOpista.getNombre());
			
			if (DTOpista.getEstado())
				ps.setInt(2,0);	//0=Disponible
			else
				ps.setInt(2,1);	//1=No disponible
			
			if(DTOpista.getDificultad()==Dificultad.infantil)
				ps.setInt(3,0);	//0=Infantil
			else if(DTOpista.getDificultad()==Dificultad.familiar)
				ps.setInt(3,1);	//1=Familiar
			else 
				ps.setInt(3,2);	//2=Adulto
			
			ps.setInt(4,DTOpista.getMaxKarts());
			ps.setInt(5, id);
			
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
	 * Borra la pista en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return boolean True si la ha podido borrar, False en caso contrario.
	 */
	public boolean Borrar (String nombre, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("BorrarPista");
			PreparedStatement ps = con.prepareStatement(statement);
			
			ps.setString(1,nombre);
			
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
	 * Obtiene todas las pistas en la base de datos.
	 * @param none.
	 * @return listaPistas Tipo ArrayList <DTOpista> Vector con todas las pistas en la base de datos.
	 */
	public ArrayList <DTOpista> ListaPistas(java.util.Properties prop){
		ArrayList <DTOpista> listaPistas = new ArrayList <DTOpista>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerPistas");
			PreparedStatement ps=con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	int ID = rs.getInt("ID");
		    	String nombre = rs.getString("nombre");
	    		int estad = rs.getInt("estado");
	    		int dif = rs.getInt("dificultad");
	    		int maxKarts = rs.getInt("maxKarts");
		    	
		    	boolean estado = false;
		    	
		    	if(estad==0)
		    		estado = true;
		    	else if(estad==1)
		    		estado = false;
		    	
		    	Dificultad dificultad = Dificultad.infantil;
		    	
		    	if(dif==0)
					dificultad=Dificultad.infantil;
				else if(dif==1)
					dificultad=Dificultad.familiar;
				else if(dif==2)
					dificultad=Dificultad.adulto;
		    	
		    	DTOpista pista = new DTOpista(ID, nombre, estado, dificultad, maxKarts);
	    		listaPistas.add(pista);
		    }
		    if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaPistas;
	}
	
	/**
	 * Obtiene todas las pistas con una dificultad en la base de datos.
	 * @param dificultad Entero con el valor numero de la dificultad de la pista
	 * @return listaPistas Tipo ArrayList <DTOpista> Vector con todas las pistas en la base de datos.
	 */
	public ArrayList <DTOpista> ListaPistasTipo(int dificultad, java.util.Properties prop){
		ArrayList <DTOpista> listaPistas = new ArrayList <DTOpista>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerPistasTipo");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setInt(1,dificultad);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	int ID = rs.getInt("ID");
		    	String nombre = rs.getString("nombre");
	    		int estad = rs.getInt("estado");
	    		int dif = rs.getInt("dificultad");
	    		int maxKarts = rs.getInt("maxKarts");
		    	
		    	boolean estado = false;
		    	
		    	if(estad==0)
		    		estado = true;
		    	else if(estad==1)
		    		estado = false;
		    	
		    	Dificultad dificulta = Dificultad.infantil;
		    	
		    	if(dif==0)
					dificulta=Dificultad.infantil;
				else if(dif==1)
					dificulta=Dificultad.familiar;
				else if(dif==2)
					dificulta=Dificultad.adulto;
		    	
		    	DTOpista pista = new DTOpista(ID, nombre, estado, dificulta, maxKarts);
		    	
	    		listaPistas.add(pista);
		    }
		    if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaPistas;
	}
	
	/**
	 * Obtiene todas las pistas con un numero de karts mayor al parametro en la base de datos.
	 * @param numKarts Entero con el numero de karts de la pista
	 * @return listaPistas Tipo ArrayList <DTOpista> Vector con todas las pistas en la base de datos.
	 */
	public ArrayList <DTOpista> ListaPistasKarts(int numKarts, java.util.Properties prop){
		ArrayList <DTOpista> listaPistas = new ArrayList <DTOpista>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerPistas");
			PreparedStatement ps=con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("maxKarts")>numKarts) {
		    		int ID = rs.getInt("ID");
		    		String nombre = rs.getString("nombre");
		    		int estad = rs.getInt("estado");
		    		int dif = rs.getInt("dificultad");
		    		int maxKarts = rs.getInt("maxKarts");
		    	
		    		boolean estado = false;
		    	
		    		if(estad==0)
		    			estado = true;
		    		else if(estad==1)
		    			estado = false;

		    		Dificultad dificulta = Dificultad.infantil;

		    		if(dif==0)
		    			dificulta=Dificultad.infantil;
		    		else if(dif==1)
		    			dificulta=Dificultad.familiar;
		    		else if(dif==2)
		    			dificulta=Dificultad.adulto;

		    		DTOpista pista = new DTOpista(ID, nombre, estado, dificulta, maxKarts);

		    		listaPistas.add(pista);
		    	}
		    }
		    if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaPistas;
	}
	
	/**
	 * Busca la pista con el nombre como parametro en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return DTOpista Tipo DTOpista con la informacion de la pista.
	 */
	public DTOpista buscarPista(String nombre, java.util.Properties prop){
		DTOpista DTOpista = null;
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerPistasNombre");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombre);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	int ID = rs.getInt("ID");
		    	String name = rs.getString("nombre");
	    		int estad = rs.getInt("estado");
	    		int dif = rs.getInt("dificultad");
	    		int maxKarts = rs.getInt("maxKarts");
		    	
		    	boolean estado=false;
		    	
		    	if(estad==0)
		    		estado = true;
		    	else if(estad==1)
		    		estado = false;
		    	
		    	Dificultad dificultad = Dificultad.infantil;
		    	
		    	if(dif==0)
					dificultad=Dificultad.infantil;
				else if(dif==1)
					dificultad=Dificultad.familiar;
				else if(dif==2)
					dificultad=Dificultad.adulto;
		    	
		    	DTOpista aux = new DTOpista(ID, name, estado, dificultad, maxKarts);
		    	return aux;
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return DTOpista;
	}	
	
	/**
	 * Busca la pista con el identificador como parametro en la base de datos.
	 * @param id Numero entero con el identificador de la pista.
	 * @return DTOpista Tipo DTOpista con la informacion de la pista.
	 */
	public DTOpista buscarPistaID(int id, java.util.Properties prop){
		DTOpista DTOpista = null;
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerPistasID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	int ID = rs.getInt("ID");
		    	String name = rs.getString("nombre");
	    		int estad = rs.getInt("estado");
	    		int dif = rs.getInt("dificultad");
	    		int maxKarts = rs.getInt("maxKarts");
		    	
		    	boolean estado=false;
		    	
		    	if(estad==0)
		    		estado = true;
		    	else if(estad==1)
		    		estado = false;
		    	
		    	Dificultad dificultad = Dificultad.infantil;
		    	
		    	if(dif==0)
					dificultad=Dificultad.infantil;
				else if(dif==1)
					dificultad=Dificultad.familiar;
				else if(dif==2)
					dificultad=Dificultad.adulto;
		    	
		    	DTOpista aux = new DTOpista(ID, name, estado, dificultad, maxKarts);
		    	return aux;
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return DTOpista;
	}	
	
	/**
	 * Busca la pista con el identificador como parametro en la base de datos.
	 * @param id Numero entero con el identificador de la pista.
	 * @return boolean Tipo booleano con la informacion de si existe o no la pista.
	 */
	public boolean existePistaID(int id, java.util.Properties prop){
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerPistasID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	return true;
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return false;
	}	
}