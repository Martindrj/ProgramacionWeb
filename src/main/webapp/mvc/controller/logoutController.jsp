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
		nextPage = "userController.jsp";
		nextPageMessage = "";
	}else{
		%>
		<jsp:setProperty property="id" value="" name="userBean"/>
		<jsp:setProperty property="nombreApellidos" value="" name="userBean"/>
		<jsp:setProperty property="correo" value="" name="userBean"/>
		<jsp:setProperty property="password" value="" name="userBean"/>
		<jsp:setProperty property="rol" value="" name="userBean"/>
		<jsp:setProperty property="fechaNacimiento" value="" name="userBean"/>
		<jsp:setProperty property="fechaInscripcion" value="" name="userBean"/>
		<jsp:setProperty property="anios" value="" name="userBean"/>
		<jsp:setProperty property="meses" value="" name="userBean"/>
		<jsp:setProperty property="dias" value="" name="userBean"/>
		<%
		nextPage = "userController.jsp";
		nextPageMessage = "Usuario desconectado.";
	}
%>

<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=nextPageMessage%>" name="message"/>
</jsp:forward>