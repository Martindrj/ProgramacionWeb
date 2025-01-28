<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="reservasBean" scope="session" class="pw.display.javabean.reservasBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOreserva" %>
<%@ page import = "pw.bussiness.dto.DTOreservaInfantil" %>
<%@ page import = "pw.bussiness.dto.DTOreservaFamiliar" %>
<%@ page import = "pw.bussiness.dto.DTOreservaAdultos" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<title>Mis reservas</title>
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
	
	<h1 class="menusPrincipales">Mis reservas</h1>
	<p class="menusPrincipales">El listado de sus reservas es el siguiente. En caso de querer borrar alguna, introducir los datos que correspondan a la reserva deseada.</p>
	
	<br>
	
	<form class="menusPrincipales" id="form" method="POST" action="/PW-web/buscarBorrarReservaServlet">
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
						<input type="submit" class="btn btn-dark btn-sm" value="Borrar" />
					</th>
				</tr>
			</thead>
		</table>
	</form>
	
	<br><br>
	
	<%
	ArrayList<DTOreservaInfantil> listaInfantil = (ArrayList<DTOreservaInfantil>) request.getAttribute("listaReservasInfantil");
	ArrayList<DTOreservaFamiliar> listaFamiliar = (ArrayList<DTOreservaFamiliar>) request.getAttribute("listaReservasFamiliar");
	ArrayList<DTOreservaAdultos> listaAdultos = (ArrayList<DTOreservaAdultos>) request.getAttribute("listaReservasAdultos");
	%>
	
	<h3 class="menusPrincipales">Reservas infantiles</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="15%">ID</th>
				<th scope="col" width="15%">Pista</th>
				<th scope="col" width="15%">Fecha</th>
				<th scope="col" width="15%">Duración</th>
				<th scope="col" width="15%">Precio final</th>
				<th scope="col" width="15%">Bono</th>
				<th scope="col" width="15%">Numero participantes</th>
			</tr>
		</thead>
		<tbody>
			<%
			if(listaInfantil !=null){
				for(DTOreservaInfantil DTOreservaInfantil : listaInfantil){
			%>
			<tr>
				<td><%= DTOreservaInfantil.getId() %></td>
				<td><%= DTOreservaInfantil.getPista() %></td>
				<td><%= DTOreservaInfantil.getFecha() %></td>
				<td><%= DTOreservaInfantil.getDuracion() %></td>
				<td><%= DTOreservaInfantil.getprecioFinal() %></td>
				<td><%= DTOreservaInfantil.getBono() %></td>
				<td><%= DTOreservaInfantil.getNumParticipantes()%></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
	
	<br><br>
	
	<h3 class="menusPrincipales">Reservas familiares</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
	<thead>
			<tr>
				<th scope="col" width="15%">ID</th>
				<th scope="col" width="15%">Pista</th>
				<th scope="col" width="15%">Fecha</th>
				<th scope="col" width="15%">Duración</th>
				<th scope="col" width="15%">Precio final</th>
				<th scope="col" width="15%">Bono</th>
				<th scope="col" width="15%">Numero participantes</th>
			</tr>
		</thead>
		<tbody>
			<%
			if(listaFamiliar !=null){
				for(DTOreservaFamiliar DTOreservaFamiliar : listaFamiliar){
			%>
			<tr>
				<td><%= DTOreservaFamiliar.getId() %></td>
				<td><%= DTOreservaFamiliar.getPista() %></td>
				<td><%= DTOreservaFamiliar.getFecha() %></td>
				<td><%= DTOreservaFamiliar.getDuracion() %></td>
				<td><%= DTOreservaFamiliar.getprecioFinal() %></td>
				<td><%= DTOreservaFamiliar.getBono() %></td>
				<td><%= DTOreservaFamiliar.getNumParticipantes()%></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
	
	<br><br>
	
	<h3 class="menusPrincipales">Reservas de adultos</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="15%">ID</th>
				<th scope="col" width="15%">Pista</th>
				<th scope="col" width="15%">Fecha</th>
				<th scope="col" width="15%">Duración</th>
				<th scope="col" width="15%">Precio final</th>
				<th scope="col" width="15%">Bono</th>
				<th scope="col" width="15%">Numero participantes</th>
			</tr>
		</thead>
		<tbody>
			<%
			if(listaAdultos !=null){
				for(DTOreservaAdultos DTOreservaAdultos : listaAdultos){
			%>
			<tr>
				<td><%= DTOreservaAdultos.getId() %></td>
				<td><%= DTOreservaAdultos.getPista() %></td>
				<td><%= DTOreservaAdultos.getFecha() %></td>
				<td><%= DTOreservaAdultos.getDuracion() %></td>
				<td><%= DTOreservaAdultos.getprecioFinal() %></td>
				<td><%= DTOreservaAdultos.getBono() %></td>
				<td><%= DTOreservaAdultos.getNumParticipantes()%></td>
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