<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page errorPage="/include/errorPage.jsp" %>
<%@ page import="pw.data.dao.DAOusuario,pw.bussiness.dto.DTOusuario" %>
<%@ page import="pw.data.common.DBConnection" %>
<%@ page import="pw.bussiness.common.funciones" %>
<% 
	String nextPage = "userController.jsp";
	String nextPageMessage = "";

	if (userBean == null || userBean.getCorreo().equals("")) {
		String nombreApellidos = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String contraseña = request.getParameter("pass");
		String fechaNacimiento = request.getParameter("fechaNacimiendo");
		
		String url = application.getInitParameter("URL");
		String user = application.getInitParameter("User");
		String password = application.getInitParameter("Password");
		String properties = application.getInitParameter("properties");
		
		java.io.InputStream myIO = application.getResourceAsStream(properties);
		java.util.Properties prop = new java.util.Properties();
		prop.load(myIO);
		
		DBConnection bd = new DBConnection(url, user, password);
		
		DAOusuario DAOusuario = new DAOusuario();
		DTOusuario DTOusuario = DAOusuario.buscarUsuario(correo, prop);
		
		nextPage="../../index.jsp";
		nextPageMessage = fechaNacimiento;
		
		if (DTOusuario.getCorreo().equals(correo)){
			nextPage="userController.jsp";
			nextPageMessage = "El correo pertenece a un usuario ya registrado.";
		}else{
			String rol = "Cliente";
			DTOusuario nuevoUsuario = new DTOusuario(nombreApellidos, correo, contraseña, rol, funciones.StringToLocalDate(fechaNacimiento));
			DAOusuario.Guardar(nuevoUsuario, prop);
			nuevoUsuario = DAOusuario.buscarUsuario(nuevoUsuario.getCorreo(), prop);
			%>
			<jsp:setProperty property="id" value="<%=funciones.IntToString(nuevoUsuario.getId()) %>" name="userBean"/>
			<jsp:setProperty property="nombreApellidos" value="<%=nuevoUsuario.getNombreApellidos() %>" name="userBean"/>
			<jsp:setProperty property="correo" value="<%=nuevoUsuario.getCorreo() %>" name="userBean"/>
			<jsp:setProperty property="password" value="<%=nuevoUsuario.getPassword() %>" name="userBean"/>
			<jsp:setProperty property="rol" value="<%=nuevoUsuario.getRol() %>" name="userBean"/>
			<jsp:setProperty property="fechaNacimiento" value="<%=funciones.LocalDateToString(nuevoUsuario.getFechaNacimiento()) %>" name="userBean"/>
			<jsp:setProperty property="fechaInscripcion" value="<%=funciones.LocalDateToString(nuevoUsuario.getFechaInscripcion()) %>" name="userBean"/>
			<%
			
			nextPage = "userController.jsp";
		}
	}
%>

<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=nextPageMessage%>" name="message"/>
</jsp:forward>