package pw.servlet.Cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
 * Servlet implementation class borrarReservaClienteServlet
 */
@WebServlet(name="borrarReservaClienteServlet", urlPatterns="/borrarReservaClienteServlet")
public class borrarReservaClienteServlet extends HttpServlet {
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
		RequestDispatcher disp;
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		} else{

			int idReserva = Integer.parseInt(reservasBean.getId());
		
			LocalDate fechaReserva = funciones.StringToLocalDate(reservasBean.getFecha());
			
			if(ChronoUnit.DAYS.between(LocalDate.now(), fechaReserva)>=1) {
				DAOreservas.Borrar(idReserva,prop);
				request.setAttribute("message", "La reserva se ha eliminado con éxito.");
				disp = request.getRequestDispatcher("/consultarReservasServlet");
				disp.forward(request, response);
			}else {
				request.setAttribute("message", "Error al eliminar la reserva. No se puede eliminar una reserva a falta de 24 horas.");
				disp = request.getRequestDispatcher("/mvc/view/Cliente/clienteView.jsp");
				disp.forward(request, response);
			}
		}
	}

}
