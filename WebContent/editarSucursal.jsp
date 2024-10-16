<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Sucursal</title>
</head>
<body>
    <h1>Editar Sucursal</h1>
    <form action="sucursal?action=editar" method="post">
        <input type="hidden" name="codigo" value="${sucursal.codigo}">
        <input type="text" name="nombre" value="${sucursal.nombre}" placeholder="Nombre">
        <input type="text" name="direccion" value="${sucursal.direccion}" placeholder="Dirección">
        <input type="text" name="estado" value="${sucursal.estado}" placeholder="Estado">
        <button type="submit">Actualizar</button>
    </form>
</body>
</html>