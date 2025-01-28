package pw.bussiness.dto;

import pw.bussiness.gestores.Estado;

/**
 * Clase DTOkart.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DTOkart {
	/** ID del kart. */
	private int ID;
	/** Tipo del kart(True=Adulto/False=Infantil). */
	private boolean tipo;
	/** Estado del kart(Disponible/Reservado/Mantenimiento). */
	private Estado estado;
	/** Id de la pista a la que esta asociado. */
	private int pistaAsociada=0;

	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase DTOkart.
	 */
	public DTOkart() {
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOkart.
	 *
	 * @param ID Entero con el id del kart.
	 * @param tipo Booleano con el tipo del kart.
	 * @param estado Enumeracion Estado con el estado del kart.
	 * @param pistaAsociada Entero con el id de la pista a la que esta asociado.
	 */
	public DTOkart(int ID, boolean tipo, Estado estadoKart, int pistaAsociada) {
		this.ID = ID;
		this.tipo = tipo;
		this.estado = estadoKart;
		this.pistaAsociada = pistaAsociada;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOkart.
	 *
	 * @param tipo Booleano con el tipo del kart.
	 * @param estado Enumeracion Estado con el estado del kart.
	 * @param pistaAsociada Entero con el id de la pista a la que esta asociado.
	 */
	public DTOkart(boolean tipo, Estado estadoKart, int pistaAsociada) {
		this.tipo = tipo;
		this.estado = estadoKart;
		this.pistaAsociada = pistaAsociada;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOkart.
	 *
	 * @param ID Entero con el id del kart.
	 * @param tipo Booleano con el tipo del kart.
	 * @param estado Enumeracion Estado con el estado del kart.
	 */
	public DTOkart(int ID, boolean tipo, Estado estadoKart) {
		this.ID = ID;
		this.tipo = tipo;
		this.estado = estadoKart;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOkart.
	 *
	 * @param tipo Booleano con el tipo del kart.
	 * @param estado Enumeracion Estado con el estado del kart.
	 */
	public DTOkart(boolean tipo, Estado estadoKart) {
		this.tipo = tipo;
		this.estado = estadoKart;
	}
	
	/**
	 * Obtiene ID del kart.
	 * @param none.
	 * @return id Entero con el id del kart.
	 */
	public int getId() {
		return this.ID;
	}
	
	/**
	 * Establece ID del kart
	 * @param ID Entero con el id del kart.
	 * @return none.
	 */
	public void setId(int ID) {
		this.ID = ID;
	}
	
	/**
	 * Obtiene tipo del kart.
	 * @param none.
	 * @return tipo Booleano con el tipo del kart.
	 */
	public boolean getTipo() {
		return this.tipo;
	}
	
	/**
	 * Establece tipo del kart.
	 * @param tipo Booleano con el tipo del kart.
	 * @return none.
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Obtiene estadoKart del kart.
	 * @param none.
	 * @return estadoKart Enumeracion Estado con el estado del kart.
	 */
	public Estado getEstado() {
		return this.estado;
	}
	
	/**
	 * Establece estadoKart del kart.
	 * @param  estadoKart Enumeracion Estado con el estado del kart 
	 * @return none.
	 */
	public void setEstado(Estado estadoKart) {
		this.estado = estadoKart;
	}

	/**
	 * Obtiene pistaAsociada del kart.
	 * @param none.
	 * @return id Entero con el id de la pista a la que esta asociado.
	 */
	public int getPistaAsociada() {
		return this.pistaAsociada;
	}
	
	/**
	 * Establece pistaAsociada del kart
	 * @param id Entero con el id de la pista a la que esta asociado.
	 * @return none.
	 */
	public void setPistaAsociada(int pistaAsociada) {
		this.pistaAsociada = pistaAsociada;
	}
	
	/**
	 * Obtiene informacion del kart.
	 * @param none.
	 * @return infoKart Cadena de texto con la informacion del kart.
	 */
	public String toString() {
		String infoKart="";
		if(this.tipo==true) {
			infoKart = "ID: " + this.ID + " Tipo: Adulto" + " Estado: " + this.estado + " Pista Asociada: " + this.pistaAsociada;
		}
		else if(this.tipo==false) {
			infoKart = "ID: " + this.ID + " Tipo: Infantil" + " Estado: " + this.estado + " Pista Asociada: " + this.pistaAsociada;
		}
		return infoKart;
	}
}
