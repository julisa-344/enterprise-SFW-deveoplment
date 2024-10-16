<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editar Usuario</title>
	</head>
	<body>
		<h1>Editar Usuario</h1>
		<br>
		<br>
		<c:if test= "${mensaje!=null}">
			<div>${mensaje}</div>
		</c:if>
		<form action="usuario" method="POST">
			<input type="hidden" name="opcionPost" value="actualizar">
			Correo: <input type="text" name="correo" value="${usuario.correo}"><br><br>
			Password: <input type="password" name="password" value="${usuario.password}"><br><br>
			Nombre: <input type="text" name="nombre" value="${usuario.nombre}"><br><br>
			Apellido Paterno: <input type="text" name="apellidoPaterno" value="${usuario.apellidoPaterno}"><br><br>
			<button>Grabar</button>
		</form>
	</body>
</html>