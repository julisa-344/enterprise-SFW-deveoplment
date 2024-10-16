<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editar Jefe de tienda</title>
	</head>
	<body>
		<h1>Editar Jefe de tienda</h1>
		<br>
		<br>
		<c:if test= "${mensaje!=null}">
			<div>${mensaje}</div>
		</c:if>
		<form action="jefeTienda" method="POST">
			<input type="hidden" name="action" value="actualizar">
			<input type="hidden" name="codigo" value="${jefeTienda.codigo}"><br><br> 
			<!-- Line above is quite insecure as the ID can be changed to any one and the user perform updates to others buuut well -->
			Nombre: <input type="text" name="nombre" value="${jefeTienda.nombre}"><br><br>
			Apellido Paterno: <input type="text" name="apellidoPaterno" value="${jefeTienda.apellidoPaterno}"><br><br>
            Apellido Materno: <input type="text" name="apellidoMaterno" value="${jefeTienda.apellidoMaterno}"><br><br>
            DNI: <input type="text" name="dni" value="${jefeTienda.dni}"><br><br>
			<button>Grabar</button>
		</form>
	</body>
</html>