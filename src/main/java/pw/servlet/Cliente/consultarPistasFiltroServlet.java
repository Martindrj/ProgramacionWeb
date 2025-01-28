package pw.servlet.Cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.bussiness.dto.DTOpista;
import pw.bussiness.dto.DTOreservaAdultos;
import pw.bussiness.dto.DTOreservaFamiliar;
import pw.bussiness.dto.DTOreservaInfantil;
import pw.bussiness.gestores.Dificultad;
import pw.data.common.DBConnection;
import pw.data.dao.DAOpista;
import pw.data.dao.DAOreservas;
import pw.display.javabean.usuarioBean;

/**
 * Servlet implementation class BuscarPistaServlet
 */
@WebServlet(name="consultarPistasFiltroServlet", urlPatterns="/consultarPistasFiltroServlet")
public class consultarPistasFiltroServlet extends HttpServlet {
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
		
		if(usuarioBean == null || usuarioBean.getCorreo().equals("")) {
			response.sendRedirect("/PW-web");
			request.setAttribute("message", "Acceda o registrese");
		} else{
			String tipoPista = null;
			String fecha = null;
			String karts = null;
			tipoPista = request.getParameter("tipoPista");
			fecha = request.getParameter("fecha");
			karts = request.getParameter("numKarts");
			
			if(tipoPista == null || fecha == null || karts == null) {
				request.setAttribute("listaPistas", DAOpista.ListaPistas(prop));
				
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/buscarPistasView.jsp");
				dispatcher.forward(request, response);
			}else {
				ArrayList <DTOpista> pistasbd = DAOpista.ListaPistas(prop);
				ArrayList <DTOpista> buscarPistas = new ArrayList <DTOpista>();
				
				DAOreservas DAOreservas = new DAOreservas();
				LocalDate fecha1 = LocalDate.parse(fecha);
				int numkarts = Integer.parseInt(karts);
				
				for (DTOpista pista : pistasbd) {
					if (tipoPista.equals("infantil")) {
						if (pista.getDificultad() == Dificultad.infantil && pista.getEstado()==true && pista.getMaxKarts()>= numkarts) {
							if(DAOreservas.ListaReservasInfantilPistaFecha(pista.getNombre(), fecha1, prop).size()==0) {
								buscarPistas.add(pista);
							}
						}
					}
					else if (tipoPista.equals("familiar")) {
						if (pista.getDificultad() == Dificultad.familiar && pista.getEstado()==true && pista.getMaxKarts()>= numkarts) {
							if(DAOreservas.ListaReservasFamiliarPistaFecha(pista.getNombre(), fecha1, prop).size()==0) {
								buscarPistas.add(pista);
							}
						}
					}else if (tipoPista.equals("adultos")) {
						if (pista.getDificultad() == Dificultad.adulto && pista.getEstado()==true && pista.getMaxKarts()>= numkarts) {
							if(DAOreservas.ListaReservasAdultosPistaFecha(pista.getNombre(), fecha1, prop).size()==0) {
								buscarPistas.add(pista);
							}
						}
					}
				}
				request.setAttribute("listaPistas", buscarPistas);
				dispatcher = request.getRequestDispatcher("/mvc/view/Cliente/buscarPistasView.jsp");
				dispatcher.forward(request, response);
			}
		}	
	}
}