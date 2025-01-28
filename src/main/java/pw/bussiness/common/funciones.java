package pw.bussiness.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Clase funciones.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 */
public class funciones {

	public static String dateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fecha = format.format(date);
		return fecha;
	}

	public static String LocalDateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = date.format(formatter);
		return formattedString;
	}

	public static LocalDate StringToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha = LocalDate.parse(date, formatter);
		return fecha;
	}
	
	public static String IntToString(int number) {
		return String.valueOf(number);
	}
	
	public static String LongToString(long number) {
		return Long.toString(number);
	}
	
}
