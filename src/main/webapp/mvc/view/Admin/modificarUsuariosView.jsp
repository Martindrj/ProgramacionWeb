<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Administrador modificar usuario</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/PW-web/css/barraMenu.css" rel="stylesheet" type="text/css">
<link href="/PW-web/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<script type="text/javascript">
function mostrarContraseña(){
  var checkBox = document.getElementById('ver');
  var texto = document.getElementById('password');
  if (checkBox.checked == true){
	texto.type = 'text';
  } else{
	texto.type = 'password';
  }
}
</script>

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
	
	<h1 class="menusPrincipales">Modificar usuario</h1>
	<p class="menusPrincipales">El usuario seleccionado se puede modificar cambiando los siguientes campos.</p>
	
	<br>
	
	<form class="menusPrincipales" id="form" method="post" action="#">
		<div class="form-group">
			<label>Nombre y apellidos</label> 
			<br>
			<input type="text" id="nombre" name="nombre" placeholder="Fernando Alonso Díaz" required>
		</div>
		<div class="form-group">
			<label>Correo electrónico</label> 
			<br>
			<input type="email" id="correo" name=correo placeholder="ejemplo@email.com" required>
		</div>
		<div class="form-group">
			<label>Contraseña</label> 
			<br>
			<input type="password" id="password" name=password placeholder="Password" required>
			<input type="checkbox" id="ver" onclick="mostrarContraseña()">
			<label for="mostrarContraseña">Mostrar contraseña</label>
		</div>
		<div class="form-group">
			<label>Rol</label> 
			<br> 
			<select id="rol" name="rol">
				<option value="cliente">Cliente</option>
				<option value="admin">Administrador</option>
			</select> 
		</div>
		<div class="form-group">
			<label>Fecha de nacimiento</label> 
			<br>
			 <input type="date" id="fechaNacimiento" name=fechaNacimiento required>
		</div>
		<div class="form-group">
			<label>Fecha de inscripcion</label> 
			<br>
			 <input type="date" id="fechaInscripcion" name=fechaInscripcion required>
		</div>
		<button type="submit" class="btn btn-dark">Actualizar</button>
		<button type="reset" class="btn btn-dark">Borrar</button>
	</form>
</body>
</html>