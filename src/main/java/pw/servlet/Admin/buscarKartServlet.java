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

import pw.bussiness.common.funciones;
import pw.bussiness.dto.DTOkart;
import pw.bussiness.dto.DTOpista;
import pw.bussiness.gestores.Dificultad;
import pw.bussiness.gestores.Estado;
import pw.data.common.DBConnection;
import pw.data.dao.DAOkart;
import pw.data.dao.DAOpista;
import pw.display.javabean.pistaBean;
import pw.display.javabean.usuarioBean;
import pw.display.javabean.kartBean;

/**
 * Servlet que implementa la clase buscarKartServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="buscarKartServlet", urlPatterns="/buscarKartServlet")
public class buscarKartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubresponse.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubdoGet(request, response);
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		usuarioBean usuarioBean = (usuarioBean)session.getAttribute("userBean");
		kartBean kartBean= (kartBean)session.getAttribute("kartBean");
		
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
			
			DTOkart DTOkart = new DTOkart();
			DAOkart DAOkart = new DAOkart();
			int idPista = Integer.parseInt(id);
			String tipo="";
			String estado="";
			String pistaAsociada="";
			ArrayList<Integer> listaKarts = new ArrayList<Integer>();
		
			if(DAOkart.existeKartID(idPista, prop)) {
			
				DTOkart = DAOkart.buscarKartID(idPista,prop);
				if(DTOkart.getTipo())
					tipo="Adulto";
				else if (!DTOkart.getTipo())
					tipo="Infantil";
			
				if(DTOkart.getEstado()==Estado.disponible)
					estado="Disponible";
				else if(DTOkart.getEstado()==Estado.reservado)
					estado="Reservado";
				else if(DTOkart.getEstado()==Estado.mantenimiento)
					estado="Mantenimiento";
				
				int idPistaAsociada = 0;
				if(DTOkart.getPistaAsociada()==0){
					idPistaAsociada = 0;
				}else {
					idPistaAsociada = DTOkart.getPistaAsociada();
				}
				
				pistaAsociada=Integer.toString(idPistaAsociada);
			
				kartBean.setId(funciones.IntToString(DTOkart.getId()));
				kartBean.setTipo(tipo);
				kartBean.setEstado(estado);
				kartBean.setPistaAsociada(pistaAsociada);
				
				request.setAttribute("pistaAsociada", pistaAsociada);
			
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/modificarKartsView.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("message", "No se ha podido encontrar el kart en la base de datos.");
			
				dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
