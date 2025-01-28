<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="pistaBean" scope="session" class="pw.display.javabean.pistaBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOpista" %>
<%@ page import = "pw.bussiness.gestores.Dificultad" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head><title>Administrador modificar pistas</title>
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
	
	<h1 class="menusPrincipales">Nuestras pistas</h1>
	<p class="menusPrincipales">El listado de nuestras pistas es el siguiente. En caso de querer modificar alguna, introducir los datos que correspondan a la pista deseada.</p>
	
	<br>
	
	<form class="menusPrincipales" id="form" method="POST" action="/PW-web/buscarPistaServlet">
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
	
	<%
	ArrayList<DTOpista> listaPistas = (ArrayList<DTOpista>) request.getAttribute("listaPistas");
	%>
	
	<h3 class="menusPrincipales">Pistas</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="5%">ID</th>
				<th scope="col" width="15%">Nombre</th>
				<th scope="col" width="10%">Estado</th>
				<th scope="col" width="10%">Dificultad</th>
				<th scope="col" width="10%">Numero máximo de karts</th>
				<th scope="col" width="15%">Karts asociados actualmente</th>
			</tr>
		</thead>
		<tbody>
			<%
			if(listaPistas !=null){
				for(DTOpista DTOpista : listaPistas){
			%>
			<tr>
				<td><%= DTOpista.getId() %></td>
				<td><%= DTOpista.getNombre() %></td>
				<%
				if(DTOpista.getEstado()==true){
					%><td>Disponible</td><%
				}else{
					%><td>No disponible</td><%
				}
				if(DTOpista.getDificultad()==Dificultad.infantil){
					%><td>Infantil</td><%
				}else if(DTOpista.getDificultad()==Dificultad.familiar){
					%><td>Familiar</td><%
				}else{
					%><td>Adultos</td><%
				}
				%>
				<td><%= DTOpista.getMaxKarts() %></td>
				<td></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
	<br><br>
</body>
</html>