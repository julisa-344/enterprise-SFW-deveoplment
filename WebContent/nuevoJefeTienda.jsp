<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nuevo jefe de tienda</title>
	</head>
	<body>
		<h1>Nuevo jefe de tienda</h1>
		<br>
		<br>
		<c:if test= "${mensaje!=null}">
			<div>${mensaje}</div>
		</c:if>
		<form action="jefeTienda" method="POST">
			<input type="hidden" name="action" value="registrar">
			Nombre: <input type="text" name="nombre"><br><br>
			Apellido Paterno: <input type="text" name="apellidoPaterno"><br><br>
            Apellido Materno: <input type="text" name="apellidoMaterno"><br><br>
            Dni: <input type="text" name="dni"><br><br>
			<button>Grabar</button>
		</form>
	</body>
</html>