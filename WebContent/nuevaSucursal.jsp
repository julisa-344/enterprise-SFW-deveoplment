<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nueva Sucursal</title>
</head>
<body>
    <h1>Nueva Sucursal</h1>
    <form action="sucursal?action=crear" method="post">
        <input type="text" name="nombre" placeholder="Nombre">
        <input type="text" name="direccion" placeholder="Dirección">
        <input type="text" name="estado" placeholder="Estado">
        <button type="submit">Grabar</button>
    </form>
</body>
</html>