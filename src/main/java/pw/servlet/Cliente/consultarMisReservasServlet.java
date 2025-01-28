package pw.servlet.Cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.bussiness.dto.DTOreservaAdultos;
import pw.bussiness.dto.DTOreservaFamiliar;
import pw.bussiness.dto.DTOreservaInfantil;
import pw.data.common.DBConnection;
import pw.data.dao.DAOreservas;
import pw.display.javabean.usuarioBean;

/**
 * Servlet implementation class ConsultarReservasServlet
 */
@WebServlet(name="consultarMisReservasServlet", urlPatterns="/consultarMisReservasServlet")
public class consultarMisReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		DAOreservas DAOreservas = new DAOreservas();
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		} else{
			String fecha_inicio = null;
			String fecha_final = null;
			fecha_inicio = request.getParameter("fechaInicio");
			fecha_final = request.getParameter("fechaFin");
			
			if(fecha_inicio == null || fecha_final == null) {
				request.setAttribute("listaReservasInfantil", DAOreservas.ListaReservasInfantilUsuario(usuarioBean.getCorreo(), prop));
				request.setAttribute("listaReservasFamiliar", DAOreservas.ListaReservasFamiliarUsuario(usuarioBean.getCorreo(), prop));
				request.setAttribute("listaReservasAdultos", DAOreservas.ListaReservasAdultosUsuario(usuarioBean.getCorreo(), prop));
				
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/consultarMisReservasView.jsp");
				dispatcher.forward(request, response);
			}else {
				LocalDate fecha1 = LocalDate.parse(fecha_inicio);
				LocalDate fecha2 = LocalDate.parse(fecha_final);
				
				ArrayList<DTOreservaInfantil> listaReservasInfantilFecha = new ArrayList <DTOreservaInfantil>();
				ArrayList<DTOreservaFamiliar> listaReservasFamiliarFecha = new ArrayList <DTOreservaFamiliar>();
				ArrayList<DTOreservaAdultos> listaReservasAdultoFecha = new ArrayList <DTOreservaAdultos>();
				
				for (DTOreservaInfantil reserva : DAOreservas.ListaReservasInfantilUsuario(usuarioBean.getCorreo(), prop)) {
					if (((fecha1.isBefore(reserva.getFecha())) || (fecha1.isEqual(reserva.getFecha()))) && ((fecha2.isAfter(reserva.getFecha())) || (fecha2.isEqual(reserva.getFecha())))) {
						listaReservasInfantilFecha.add(reserva);
					}
				}
				for (DTOreservaFamiliar reserva : DAOreservas.ListaReservasFamiliarUsuario(usuarioBean.getCorreo(), prop)) {
					if (((fecha1.isBefore(reserva.getFecha())) || (fecha1.isEqual(reserva.getFecha()))) && ((fecha2.isAfter(reserva.getFecha())) || (fecha2.isEqual(reserva.getFecha())))) {
						listaReservasFamiliarFecha.add(reserva);
					}
				}
				for (DTOreservaAdultos reserva : DAOreservas.ListaReservasAdultosUsuario(usuarioBean.getCorreo(), prop)) {
					if (((fecha1.isBefore(reserva.getFecha())) || (fecha1.isEqual(reserva.getFecha()))) && ((fecha2.isAfter(reserva.getFecha())) || (fecha2.isEqual(reserva.getFecha())))) {
						listaReservasAdultoFecha.add(reserva);
					}
				}
				request.setAttribute("listaReservasInfantil", listaReservasInfantilFecha);
				request.setAttribute("listaReservasFamiliar", listaReservasFamiliarFecha);
				request.setAttribute("listaReservasAdultos", listaReservasAdultoFecha);
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/consultarMisReservasView.jsp");
				dispatcher.forward(request, response);	
			}
		}
	}

}
