<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>EL RINCÓN DEL CINE - Gestión</title>
    <link href="./styles/table.css" rel="stylesheet" id="bootstrap-css">
    <link href="./bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="./js/jquery-3.6.1.min.js"></script>
    <script src="./bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
 
    <script src="./js/peliculas.js"></script>
</head>    


<table border="1" background-color="white" class="table table-striped table-hover">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Género</th>
			<th>Director</th>
			<th>Reparto</th>
			<th>Fecha de estreno</th>
			<th></th>
		</tr>
	</thead>
		<tbody>
	<c:forEach begin="0" step="1" items="${ListaPeliculas}" var="item">
			<tr>
				<td>${item.getTitle_rf()}</td>
				<td>${item.getGenero()}</td>
				<td>${item.getDirector_rf()}</td>
				<td>${item.getReparto_rf()}</td>
				<td>${item.getDatepremiere_rf()}</td>
				<td><form:form> <input type="button" class="eliminar btn btn-danger" data="${item.getIdfilm_rf()}" value="Eliminar"/></form:form> </td>
			</tr>
	</c:forEach>
		</tbody>
</table>
</html>
