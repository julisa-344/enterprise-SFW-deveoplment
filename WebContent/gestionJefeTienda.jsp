<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Jefe de tienda</title>
</head>
<body>
    <h1>Gestión de Jefe de tienda</h1>
    <form action="jefeTienda" method="get">
        <input type="text" name="apellidoPaterno" placeholder="apellidoPaterno">
        <input type="text" name="apellidoMaterno" placeholder="apellidoMaterno">
        <input type="hidden" name="action" value="buscar">
        <button type="submit">Buscar</button>
    </form>
    <c:out value="${fn:length(listaJefeTienda)}"/> Jefes de tienda encontrados
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>apellido Paterno</th>
            <th>apellido Materno</th>
            <th>DNI</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="jefeTienda" items="${listaJefeTienda}">
            <tr>
                <td>${jefeTienda.codigo}</td>
                <td>${jefeTienda.nombre}</td>
                <td>${jefeTienda.apellidoPaterno}</td>
                <td>${jefeTienda.apellidoMaterno}</td>
                <td>${jefeTienda.dni}</td>
                <td>
                    <a href="jefeTienda?action=editar&codigo=${jefeTienda.codigo}">Editar</a>
                    <a href="jefeTienda?action=eliminar&codigo=${jefeTienda.codigo}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="jefeTienda?action=nuevo">Nuevo</a>
</body>
</html>