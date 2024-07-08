<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="LoginServlet" method="post">
    <label for="nombreUsuario">Nombre de Usuario:</label>
    <input type="text" id="nombreUsuario" name="nombreUsuario" required><br><br>
    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>
<c:if test="${param.error != null}">
    <p style="color: red;">${param.error}</p>
</c:if>
</body>
</html>