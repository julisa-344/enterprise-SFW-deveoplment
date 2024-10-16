<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registrar Usuario</title>
</head>
<body>
    <h1>Registrar Usuario</h1>
    <c:if test="${not empty mensaje}">
        <div>${mensaje}</div>
    </c:if>
    <form action="usuario" method="POST">
        <input type="hidden" name="opcionPost" value="registrar">
        Correo: <input type="text" name="correo"><br><br>
        Password: <input type="password" name="password"><br><br>
        Nombre: <input type="text" name="nombre"><br><br>
        Apellido Paterno: <input type="text" name="apellidoPaterno"><br><br>
        <button>Registrar</button>
    </form>
</body>
</html>