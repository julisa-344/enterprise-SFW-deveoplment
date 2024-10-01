<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestión de Usuarios</h1><br><br>
	<form action="usuario" method="GET">
		<input type="hidden" name="opcionGet" value="buscarUsuario">
		Correo: <input type="text" name="correo">
		<button>Buscar</button>
	</form>
	<br>
	<br>
	<c:if test= "${mensaje!=null}">
		<div>${mensaje}</div>
	</c:if>	
	<table>
		<tr>
			<td>Cod.Usuario</td>
			<td>Correo</td>
			<td>Estado</td>
			<td>Acciones</td>
		</tr>
		<c:forEach var="usuario" items="${listaUsuario}">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.correo}</td>
				<td>${usuario.estado}</td>
				<td><a href="usuario?opcionGet=editar&id=${usuario.id}">Editar</a> 
				    <a href="usuario?opcionGet=eliminar&id=${usuario.id}">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="usuario" method="POST">
		<input type="hidden" name="opcionPost" value="nuevoUsuario">
		<button>Nuevo</button>
	</form>
</body>
</html>