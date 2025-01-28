<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<jsp:useBean  id="listasBean" scope="session" class="pw.display.javabean.listasBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>
<%@ page import = "pw.bussiness.dto.DTOusuario" %>
<!DOCTYPE html>
<html>
<head>
<title>Administrador</title>
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
	
	<h1 class="menusPrincipales">Bienvenido al menú de administrador <jsp:getProperty property="nombreApellidos" name="userBean"/></h1>
	<div class="menusPrincipales">
		<table style="width: 90%">
			<thead>
				<tr>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Pistas</h1>
							<form id="form" method="POST" action="/PW-web/mvc/view/Admin/crearPistasView.jsp">
								<button type="submit" value="Submit">Crear pista</button>
							</form>
							<p>Pulsa el boton si quieres crear una pista.</p>
							<form id="form" method="POST" action="/PW-web/consultarPistasAdminServlet">
								<button type="submit" value="Submit">Modificar pistas</button>
							</form>
							<p>Pulsa el boton si quieres modificar los datos de una pista.</p>
						</div>
					</th>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Reservas</h1>
							<form id="form" method="POST" action="/PW-web/consultarReservasAdminServlet">
								<button type="submit" value="Submit">Modificar reserva</button>
							</form>
							<p>Pulsa el boton si quieres modificar los datos de una reserva.</p>
							<form id="form" method="POST" action="/PW-web/consultarBorrarReservasAdminServlet">
								<button type="submit" value="Submit">Borrar reserva</button>
							</form>
							<p>Pulsa el boton si quieres borrar una reserva.</p>
						</div>
					</th>
				</tr>
				<tr>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Usuarios</h1>
							<form id="form" method="POST" action="/PW-web/mvc/view/Admin/crearUsuarioView.jsp">
								<button type="submit" value="Submit">Crear usuario</button>
							</form>
							<p>No funciona.</p>
							<form id="form" method="POST" action="">
								<button type="submit" value="Submit">Modificar usuarios</button>
							</form>
							<p>No funciona.</p>
							<form id="form" method="POST" action="">
								<button type="submit" value="Submit">Borrar usuarios</button>
							</form>
							<p>No funciona.</p>
						</div>
					</th>
					<th scope="col" width="50%">
						<div class="container p-3 my-3 border">
							<h1>Karts</h1>
							<form id="form" method="POST" action="/PW-web/mvc/view/Admin/crearKartsView.jsp">
								<button type="submit" value="Submit">Crear kart</button>
							</form>
							<p>Pulsa el boton si quieres crear un kart.</p>
							<form id="form" method="POST" action="/PW-web/consultarKartsAdminServlet">
								<button type="submit" value="Submit">Modificar kart</button>
							</form>
							<p>Pulsa el boton si quieres modificar los datos de un kart.</p>
							<form id="form" method="POST" action="/PW-web/consultarKartsYPistasAdminServlet">
								<button type="submit" value="Submit">Asociar kart a pista</button>
							</form>
							<p>Pulsa el boton si quieres asociar un kart a una pista.</p>
						</div>
					</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<div>
		<h3 class="menusPrincipales">Usuarios</h3>
	<table class="tablasInformacion" style="width: 40%" border="2px">
		<thead>
			<tr>
				<th scope="col" width="5%">ID</th>
 				<th scope="col" width="15%">Nombre y apellidos</th>
				<th scope="col" width="10%">Antigüedad</th>
			</tr>
		</thead>
		<tbody>
		
			<%
			for(DTOusuario usuario : listasBean.getListaUsuarios()){
			%>
			<tr>
				<th scope="col" width="5%"><%=usuario.getId() %></th>	
				<td scope="col" width="15%"><%=usuario.getNombreApellidos()%></td>
				<td scope="col" width="10%"><%=usuario.calcularAntiguedadAnios()%> años <%=usuario.calcularAntiguedadMeses()%> meses <%=usuario.calcularAntiguedadDias()%> dias</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	</div>
	<br>
</body>
</html>