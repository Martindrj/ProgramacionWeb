<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>
<%@ page import = "pw.bussiness.common.funciones" %>

<!DOCTYPE html>
<html>
<head>
<title>Mis datos</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/PW-web/css/barraMenu.css" rel="stylesheet" type="text/css">
<link href="/PW-web/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<script type="text/javascript">
function mostrarContraseña(){
  var checkBox = document.getElementById('ver');
  var texto = document.getElementById('pass');
  if (checkBox.checked == true){
	texto.style.display = 'block';
  } else{
	texto.style.display = 'none';
  }
}
</script>

	<%
	if (userBean == null || userBean.getCorreo().equals("") ) {%>
		<jsp:forward page="../controller/userController.jsp"/>
	<%
	}
	%>

	<%
	String message = (String)request.getAttribute("message");
	if (message == null) message = "";
	%>
	<%=message%>
	
	<nav class="navbar navbar-light bg-light sticky-top">
		<% if(userBean.getRol().equals("Administrador")){ %>
	 	 <a class="navbar-brand" href="/PW-web/mvc/view/Admin/adminView.jsp">
	  	 	 <p>🏠 Inicio</p>
	  	</a>
	  	<%}else{ %>
	  	 <a class="navbar-brand" href="/PW-web/mvc/view/Cliente/clienteView.jsp">
	  	 	 <p>🏠 Inicio</p>
	  	</a>
	  	<% } %>
	  	<div class="centroHora">
	    	<%=funciones.dateToString( new java.util.Date() )%>
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
	
	<h1 class="menusPrincipales">Mis datos</h1>
	<p class="menusPrincipales">Estos son los datos sobre tu cuenta.</p>
	
	<br>
	<div class="menusPrincipales">
		<label>Nombre y apellidos: </label> 
		<br>
		<button id="nombre" name="nombre"><jsp:getProperty property="nombreApellidos" name="userBean"/></button>
		<br>
		<label>Correo electrónico: </label> 
		<br>
		<button id="correo" name="correo"><jsp:getProperty property="correo" name="userBean"/></button>
		<br>
		<label>Contraseña: </label> 
		<br>
		<input type="checkbox" id="ver" onclick="mostrarContraseña()">
		<label for="mostrarContraseña">Mostrar contraseña</label>
		<div>
			<button class="botonOculto" id="pass" name="pass"><jsp:getProperty property="password" name="userBean"/></button>
		</div>
		<br>
		<label>Rol:</label> 
		<br>
		<button id="rol" name="rol"><jsp:getProperty property="rol" name="userBean"/></button>
		<br> 
		<label>Fecha de nacimiento:</label> 
		<br>
		<button id="fechaNacimiento" name="fechaNacimiento"><jsp:getProperty property="fechaNacimiento" name="userBean"/></button>
		<br>
		<label>Fecha de inscripcion:</label> 
		<br>
		<button id="fechaInscripcion" name="fechaInscripcion"><jsp:getProperty property="fechaInscripcion" name="userBean"/></button>
	</div>
</body>
</html>