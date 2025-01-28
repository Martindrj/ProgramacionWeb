<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="userBean" scope="session" class="pw.display.javabean.usuarioBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<title>Inicio</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/PW-web/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
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
		  				<h1>Servicio de reservas de karts</h1>
						<a href="/PW-web/mvc/view/loginView.jsp">
							<button type="button" class="btn btn-light btn-lg">Inicia sesión</button>
						</a> 
						<a href="/PW-web/mvc/view/registroView.jsp">
							<button type="button" class="btn btn-light btn-lg">Crea una cuenta</button>
						</a>
						<fieldset>
								<br>Daniel Hinojosa Sánchez<br>
		 						Martín Del Río Jiménez<br>
		 						Juan Antonio Gálvez Jiménez<br>
								Marta Rubio Sánchez<br>
		 						Miguel Castro Martín
						</fieldset>
					</div>
				</div>
			</div>
		</div>
	<%}else {%>
		<jsp:forward page="/mvc/controller/userController.jsp"/>
<% } %>
</body>
</html>