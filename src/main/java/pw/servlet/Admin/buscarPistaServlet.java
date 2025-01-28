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
import pw.bussiness.common.funciones;

/**
 * Servlet que implementa la clase buscarPistaServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="buscarPistaServlet", urlPatterns="/buscarPistaServlet")
public class buscarPistaServlet extends HttpServlet {
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
			String id = request.getParameter("identificador");
			
			DTOpista DTOpista = new DTOpista();
			DAOpista DAOpista = new DAOpista();
			DAOkart DAOkart = new DAOkart();
			int idPista = Integer.parseInt(id);
			String estado="";
			String dificultad="";
			ArrayList<Integer> listaKarts = new ArrayList<Integer>();
			
			if(DAOpista.existePistaID(idPista, prop)) {
			
				DTOpista = DAOpista.buscarPistaID(idPista,prop);
			
				if(DTOpista.getEstado())
					estado="Disponible";
				else if (!DTOpista.getEstado())
					estado="No disponible";
			
				if(DTOpista.getDificultad()==Dificultad.infantil)
					dificultad="Infantil";
				else if(DTOpista.getDificultad()==Dificultad.adulto)
					dificultad="Adulto";
				else if(DTOpista.getDificultad()==Dificultad.familiar)
					dificultad="Familiar";
			
				for(DTOkart k : DAOkart.buscarKartsPista(idPista,prop)) {
						listaKarts.add(k.getId());
				}

				pistaBean.setId(funciones.IntToString(DTOpista.getId()));
				pistaBean.setNombre(DTOpista.getNombre());
				pistaBean.setEstado(estado);
				pistaBean.setDificultad(dificultad);
				pistaBean.setMaxKarts(funciones.IntToString(DTOpista.getMaxKarts()));
				pistaBean.setLista(listaKarts);
			
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/modificarPistasView.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("message", "No se ha podido encontrar la pista en la base de datos.");
			
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}