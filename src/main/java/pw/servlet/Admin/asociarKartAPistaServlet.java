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

import pw.bussiness.dto.DTOkart;
import pw.bussiness.dto.DTOpista;
import pw.bussiness.gestores.Dificultad;
import pw.bussiness.gestores.Estado;
import pw.data.common.DBConnection;
import pw.data.dao.DAOkart;
import pw.data.dao.DAOpista;
import pw.display.javabean.usuarioBean;

/**
 * Servlet implementation class asociarKartPista
 */
@WebServlet(name="asociarKartAPistaServlet", urlPatterns="/asociarKartAPistaServlet")
public class asociarKartAPistaServlet extends HttpServlet {
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
		
		DAOpista DAOpista = new DAOpista();
		DAOkart DAOkart = new DAOkart();
		DTOpista DTOpista = new DTOpista();
		DTOkart DTOkart = new DTOkart();
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		} else{

			String id = request.getParameter("idKart");
			String nombrePista = request.getParameter("nombre");
			
			int idKart = Integer.parseInt(id);
		
			DTOpista = DAOpista.buscarPista(nombrePista,prop);
			DTOkart = DAOkart.buscarKartID(idKart,prop);
		
			if(DTOpista != null && DTOkart!= null) {
				if(DTOpista.getEstado() && DTOkart.getEstado()==Estado.disponible) {
					if(DTOpista.getDificultad()==Dificultad.infantil && !DTOkart.getTipo()) {
						DAOkart.AsociarKart(DTOkart.getId(), DTOpista.getId(),prop);
						request.setAttribute("message", "La asociación se ha creado con éxito.");
						dispatcher = request.getRequestDispatcher("/consultarKartsYPistasAdminServlet");
						dispatcher.forward(request, response);
					}else if(DTOpista.getDificultad()==Dificultad.adulto && DTOkart.getTipo()) {
						DAOkart.AsociarKart(idKart, DTOpista.getId(),prop);
						request.setAttribute("message", "La asociación se ha creado con éxito.");
						dispatcher = request.getRequestDispatcher("/consultarKartsYPistasAdminServlet");
						dispatcher.forward(request, response);
					}else if(DTOpista.getDificultad()==Dificultad.familiar){
						DAOkart.AsociarKart(idKart, DTOpista.getId(),prop);
						request.setAttribute("message", "La asociación se ha creado con éxito.");
						dispatcher = request.getRequestDispatcher("/consultarKartsYPistasAdminServlet");
						dispatcher.forward(request, response);
					}else {
						request.setAttribute("message", "Error al asociar la pista. La pista o el kart no pueden ser asociados.");
						dispatcher = request.getRequestDispatcher("/mvc/view/Admin/AdminView.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("message", "Error al asociar la pista. La pista o el kart no se encuentran disponibles.");
					dispatcher = request.getRequestDispatcher("/mvc/view/Admin/AdminView.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("message", "Error al asociar la pista. La pista o el kart no existe.");
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/AdminView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
