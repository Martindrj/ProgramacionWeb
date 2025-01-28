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
		String correo = request.getParameter("correo");
		String contraseña = request.getParameter("pass");
		
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
		
		
		if (!DTOusuario.getCorreo().equals(correo) || !DTOusuario.getPassword().equals(contraseña)){
			nextPage="../../index.jsp";
			nextPageMessage = "Usuario o contrasena incorrecta";
		}else{
			%>
			<jsp:setProperty property="id" value="<%=funciones.IntToString(DTOusuario.getId()) %>" name="userBean"/>
			<jsp:setProperty property="nombreApellidos" value="<%=DTOusuario.getNombreApellidos() %>" name="userBean"/>
			<jsp:setProperty property="correo" value="<%=DTOusuario.getCorreo() %>" name="userBean"/>
			<jsp:setProperty property="password" value="<%=DTOusuario.getPassword() %>" name="userBean"/>
			<jsp:setProperty property="rol" value="<%=DTOusuario.getRol() %>" name="userBean"/>
			<jsp:setProperty property="fechaNacimiento" value="<%=funciones.LocalDateToString(DTOusuario.getFechaNacimiento()) %>" name="userBean"/>
			<jsp:setProperty property="fechaInscripcion" value="<%=funciones.LocalDateToString(DTOusuario.getFechaInscripcion()) %>" name="userBean"/>
			<jsp:setProperty property="anios" value="<%=funciones.LongToString(DTOusuario.calcularAntiguedadAnios()) %>" name="userBean"/>
			<jsp:setProperty property="meses" value="<%=funciones.LongToString(DTOusuario.calcularAntiguedadMeses()) %>" name="userBean"/>
			<jsp:setProperty property="dias" value="<%=funciones.LongToString(DTOusuario.calcularAntiguedadDias()) %>" name="userBean"/>
			<%
			
			nextPage = "userController.jsp";
			nextPageMessage = "Usuario conectado";
		}
	}
%>

<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=nextPageMessage%>" name="message"/>
</jsp:forward>