package pw.servlet.Cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.bussiness.common.funciones;
import pw.bussiness.dto.DTOreservaAdultos;
import pw.bussiness.dto.DTOreservaFamiliar;
import pw.bussiness.dto.DTOreservaInfantil;
import pw.data.common.DBConnection;
import pw.data.dao.DAOreservas;
import pw.display.javabean.reservasBean;
import pw.display.javabean.usuarioBean;

/**
 * Servlet que implementa la clase buscarReservasServlet.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 * */
@WebServlet(name="buscarReservaServlet", urlPatterns="/buscarReservaServlet")
public class buscarReservaServlet extends HttpServlet {
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
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		}else{
			String id = request.getParameter("identificador");
			DTOreservaInfantil DTOreservaInfantil = new DTOreservaInfantil();			
			DTOreservaFamiliar DTOreservaFamiliar = new DTOreservaFamiliar();
			DTOreservaAdultos DTOreservaAdultos = new DTOreservaAdultos();
			DAOreservas DAOreservas = new DAOreservas();
			String idbon ="";
			int ida = Integer.parseInt(id);
				if (DAOreservas.BuscarReservasInfantilID(ida, prop) != null) {
					DTOreservaInfantil = DAOreservas.BuscarReservasInfantilID(ida, prop);
					reservasBean.setId(id);
					reservasBean.setUsuario(DTOreservaInfantil.getUsuario());
					reservasBean.setPista(DTOreservaInfantil.getPista());
					reservasBean.setFecha(funciones.LocalDateToString(DTOreservaInfantil.getFecha()));
					reservasBean.setDuracion(funciones.IntToString(DTOreservaInfantil.getDuracion()));
					reservasBean.setPrecio(Float.toString(DTOreservaInfantil.getPrecio()));
					reservasBean.setDescuento(Float.toString(DTOreservaInfantil.getDescuento()));
					reservasBean.setTipoReserva("infantil");
					reservasBean.setBono(funciones.IntToString(DTOreservaInfantil.getBono()));
					reservasBean.setNumInfantil(funciones.IntToString(DTOreservaInfantil.getNumInfantil()));
					reservasBean.setNumAdultos("0");
					reservasBean.setNumParticipantes(funciones.IntToString(DTOreservaInfantil.getNumInfantil()));
					
					idbon=Integer.toString(DTOreservaInfantil.getBono());	
					
				}else if (DAOreservas.BuscarReservasFamiliarID(ida, prop) != null) {
					DTOreservaFamiliar = DAOreservas.BuscarReservasFamiliarID(ida, prop);
					reservasBean.setId(id);
					reservasBean.setUsuario(DTOreservaFamiliar.getUsuario());
					reservasBean.setPista(DTOreservaFamiliar.getPista());
					reservasBean.setFecha(funciones.LocalDateToString(DTOreservaFamiliar.getFecha()));
					reservasBean.setDuracion(funciones.IntToString(DTOreservaFamiliar.getDuracion()));
					reservasBean.setPrecio(Float.toString(DTOreservaFamiliar.getPrecio()));
					reservasBean.setDescuento(Float.toString(DTOreservaFamiliar.getDescuento()));
					reservasBean.setTipoReserva("familiar");
					reservasBean.setBono(funciones.IntToString(DTOreservaFamiliar.getBono()));
					reservasBean.setNumInfantil(funciones.IntToString(DTOreservaFamiliar.getNumInfantil()));
					reservasBean.setNumAdultos(funciones.IntToString(DTOreservaFamiliar.getNumAdultos()));
					reservasBean.setNumParticipantes(funciones.IntToString(DTOreservaFamiliar.getNumParticipantes()));
					
					idbon=Integer.toString(DTOreservaInfantil.getBono());
					
				}else if (DAOreservas.BuscarReservasAdultosID(ida, prop) != null) {
					DTOreservaAdultos = DAOreservas.BuscarReservasAdultosID(ida, prop);
					reservasBean.setId(id);
					reservasBean.setUsuario(DTOreservaAdultos.getUsuario());
					reservasBean.setPista(DTOreservaAdultos.getPista());
					reservasBean.setFecha(funciones.LocalDateToString(DTOreservaAdultos.getFecha()));
					reservasBean.setDuracion(funciones.IntToString(DTOreservaAdultos.getDuracion()));
					reservasBean.setPrecio(Float.toString(DTOreservaAdultos.getPrecio()));
					reservasBean.setDescuento(Float.toString(DTOreservaAdultos.getDescuento()));
					reservasBean.setTipoReserva("adultos");
					reservasBean.setBono(funciones.IntToString(DTOreservaAdultos.getBono()));
					reservasBean.setNumInfantil("0");
					reservasBean.setNumAdultos(funciones.IntToString(DTOreservaAdultos.getNumAdultos()));
					reservasBean.setNumParticipantes(funciones.IntToString(DTOreservaAdultos.getNumAdultos()));	
					
					idbon=Integer.toString(DTOreservaInfantil.getBono());
				}
				request.setAttribute("bono", idbon);
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/modificarReservasView.jsp");
				dispatcher.forward(request, response);
			}
		}
	}