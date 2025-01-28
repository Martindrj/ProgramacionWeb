package pw.servlet.Admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import pw.display.javabean.reservasBean;
import pw.display.javabean.usuarioBean;
import pw.bussiness.common.funciones;

/**
 * Servlet que implementa la clase borrarReservasServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="borrarReservaAdminServlet", urlPatterns="/borrarReservaAdminServlet")
public class borrarReservaAdminServlet extends HttpServlet {
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
		reservasBean reservasBean= (reservasBean)session.getAttribute("reservasBean");
		
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
			int idReserva = Integer.parseInt(reservasBean.getId());
			LocalDate fechaReserva = funciones.StringToLocalDate(reservasBean.getFecha());
		
			LocalDate fechaLimite = LocalDate.now();
		
			if(fechaLimite.isBefore(fechaReserva)) {
				DAOreservas.Borrar(idReserva,prop);
				request.setAttribute("message", "La reserva se ha eliminado con éxito.");
				dispatcher = request.getRequestDispatcher("/consultarBorrarReservasAdminServlet");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("message", "Error al eliminar la reserva. No se puede eliminar una reserva ya realizada.");
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/AdminView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
