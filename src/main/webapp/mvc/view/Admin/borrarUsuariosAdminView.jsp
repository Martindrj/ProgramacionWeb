<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador borrar usuarios</title>
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
	<p class="menusPrincipales">El listado de nuestros usuarios es el siguiente. En caso de querer borrar alguno, hacer click en el icono correspondiente.</p>
	
	<br>
	
	<h3 class="menusPrincipales">Usuarios</h3>
	<table class="tablasInformacion" style="width: 75%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="15%">Nombre y apellidos</th>
				<th scope="col" width="10%">Correo electrónico</th>
				<th scope="col" width="5%">Rol</th>
				<th scope="col" width="10%">Fecha de nacimiento</th>
				<th scope="col" width="10%">Fecha de inscripcion</th>
				<th scope="col" width="5%">Borrar</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i=0; i<2; i++){
			%>
			<tr>
				<td scope="col" width="15%">prueba</td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="5%"></td>
				<td scope="col" width="10%"></td>
				<td scope="col" width="10%"></td>
				<th scope="col" width="5%">
					<a class="navbar-brand" href="/PW-web/mvc/view/Admin/borrarUsuariosAdminView.jsp">
	  	 				<img src="../../../images/basura.jpg" width="20" height="20" class="d-inline-block align-top" alt="">
	  				</a>
				</th>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br><br>
</body>
</html>