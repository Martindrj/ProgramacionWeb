<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador modificar reservas</title>
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
	
	<h1 class="menusPrincipales">Nuestras reservas</h1>
	<p class="menusPrincipales">El listado de nuestras reservas es el siguiente. En caso de querer modificar alguna, hacer click en el icono correspondiente.</p>
	
	<br>
	
	<form class="menusPrincipales" id="form" method="POST" action="/PW-web/mvc/view/Admin/modificarUsuariosView.jsp">
		<table class="alineadoCentro" style="width: 30%">
			<thead>
				<tr>
					<th scope="col">
						<label>ID</label>
					</th>
					<th scope="col">
						<input type="number" id="identificador" name="identificador" placeholder="1" required>
					</th>
					<th scope="col">
						<input type="submit" class="btn btn-dark btn-sm" value="Filtrar" />
					</th>
				</tr>
			</thead>
		</table>
	</form>
	
	<br>
	
	<h3 class="menusPrincipales">Reservas</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="5%">ID</th>
				<th scope="col" width="10%">Usuario</th>
				<th scope="col" width="10%">Pista</th>
				<th scope="col" width="10%">Fecha</th>
				<th scope="col" width="5%">Duración</th>
				<th scope="col" width="10%">Precio final</th>
				<th scope="col" width="10%">Tipo</th>
				<th scope="col" width="5%">Bono</th>
				<th scope="col" width="15%">Número participantes</th>
				<th scope="col" width="5%">Modificar</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i=0; i<2; i++){
			%>
			<tr>
				<td scope="col" width="5%">prueba</td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="5%"></td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="5%"></td>
				<td scope="col" width="15%"></td>
				<td scope="col" width="5%">
					<a class="navbar-brand" href="/PW-web/mvc/view/Admin/modificarReservasView.jsp">
	  	 				<img src="../../../images/modificar.jpg" width="20" height="20" class="d-inline-block align-top" alt="">
	  				</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br><br>
</body>
</html>