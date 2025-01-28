<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/PW-web/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<script type="text/javascript">
function mostrarContraseña(){
  var checkBox = document.getElementById('ver');
  var texto = document.getElementById('pass');
  if (checkBox.checked == true){
	texto.type = 'text';
  } else{
	texto.type = 'password';
  }
}
</script>

	<%
	String nextPage = "../../controller/userController.jsp";
	String messageNextPage = (String)request.getAttribute("message");
	if (messageNextPage == null){
		messageNextPage = (String)request.getParameter("message");
		
		if( messageNextPage == null )
			messageNextPage = "";
	}
	if (userBean == null || userBean.getCorreo().equals("") ) {
	%>
	<p><%=messageNextPage%></p>
		<div class="row justify-content-center align-items-center" style="height: 70vh">
			<div class="center">
				<div class="container bg-dark text-white text-center">
					<div class="card-body">
  						<h1>Iniciar sesión</h1>
						<form id="form" method="post" action="/PW-web/mvc/controller/loginController.jsp">
							<label for="email">Correo electrónico</label>
							<input type="email" name=correo id="correo" placeholder="ejemplo@email.com" required>
							<small id="emailHelp" class="form-text text-muted">Nunca compartiremos tu correo a terceros.</small>
							<br>
							<label for="password">Contraseña</label>
							<input type="password" name=pass id="pass" placeholder="password" required>
							<br>
							<input type="checkbox" id="ver" onclick="mostrarContraseña()">
							<label for="mostrarContraseña">Mostrar contraseña</label>
							<br><br>
							<input type="reset" class="btn btn-light btn-lg" value="Borrar"/>
							<input type="submit" class="btn btn-light btn-lg" value="Acceder"/>
						</form>
						<form method="post" action="/PW-web">
							<br>
							<input type="submit" class="btn btn-light btn-lg" value="Volver">
						</form>
					</div>
				</div>
			</div>
		</div>
	<%}else {%>
		<jsp:forward page="/mvc/controller/userController.jsp"/>
<% } %>
</body>
</html>