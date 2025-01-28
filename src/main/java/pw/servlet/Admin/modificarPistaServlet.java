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

import pw.bussiness.dto.DTOpista;
import pw.bussiness.gestores.Dificultad;
import pw.data.common.DBConnection;
import pw.data.dao.DAOkart;
import pw.data.dao.DAOpista;
import pw.display.javabean.usuarioBean;
import pw.display.javabean.pistaBean;

/**
 * Servlet que implementa la clase modificarPistaServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="modificarPistaServlet", urlPatterns="/modificarPistaServlet")
public class modificarPistaServlet extends HttpServlet {
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
			String nombrePista = request.getParameter("nombre");
			String estado = request.getParameter("estado");
			String dificultad = request.getParameter("dificultad");
			String maxKarts = request.getParameter("maxKarts");

			DTOpista DTOpista = new DTOpista();
			DAOpista DAOpista = new DAOpista();
			DAOkart DAOkart = new DAOkart();
			int idPista = Integer.parseInt(pistaBean.getId());
			
			if(DAOpista.existePistaID(idPista, prop)) {
				DTOpista.setNombre(nombrePista);
				
				if(estado.equals("disponible"))
					DTOpista.setEstado(true);
				else if (estado.equals("noDisponible"))
					DTOpista.setEstado(false);
			
				if(dificultad.equals("infantil"))
					DTOpista.setDificultad(Dificultad.infantil);
				else if(dificultad.equals("familiar"))
					DTOpista.setDificultad(Dificultad.familiar);
				else if(dificultad.equals("adulto"))
					DTOpista.setDificultad(Dificultad.adulto);
			
				int maxKartsInt = Integer.parseInt(maxKarts);
			
				DTOpista.setMaxKarts(maxKartsInt);
				if(DAOpista.buscarPistaID(idPista, prop).getDificultad()!=DTOpista.getDificultad()) {
					if(DAOpista.Modificar(DTOpista, idPista, prop)) {
						pistaBean.setDificultad(dificultad);
						dispatcher = request.getRequestDispatcher("/desasociarKartServlet");
						dispatcher.forward(request, response);
					}else {
						request.setAttribute("message", "Error al modificar la pista.");
						dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					DAOpista.Modificar(DTOpista, idPista, prop);
					request.setAttribute("message", "La pista se ha modificado con éxito.");
					dispatcher = request.getRequestDispatcher("/consultarPistasAdminServlet");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("message", "No se ha podido encontrar la pista en la base de datos.");
				
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
