<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="kartBean" scope="session" class="pw.display.javabean.kartBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador modificar kart</title>
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
	
	<%
	String pistaAsociada = (String) request.getAttribute("pistaAsociada");
	%>
	
	<h1 class="menusPrincipales">Modificar kart</h1>
	<p class="menusPrincipales">El kart seleccionado se puede modificar cambiando los siguientes campos.</p>
	
	<br>
	
	<h3 class="menusPrincipales">Se esta modificando el kart con ID <jsp:getProperty property="id" name="kartBean"/></h3>
	
	<form class="menusPrincipales" id="form" method="post" action="/PW-web/modificarKartServlet">
		<div class="form-group">
			<label>ID:</label>
			<button type="button"><jsp:getProperty property="id" name="kartBean"/></button>
			<br>
		</div>
		<div class="form-group">
			<label>Tipo del kart:</label><jsp:getProperty property="tipo" name="kartBean"/>
			<br> 
			<select id="tipo" name="tipo" required>
				<option value="infantil">Infantil</option>
				<option value="adulto">Adulto</option>
			</select> 
		</div>
		<div class="form-group">
			<label>Estado del kart:</label><jsp:getProperty property="estado" name="kartBean"/>
			<br> 
			<select id="estado" name="estado" required>
				<option value="disponible">Disponible</option>
				<option value="reservado">Reservado</option>
				<option value="mantenimiento">Mantenimiento</option>
			</select> 
		</div>
		<div class="form-group">
			<%
			if(pistaAsociada.equals("0")){
				%><label>No esta asociado a ninguna pista</label>
				  <br>
				  <label>Introduce el ID de una pista si deseas asociarlo.</label>
				<%
			}else{
				%><label>ID de la pista al que está asociado:</label><jsp:getProperty property="pistaAsociada" name="kartBean"/><%
			}
			%>
			<br>
			<input type="number" id="pistaAsociada" name="pistaAsociada" placeholder="1">
		</div>
		<button type="submit" class="btn btn-dark">Actualizar</button>
		<button type="reset" class="btn btn-dark">Borrar</button>
	</form>
</body>
</html>