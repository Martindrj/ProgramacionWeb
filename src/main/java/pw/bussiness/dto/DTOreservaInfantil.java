package pw.bussiness.dto;

import java.time.LocalDate;

/**
 * Clase DTOreservaInfantil.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DTOreservaInfantil extends DTOreserva{
	/**	Numero de niños en la reserva. */
	private int numInfantil;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase DTOreservaInfantil.
	 */
	public DTOreservaInfantil(){
		super();
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOreservaInfantil.
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
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public DTOreservaInfantil(int ID, String usuario, String pista, LocalDate fecha, int duracion, float precio, float descuento, int tipoReserva, int bono, int numInfantil, int numParticipantes) {
		super(ID, usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numParticipantes);
		this.numInfantil = numInfantil;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOreservaInfantil.
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
	 * @param numParticipantes Entero con el numero de participantes de la reserva.
	 */
	public DTOreservaInfantil(String usuario, String pista, LocalDate fecha, int duracion, float precio, float descuento, int tipoReserva, int bono, int numInfantil, int numParticipantes) {
		super(usuario, pista, fecha, duracion, precio, descuento, tipoReserva, bono, numParticipantes);
		this.numInfantil = numInfantil;
	}

	/**
	 * Obtiene numero de niños en la reserva.
	 * 
	 * @return numInfantil Entero con el numero de niños en la reserva.
	 */
	public int getNumInfantil() {
		return this.numInfantil;
	}
	
	/**
	 * Establece numero de niños en la reserva.
	 *
	 * @param numInfantil Entero con el numero de niños en la reserva.
	 */
	public void setNumInfantil(int numInfantil) {
		this.numInfantil = numInfantil;
	}
	
	/**
	 * Obtiene informacion de la reserva de niños.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva de niños.
	 */
	public String toString() {
		String infoReserva = toString_();
		infoReserva = infoReserva + "\tNumero niños: " + this.numInfantil;
		return infoReserva;
	}
}
