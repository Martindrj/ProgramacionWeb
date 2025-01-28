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
 * Servlet que implementa la clase crearKartServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="crearKartServlet", urlPatterns="/crearKartServlet")
public class crearKartServlet extends HttpServlet {
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
		// TODO Auto-generated method stu
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
		
		DTOkart DTOkart = new DTOkart();
		DAOkart DAOkart = new DAOkart();
		DAOpista DAOpista = new DAOpista();
		
		if(usuarioBean==null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		}else {
			String tipo = request.getParameter("tipo");
			String estadoKart = request.getParameter("estado");
			String pistaAsociada = request.getParameter("pistaAsociada");
			
			if(tipo.equals("infantil"))
				DTOkart.setTipo(false);
			else if(tipo.equals("adulto"))
				DTOkart.setTipo(true);
			
			if(estadoKart.equals("disponible"))
				DTOkart.setEstado(Estado.disponible);
			else if(estadoKart.equals("reservado"))
				DTOkart.setEstado(Estado.reservado);
			else if(estadoKart.equals("mantenimiento"))
				DTOkart.setEstado(Estado.mantenimiento);
			
			int idKart = 0;
			
			if(pistaAsociada.equals("")) {
				idKart = 0;
			}else {
				idKart = Integer.parseInt(pistaAsociada);
			}
			
			DTOpista DTOpista = DAOpista.buscarPistaID(idKart, prop);
			
			if(DTOpista!=null) {
				if((DTOpista.getDificultad()==Dificultad.infantil && !DTOkart.getTipo()) || (DTOpista.getDificultad()==Dificultad.adulto && DTOkart.getTipo()) || DTOpista.getDificultad()==Dificultad.familiar) {
					DTOkart.setPistaAsociada(DTOpista.getId());
					DAOkart.Guardar(DTOkart, prop);
					
					request.setAttribute("message", "El kart se ha creado con exito.");
					dispatcher = request.getRequestDispatcher("/consultarKartsAdminServlet");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("message", "Error al crear el kart.");
					dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				DTOkart.setPistaAsociada(0);
				DAOkart.Guardar(DTOkart,prop);
				request.setAttribute("message", "El kart se ha creado con éxito.");
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/crearKartsView.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
	}

}
