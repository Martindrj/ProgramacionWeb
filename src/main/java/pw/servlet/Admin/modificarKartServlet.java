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
import pw.display.javabean.kartBean;
import pw.display.javabean.usuarioBean;

/**
 * Servlet que implementa la clase modificarKartServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="modificarKartServlet", urlPatterns="/modificarKartServlet")
public class modificarKartServlet extends HttpServlet {
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
			String tipo = request.getParameter("tipo");
			String estadoKart = request.getParameter("estado");
			String pistaAsociada = "";
			pistaAsociada = request.getParameter("pistaAsociada");
			
			DTOkart DTOkart = new DTOkart();
			DTOpista DTOpista = new DTOpista();
			DAOkart DAOkart = new DAOkart();
			DAOpista DAOpista = new DAOpista();
			
			int idKart = Integer.parseInt(kartBean.getId());
			
			if(DAOkart.existeKartID(idKart, prop)) {
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
				
				if(pistaAsociada.equals("")) {
					DTOkart.setPistaAsociada(0);
					DTOpista = DAOpista.buscarPistaID(0,prop);
				}else {
					DTOkart.setPistaAsociada(Integer.parseInt(pistaAsociada));
					DTOpista = DAOpista.buscarPistaID(Integer.parseInt(pistaAsociada),prop);
				}
				
				if(DTOpista!=null && DTOpista.getId()!=0) {
					if((DTOpista.getDificultad()==Dificultad.infantil && !DTOkart.getTipo()) || (DTOpista.getDificultad()==Dificultad.adulto && DTOkart.getTipo()) || DTOpista.getDificultad()==Dificultad.familiar) {
						DTOkart.setPistaAsociada(DTOpista.getId());
						DAOkart.Modificar(DTOkart, idKart,prop);
						request.setAttribute("message", "El kart se ha modificado con exito.");
						dispatcher = request.getRequestDispatcher("/consultarKartsAdminServlet");
						dispatcher.forward(request, response);
					}
					else {
						request.setAttribute("message", "Error al modificar el kart.");
						dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
						dispatcher.forward(request, response);
					}
				}else if(DTOkart.getPistaAsociada()==0){
					DAOkart.Modificar(DTOkart, idKart,prop);
					request.setAttribute("message", "El kart se ha modificado con exito.");
					dispatcher = request.getRequestDispatcher("/consultarKartsAdminServlet");
					dispatcher.forward(request, response);
				}else {
					request.setAttribute("message", "No se ha podido encontrar la pista a la que se esta asociando el kart.");
					
					dispatcher = request.getRequestDispatcher("/mvc/view/Admin/adminView.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
	}

}
