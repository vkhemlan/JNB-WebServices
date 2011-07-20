<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Información de usuario</title>
</head>
<body>
<table border=1>
	<thead><tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Apellido paterno</th>
		<th>Apellido Materno</th>
		<th>RUT</th>
		<th>Digito verificador</th>
		<th>Dirección</th>
		<th>Teléfono</th>
		<th>Teléfono Celular</th>
		<th>Ocupación</th>
		<th>Teléfono laboral</th>
		<th>Dirección laboral</th>
		<th>Genero</th>
	</tr></thead>
	<tr>
		<td>${usuario.id}</td>
		<td>${usuario.nombre}</td>
		<td>${usuario.apellidoPaterno}</td>
		<td>${usuario.apellidoMaterno}</td>
		<td>${usuario.rut}</td>
		<td>${usuario.digitoVerificador}</td>
		<td>${usuario.direccion}</td>
		<td>${usuario.telefono}</td>
		<td>${usuario.telefonoCelular}</td>
		<td>${usuario.ocupacion}</td>
		<td>${usuario.telefonoLaboral}</td>
		<td>${usuario.direccionLaboral}</td>
		<td>${usuario.genero}</td>
	</tr>
</table>
</body>
</html>
