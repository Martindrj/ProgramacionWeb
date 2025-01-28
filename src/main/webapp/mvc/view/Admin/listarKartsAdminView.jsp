<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="kartBean" scope="session" class="pw.display.javabean.kartBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOkart" %>
<%@ page import = "pw.bussiness.gestores.Estado" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head><title>Administrador modificar karts</title>
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
	
	<h1 class="menusPrincipales">Nuestros karts</h1>
	<p class="menusPrincipales">El listado de nuestros karts es el siguiente. En caso de querer modificar alguno, introducir los datos que correspondan al kart deseado.</p>
	
	<br>
	
	<form class="menusPrincipales" id="form" method="POST" action="/PW-web/buscarKartServlet">
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
	ArrayList<DTOkart> listaKarts = (ArrayList<DTOkart>) request.getAttribute("listaKarts");
	%>
	
	<h3 class="menusPrincipales">Karts</h3>
	<table class="tablasInformacion" style="width: 40%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="5%">ID</th>
				<th scope="col" width="10%">Tipo</th>
				<th scope="col" width="10%">Estado</th>
				<th scope="col" width="5%">Pista asociada</th>
			</tr>
		</thead>
		<tbody>
			<%
			if(listaKarts !=null){
				for(DTOkart DTOkart : listaKarts){
			%>
			<tr>
				<td><%= DTOkart.getId() %></td>
				<%
				if(DTOkart.getTipo()==true){
					%><td>Adulto</td><%
				}else{
					%><td>Infantil</td><%
				}
				if(DTOkart.getEstado()==Estado.disponible){
					%><td>Disponible</td><%
				}else if(DTOkart.getEstado()==Estado.reservado){
					%><td>Reservado</td><%
				}else{
					%><td>Mantenimiento</td><%
				}
				%>
				<td><%= DTOkart.getPistaAsociada() %></td>
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