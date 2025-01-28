<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="reservasBean" scope="session" class="pw.display.javabean.reservasBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Reserva</title>
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
				<a href="../PW-web/mvc/view/datosPersonalesView.jsp">Mis datos</a> 
				<a href="/PW-web/mvc/controller/logoutController.jsp">Desconectar</a>
			</div>
		</div>
	</nav>
	
	<br>
	
	<h1 class="menusPrincipales">Borrar reserva</h1>
	<p class="menusPrincipales">La reserva seleccionada se va a borrar.</p>
	
	<br>
	
	<%
	String bono = (String) request.getAttribute("bono");
	%>
	
	<h3 class="menusPrincipales">Se borrará la reserva con ID <jsp:getProperty property="id" name="reservasBean"/></h3>
	
	<form class="menusPrincipales" id="form" method="post" action="/PW-web/borrarReservaAdminServlet">
		<div class="form-group">
			<label>ID:</label>
			<button type="button"><jsp:getProperty property="id" name="reservasBean"/></button>
			<br>
		</div>
		<div class="form-group">
			<label>Usuario:</label>
			<button type="button"><jsp:getProperty property="usuario" name="reservasBean"/></button>
			<br>
		</div>
		<div class="form-group">
			<%
			if(bono.equals("0")){
				%><label>No pertenece a ningun bono</label>
				  <br>
				<%
			}else{
				%><button type="button"><jsp:getProperty property="bono" name="reservasBean"/></button><%
			}
			%>
			<br>
		</div>
		<div class="form-group">
			<label>Nombre de la pista:</label>
			<button type="button"><jsp:getProperty property="pista" name="reservasBean"/></button>
			<br>
		</div>
		<div class="form-group">
			<label>Fecha:</label>
			<button type="button"><jsp:getProperty property="fecha" name="reservasBean"/></button>
			<br> 
		</div>
		<div class="form-group">
			<label>Duracion:</label>
			<button type="button"><jsp:getProperty property="duracion" name="reservasBean"/></button>
			<br>
		</div>
		<div class="form-group">
			<label>Numero de niños:</label>
			<button type="button"><jsp:getProperty property="numInfantil" name="reservasBean"/></button>
			<br>
		</div>
		<div class="form-group">
			<label>Numero de adultos:</label>
			<button type="button"><jsp:getProperty property="numAdultos" name="reservasBean"/></button>
			<br>
		</div>
		<button type="submit" class="btn btn-dark">Borrar</button>
	</form>
</body>
</html>