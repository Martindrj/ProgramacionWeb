package pw.display.javabean;

import java.io.Serializable;

/**
 * Clase kartBean.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 */
public class kartBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/** id del kart. */
	private String id = "";
	/** Tipo del kart. */
	private String tipo = "";
	/** Estado del kart. */
	private String estado = "";
	/** id de la pista a la que esta asociado. */
	private String pistaAsociada = "";

	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase kartBean.
	 */
	public kartBean() {
	}
	
	/**
	 * Obtiene id del kart.
	 * @param none.
	 * @return id Cadena de texto con el id del kart.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Establece id del kart
	 * @param id Cadena de texto con el id del kart.
	 * @return none.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Obtiene tipo del kart.
	 * @param none.
	 * @return Cadena de texto con el tipo del kart.
	 */
	public String getTipo() {
		return this.tipo;
	}
	
	/**
	 * Establece tipo del kart.
	 * @param Cadena de texto con el tipo del kart.
	 * @return none.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Obtiene estadoKart del kart.
	 * @param none.
	 * @return estadoKart Cadena de texto con el estado del kart.
	 */
	public String getEstado() {
		return this.estado;
	}
	
	/**
	 * Establece estadoKart del kart.
	 * @param  estadoKart Cadena de texto con el estado del kart 
	 * @return none.
	 */
	public void setEstado(String estadoKart) {
		this.estado = estadoKart;
	}

	/**
	 * Obtiene pistaAsociada del kart.
	 * @param none.
	 * @return id Cadena de texto con el id de la pista a la que esta asociado.
	 */
	public String getPistaAsociada() {
		return this.pistaAsociada;
	}
	
	/**
	 * Establece pistaAsociada del kart
	 * @param id Cadena de texto con el id de la pista a la que esta asociado.
	 * @return none.
	 */
	public void setPistaAsociada(String pistaAsociada) {
		this.pistaAsociada = pistaAsociada;
	}
}