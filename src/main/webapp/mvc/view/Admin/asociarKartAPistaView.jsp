<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOkart" %>
<%@ page import = "pw.bussiness.dto.DTOpista" %>
<%@ page import = "pw.bussiness.gestores.Dificultad" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador asociar kart</title>
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
	
	<h1 class="menusPrincipales">Asociar kart a pista</h1>
	<p class="menusPrincipales">Introduce los datos del kart y la pista para asociarlos.</p>
	
	<br>
	
	<form class="menusPrincipales" id="form" method="POST" action="/PW-web/asociarKartAPistaServlet">
		<table class="alineadoCentro" style="width: 30%">
			<thead>
				<tr>
					<th scope="col">
						<label>ID del kart</label> 
						<br> 
						<input type="number" id="idKart" name="idKart" placeholder="1" required>
					</th>
					<th scope="col">
						<label>Nombre de la pista</label> 
						<br>
						<input type="text" id="nombre" name="nombre" placeholder="BAHRAIN" required>
					</th>
					<th scope="col">
						<input type="submit" class="btn btn-dark btn-sm" value="Asociar" />
					</th>
				</tr>
			</thead>
		</table>
	</form>
	
	<br><br>
	
	<%
	ArrayList<DTOkart> listaKarts = (ArrayList<DTOkart>) request.getAttribute("listaKarts");
	ArrayList<DTOpista> listaPistas = (ArrayList<DTOpista>) request.getAttribute("listaPistas");
	%>

	<table class="alineadoCentro" style="width: 70%">
		<thead>
			<tr>
				<th scope="col">
					<h3 class="menusPrincipales">Karts</h3>
					<table class="tablasInformacion" style="width: 75%" border="2px">
						<thead>
							<tr>
								<th scope="col" width="15%">ID</th>
								<th scope="col" width="10%">Tipo</th>
								<th scope="col" width="10%">Pista asociada</th>
							</tr>
						</thead>
						<tbody>
							<%
							if (listaKarts != null) {
								for (DTOkart DTOkart : listaKarts) {
							%>
							<tr>
								<td><%=DTOkart.getId()%></td>
								<%
								if (DTOkart.getTipo() == true) {
								%><td>Adulto</td>
								<%
								} else {
								%><td>Infantil</td>
								<%
								}
								%>
								<td><%=DTOkart.getPistaAsociada()%></td>
							</tr>
							<%
							}
							}
							%>
						</tbody>
					</table>
				</th>
				<th scope="col">
					<h3 class="menusPrincipales">Pistas</h3>
					<table class="tablasInformacion" style="width: 50%%" border="2px">
						<thead>
							<tr>
								<th scope="col" width="15%">ID</th>
								<th scope="col" width="15%">Nombre</th>
								<th scope="col" width="15%">Dificultad</th>
							</tr>
						</thead>
						<tbody>
							<%
							if (listaPistas != null) {
								for (DTOpista DTOpista : listaPistas) {
							%>
							<tr>
								<td><%=DTOpista.getId()%></td>
								<td><%=DTOpista.getNombre()%></td>
								<%
								if (DTOpista.getDificultad() == Dificultad.infantil) {
								%><td>Infantil</td>
								<%
								} else if (DTOpista.getDificultad() == Dificultad.familiar) {
								%><td>Familiar</td>
								<%
								} else {
								%><td>Adultos</td>
								<%
				}
				%>
							</tr>
							<%
				}
			}
			%>
						</tbody>
					</table>
				</th>
			</tr>
		</thead>
	</table>

	<br>
</body>
</html>