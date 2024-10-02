<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EP1, Julisa Leon</title>
	</head>
	<body>
		<h1>Sistema de gestion de Sucursales</h1>
		<br>
		<form action="login" method="POST">
			<input type="hidden" name="opcionPost" value="validarUsuario">
			Correo: <input type="text" name="correo"><br><br>
			Password: <input type="password" name="password"><br><br>
			<button>Ingresar</button>
		</form>
	</body>
</html>