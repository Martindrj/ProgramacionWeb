<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador crear pista</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/PW-web/css/barraMenu.css" rel="stylesheet" type="text/css">
<link href="/PW-web/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%
	if (userBean == null || userBean.getCorreo().equals("") || !userBean.getRol().equals("Administrador")) {%>
		<jsp:forward page="../../controller/userController.jsp"/>
	<%
	}
	%>

	<%
	String message = (String)request.getAttribute("message");
	if (message == null) message = "";
	%>
	<%=message%>
	
	<nav class="navbar navbar-light bg-light sticky-top">
	 	 <a class="navbar-brand" href="/PW-web/mvc/view/Admin/adminView.jsp">
	  	 	 <p>🏠 Inicio</p>
	  	</a>
	  	<div class="centroHora">
	    	<%=funciones.dateToString( new java.util.Date() ) %>
		</div>
		<div class="dropdown">
			<button class="quitarMargenBorde">👤 Mi cuenta</button>
			<div class="dropdown-content">
				<a href="/PW-web/mvc/view/datosPersonalesView.jsp">Mis datos</a> 
				<a href="/PW-web/mvc/controller/logoutController.jsp">Desconectar</a>
			</div>
		</div>
	</nav>

	<br>
	
	<h1 class="menusPrincipales">Crear nueva pista</h1>
	
	<br>

	<form class="menusPrincipales" id="form" method="post" action="/PW-web/crearPistaServlet">
		<div class="form-group">
			<label>Nombre de la pista</label> 
			<br>
			<input type="text" id="nombre" name="nombre" placeholder="BAHRAIN" required>
		</div>
		<div class="form-group">
			<label>Estado de la pista</label> 
			<br> 
			<select id="estado" name="estado">
				<option value="disponible">Disponible</option>
				<option value="noDisponible">No disponible</option>
			</select> 
		</div>
		<div class="form-group">
			<label>Tipo de la pista</label> 
			<br> 
			<select id="tipo" name="tipo">
				<option value="infantil">Infantil</option>
				<option value="familiar">Familiar</option>
				<option value="adulto">Adulto</option>
			</select> 
		</div>
		<div class="form-group">
			<label>Número máximo de karts de la pista</label> 
			<br>
			<input type="number" id="maxKarts" name="maxKarts" placeholder="1" required>
		</div>
		<button type="submit" class="btn btn-dark">Crear</button>
		<button type="reset" class="btn btn-dark">Borrar</button>
	</form>
</body>
</html>