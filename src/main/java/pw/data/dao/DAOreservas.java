package pw.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import pw.bussiness.dto.DTOreservaAdultos;
import pw.bussiness.dto.DTOreservaFamiliar;
import pw.bussiness.dto.DTOreservaInfantil;
import pw.data.common.DBConnection;


/**
 * Clase DAOreservas.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DAOreservas extends DBConnection{
	
	/**
	 * Guarda una reserva infantil no perteneciente a bono en la base de datos.
	 * @param DTOreservaInfantil Tipo DTOreservaInfantil con la reserva.
	 * @return none.
	 */
	public void GuardarInfantilIndividual(DTOreservaInfantil DTOreservaInfantil, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarReservaIndividual");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaInfantil.getUsuario());
			ps.setString(2,DTOreservaInfantil.getPista());
			ps.setDate(3,conversionDate(DTOreservaInfantil.getFecha()));
			ps.setInt(4,DTOreservaInfantil.getDuracion());
			ps.setFloat(5,DTOreservaInfantil.getPrecio());
			ps.setFloat(6, DTOreservaInfantil.getDescuento());
			ps.setInt(7,0);
			ps.setInt(8,DTOreservaInfantil.getNumInfantil());
			ps.setInt(9,0);
			ps.setInt(10,DTOreservaInfantil.getNumInfantil());
		
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Guarda una reserva familiar no perteneciente a bono en la base de datos.
	 * @param DTOreservaFamiliar Tipo DTOreservaFamiliar con la reserva.
	 * @return none.
	 */
	public void GuardarFamiliarIndividual(DTOreservaFamiliar DTOreservaFamiliar, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarReservaIndividual");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaFamiliar.getUsuario());
			ps.setString(2,DTOreservaFamiliar.getPista());
			ps.setDate(3,conversionDate(DTOreservaFamiliar.getFecha()));
			ps.setInt(4,DTOreservaFamiliar.getDuracion());
			ps.setFloat(5,DTOreservaFamiliar.getPrecio());
			ps.setFloat(6, DTOreservaFamiliar.getDescuento());
			ps.setInt(7,1);
			ps.setInt(8,DTOreservaFamiliar.getNumInfantil());
			ps.setInt(9,DTOreservaFamiliar.getNumAdultos());
			ps.setInt(10,DTOreservaFamiliar.getNumInfantil()+DTOreservaFamiliar.getNumAdultos());
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Guarda una reserva adultos no perteneciente a bono en la base de datos.
	 * @param DTOreservaAdultos Tipo DTOreservaAdultos con la reserva.
	 * @return none.
	 */
	public void GuardarAdultosIndividual(DTOreservaAdultos DTOreservaAdultos, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarReservaIndividual");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaAdultos.getUsuario());
			ps.setString(2,DTOreservaAdultos.getPista());
			ps.setDate(3,conversionDate(DTOreservaAdultos.getFecha()));
			ps.setInt(4,DTOreservaAdultos.getDuracion());
			ps.setFloat(5,DTOreservaAdultos.getPrecio());
			ps.setFloat(6, DTOreservaAdultos.getDescuento());
			ps.setInt(7,2);
			ps.setInt(8,0);
			ps.setInt(9,DTOreservaAdultos.getNumAdultos());
			ps.setInt(10,DTOreservaAdultos.getNumAdultos());
			
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Guarda una reserva infantil perteneciente a bono en la base de datos.
	 * @param DTOreservaInfantil Tipo DTOreservaInfantil con la reserva.
	 * @return none.
	 */
	public void GuardarInfantilBono(DTOreservaInfantil DTOreservaInfantil, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarReservaBono");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaInfantil.getUsuario());
			ps.setString(2,DTOreservaInfantil.getPista());
			ps.setDate(3,conversionDate(DTOreservaInfantil.getFecha()));
			ps.setInt(4,DTOreservaInfantil.getDuracion());
			ps.setFloat(5,DTOreservaInfantil.getPrecio());
			ps.setFloat(6, DTOreservaInfantil.getDescuento());
			ps.setInt(7,0);
			ps.setInt(8,DTOreservaInfantil.getBono());
			ps.setInt(9,DTOreservaInfantil.getNumInfantil());
			ps.setInt(10,0);
			ps.setInt(11,DTOreservaInfantil.getNumInfantil());
		
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	/**
	 * Modifica la reserva infantil en la base de datos.
	 * @param DTOreservaInfantil Tipo DTOreservaInfantil con la reserva.
	 * @return boolean Dependiendo de si lo modifica o no.
	 */
	public boolean ModificarInfantil(DTOreservaInfantil DTOreservaInfantil, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarReserva");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaInfantil.getUsuario());
			ps.setString(2,DTOreservaInfantil.getPista());
			ps.setDate(3,conversionDate(DTOreservaInfantil.getFecha()));
			ps.setInt(4,DTOreservaInfantil.getDuracion());
			ps.setFloat(5,DTOreservaInfantil.getPrecio());
			ps.setFloat(6, DTOreservaInfantil.getDescuento());
			ps.setInt(7,0);
			if(DTOreservaInfantil.getBono()==0) {
				ps.setNull(8, 0);
			}else {
				ps.setInt(8, DTOreservaInfantil.getBono());
			}
			ps.setInt(9,DTOreservaInfantil.getNumInfantil());
			ps.setInt(10,0);
			ps.setInt(11,DTOreservaInfantil.getNumInfantil());
			ps.setInt(12,DTOreservaInfantil.getId());
			
			ps.executeUpdate();	
			if (ps != null) {
				ps.close();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Modifica la reserva familiar en la base de datos.
	 * @param DTOreservaFamiliar Tipo DTOreservaFamiliar con la reserva.
	 * @return boolean Dependiendo de si lo modifica o no.
	 */
	public boolean ModificarFamiliar(DTOreservaFamiliar DTOreservaFamiliar, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarReserva");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaFamiliar.getUsuario());
			ps.setString(2,DTOreservaFamiliar.getPista());
			ps.setDate(3,conversionDate(DTOreservaFamiliar.getFecha()));
			ps.setInt(4,DTOreservaFamiliar.getDuracion());
			ps.setFloat(5,DTOreservaFamiliar.getPrecio());
			ps.setFloat(6, DTOreservaFamiliar.getDescuento());
			ps.setInt(7,1);
			if(DTOreservaFamiliar.getBono()==0) {
				ps.setNull(8, 0);
			}else {
				ps.setInt(8, DTOreservaFamiliar.getBono());
			}
			ps.setInt(9,DTOreservaFamiliar.getNumInfantil());
			ps.setInt(10,DTOreservaFamiliar.getNumAdultos());
			ps.setInt(11,DTOreservaFamiliar.getNumInfantil()+DTOreservaFamiliar.getNumAdultos());
			ps.setInt(12,DTOreservaFamiliar.getId());
			
			ps.executeUpdate();	
			if (ps != null) {
				ps.close();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Modifica la reserva adultos en la base de datos.
	 * @param DTOreservaAdultos Tipo DTOreservaAdultos con la reserva.
	 * @return boolean Dependiendo de si lo modifica o no.
	 */
	public boolean ModificarAdultos(DTOreservaAdultos DTOreservaAdultos, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarReserva");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,DTOreservaAdultos.getUsuario());
			ps.setString(2,DTOreservaAdultos.getPista());
			ps.setDate(3,conversionDate(DTOreservaAdultos.getFecha()));
			ps.setInt(4,DTOreservaAdultos.getDuracion());
			ps.setFloat(5,DTOreservaAdultos.getPrecio());
			ps.setFloat(6, DTOreservaAdultos.getDescuento());
			ps.setInt(7,2);
			if(DTOreservaAdultos.getBono()==0) {
				ps.setNull(8, 0);
			}else {
				ps.setInt(8, DTOreservaAdultos.getBono());
			}
			ps.setInt(9,0);
			ps.setInt(10,DTOreservaAdultos.getNumAdultos());
			ps.setInt(11,DTOreservaAdultos.getNumAdultos());
			ps.setInt(12,DTOreservaAdultos.getId());
			
			ps.executeUpdate();	
			if (ps != null) {
				ps.close();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Borra la reserva en la base de datos.
	 * @param ID Entero con el ID de la reserva.
	 * @return fechaReserva Tipo LocalDate con la fecha de la reserva.
	 */
	public boolean Borrar(int ID, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("BorrarReserva");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setInt(1,ID);
			
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Borra la reserva en la base de datos.
	 * @param correo Cadena de texto con el correo del usuario.
	 * @return fechaReserva Tipo LocalDate con la fecha de la reserva.
	 */
	public boolean BorrarUsuarioFecha(String correo, LocalDate fechaReserva, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("BorrarReservaUsuarioFecha");
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setString(1,correo);
			ps.setDate(2,conversionDate(fechaReserva));
			
			ps.executeUpdate();
			if (ps != null) {
				ps.close();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Obtiene todas las reservas infantiles en la base de datos.
	 * @param id Entero con el id de la reserva.
	 * @return listaReservas Tipo DTOreservaInfantil Con toda la informacion de la reserva infantil en la base de datos.
	 */
	public DTOreservaInfantil BuscarReservasInfantilID(int id, java.util.Properties prop) {
		DTOreservaInfantil DTOreservaInfantil = null;
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerReservasID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,id);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numInfantil);
		    		return aux;
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return DTOreservaInfantil;
	}
	
	/**
	 * Obtiene todas las reservas familiares en la base de datos.
	 * @param id Entero con el id de la reserva.
	 * @return listaReservas Tipo DTOreservaFamiliar Con toda la informacion de la reserva familiar en la base de datos.
	 */
	public DTOreservaFamiliar BuscarReservasFamiliarID(int id, java.util.Properties prop) {
		DTOreservaFamiliar DTOreservaFamiliar = null;
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerReservasID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,id);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numAdultos, numInfantil+numAdultos);
		    		return aux;
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return DTOreservaFamiliar;
	}
	
	/**
	 * Obtiene todas las reservas adultos en la base de datos.
	 * @param id Entero con el id de la reserva.
	 * @return listaReservas Tipo DTOreservaAdultos Con toda la informacion de la reserva adultos en la base de datos.
	 */
	public DTOreservaAdultos BuscarReservasAdultosID(int id, java.util.Properties prop) {
		DTOreservaAdultos DTOreservaAdultos = null;
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerReservasID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,id);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bono = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numAdultos, numAdultos);
					return aux;
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return DTOreservaAdultos;
	}
	
	/**
	 * Obtiene todas las reservas infantiles en la base de datos.
	 * @param none.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles en la base de datos.
	 */
	public ArrayList <DTOreservaInfantil> ListaReservasInfantil(java.util.Properties prop) {
		ArrayList <DTOreservaInfantil> listaReservas = new ArrayList <DTOreservaInfantil>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerReservas");
			PreparedStatement ps = con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares en la base de datos.
	 * @param none.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas familiares en la base de datos.
	 */
	public ArrayList <DTOreservaFamiliar> ListaReservasFamiliar(java.util.Properties prop) {
		ArrayList <DTOreservaFamiliar> listaReservas = new ArrayList <DTOreservaFamiliar>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerReservas");
			PreparedStatement ps = con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numAdultos, numInfantil+numAdultos);
		    		listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas adultos en la base de datos.
	 * @param none.
	 * @return listaReservas Tipo ArrayList <DTOreservaAdultos> Vector con todas las reservas adultos en la base de datos.
	 */
	public ArrayList <DTOreservaAdultos> ListaReservasAdultos(java.util.Properties prop) {
		ArrayList <DTOreservaAdultos> listaReservas = new ArrayList <DTOreservaAdultos>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerReservas");
			PreparedStatement ps = con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bono = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numAdultos, numAdultos);
					listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas infantiles de un usuario en la base de datos.
	 * @param nombre Cadena de texto con el correo de un usuario.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de un usuario en la base de datos.
	 */
	public ArrayList <DTOreservaInfantil> ListaReservasInfantilUsuario(String correo, java.util.Properties prop) {
		ArrayList <DTOreservaInfantil> listaReservas = new ArrayList <DTOreservaInfantil>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,correo);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares de un usuario en la base de datos.
	 * @param nombre Cadena de texto con el correo de un usuario.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas familiares de un usuario en la base de datos.
	 */
	public ArrayList <DTOreservaFamiliar> ListaReservasFamiliarUsuario(String correo, java.util.Properties prop) {
		ArrayList <DTOreservaFamiliar> listaReservas = new ArrayList <DTOreservaFamiliar>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,correo);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numAdultos , numInfantil+numAdultos);
		    		listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas adultos de un usuario en la base de datos.
	 * @param nombre Cadena de texto con el correo de un usuario.
	 * @return listaReservas Tipo ArrayList <DTOreservaAdultos> Vector con todas las reservas adultos de un usuario en la base de datos.
	 */
	public ArrayList <DTOreservaAdultos> ListaReservasAdultosUsuario(String correo, java.util.Properties prop) {
		ArrayList <DTOreservaAdultos> listaReservas = new ArrayList <DTOreservaAdultos>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,correo);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bono = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numAdultos, numAdultos);
					listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas infantiles de un usuario en la base de datos.
	 * @param nombre Cadena de texto con el correo de un usuario.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de un usuario en la base de datos.
	 */
	public ArrayList <DTOreservaInfantil> ListaReservasInfantilUsuarioFecha(String correo, LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList <DTOreservaInfantil> listaReservas = new ArrayList <DTOreservaInfantil>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,correo);
			ps.setDate(2,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares de un usuario en la base de datos.
	 * @param nombre Cadena de texto con el correo de un usuario.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas familiares de un usuario en la base de datos.
	 */
	public ArrayList <DTOreservaFamiliar> ListaReservasFamiliarUsuarioFecha(String correo, LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList <DTOreservaFamiliar> listaReservas = new ArrayList <DTOreservaFamiliar>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,correo);
			ps.setDate(2,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("ID_users");
		    		String pista = rs.getString("ID_pistas");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numAdultos, numInfantil+numAdultos);
		    		listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas adultos de un usuario en la base de datos.
	 * @param nombre Cadena de texto con el correo de un usuario.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaAdultos> Vector con todas las reservas adultos de un usuario en la base de datos.
	 */
	public ArrayList <DTOreservaAdultos> ListaReservasAdultosUsuarioFecha(String correo, LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList <DTOreservaAdultos> listaReservas = new ArrayList <DTOreservaAdultos>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasUsuario");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,correo);
			ps.setDate(2,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bono = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numAdultos, numAdultos);
					listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas infantiles en una fecha en la base de datos.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles en una fecha en la base de datos.
	 */
	public ArrayList <DTOreservaInfantil> ListaReservasInfantilFecha(LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList <DTOreservaInfantil> listaReservas = new ArrayList <DTOreservaInfantil>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasFecha");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setDate(1,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares en una fecha en la base de datos.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas familiares en una fecha en la base de datos.
	 */
	public ArrayList <DTOreservaFamiliar> ListaReservasFamiliarFecha(LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList <DTOreservaFamiliar> listaReservas = new ArrayList <DTOreservaFamiliar>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasFecha");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setDate(1,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bono = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numInfantil, numAdultos, numInfantil+numAdultos);
		    		listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas adultos en una fecha en la base de datos.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaAdultos> Vector con todas las reservas adultos en una fecha en la base de datos.
	 */
	public ArrayList <DTOreservaAdultos> ListaReservasAdultosFecha(LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList <DTOreservaAdultos> listaReservas = new ArrayList <DTOreservaAdultos>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasFecha");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setDate(1,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bono = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numAdultos, numAdultos);
					listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas infantiles de un bono en la base de datos.
	 * @param bono Entero con el id del bono.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de un bono en la base de datos.
	 */
	public ArrayList <DTOreservaInfantil> ListaReservasInfantilBono(int bono, java.util.Properties prop) {
		ArrayList <DTOreservaInfantil> listaReservas = new ArrayList <DTOreservaInfantil>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasBono");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,bono);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bon = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares de un bono en la base de datos.
	 * @param bono Entero con el id del bono.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas familiares de un bono en la base de datos.
	 */
	public ArrayList <DTOreservaFamiliar> ListaReservasFamiliarBono(int bono, java.util.Properties prop) {
		ArrayList <DTOreservaFamiliar> listaReservas = new ArrayList <DTOreservaFamiliar>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasBono");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,bono);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bon = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numInfantil, numAdultos, numInfantil+numAdultos);
		    		listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas adultos de un bono en la base de datos.
	 * @param bono Entero con el id del bono.
	 * @return listaReservas Tipo ArrayList <DTOreservaAdultos> Vector con todas las reservas adultos de un bono en la base de datos.
	 */
	public ArrayList <DTOreservaAdultos> ListaReservasAdultosBono(int bono, java.util.Properties prop) {
		ArrayList <DTOreservaAdultos> listaReservas = new ArrayList <DTOreservaAdultos>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasBono");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,bono);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bon = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numAdultos, numAdultos);
					listaReservas.add(aux);
				}
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas infantiles de una pista en una fecha en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de una pista en una fecha en la base de datos.
	 */
	public ArrayList<DTOreservaInfantil> ListaReservasInfantilPista(String nombrePista, java.util.Properties prop) {
		ArrayList<DTOreservaInfantil> listaReservas = new ArrayList<DTOreservaInfantil>();
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasPista");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombrePista);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bon = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
		    	}
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares de una pista en una fecha en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas adultos de una pista en una fecha en la base de datos.
	 */
	public ArrayList<DTOreservaFamiliar> ListaReservasFamiliarPista(String nombrePista, java.util.Properties prop) {
		ArrayList<DTOreservaFamiliar> listaReservas = new ArrayList<DTOreservaFamiliar>();
		
		try {	
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasPista");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombrePista);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bon = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numInfantil, numAdultos, numInfantil+numAdultos);
		    		listaReservas.add(aux);
		    	}
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}

	/**
	 * Obtiene todas las reservas infantiles de una pista en una fecha en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de una pista en una fecha en la base de datos.
	 */
	public ArrayList<DTOreservaAdultos> ListaReservasAdultosPista(String nombrePista, java.util.Properties prop) {
		ArrayList<DTOreservaAdultos> listaReservas = new ArrayList<DTOreservaAdultos>();
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasPista");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombrePista);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bon = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numAdultos, numAdultos);
					listaReservas.add(aux);
		    	}
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas infantiles de una pista en una fecha en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de una pista en una fecha en la base de datos.
	 */
	public ArrayList<DTOreservaInfantil> ListaReservasInfantilPistaFecha(String nombrePista, LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList<DTOreservaInfantil> listaReservas = new ArrayList<DTOreservaInfantil>();
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasPistaFecha");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombrePista);
			ps.setDate(2,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")==0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 0;
		    		int bon = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		
		    		DTOreservaInfantil aux = new DTOreservaInfantil(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numInfantil, numInfantil);
		    		listaReservas.add(aux);	
		    	}
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene todas las reservas familiares de una pista en una fecha en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaFamiliar> Vector con todas las reservas adultos de una pista en una fecha en la base de datos.
	 */
	public ArrayList<DTOreservaFamiliar> ListaReservasFamiliarPistaFecha(String nombrePista, LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList<DTOreservaFamiliar> listaReservas = new ArrayList<DTOreservaFamiliar>();
		
		try {	
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasPistaFecha");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombrePista);
			ps.setDate(2,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")>0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 1;
		    		int bon = rs.getInt("bono");
		    		int numInfantil = rs.getInt("numInfantil");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaFamiliar aux = new DTOreservaFamiliar(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numInfantil, numAdultos, numInfantil+numAdultos);
		    		listaReservas.add(aux);
		    	}
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}

	/**
	 * Obtiene todas las reservas infantiles de una pista en una fecha en la base de datos.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param fechaReserva Tipo LocalDate con la fecha de la reserva.
	 * @return listaReservas Tipo ArrayList <DTOreservaInfantil> Vector con todas las reservas infantiles de una pista en una fecha en la base de datos.
	 */
	public ArrayList<DTOreservaAdultos> ListaReservasAdultosPistaFecha(String nombrePista, LocalDate fechaReserva, java.util.Properties prop) {
		ArrayList<DTOreservaAdultos> listaReservas = new ArrayList<DTOreservaAdultos>();
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerReservasPistaFecha");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1,nombrePista);
			ps.setDate(2,conversionDate(fechaReserva));
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	if(rs.getInt("numAdultos")>0 && rs.getInt("numInfantil")==0) {
		    		int ID = rs.getInt("ID");
		    		String usuario = rs.getString("usuario");
		    		String pista = rs.getString("pista");
		    		LocalDate fecha = java.time.LocalDate.parse(rs.getDate("fecha").toString());
		    		int duracion = rs.getInt("duracion");
		    		float precio = rs.getFloat("precio");
		    		float descuento = rs.getFloat("descuento");
		    		int tipoReserva = 2;
		    		int bon = rs.getInt("bono");
		    		int numAdultos = rs.getInt("numAdultos");
		    		
		    		DTOreservaAdultos aux = new DTOreservaAdultos(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bon, numAdultos, numAdultos);
					listaReservas.add(aux);
		    	}
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaReservas;
	}
	
	/**
	 * Obtiene el numero de reservas a partir de la hora del sistema en la base de datos.
	 * @param none.
	 * @return numeroReservas Entero con el numero de reservas a partir de la hora del sistema en la base de datos.
	 */
	public int numeroReservasFuturas(java.util.Properties prop) {
		int numeroReservas=0;
		
		try {
			Connection con=getConnection();
			
			String statement = prop.getProperty("LeerReserva");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(statement);
			
		    while (rs.next()) 
		    	if(java.time.LocalDate.parse(rs.getDate("fecha").toString()).compareTo(LocalDate.now())>0)
		    		numeroReservas++;

		}catch(Exception e) {
			System.out.println(e);
		}
		return numeroReservas;
	}
	
	/**
	 * Funcion que devuelve el id del ultimo bono creado en la base de datos
	 * 
	 */
	public int getUltimoIdBono(java.util.Properties prop) {
		int numBono=0;
		
		try {		
			Connection con=getConnection();
			
			String statement = prop.getProperty("LeerReservas");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(statement);
			
		    while (rs.next())
		    	if(numBono<rs.getInt("bono"))
		    		numBono= rs.getInt("bono");
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		return numBono;
	}
	
	/**
	 * Funcion que devuelve el numero de reservas creadas en un bono en la base de datos
	 * 
	 */
	public int numeroReservasBono(int id, java.util.Properties prop) {
		int cont=0;
		
		try {		
			Connection con=getConnection();
			
			String statement = prop.getProperty("LeerReserva")+" where bono='"+id+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(statement);
			
		    while (rs.next())
		    	cont++;
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		return cont;
	}

	public java.sql.Date conversionDate(LocalDate localdate) {
		java.sql.Date date = java.sql.Date.valueOf( localdate );
		return  date; 
	}
}