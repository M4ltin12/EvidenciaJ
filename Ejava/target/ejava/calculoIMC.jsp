<!DOCTYPE html>
<html>
<head>
    <title>Calculo de IMC</title>
</head>
<body>
<h2>Calculo de IMC</h2>
<form action="CalculoIMCServlet" method="post">
    <label for="peso">Peso (en kg):</label>
    <input type="number" step="0.1" id="peso" name="peso" required><br><br>
    <input type="submit" value="Calcular IMC">
</form>
<c:if test="${param.error != null}">
    <p style="color: red;">${param.error}</p>
</c:if>
</body>
</html>
