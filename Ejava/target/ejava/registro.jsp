<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
</head>
<body>
<h2>Registro</h2>
<form action="RegistroServlet" method="post">
    <label for="nombreCompleto">Nombre Completo:</label>
    <input type="text" id="nombreCompleto" name="nombreCompleto" required><br><br>
    <label for="nombreUsuario">Nombre de Usuario:</label>
    <input type="text" id="nombreUsuario" name="nombreUsuario" required><br><br>
    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="edad">Edad:</label>
    <input type="number" id="edad" name="edad" required><br><br>
    <label for="sexo">Sexo:</label>
    <select id="sexo" name="sexo" required>
        <option value="M">Masculino</option>
        <option value="F">Femenino</option>
    </select><br><br>
    <label for="estatura">Estatura (en metros):</label>
    <input type="number" step="0.01" id="estatura" name="estatura" required><br><br>
    <input type="submit" value="Registrar">
</form>
<c:if test="${param.error != null}">
    <p style="color: red;">${param.error}</p>
</c:if>
</body>
</html>
