package pw.bussiness.dto;

import java.time.LocalDate;

/**
 * Clase DTOindividualReservas.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DTOindividualReservas extends DTOcreadorReservas{
	/**	Obtiene reserva de tipo infantil. Asigna valores a todos sus atributos. */
	@Override
	public DTOreservaInfantil crearReservaInfantil(DTOusuario DTOusuario, DTOpista DTOpista, LocalDate fecha, int duracion, float precio, float descuento, int bono, int numInfantil) {
		DTOreservaInfantil DTOreservaInfantil = new DTOreservaInfantil(DTOusuario.getCorreo(), DTOpista.getNombre(), fecha, duracion, precio, descuento, 0, bono, numInfantil, numInfantil);
		return DTOreservaInfantil;
	}

	/**	Obtiene reserva de tipo familiar. Asigna valores a todos sus atributos. */
	@Override
	public DTOreservaFamiliar crearReservaFamiliar(DTOusuario DTOusuario, DTOpista DTOpista, LocalDate fecha, int duracion, float precio, float descuento, int bono, int numInfantil, int numAdultos) {
		DTOreservaFamiliar DTOreservaFamiliar = new DTOreservaFamiliar(DTOusuario.getCorreo(), DTOpista.getNombre(), fecha, duracion, precio, descuento, 1, bono, numInfantil, numAdultos, numInfantil+numAdultos);
		return DTOreservaFamiliar;
	}

	/**	Obtiene reserva de tipo adulto. Asigna valores a todos sus atributos. */
	@Override
	public DTOreservaAdultos crearReservaAdultos(DTOusuario DTOusuario, DTOpista DTOpista, LocalDate fecha, int duracion, float precio, float descuento, int bono, int numAdultos) {
		DTOreservaAdultos DTOreservaAdultos = new DTOreservaAdultos(DTOusuario.getCorreo(), DTOpista.getNombre(), fecha, duracion, precio, descuento, 2, bono, numAdultos, numAdultos);
		return DTOreservaAdultos;
	}
}