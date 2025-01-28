package pw.servlet.Cliente;

import java.io.IOException;
import java.time.LocalDate;

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
import pw.display.javabean.reservasBean;

/**
 * Servlet que implementa la clase modificarReservaServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="modificarReservaServlet", urlPatterns="/modificarReservaServlet")
public class modificarReservaServlet extends HttpServlet {
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
		reservasBean reservasBean = (reservasBean)session.getAttribute("reservasBean");
		
		String url = application.getInitParameter("URL");
		String user = application.getInitParameter("User");
		String password = application.getInitParameter("Password");
		String properties = application.getInitParameter("properties");
		
		java.io.InputStream myIO = application.getResourceAsStream(properties);
		java.util.Properties prop = new java.util.Properties();
		prop.load(myIO);
		
		DBConnection bd = new DBConnection(url, user, password);
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		}else {
			String pista = request.getParameter("pista");
			String fecha = request.getParameter("fecha");
			String duracion = request.getParameter("duracion");
			String numInf = request.getParameter("numInfantil");
			String numAdul = request.getParameter("numAdultos");
			
			LocalDate fechaReserva =funciones.StringToLocalDate(fecha);
			int duracionReserva = Integer.parseInt(duracion);
			int numInfantil = Integer.parseInt(numInf);
			int numAdultos = Integer.parseInt(numAdul);
			
			int idReserva = Integer.parseInt(reservasBean.getId());
			float precio=0;
			float descuento = Float.parseFloat(reservasBean.getDescuento());
			int bono = Integer.parseInt(reservasBean.getBono());
			
			DTOreservaFamiliar DTOreservaFamiliar = null;
			DTOreservaAdultos DTOreservaAdultos = null;
			DTOreservaInfantil DTOreservaInfantil = null;
			
			DAOpista DAOpista = new DAOpista();
			DTOpista DTOpista = DAOpista.buscarPista(pista, prop);
			DAOreservas DAOreservas = new DAOreservas();
			if (numAdultos == 0 && numInfantil != 0 && numInfantil <= DTOpista.getMaxKarts()) {
				if(DTOpista.getDificultad() == Dificultad.infantil) {
					if (DAOreservas.ListaReservasInfantilPistaFecha(pista, fechaReserva, prop).size() ==0){
						int tipoReserva = 0;
						reservasBean.setTipoReserva("infantil");
						
						if (duracionReserva == 60) {
							precio=20;
						}else if (duracionReserva == 90) {
							precio=30;
						}else if (duracionReserva == 120) {
							precio=40;
						}
						DTOreservaInfantil = new DTOreservaInfantil(idReserva,reservasBean.getUsuario(), pista, fechaReserva, duracionReserva, precio, descuento, tipoReserva, bono, numInfantil, numInfantil);
					}
					
					if (DAOreservas.ModificarInfantil(DTOreservaInfantil, prop)) {
						request.setAttribute("message", "La reserva se ha modificado con éxito.");
						dispatcher = request.getRequestDispatcher("/consultarReservasServlet");
						dispatcher.forward(request, response);		
					}else {
						request.setAttribute("message", "No se ha podido realizar la modificacion de reserva.");
						
						dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "No se ha podido realizar la modificacion de reserva.");
					
					dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
					dispatcher.forward(request, response);
				}	
			}else if ((numAdultos !=0 || numInfantil !=0) && numInfantil+numAdultos <= DTOpista.getMaxKarts()) {
				if(DTOpista.getDificultad() == Dificultad.familiar) {
					if (DAOreservas.ListaReservasFamiliarPistaFecha(pista, fechaReserva, prop).size() ==0){
						int tipoReserva = 1;
						reservasBean.setTipoReserva("familiar");
						
						if (duracionReserva == 60) {
							precio=20;
						}else if (duracionReserva == 90) {
							precio=30;
						}else if (duracionReserva == 120) {
							precio=40;
						}
						DTOreservaFamiliar = new DTOreservaFamiliar(idReserva,reservasBean.getUsuario(), pista, fechaReserva, duracionReserva, precio, descuento, tipoReserva, bono, numInfantil,numAdultos, numInfantil+numAdultos);
					}
					if (DAOreservas.ModificarFamiliar(DTOreservaFamiliar, prop)) {
						request.setAttribute("message", "La reserva se ha modificado con éxito.");
						dispatcher = request.getRequestDispatcher("/consultarReservasServlet");
						dispatcher.forward(request, response);	
					}else {
						request.setAttribute("message", "No se ha podido encontrar la pista en la base de datos.");
						
						dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "No se ha podido realizar la modificacion de reserva.");
					
					dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
					dispatcher.forward(request, response);
				}
			}else if (numAdultos != 0 && numInfantil == 0 && numAdultos <= DTOpista.getMaxKarts()) {
				if(DTOpista.getDificultad() == Dificultad.adulto) {
					if (DAOreservas.ListaReservasAdultosPistaFecha(pista, fechaReserva, prop).size() ==0){
						int tipoReserva = 2;		
						reservasBean.setTipoReserva("adulto");
						
						if (duracionReserva == 60) {
							precio=20;
						}else if (duracionReserva == 90) {
							precio=30;
						}else if (duracionReserva == 120) {
							precio=40;
						}
						DTOreservaAdultos = new DTOreservaAdultos(idReserva,reservasBean.getUsuario(), pista, fechaReserva, duracionReserva, precio, descuento, tipoReserva, bono, numAdultos, numAdultos);
					}
					if (DAOreservas.ModificarAdultos(DTOreservaAdultos, prop)) {
						
						request.setAttribute("message", "La reserva se ha modificado con éxito.");
						dispatcher = request.getRequestDispatcher("/consultarReservasServlet");
						dispatcher.forward(request, response);		
					}else {
						request.setAttribute("message", "No se ha podido encontrar la pista en la base de datos.");
						
						dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "No se ha podido modificar la reserva.");
				
					dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("message", "No se ha podido realizar la modificacion de reserva.");
				
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}		