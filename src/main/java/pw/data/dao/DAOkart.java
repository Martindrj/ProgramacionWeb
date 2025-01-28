package pw.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pw.bussiness.dto.DTOkart;
import pw.bussiness.gestores.Estado;
import pw.data.common.DBConnection;


/**
 * Clase DAOkart.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DAOkart extends DBConnection {
	
	/**
	 * Guarda un kart en la base de datos.
	 * @param DTOkart Tipo DTOkart con toda la informacion del kart.
	 * @return none.
	 */
	public void Guardar(DTOkart DTOkart, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("GuardarKart");
			PreparedStatement ps = con.prepareStatement(statement);
			
			if(DTOkart.getTipo()) 
				ps.setInt(1,0);	//0=Adulto
			else 
				ps.setInt(1,1);	//1=Infantil
			
			if(DTOkart.getEstado()==Estado.disponible)
				ps.setInt(2,0);	//0=Disponible
			else if(DTOkart.getEstado()==Estado.reservado)
				ps.setInt(2,1);	//1=Reservado
			else 
				ps.setInt(2,2);	//2=Mantenimiento
			if(DTOkart.getPistaAsociada()!=0) {
				ps.setInt(3, DTOkart.getPistaAsociada());
			}else {
				ps.setNull(3, 0);
			}
			
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
	 * Modifica el kart en la base de datos.
	 * @param kart Tipo DTOkart con toda la informacion del kart.
	 * @param ID Entero del identificador del kart..
	 * @return none.
	 */
	public void Modificar(DTOkart DTOkart, int ID, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("ModificarKart");
			PreparedStatement ps = con.prepareStatement(statement);
			
			if (DTOkart.getTipo())
				ps.setInt(1,0);	//0=Adulto
			else
				ps.setInt(1,1);	//1=Infantil
			
			if(DTOkart.getEstado()==Estado.disponible)
				ps.setInt(2,0);	//0=Disponible
			else if(DTOkart.getEstado()==Estado.reservado)
				ps.setInt(2,1);	//1=Reservado
			else 
				ps.setInt(2,2);	//2=Mantenimiento
			
			if(DTOkart.getPistaAsociada()==0) {
				ps.setNull(3, 0);
			}else {
				ps.setInt(3, DTOkart.getPistaAsociada());
			}
			ps.setInt(4, ID);
			
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
	 * Borra el kart en la base de datos.
	 * @param ID Entero del identificador del kart.
	 * @return boolean True si lo ha podido borrar, False en caso contrario.
	 */
	public boolean Borrar (int ID, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("BorrarKart");
			PreparedStatement ps = con.prepareStatement(statement);
			
			ps.setInt(1,ID);
			
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
	 * Obtiene todos los karts en la base de datos.
	 * @param none.
	 * @return listaKarts Tipo ArrayList <DTOkart> Vector con todos los karts en la base de datos.
	 */
	public ArrayList <DTOkart> ListaKarts(java.util.Properties prop){
		ArrayList <DTOkart> listaKarts= new ArrayList <DTOkart>();
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("LeerKarts");
			PreparedStatement ps=con.prepareStatement(statement);
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	int ID = rs.getInt("ID");
		    	int tip = rs.getInt("tipo");
		    	int estad = rs.getInt("estado");
		    	int pistaAsociada = rs.getInt("pistaAsociada");
		    	boolean tipo = false;
		    	
		    	if (tip==0)
					tipo=true;
				else
					tipo=false;
		    	
		    	Estado estado = Estado.disponible;
		   
		    	if(estad==0)
		    		estado=Estado.disponible;
		    	else if(estad==1)
		    		estado=Estado.reservado;
		    	else
		    		estado=Estado.mantenimiento;
	
		    	DTOkart kart = new DTOkart(ID, tipo, estado, pistaAsociada);
		    	
	    		listaKarts.add(kart);
		    }
		    if (ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaKarts;
	}
	
	/**
	 * Busca el kart con el id como parametro en la base de datos.
	 * @param ID Entero con el identificador del kart.
	 * @return DTOkart Tipo DTOkart con la informacion del kart.
	 */
	public DTOkart buscarKartID(int ID, java.util.Properties prop){
		DTOkart DTOkart = null;
		
		try {		
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerKartsID");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,ID);
			ResultSet rs = ps.executeQuery();
			
		    while (rs.next()) {
		    	int id = rs.getInt("ID");
		    	int tip = rs.getInt("tipo");
		    	int estad = rs.getInt("estado");
		    	int pistaAsociada = rs.getInt("pistaAsociada");
		    
		    	boolean tipo = false;
		    	
		    	if (tip==0)
					tipo=true;
				else
					tipo=false;
		    	
		    	Estado estado = Estado.disponible;
		   
		    	if(estad==0)
		    		estado=Estado.disponible;
		    	else if(estad==1)
		    		estado=Estado.reservado;
		    	else
		    		estado=Estado.mantenimiento;
		    	
		    	DTOkart aux = new DTOkart(id, tipo, estado, pistaAsociada);
		    	
		    	return aux;
		    }
		    if (ps != null) {
		    	ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return DTOkart;
	}	
	
	/**
	 * Busca los karts con el estado como parametro en la base de datos.
	 * @param estado Entero con el estado del kart.
	 * @return listaKarts Tipo ArrayList <DTOkart> Vector con los karts con el estado buscado.
	 */
	public ArrayList <DTOkart> buscarKartsEstado(int estado, java.util.Properties prop) {
		ArrayList <DTOkart> listaKarts = new ArrayList <DTOkart>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerKartsEstado");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,estado);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	int id = rs.getInt("ID");
		    	int tip = rs.getInt("tipo");
		    	int estad = rs.getInt("estado");
		    	int pistaAsociada = rs.getInt("pistaAsociada");
		    	
		    	boolean tipo = false;
		    	
		    	if (tip==0)
					tipo=true;
				else
					tipo=false;
		    	
		    	Estado estadoA = Estado.disponible;
		   
		    	if(estad==0)
		    		estadoA=Estado.disponible;
		    	else if(estad==1)
		    		estadoA=Estado.reservado;
		    	else
		    		estadoA=Estado.mantenimiento;
		    	
		    	DTOkart aux = new DTOkart(id, tipo, estadoA, pistaAsociada);
		 
		    	listaKarts.add(aux);
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaKarts;
	}
	
	/**
	 * Busca los karts con el pistaAsociada como parametro en la base de datos.
	 * @param pistaAsociada Entero con el pistaAsociada del kart.
	 * @return listaKarts Tipo ArrayList <DTOkart> Vector con los karts con el pistaAsociada buscado.
	 */
	public ArrayList <DTOkart> buscarKartsPista(int pistaAsociada, java.util.Properties prop) {
		ArrayList <DTOkart> listaKarts = new ArrayList <DTOkart>();
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerKartsPistaAsociada");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,pistaAsociada);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	int id = rs.getInt("ID");
		    	int tip = rs.getInt("tipo");
		    	int estad = rs.getInt("estado");
		    	int pistaAsociad = rs.getInt("pistaAsociada");
		    	
		    	boolean tipo = false;
		    	
		    	if (tip==0)
					tipo=true;
				else
					tipo=false;
		    	
		    	Estado estadoA = Estado.disponible;
		   
		    	if(estad==0)
		    		estadoA=Estado.disponible;
		    	else if(estad==1)
		    		estadoA=Estado.reservado;
		    	else
		    		estadoA=Estado.mantenimiento;
		    	
		    	DTOkart aux = new DTOkart(id, tipo, estadoA, pistaAsociad);
		 
		    	listaKarts.add(aux);
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return listaKarts;
	}
	
	/**
	 * Busca los karts con el pistaAsociada como parametro en la base de datos.
	 * @param pistaAsociada Entero con el pistaAsociada del kart.
	 * @return numKarts Entero con la cantidad de karts el pistaAsociada buscado.
	 */
	public int buscarNumeroKartsPista(int pistaAsociada, java.util.Properties prop) {
		int numKarts=0;
		
		try {
			Connection con = getConnection();
			
			String statement = prop.getProperty("LeerKartsPistaAsociada");
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1,pistaAsociada);
			ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	numKarts++;
		    }
		    if (ps != null) {
		        ps.close();
		    }
		}catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return numKarts;
	}
	
	/**
	 * Asocia al kart con el id como parametro el pistaAsociada en la base de datos.
	 * @param ID Entero con el identificador del kart.
	 * @param pistaAsociada Entero con el pistaAsociada del kart.
	 * @return none.
	 */
	public void AsociarKart(int ID, int pistaAsociada, java.util.Properties prop) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			String statement = prop.getProperty("AsociarKart");
			PreparedStatement ps = con.prepareStatement(statement);

			ps.setInt(1, pistaAsociada);
			ps.setInt(2, ID);
			
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
     * Busca el kart con el id como parametro en la base de datos.
     * @param ID Entero con el identificador del kart.
     * @return boolean Tipo boolean con la informacion de si existe el kart o no.
     */
    public boolean existeKartID(int ID, java.util.Properties prop){

        try {
            Connection con = getConnection();

            String statement = prop.getProperty("LeerKartsID");
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setInt(1,ID);
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