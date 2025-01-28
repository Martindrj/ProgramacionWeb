package pw.display.javabean;

import java.io.Serializable;

/**
 * Clase reservasBean.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class reservasBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ID de la reserva .*/
	private String id = "";
	/** Nombre del usuario que reserva. */
	private String usuario = "";
	/** Nombre de la pista que reserva. */
	private String pista = "";
	/** Fecha de la reserva. */
	private String fecha = "";
	/** Duracion de la reserva. */
	private String duracion = "";
	/** Precio inicial de la reserva. */
	private String precio = "";
	/** Descuento aplicado a la reserva). */
	private String descuento = "";
	/** Tipo de reserva. */
	private String tipoReserva = "";
	/** Identificador del bono. */
	private String bono = "";
	/**	Numero de niños en la reserva. */
	private String numInfantil;
	/**	Numero de adultos en la reserva. */
	private String numAdultos;
	/**	Numero de participantes en la reserva. */
	private String numParticipantes;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase reservasBean.
	 */
	public reservasBean() {
	}
	
	/**
	 * Obtiene id de la reserva.
	 * @param none
	 * @return id Cadena de texto con el id de la reserva.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Establece id de la reserva
	 * @param id Cadena de texto con el id de la reserva.
	 * @return none
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Obtiene nombre del usuario que reserva.
	 * @param none
	 * @return usuario Cadena de texto con el nombre del usuario que reserva.
	 */
	public String getUsuario() {
		return this.usuario;
	}
	/**
	 * Establece nombre del usuario que reserva.
	 * @param usuario Cadena de texto con el nombre del usuario que reserva.
	 * @return none
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Obtiene nombre de la pista que reserva.
	 * @param none
	 * @return pista Cadena de texto con el nombre de la pista que reserva.
	 */
	public String getPista() {
		return this.pista;
	}
	/**
	 * Establece nombre de la pista que reserva.
	 * @param nombre Cadena de texto con el nombre de la pista que reserva.
	 * @return none
	 */
	public void setPista(String pista) {
		this.pista = pista;
	}
	
	/**
	 * Obtiene fecha de creacion de la reserva.
	 * @param none
	 * @return fecha String con la fecha de creacion de la reserva.
	 */
	public String getFecha() {
		return this.fecha;
	}
	
	/**
	 * Establece fecha de creacion de la reserva.
	 * @param fecha String con la fecha de creacion de la reserva.
	 * @return none
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene duracion de la reserva.
	 * @param none
	 * @return duracion Cadena de texto con la duracion de la reserva.
	 */
	public String getDuracion() {
		return this.duracion;
	}
	
	/**
	 * Establece duracion de la reserva.
	 * @param duracion Cadena de texto con la duracion de la reserva.
	 * @return none
	 */
    public void setDuracion(String duracion) {
    	this.duracion = duracion;
    }
	
	/**
	 * Obtiene precio inicial de la reserva.
	 * @param none
	 * @return precio Cadena de texto con el precio inicial de la reserva.
	 */
	public String getPrecio() {
		return this.precio;
	}
	
	/**
	 * Establece precio inicial de la reserva.
	 * @param precio Cadena de texto con el precio inicial de la reserva.
	 * @return none
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene descuento de la reserva.
	 * @param none
	 * @return descuento Cadena de texto con el descuento de la reserva.
	 */
	public String getDescuento() {
		return this.descuento;
	}
	
	/**
	 * Establece descuento de la reserva.
	 * @param descuento Cadena de texto con el descuento de la reserva.
	 * @return none
	 */
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	/**
	 * Obtiene tipoReserva de la reserva.
	 * @param none
	 * @return tipoReserva Cadena de texto con el tipo de la reserva.
	 */
	public String getTipoReserva() {
		return this.tipoReserva;
	}
	
	/**
	 * Establece tipoReserva de la reserva.
	 * @param tipoReserva Cadena de texto con el tipo de la reserva.
	 * @return none
	 */
    public void setTipoReserva(String tipoReserva) {
    	this.tipoReserva = tipoReserva;
    }
    
    /**
	 * Obtiene id del bono de la reserva.
	 * @param none
	 * @return bono Cadena de texto con el id del bono de la reserva.
	 */
	public String getBono() {
		return this.bono;
	}
	
	/**
	 * Establece id del bono de la reserva.
	 * @param duracion Cadena de texto con el id del bono de la reserva.
	 * @return none
	 */
    public void setBono(String bono) {
    	this.bono = bono;
    }
    
    /**
	 * Obtiene numero de niños en la reserva.
	 * 
	 * @return numInfantil Cadena de texto con el numero de niños en la reserva.
	 */
	public String getNumInfantil(){
		return this.numInfantil;
	}
	
	/**
	 * Establece numero de niños en la reserva.
	 *
	 * @param numInfantil Cadena de texto con el numero de niños en la reserva.
	 */
	public void setNumInfantil(String numInfantil){
		this.numInfantil = numInfantil;
	}
	
	/**
	 * Obtiene numero de adultos en la reserva.
	 * 
	 * @return numAdultos Cadena de texto con el numero de adultos en la reserva.
	 */
	public String getNumAdultos(){
		return this.numAdultos;
	}
	
	/**
	 * Establece numero de adultos en la reserva.
	 *
	 * @param numAdultos Cadena de texto con el numero de adultos en la reserva.
	 */
	public void setNumAdultos(String numAdultos){
		this.numAdultos = numAdultos;
	}
	
	/**
	 * Obtiene numero de participantes en la reserva.
	 * 
	 * @return numAdultos Cadena de texto con el numero de participantes en la reserva.
	 */
	public String getNumParticipantes(){
		return this.numParticipantes;
	}
	
	/**
	 * Establece numero de participantes en la reserva.
	 *
	 * @param numAdultos Cadena de texto con el numero de participantes en la reserva.
	 */
	public void setNumParticipantes(String numParticipantes){
		this.numParticipantes = numParticipantes;
	}
}
