package pw.display.javabean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase pistaBean.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class pistaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ID de la pista. */
	private String id = "";
	/** Nombre de la pista. */
	private String nombre = "";
	/** Estado de la pista. */
	private String estado = "";
	/** Dificultad de la pista. */
	private String dificultad = "";
	/** Numero maximo de karts permitidos. */
	private String maxKarts = "";
	/** Lista de karts asociados. */
	private ArrayList<Integer> lista;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase pistaBean.
	 */
	public pistaBean() {
	}

	/**
	 * Obtiene ID de la pista.
	 * @param none.
	 * @return ID Cadena de texto con el identificador de la pista.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Establece ID de la pista.
	 * @param ID Cadena de texto con el identificador de la pista.
	 * @return none.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Obtiene nombre de la pista.
	 * @param none.
	 * @return Cadena de texto con el nombre de la pista.
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Establece nombre de la pista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @return none.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene estado de la pista.
	 * @param none.
	 * @return estadoPista Cadena de texto con el estado de la pista.
	 */
	public String getEstado() {
		return this.estado;
	}
	
	/**
	 * Establece estado de la pista.
	 * @param estado Cadena de texto con el estado de la pista.
	 * @return none.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene dificultad de la pista.
	 * @param none.
	 * @return dificultad Cadena de texto con la dificultad de la pista.
	 */
	public String getDificultad() {
		return this.dificultad;
	}
	
	/**
	 * Establece dificultad de la pista.
	 * @param dificultad Cadena de texto con la dificultad de la pista.
	 * @return none.
	 */
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	/**
	 * Obtiene maxKarts de la pista.
	 * @param none.
	 * @return maxKarts Cadena de texto con la cantidad maxima de karts de la pista.
	 */
	public String getMaxKarts() {
		return this.maxKarts;
	}
	
	/**
	 * Establece maxKarts de la pista.
	 * @param maxKarts Cadena de texto con la cantidad maxima de karts de la pista.
	 * @return none.
	 */
	public void setMaxKarts(String maxKarts) {
		this.maxKarts = maxKarts;
	}
	
	/**
	 * Obtiene lista de la pista.
	 * @param none.
	 * @return lista Tipo ArrayList con los karts de la pista.
	 */
	public ArrayList<Integer> getLista() {
		return this.lista;
	}
	
	/**
	 * Establece lista de la pista.
	 * @param lista Tipo ArrayList con los karts de la pista.
	 * @return none.
	 */
	public void setLista(ArrayList<Integer> lista) {
		this.lista = lista;
	}
}