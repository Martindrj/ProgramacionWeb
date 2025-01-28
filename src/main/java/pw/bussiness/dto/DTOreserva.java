package pw.bussiness.dto;

import java.time.LocalDate;

/**
 * Clase DTOreserva.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public abstract class DTOreserva {
	/** ID de la reserva .*/
	protected int ID;
	/** Nombre del usuario que reserva. */
	protected String usuario;
	/** Nombre de la pista que reserva. */
	protected String pista;
	/** Fecha de la reserva. */
	protected LocalDate fecha;
	/** Duracion de la reserva. */
	protected int duracion;
	/** Precio inicial de la reserva. */
	protected float precio;
	/** Descuento aplicado a la reserva(en decimal). */
	protected float descuento;
	/** Tipo de reserva(0=Infantil, 1=Familiar, 2=Adulto). */
	protected int tipoReserva;
	/** Identificador del bono(0=No pertenece a bono). */
	protected int bono;
	/** Numero participantes. */
	protected int numParticipantes;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase DTOreserva.
	 */
	public DTOreserva() {
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOreserva.
	 *
	 * @param ID Entero con el ID de la reserva
	 * @param usuario Cadena de texto con el nombre del usuario que reserva.
	 * @param pista Cadena de texto con el nombre de la pista que reserva.
	 * @param fecha Tipo LocalDate con la fecha de la reserva.
	 * @param duracion Entero con la duracion de la reserva.
	 * @param precio Float con el precio inicial de la reserva.
	 * @param descuento Float con el descuento de la reserva.
	 * @param tipoReserva Entero con el tipo de la reserva(0=Infantil, 1=Familiar, 2=Adulto).
	 * @param bono Entero con el id del bono(0=No pertenece a bono).
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public DTOreserva(int ID, String usuario, String pista, LocalDate fecha, int duracion, float precio, float descuento, int tipoReserva, int bono, int numParticipantes) {
		this.ID = ID;
		this.usuario = usuario;
		this.pista = pista;
		this.fecha = fecha;
		this.duracion = duracion;
		this.precio = precio;
		this.descuento = descuento;
		this.tipoReserva = tipoReserva;
		this.bono = bono;
		this.numParticipantes = numParticipantes;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOreserva.
	 *
	 * @param usuario Cadena de texto con el nombre del usuario que reserva.
	 * @param pista Cadena de texto con el nombre de la pista que reserva.
	 * @param fecha Tipo LocalDate con la fecha de la reserva.
	 * @param duracion Entero con la duracion de la reserva.
	 * @param precio Float con el precio inicial de la reserva.
	 * @param descuento Float con el descuento de la reserva.
	 * @param tipoReserva Entero con el tipo de la reserva(0=Infantil, 1=Familiar, 2=Adulto).
	 * @param bono Entero con el id del bono(0=No pertenece a bono).
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public DTOreserva(String usuario, String pista, LocalDate fecha, int duracion, float precio, float descuento, int tipoReserva, int bono, int numParticipantes) {
		this.usuario = usuario;
		this.pista = pista;
		this.fecha = fecha;
		this.duracion = duracion;
		this.precio = precio;
		this.descuento = descuento;
		this.tipoReserva = tipoReserva;
		this.bono = bono;
		this.numParticipantes = numParticipantes;
	}
	
	/**
	 * Obtiene ID de la reserva.
	 * @param none
	 * @return ID Entero con el ID de la reserva.
	 */
	public int getId() {
		return this.ID;
	}
	
	/**
	 * Establece ID de la reserva
	 * @param ID Entero con el ID de la reserva.
	 * @return none
	 */
	public void setId(int ID) {
		this.ID = ID;
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
	 * @return fecha LocalDate con la fecha de creacion de la reserva.
	 */
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	/**
	 * Establece fecha de creacion de la reserva.
	 * @param fecha LocalDate con la fecha de creacion de la reserva.
	 * @return none
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene duracion de la reserva.
	 * @param none
	 * @return duracion Entero con la duracion de la reserva.
	 */
	public int getDuracion() {
		return this.duracion;
	}
	
	/**
	 * Establece duracion de la reserva.
	 * @param duracion Entero con la duracion de la reserva.
	 * @return none
	 */
    public void setDuracion(int duracion) {
    	this.duracion = duracion;
    }
	
	/**
	 * Obtiene precio inicial de la reserva.
	 * @param none
	 * @return precio Float con el precio inicial de la reserva.
	 */
	public float getPrecio() {
		return this.precio;
	}
	
	/**
	 * Establece precio inicial de la reserva.
	 * @param precio Float con el precio inicial de la reserva.
	 * @return none
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene descuento de la reserva.
	 * @param none
	 * @return descuento Float con el descuento de la reserva.
	 */
	public float getDescuento() {
		return this.descuento;
	}
	
	/**
	 * Establece descuento de la reserva.
	 * @param descuento Float con el descuento de la reserva.
	 * @return none
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	/**
	 * Obtiene tipoReserva de la reserva.
	 * @param none
	 * @return tipoReserva Entero con el tipo de la reserva.
	 */
	public int getTipoReserva() {
		return this.tipoReserva;
	}
	
	/**
	 * Establece tipoReserva de la reserva.
	 * @param tipoReserva Entero con el tipo de la reserva.
	 * @return none
	 */
    public void setTipoReserva(int tipoReserva) {
    	this.tipoReserva = tipoReserva;
    }
    
    /**
	 * Obtiene id del bono de la reserva.
	 * @param none
	 * @return bono Entero con el id del bono de la reserva.
	 */
	public int getBono() {
		return this.bono;
	}
	
	/**
	 * Establece id del bono de la reserva.
	 * @param duracion Entero con el id del bono de la reserva.
	 * @return none
	 */
    public void setBono(int bono) {
    	this.bono = bono;
    }

	/**
	 * Obtiene el precio final de la reserva.
	 * @return Precio final de la reserva.
	 */
    public float getprecioFinal() {
    	return this.precio * this.descuento;
    }
    
    /**
	 * Obtiene numParticipantes de la reserva.
	 * @param none
	 * @return numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public int getNumParticipantes() {
		return this.numParticipantes;
	}
	
	/**
	 * Establece numParticipantes de la reserva
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 * @return none
	 */
	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}
    
    /**
	 * Obtiene informacion de la reserva.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva.
	 */
	public String toString_() {
		String infoReserva = "\nID: " + this.ID + "\nUsuario: " + this.usuario + "\tPista: " + this.pista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPrecio inicial: " + this.precio + "\tDescuento: " + this.descuento + "\tTipo de reserva: " + this.tipoReserva + "\tBono: " + this.bono;
		return infoReserva;
	}
}
