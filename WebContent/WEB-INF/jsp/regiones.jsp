<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Información de regiones</title>
</head>
<body>
<table border=1>
	<thead><tr>
		<th>ID</th>
		<th>Número</th>
		<th>Nombre</th>
		<th>Capital</th>
	</tr></thead>
	<c:forEach var="region" items="${regiones.regiones}">
		<tr>
			<td>${region.id}</td>
			<td>${region.numero}</td>
			<td>${region.nombre}</td>
			<td>${region.capital}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
