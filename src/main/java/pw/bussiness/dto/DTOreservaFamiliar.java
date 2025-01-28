package pw.bussiness.dto;

import java.time.LocalDate;

/**
 * Clase DTOreservaFamiliar.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DTOreservaFamiliar extends DTOreserva{
	/**	Numero de niños en la reserva. */
	private int numInfantil;
	/**	Numero de adultos en la reserva. */
	private int numAdultos;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase DTOreservaFamiliar.
	 */
	public DTOreservaFamiliar(){
		super();
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOreservaFamiliar.
	 *
	 * @param ID Entero con el ID de la reserva.
	 * @param usuario Cadena de texto con el nombre del usuario que reserva.
	 * @param pista Cadena de texto con el nombre de la pista que reserva.
	 * @param fecha Tipo LocalDate con la fecha de la reserva.
	 * @param duracion Entero con la duracion de la reserva.
	 * @param precio Float con el precio inicial de la reserva.
	 * @param descuento Float con el descuento de la reserva.
	 * @param tipoReserva Entero con el tipo de la reserva(0=Infantil, 1=Familiar, 2=Adulto).
	 * @param bono Entero con el id del bono(0=No pertenece a bono).
	 * @param numInfantil Entero con la cantidad de niños.
	 * @param numAdultos Entero con la cantidad de adultos.
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public DTOreservaFamiliar(int ID, String usuario, String pista, LocalDate fecha, int duracion, float precio, float descuento, int tipoReserva, int bono, int numInfantil, int numAdultos, int numParticipantes) {
		super(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numParticipantes);
		this.numInfantil = numInfantil;
		this.numAdultos = numAdultos;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOreservaFamiliar.
	 *
	 * @param usuario Cadena de texto con el nombre del usuario que reserva.
	 * @param pista Cadena de texto con el nombre de la pista que reserva.
	 * @param fecha Tipo LocalDate con la fecha de la reserva.
	 * @param duracion Entero con la duracion de la reserva.
	 * @param precio Float con el precio inicial de la reserva.
	 * @param descuento Float con el descuento de la reserva.
	 * @param tipoReserva Entero con el tipo de la reserva(0=Infantil, 1=Familiar, 2=Adulto).
	 * @param bono Entero con el id del bono(0=No pertenece a bono).
	 * @param numInfantil Entero con la cantidad de niños.
	 * @param numAdultos Entero con la cantidad de adultos.
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public DTOreservaFamiliar(String usuario, String pista, LocalDate fecha, int duracion, float precio, float descuento, int tipoReserva, int bono, int numInfantil, int numAdultos, int numParticipantes) {
		super(usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numParticipantes);
		this.numInfantil = numInfantil;
		this.numAdultos = numAdultos;
	}
	
	/**
	 * Obtiene numero de niños en la reserva.
	 * 
	 * @return numInfantil Entero con el numero de niños en la reserva.
	 */
	public int getNumInfantil(){
		return this.numInfantil;
	}
	
	/**
	 * Establece numero de niños en la reserva.
	 *
	 * @param numInfantil Entero con el numero de niños en la reserva.
	 */
	public void setNumInfantil(int numInfantil){
		this.numInfantil = numInfantil;
	}
	
	/**
	 * Obtiene numero de adultos en la reserva.
	 * 
	 * @return numAdultos Entero con el numero de adultos en la reserva.
	 */
	public int getNumAdultos(){
		return this.numAdultos;
	}
	
	/**
	 * Establece numero de adultos en la reserva.
	 *
	 * @param numAdultos Entero con el numero de adultos en la reserva.
	 */
	public void setNumAdultos(int numAdultos){
		this.numAdultos = numAdultos;
	}
	
	/**
	 * Obtiene informacion de la reserva familiar.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva familiar.
	 */
	public String toString() {
		String infoReserva = toString_();
		infoReserva = infoReserva + "\tNumero niños: " + this.numInfantil + "\tNumero adultos: " + this.numAdultos;
		return infoReserva;
	}
}
