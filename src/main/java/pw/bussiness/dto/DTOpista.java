package pw.bussiness.dto;

import java.util.ArrayList;

import pw.bussiness.gestores.Dificultad;

/**
 * Clase DTOpista.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DTOpista {
	/** ID de la pista. */
	private int ID;
	/** Nombre de la pista. */
	private String nombre;
	/** Estado de la pista(True=Disponible/False=No disponible). */
	private boolean estado;
	/** Dificultad de la pista(Infantil/Familiar/Adultos). */
	private Dificultad dificultad;
	/** Numero maximo de karts permitidos. */
	private int maxKarts;
	/** Lista de karts asociados a la pista. */
	private ArrayList<DTOkart> lista = new ArrayList<DTOkart>();
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase DTOpista.
	 */
	public DTOpista() {
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOpista.
	 * @param ID Entero con el identificador de la pista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param estado Booleano con el estado de la pista.
	 * @param dificultad Enumeracion Dificultad con la dificultad de las pista.
	 * @param maxKarts Entero con la cantidad de karts maximos permitidos en la pista.
	 * @param lista Lista con la lista de karts asociados en la pista.
	 */
	public DTOpista(int ID, String nombre, boolean estado, Dificultad dificultad, int maxKarts, ArrayList<DTOkart> lista) {
		this.ID = ID;
		this.nombre = nombre;
		this.estado = estado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
		this.lista = lista;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOpista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param estado Booleano con el estado de la pista.
	 * @param dificultad Enumeracion Dificultad con la dificultad de las pista.
	 * @param maxKarts Entero con la cantidad de karts maximos permitidos en la pista.
	 * @param lista Lista con la lista de karts asociados en la pista.
	 */
	public DTOpista(String nombre, boolean estado, Dificultad dificultad, int maxKarts, ArrayList<DTOkart> lista) {
		this.nombre = nombre;
		this.estado = estado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
		this.lista = lista;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOpista.
	 * @param ID Entero con el identificador de la pista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param estado Booleano con el estado de la pista.
	 * @param dificultad Enumeracion Dificultad con la dificultad de las pista.
	 * @param maxKarts Entero con la cantidad de karts maximos permitidos en la pista.
	 */
	public DTOpista(int ID, String nombre, boolean estado, Dificultad dificultad, int maxKarts) {
		this.ID = ID;
		this.nombre = nombre;
		this.estado = estado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOpista.
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param estado Booleano con el estado de la pista.
	 * @param dificultad Enumeracion Dificultad con la dificultad de las pista.
	 * @param maxKarts Entero con la cantidad de karts maximos permitidos en la pista.
	 */
	public DTOpista(String nombre, boolean estado, Dificultad dificultad, int maxKarts) {
		this.nombre = nombre;
		this.estado = estado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
	}

	/**
	 * Obtiene ID de la pista.
	 * @param none.
	 * @return ID Entero con el identificador de la pista.
	 */
	public int getId() {
		return this.ID;
	}
	
	/**
	 * Establece ID de la pista.
	 * @param ID Entero con el identificador de la pista.
	 * @return none.
	 */
	public void setId(int ID) {
		this.ID = ID;
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
	 * @return estadoPista Booleano con el estado de la pista.
	 */
	public boolean getEstado() {
		return this.estado;
	}
	
	/**
	 * Establece estado de la pista.
	 * @param estado Booleano con el estado de la pista.
	 * @return none.
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene dificultad de la pista.
	 * @param none.
	 * @return dificultad Enumeracion Dificultad con la dificultad de la pista.
	 */
	public Dificultad getDificultad() {
		return this.dificultad;
	}
	
	/**
	 * Establece dificultad de la pista.
	 * @param dificultad Enumeracion Dificultad con la dificultad de la pista.
	 * @return none.
	 */
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	/**
	 * Obtiene maxKarts de la pista.
	 * @param none.
	 * @return maxKarts Entero con la cantidad maxima de karts de la pista.
	 */
	public int getMaxKarts() {
		return this.maxKarts;
	}
	
	/**
	 * Establece maxKarts de la pista.
	 * @param maxKarts Entero con la cantidad maxima de karts de la pista.
	 * @return none.
	 */
	public void setMaxKarts(int maxKarts) {
		this.maxKarts = maxKarts;
	}

	/**
	 * Obtiene lista de la pista.
	 * @param none.
	 * @return lista Lista con los karts de la pista.
	 */
	public ArrayList<DTOkart> getLista() {
		return this.lista;
	}
	
	/**
	 * Establece lista de la pista.
	 * @param lista Lista con los karts de la pista.
	 * @return none.
	 */
	public void setLista(ArrayList<DTOkart> lista) {
		this.lista = lista;
	}
	
	/**
	 * Obtiene informacion de la pista.
	 * @param none.
	 * @return infoPista Cadena de texto con la informacion de la pista.
	 */
	public String toString() {
		String infoPista="";
		if(this.estado==true) {
			infoPista = "ID: " + this.ID + "\nNombre: " + this.nombre + "\nEstado: Disponible" + "\nDificultad: " + this.dificultad + "\nMax Karts: " + this.maxKarts + "\nLista Karts asociados: " + this.lista;
		}
		else if(this.estado==false) {
			infoPista = "ID: " +this.ID + "\nNombre: " + this.nombre + "\nEstado: No disponible" + "\nDificultad: " + this.dificultad + "\nMax Karts: " + this.maxKarts + "\nLista Karts asociados: " + this.lista;
		}
		return infoPista;
	}
}
