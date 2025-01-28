<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOusuario" %>

<!DOCTYPE html>
<html>
<head>
<title>Inicio</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/PW-web/css/barraMenu.css" rel="stylesheet" type="text/css">
<link href="/PW-web/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%
	if (userBean == null || userBean.getCorreo().equals("") || !userBean.getRol().equals("Cliente")) {%>
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
	 	 <a class="navbar-brand" href="/PW-web/mvc/view/Cliente/clienteView.jsp">
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
	
	<h1 class="menusPrincipales">Bienvenido al menú principal  <jsp:getProperty property="nombreApellidos" name="userBean"/></h1>
	<p class="menusPrincipales">Llevas en el sistema <jsp:getProperty property="anios" name="userBean"/> años <jsp:getProperty property="meses" name="userBean"/> meses y <jsp:getProperty property="dias" name="userBean"/> dias.</p>
	<div class="menusPrincipales">
		<table style="width: 90%">
			<thead>
				<tr>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Reservas</h1>
							<form id="form" method="POST" action="/PW-web/mvc/view/Cliente/crearReservaView.jsp">
								<button type="submit" value="Submit">Crear nueva reserva</button>
							</form>
							<p>Pulsa el boton si quieres introducir los datos para una nueva reserva.</p>
							<form id="form" method="POST" action="">
								<button type="submit" value="Submit">Adquirir bono</button>
							</form>
							<p>No funciona</p>
						</div>
					</th>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Pistas</h1>
							<form id="form" method="POST" action="/PW-web/consultarPistasServlet">
								<button type="submit" value="Submit">Listar pistas</button>
							</form>
							<p>Pulsa el boton si quieres ver los datos de nuestras pistas.</p>
							<form id="form" method="POST" action="/PW-web/consultarPistasFiltroServlet">
								<button type="submit" value="Submit">Buscar pistas</button>
							</form>
							<p>Pulsa el boton si quieres ver los datos de nuestras pistas realizando un filtrado.</p>
						</div>
					</th>
				</tr>
				<tr>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Mis reservas</h1>
							<form id="form" method="POST" action="/PW-web/consultarMisReservasServlet">
								<button type="submit" value="Submit">Consultar mis reservas</button>
							</form>
							<p>Pulsa el boton si quieres ver los datos de tus reservas.</p>
							<form id="form" method="POST" action="/PW-web/consultarReservasServlet">
								<button type="submit" value="Submit">Modificar reserva</button>
							</form>
							<p>Pulsa el boton si quieres modificar los datos de tus reservas.</p>
							<form id="form" method="POST" action="/PW-web/consultarBorrarReservasServlet">
								<button type="submit" value="Submit">Cancelar reserva</button>
							</form>
							<p>Pulsa el boton si quieres borrar una de tus reservas.</p>
						</div>
					</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>