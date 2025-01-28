package pw.display.javabean;

import java.io.Serializable;
import java.util.ArrayList;

import pw.bussiness.dto.DTOusuario;
import pw.bussiness.dto.DTOpista;
import pw.bussiness.dto.DTOkart;
import pw.bussiness.dto.DTOreservaInfantil;
import pw.bussiness.dto.DTOreservaFamiliar;
import pw.bussiness.dto.DTOreservaAdultos;

/**
 * Clase listasBean.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez
 */
public class listasBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DTOusuario> listaUsuarios;
	private ArrayList<DTOpista> listaPistas;
	private ArrayList<DTOkart> listaKarts;
	private ArrayList<DTOreservaInfantil> listaReservasInfantil;
	private ArrayList<DTOreservaFamiliar> listaReservasFamiliar;
	private ArrayList<DTOreservaAdultos> listaReservasAdultos;
	
	public ArrayList<DTOusuario> getListaUsuarios() {
		return this.listaUsuarios;
	}
	
	public void setListaUsuarios(ArrayList<DTOusuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public ArrayList<DTOpista> getListaPistas() {
		return this.listaPistas;
	}
	
	public void setListaPistas(ArrayList<DTOpista> listaPistas) {
		this.listaPistas = listaPistas;
	}
	
	public ArrayList<DTOkart> getListaKarts() {
		return this.listaKarts;
	}
	
	public void setListaKarts(ArrayList<DTOkart> listaKarts) {
		this.listaKarts = listaKarts;
	}
	
	public ArrayList<DTOreservaInfantil> getListaReservasInfantil() {
		return this.listaReservasInfantil;
	}
	
	public void setListaReservasInfantil(ArrayList<DTOreservaInfantil> listaReservasInfantil) {
		this.listaReservasInfantil = listaReservasInfantil;
	}
	
	public ArrayList<DTOreservaFamiliar> getListaReservasFamiliar() {
		return this.listaReservasFamiliar;
	}
	
	public void setListaReservasFamiliar(ArrayList<DTOreservaFamiliar> listaReservasFamiliar) {
		this.listaReservasFamiliar = listaReservasFamiliar;
	}
	
	public ArrayList<DTOreservaAdultos> getListaReservasAdultos() {
		return this.listaReservasAdultos;
	}
	
	public void setListaReservasAdultos(ArrayList<DTOreservaAdultos> listaReservasAdultos) {
		this.listaReservasAdultos = listaReservasAdultos;
	}
}
