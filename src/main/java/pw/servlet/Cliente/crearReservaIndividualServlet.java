package pw.servlet.Cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.bussiness.common.funciones;
import pw.bussiness.dto.DTOpista;
import pw.bussiness.dto.DTOreservaAdultos;
import pw.bussiness.dto.DTOreservaFamiliar;
import pw.bussiness.dto.DTOreservaInfantil;
import pw.bussiness.gestores.Dificultad;
import pw.data.common.DBConnection;
import pw.data.dao.DAOpista;
import pw.data.dao.DAOreservas;
import pw.display.javabean.usuarioBean;

/**
 * Servlet implementation class crearReservaIndividualServlet
 */
@WebServlet(name="crearReservaIndividualServlet", urlPatterns ="/crearReservaIndividualServlet")
public class crearReservaIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		usuarioBean usuarioBean = (usuarioBean)session.getAttribute("userBean");
		
		String url = application.getInitParameter("URL");
		String user = application.getInitParameter("User");
		String password = application.getInitParameter("Password");
		String properties = application.getInitParameter("properties");
		
		java.io.InputStream myIO = application.getResourceAsStream(properties);
		java.util.Properties prop = new java.util.Properties();
		prop.load(myIO);
		DBConnection bd = new DBConnection(url, user, password);
		
		String usuario = usuarioBean.getCorreo();
		LocalDate fechaReserva;
		int duracionReserva;
		float precio=0;
		float descuento;
		int tipoReserva;
		int bono;
		int numInfantil;
		int numAdultos;	
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		}else {
			String nombrePista = request.getParameter("pista");
			String fecha = request.getParameter("fecha");
			String duracion = request.getParameter("duracion");
			String numInf = request.getParameter("numInfantil");
			String numAdul = request.getParameter("numAdultos");
			
			DTOreservaInfantil DTOreservaInfantil = null;
			DTOreservaFamiliar DTOreservaFamiliar = null;
			DTOreservaAdultos DTOreservaAdultos = null;
			
			DAOreservas DAOreservas = new DAOreservas();
			DAOpista DAOpista = new DAOpista();
			DTOpista DTOpista = DAOpista.buscarPista(nombrePista, prop);
			
			numAdultos = Integer.parseInt(numAdul);
			numInfantil = Integer.parseInt(numInf);
			duracionReserva = Integer.parseInt(duracion);
			fechaReserva =funciones.StringToLocalDate(fecha);
			
			if(numAdultos == 0 && numInfantil != 0 && numInfantil <= DTOpista.getMaxKarts()) {
				if (DTOpista.getDificultad() == Dificultad.infantil) {
					if(DAOreservas.ListaReservasInfantilPistaFecha(nombrePista, fechaReserva, prop).size() ==0) {
						tipoReserva = 0;
					
						if (duracionReserva == 60) {
							precio=20;
						}else if (duracionReserva == 90) {
							precio=30;
						}else if (duracionReserva == 120) {
							precio=40;
						}
						
						LocalDate comprobarFecha = funciones.StringToLocalDate(usuarioBean.getFechaInscripcion());
						long antiguedad=ChronoUnit.YEARS.between(comprobarFecha, LocalDate.now());
						if (antiguedad < 2) descuento = 1;
						else descuento = (float)0.95;
						DTOreservaInfantil = new DTOreservaInfantil(usuario,nombrePista,fechaReserva, duracionReserva, precio, descuento, tipoReserva, 0, numInfantil, numInfantil);
						
						DAOreservas.GuardarInfantilIndividual(DTOreservaInfantil, prop);
						request.setAttribute("message","La reserva se ha realizado correctamente");
						dispatcher = request.getRequestDispatcher("/consultarReservasServlet");
						dispatcher.forward(request, response);
					}else {
						request.setAttribute("message", "No se ha podido crear la reserva.");
						dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "No se ha podido crear la reserva.");
					dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
					dispatcher.forward(request, response);
				}
			}else if(numAdultos != 0 && numInfantil != 0 && (numInfantil + numInfantil) <= DTOpista.getMaxKarts()) {
				if (DTOpista.getDificultad() == Dificultad.familiar) {
					if(DAOreservas.ListaReservasFamiliarPistaFecha(nombrePista, fechaReserva, prop).size() ==0) {
						tipoReserva = 1;
					
						if (duracionReserva == 60) {
							precio=20;
						}else if (duracionReserva == 90) {
							precio=30;
						}else if (duracionReserva == 120) {
							precio=40;
						}
					
						LocalDate comprobarFecha = funciones.StringToLocalDate(usuarioBean.getFechaInscripcion());
					
						long antiguedad=ChronoUnit.YEARS.between(comprobarFecha, LocalDate.now());
						if (antiguedad < 2) descuento = 1;
						else descuento = (float)0.95;
						DTOreservaFamiliar = new DTOreservaFamiliar(usuario,nombrePista,fechaReserva, duracionReserva, precio, descuento, tipoReserva, 0, numInfantil, numAdultos, numInfantil+numAdultos);
						
						DAOreservas.GuardarFamiliarIndividual(DTOreservaFamiliar, prop);
						request.setAttribute("message","La reserva se ha realizado correctamente");
						dispatcher = request.getRequestDispatcher("/consultarReservasServlet");
						dispatcher.forward(request, response);
					}else {
						request.setAttribute("message", "No se ha podido crear la reserva.");
						dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "No se ha podido crear la reserva.");
					dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
					dispatcher.forward(request, response);
				}
			}else if(numAdultos != 0 && numInfantil == 0 && numAdultos <= DTOpista.getMaxKarts()) {
				if (DTOpista.getDificultad() == Dificultad.adulto) {
					if(DAOreservas.ListaReservasAdultosPistaFecha(nombrePista, fechaReserva, prop).size() ==0) {
						tipoReserva = 2;
					
						if (duracionReserva == 60) {
							precio=20;
						}else if (duracionReserva == 90) {
							precio=30;
						}else if (duracionReserva == 120) {
							precio=40;
						}
					
						LocalDate comprobarFecha = funciones.StringToLocalDate(usuarioBean.getFechaInscripcion());
						long antiguedad=ChronoUnit.YEARS.between(comprobarFecha, LocalDate.now());
						if (antiguedad < 2) descuento = 1;
						else descuento = (float)0.95;
						DTOreservaAdultos = new DTOreservaAdultos(usuario,nombrePista,fechaReserva, duracionReserva, precio, descuento, tipoReserva, 0, numAdultos, numAdultos);
						
						DAOreservas.GuardarAdultosIndividual(DTOreservaAdultos, prop);
						request.setAttribute("message","La reserva se ha realizado correctamente");
						dispatcher = request.getRequestDispatcher("/consultarReservasServlet");
						dispatcher.forward(request, response);
					}else {
						request.setAttribute("message", "No se ha podido crear la reserva.");
						dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "No se ha podido crear la reserva.");
					dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("message", "No se ha podido crear la reserva.");
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
