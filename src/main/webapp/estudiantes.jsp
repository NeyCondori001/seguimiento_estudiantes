<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Estudiantes</title>
    <link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
    <h1>Lista de Estudiantes</h1>
    <a href="MainController?action=nuevo" class="btn-nuv">Nuevo registro de estudiante</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Email</th>
            <th>Fecha Nacimiento</th>
            <th colspan="2">Acciones</th>
        </tr>
        
        <c:forEach var="estudiante" items="${estudiantes}">
            <tr>
                <td>${estudiante.id}</td>
                <td>${estudiante.nombre}</td>
                <td>${estudiante.apellidos}</td>
                <td>${estudiante.email}</td>
                <td>${estudiante.fechaNacimiento}</td>
                <td><a href="MainController?action=editar&id=${estudiante.id}">Editar</a></td>
                <td><a href="MainController?action=eliminar&id=${estudiante.id}" onclick="return confirm('¿Está seguro?');">Eliminar</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
