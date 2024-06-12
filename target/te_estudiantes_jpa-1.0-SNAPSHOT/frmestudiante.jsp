<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario de Estudiante</title>
    <link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
    <h1>Registro de Estudiante</h1>
    <form action="MainController" method="post">
        <input type="hidden" name="id" value="${estudiante.id == null ? 0 : estudiante.id}" />
        
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" value="${estudiante.nombre}" required /><br />
        
        <label for="apellidos">Apellidos:</label>
        <input type="text" name="apellidos" id="apellidos" value="${estudiante.apellidos}" required /><br />
        
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="${estudiante.email}" required /><br />
        
        <label for="fechanacimiento">Fecha Nacimiento:</label>
        <input type="date" name="fechaNacimiento" id="fechanacimiento" value="${estudiante.fechaNacimiento}" required /><br />
        
        <input type="submit" value="Guardar" />
    </form>
    <a href="MainController" class="btn cancel-btn">Cancelar</a>
</body>
</html>
