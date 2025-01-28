<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<fieldset>
		<legend>ERROR ${pageContext.errorData.statusCode}</legend>
		<%= exception %>
	</fieldset>
</body>
</html>