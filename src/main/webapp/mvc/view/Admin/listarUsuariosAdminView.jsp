<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="listasBean" scope="session" class="pw.display.javabean.listasBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOusuario" %>
<%@ page import = "pw.data.dao.DAOusuario" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador modificar usuarios</title>
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
	
	<h1 class="menusPrincipales">Nuestros usuarios</h1>
	<p class="menusPrincipales">El listado de nuestros usuarios es el siguiente. En caso de querer modificar alguno, introducir los datos que correspondan al usuario deseado.</p>
	
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
	
	<h3 class="menusPrincipales">Usuarios</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="5%">ID</th>
 				<th scope="col" width="15%">Nombre y apellidos</th>
				<th scope="col" width="10%">Correo electrónico</th>
				<th scope="col" width="5%">Rol</th>
				<th scope="col" width="10%">Fecha de nacimiento</th>
				<th scope="col" width="10%">Fecha de inscripcion</th>
			</tr>
		</thead>
		<tbody>
		
			<%
			for(DTOusuario usuario : listasBean.getListaUsuarios()){
			%>
			<tr>
				<th scope="col" width="5%"><%=usuario.getId() %></th>	
				<td scope="col" width="15%"><%=usuario.getNombreApellidos()%></td>
				<td scope="col" width="10%"><%=usuario.getCorreo()%></td>
				<td scope="col" width="5%"><%=usuario.getRol()%></td>
				<td scope="col" width="10%"><%=funciones.LocalDateToString(usuario.getFechaNacimiento()) %></td>
				<td scope="col" width="10%"><%=funciones.LocalDateToString(usuario.getFechaInscripcion()) %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br><br>
</body>
</html>