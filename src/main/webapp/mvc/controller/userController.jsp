<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="listasBean" scope="session" class="pw.display.javabean.listasBean"></jsp:useBean>
<%@ page errorPage="/include/errorPage.jsp" %>
<%@ page import="pw.data.dao.DAOusuario,pw.bussiness.dto.DTOusuario" %>
<%@ page import="pw.data.common.DBConnection" %>
<%@ page import="pw.bussiness.common.funciones" %>
<%
	String nextPage = "../../index.jsp";
	String nextPageMessage = "Acceda o regístrese en la página";
	
	if (userBean != null && !userBean.getCorreo().equals("")) {
		if(userBean.getRol().equals("Administrador")){
			String url = application.getInitParameter("URL");
			String user = application.getInitParameter("User");
			String password = application.getInitParameter("Password");
			String properties = application.getInitParameter("properties");
			
			java.io.InputStream myIO = application.getResourceAsStream(properties);
			java.util.Properties prop = new java.util.Properties();
			prop.load(myIO);
			
			DBConnection bd = new DBConnection(url, user, password);
			
			nextPage = "../view/Admin/adminView.jsp";
			nextPageMessage = "Bienvenido al sistema Administrador";
			DAOusuario DAOusuario = new DAOusuario();
			%>
			<jsp:setProperty property="listaUsuarios" value="<%=DAOusuario.ListaUsuarios(prop)%>" name="listasBean"/>
			<%
			
		}else if (userBean.getRol().equals("Cliente")){
			nextPage = "../view/Cliente/clienteView.jsp";
			nextPageMessage = "Bienvenido al sistema Cliente";
		}else{
			nextPage = "../../index.jsp";
			nextPageMessage = "El usuario no tiene rol.";
		}
	}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=nextPageMessage%>" name="message"/>
</jsp:forward>