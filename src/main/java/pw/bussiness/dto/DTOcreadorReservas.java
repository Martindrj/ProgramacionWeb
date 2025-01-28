package pw.bussiness.dto;

import java.time.LocalDate;

/**
 * Clase DTOcreadorReservas.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public abstract class DTOcreadorReservas {
	/** Cabezera del metodo crearReservaInfantil. */
	public abstract DTOreservaInfantil crearReservaInfantil(DTOusuario DTOusuario, DTOpista DTOpista, LocalDate fecha, int duracion, float precio, float descuento, int bono, int numInfantil);
	/** Cabezera del metodo crearReservaFamiliar. */
	public abstract DTOreservaFamiliar crearReservaFamiliar(DTOusuario DTOusuario, DTOpista DTOpista, LocalDate fecha, int duracion, float precio, float descuento, int bono, int numInfantil, int numAdultos);
	/** Cabezera del metodo crearReservaAdulto. */
	public abstract DTOreservaAdultos crearReservaAdultos(DTOusuario DTOusuario, DTOpista DTOpista, LocalDate fecha, int duracion, float precio, float descuento, int bono, int numAdultos);
}
