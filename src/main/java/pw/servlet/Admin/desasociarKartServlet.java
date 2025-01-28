package pw.servlet.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.bussiness.dto.DTOkart;
import pw.bussiness.dto.DTOpista;
import pw.bussiness.gestores.Dificultad;
import pw.data.common.DBConnection;
import pw.data.dao.DAOkart;
import pw.data.dao.DAOpista;
import pw.display.javabean.usuarioBean;
import pw.display.javabean.pistaBean;

/**
 * Servlet que implementa la clase desasociarKartServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="desasociarKartServlet", urlPatterns="/desasociarKartServlet")
public class desasociarKartServlet extends HttpServlet {
	private static final Integer PISTA_NULA = (Integer) null;
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
		pistaBean pistaBean= (pistaBean)session.getAttribute("pistaBean");
		
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
		} else{
			String dificultad = pistaBean.getDificultad();
			
			DAOkart DAOkart = new DAOkart();
			int idPista = Integer.parseInt(pistaBean.getId());
		
			if(!(dificultad.equals("Familiar"))) {
				for(DTOkart k : DAOkart.buscarKartsPista(idPista,prop)) {
					k.setPistaAsociada(PISTA_NULA);
					DAOkart.Modificar(k, k.getId(), prop);
				}
			}
			request.setAttribute("message", "La pista se ha modificado con éxito.");
			dispatcher = request.getRequestDispatcher("/consultarPistasAdminServlet");
			dispatcher.forward(request, response);
		}
	}
}
