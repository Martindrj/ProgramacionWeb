package pw.display.javabean;

import java.io.Serializable;

/**
 * Clase usuarioBean.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 */
public class usuarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/** id del usuario. */
	private String id ="";
	/** Nombre y apellidos del usuario. */
	private String nombreApellidos = "";
	/** Correo electronico del usuario. */
	private String correo = "";
	/** Contraseña del usuario. */
	private String password = "";
	/** Rol del usuario. */
	private String rol = "";
	/** Fecha de nacimiento del usuario. */
	private String fechaNacimiento = "";
	/** Fecha de registro del usuario. */
	private String fechaInscripcion = "";
	/** Años que lleva en el sistema. */
	private String anios = "";
	/** Meses que lleva en el sistema. */
	private String meses = "";
	/** Dias que lleva en el sistema. */
	private String dias = "";
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase usuarioBean.
	 */
	public usuarioBean() {
	}
	/**
	 * Obtiene id del usuario.
	 * @param none.
	 * @return id Cadena de texto con el id del usuario.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Establece id del usuario.
	 * @param id Cadena de texto con el id del usuario.
	 * @return none.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Obtiene nombre y apellidos del usuario.
	 * @param none.
	 * @return nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 */
	public String getNombreApellidos() {
		return this.nombreApellidos;
	}
	
	/**
	 * Establece nombre y apellidos del usuario.
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 * @return none.
	 */
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	
	/**
	 * Obtiene correo electronico del usuario.
	 * @param none.
	 * @return correo Cadena de texto con el correo electronico del usuario.
	 */
	public String getCorreo() {
		return this.correo;
	}
	
	/**
	 * Establece correo electronico del usuario.
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 * @return none.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Obtiene contraseña del usuario.
	 * @param none.
	 * @return password Cadena de texto con la contraseña del usuario.
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Establece contraseña del usuario.
	 * @param password Cadena de texto con la contraseña del usuario.
	 * @return none.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Obtiene rol del usuario.
	 * @param none.
	 * @return rol Cadena de texto con el rol del usuario.
	 */
	public String getRol() {
		return this.rol;
	}
	
	/**
	 * Establece rol del usuario.
	 * @param rol Cadena de texto con el rol del usuario.
	 * @return none.
	 */
	public void setRol(String rol) {
		this.rol= rol;
	}
	
	/**
	 * Obtiene fecha de nacimiento del usuario.
	 * @param none.
	 * @return fechaNacimiento LocalDate con la fecha de nacimiento del usuario.
	 */
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	/**
	 * Establece fecha de nacimiento del usuario.
	 * @param fechaNacimiento LocalDate con la fecha de nacimiento del usuario.
	 * @return none.
	 */
	public void setFechaNacimiento(String fechaNacimiento) {	
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Obtiene fecha de inscripcion del usuario.
	 * @param none.
	 * @return fechaInscripcion LocalDate con la fecha de inscripcion del usuario.
	 */
	public String getFechaInscripcion() {
		return this.fechaInscripcion;
	}
	
	/**
	 * Establece fecha de inscripcion del usuario.
	 * @param fechaInscripcion LocalDate con la fecha de inscripcion del usuario.
	 * @return none.
	 */
	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	/**
	 * Obtiene anios en el sistema del usuario.
	 * @param none.
	 * @return anios String con los anios en el sistema del usuario.
	 */
	public String getAnios() {
		return this.anios;
	}
	
	/**
	 * Establece anios en el sistema del usuario.
	 * @param anios String con los anios en el sistema del usuario.
	 * @return none.
	 */
	public void setAnios(String anios) {
		this.anios = anios;
	}
	
	/**
	 * Obtiene meses en el sistema del usuario.
	 * @param none.
	 * @return meses String con los meses en el sistema del usuario.
	 */
	public String getMeses() {
		return this.meses;
	}
	
	/**
	 * Establece meses en el sistema del usuario.
	 * @param meses String con los meses en el sistema del usuario.
	 * @return none.
	 */
	public void setMeses(String meses) {
		this.meses = meses;
	}
	
	/**
	 * Obtiene dias en el sistema del usuario.
	 * @param none.
	 * @return dias String con los dias en el sistema del usuario.
	 */
	public String getDias() {
		return this.dias;
	}
	
	/**
	 * Establece dias en el sistema del usuario.
	 * @param dias String con los dias en el sistema del usuario.
	 * @return none.
	 */
	public void setDias(String dias) {
		this.dias = dias;
	}
}
