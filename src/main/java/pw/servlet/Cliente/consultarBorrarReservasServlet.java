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

import pw.data.common.DBConnection;
import pw.data.dao.DAOreservas;
import pw.display.javabean.usuarioBean;

/**
 * Servlet implementation class ConsultarReservasServlet
 */
@WebServlet(name="consultarBorrarReservasServlet", urlPatterns="/consultarBorrarReservasServlet")
public class consultarBorrarReservasServlet extends HttpServlet {
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
			request.setAttribute("listaReservasInfantil", DAOreservas.ListaReservasInfantilUsuario(usuarioBean.getCorreo(), prop));
			request.setAttribute("listaReservasFamiliar", DAOreservas.ListaReservasFamiliarUsuario(usuarioBean.getCorreo(), prop));
			request.setAttribute("listaReservasAdultos", DAOreservas.ListaReservasAdultosUsuario(usuarioBean.getCorreo(), prop));
			
			dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/consultarBorrarReservasView.jsp");
			dispatcher.forward(request, response);
		}
	}
}
