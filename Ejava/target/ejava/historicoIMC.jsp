<!DOCTYPE html>
<html>
<head>
    <title>Historico de IMC</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>Histórico de IMC</h2>
<table border="1">
    <thead>
    <tr>
        <th>Fecha</th>
        <th>IMC</th>
    </tr>
    </thead>
    <tbody id="historicoIMC">
    </tbody>
</table>

<script>
    $(document).ready(function() {
        $.ajax({
            url: 'IMCHistoricoServlet',
            method: 'GET',
            success: function(data) {
                data.forEach(function(record) {
                    $('#historicoIMC').append('<tr><td>' + record.fecha + '</td><td>' + record.imc + '</td></tr>');
                });
            }
        });
    });
</script>
</body>
</html>
