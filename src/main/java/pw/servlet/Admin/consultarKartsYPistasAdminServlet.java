package pw.servlet.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.data.common.DBConnection;
import pw.data.dao.DAOkart;
import pw.data.dao.DAOpista;
import pw.display.javabean.usuarioBean;

/**
 * Servlet que implementa la clase consultarKartsAdminServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="consultarKartsYPistasAdminServlet", urlPatterns="/consultarKartsYPistasAdminServlet")
public class consultarKartsYPistasAdminServlet extends HttpServlet {
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
		
		DAOkart DAOkart = new DAOkart();
		DAOpista DAOpista= new DAOpista();
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		} else{
			request.setAttribute("listaKarts", DAOkart.ListaKarts(prop));
			request.setAttribute("listaPistas", DAOpista.ListaPistas(prop));
			
			dispatcher = request.getRequestDispatcher("/mvc/view/Admin/asociarKartAPistaView.jsp");
			dispatcher.forward(request, response);
		}
	}

}

