<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Sucursales</title>
</head>
<body>
    <h1>Gestión de Sucursales</h1>
    <form action="sucursal" method="get">
        <input type="text" name="nombre" placeholder="Buscar por nombre">
        <input type="hidden" name="action" value="buscar">
        <button type="submit">Buscar</button>
    </form>
    <c:out value="${fn:length(listaSucursales)}"/> sucursales encontradas
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="sucursal" items="${listaSucursales}">
            <tr>
                <td>${sucursal.codigo}</td>
                <td>${sucursal.nombre}</td>
                <td>${sucursal.direccion}</td>
                <td>${sucursal.estado}</td>
                <td>
                    <a href="sucursal?action=editar&codigo=${sucursal.codigo}">Editar</a>
                    <a href="sucursal?action=eliminar&codigo=${sucursal.codigo}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="sucursal?action=nuevo">Nueva Sucursal</a>
</body>
</html>