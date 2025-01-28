package pw.bussiness.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase DTOusuario.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class DTOusuario {
	/** id del usuario. */
	private int id;
	/** Nombre y apellidos del usuario. */
	private String nombreApellidos;
	/** Correo electronico del usuario. */
	private String correo = "";	
	/** Contraseña del usuario. */
	private String password;
	/** Rol del usuario. */
	private String rol = "";
	/** Fecha de nacimiento del usuario. */
	private LocalDate fechaNacimiento;
	/** Fecha de registro del usuario. */
	private LocalDate fechaInscripcion;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase DTOusuario.
	 */
	public DTOusuario() {	
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOusuario.
	 *
	 * @param id Entero con el id del usuario.
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 * @param password Cadena de texto con la contraseña del usuario.
	 * @param rol Cadena de texto con el rol del usuario.
	 * @param fechaNacimiento Tipo LocalDate con la fecha de nacimiento del usuario.
	 * @param fechaInscripcion Tipo LocalDate con la fecha de inscripcion del usuario.
	 */
	public DTOusuario(int id, String nombreApellidos, String correo, String password, String rol, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		this.id = id;
		this.nombreApellidos = nombreApellidos;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = fechaInscripcion;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOusuario.
	 *
	 * @param id Entero con el id del usuario.
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 * @param password Cadena de texto con la contraseña del usuario.
	 * @param rol Cadena de texto con el rol del usuario.
	 * @param fechaNacimiento Tipo LocalDate con la fecha de nacimiento del usuario.
	 */
	public DTOusuario(int id, String nombreApellidos, String correo, String password, String rol, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombreApellidos = nombreApellidos;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = LocalDate.now();
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOusuario.
	 *
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 * @param password Cadena de texto con la contraseña del usuario.
	 * @param rol Cadena de texto con el rol del usuario.
	 * @param fechaNacimiento Tipo LocalDate con la fecha de nacimiento del usuario.
	 * @param fechaInscripcion Tipo LocalDate con la fecha de inscripcion del usuario.
	 */
	public DTOusuario(String nombreApellidos, String correo, String password, String rol, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		this.nombreApellidos = nombreApellidos;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = fechaInscripcion;
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase DTOusuario.
	 *
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 * @param password Cadena de texto con la contraseña del usuario.
	 * @param rol Cadena de texto con el rol del usuario.
	 * @param fechaNacimiento Tipo LocalDate con la fecha de nacimiento del usuario.
	 */
	public DTOusuario(String nombreApellidos, String correo, String password, String rol, LocalDate fechaNacimiento) {
		this.nombreApellidos = nombreApellidos;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = LocalDate.now();
	}
	
	/**
	 * Obtiene id del usuario.
	 * @param none.
	 * @return id Entero con el id del usuario.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Establece id del usuario.
	 * @param id Entero con el id del usuario.
	 * @return none.
	 */
	public void setId(int id) {
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
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	/**
	 * Establece fecha de nacimiento del usuario.
	 * @param fechaNacimiento LocalDate con la fecha de nacimiento del usuario.
	 * @return none.
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {	
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Obtiene fecha de inscripcion del usuario.
	 * @param none.
	 * @return fechaInscripcion LocalDate con la fecha de inscripcion del usuario.
	 */
	public LocalDate getFechaInscripcion() {
		return this.fechaInscripcion;
	}
	
	/**
	 * Establece fecha de inscripcion del usuario.
	 * @param fechaInscripcion LocalDate con la fecha de inscripcion del usuario.
	 * @return none.
	 */
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	/**
	 * Obtiene informacion del usuario.
	 * @param none.
	 * @return infoUsuario Cadena de texto con la informacion del usuario.
	 */
	public String toString() {
		String infoUsuario = "id: " + this.id + "\nNombre y apellidos: " + this.nombreApellidos + "\nCorreo electronico: " + this.correo + "\nContraseña: " + this.password + "\nRol: " + this.rol + "\nFecha nacimiento: " + this.fechaNacimiento + "\nFecha inscripcion: " + this.fechaInscripcion;
		return infoUsuario;
	}
	
	/**
	 * Convierte una fecha de tipo LocalDate a java.sql.Date.
	 * @param localdate LocalDate con la fecha a convertir.
	 * @return date java.sql.Date con la fecha convertida.
	 */
	public java.sql.Date conversionDate(LocalDate localdate) {
		java.sql.Date date = java.sql.Date.valueOf( localdate );
		return  date; 
	}
	
	/**
	 * Obtiene la antiguedad de anios de la inscripcion del usuario.
	 * @return Long antiguedad de la inscripcion.
	 */
	public long calcularAntiguedadAnios(){
		long antiguedad;
			antiguedad=ChronoUnit.YEARS.between(this.fechaInscripcion, LocalDate.now());
		return antiguedad;
	}
	
	/**
	 * Obtiene la antiguedad de meses de la inscripcion del usuario.
	 * @return Long antiguedad de la inscripcion.
	 */
	public long calcularAntiguedadMeses(){
		long antiguedad;
			antiguedad=ChronoUnit.MONTHS.between(this.fechaInscripcion, LocalDate.now());
		return antiguedad;
	}
	
	/**
	 * Obtiene la antiguedad de dias de la inscripcion del usuario.
	 * @return Long antiguedad de la inscripcion.
	 */
	public long calcularAntiguedadDias(){
		long antiguedad;
			antiguedad=ChronoUnit.DAYS.between(this.fechaInscripcion, LocalDate.now());
		return antiguedad;
	}
}
