$(document).ready(function() {
    $('#btn_buscar').click(function() {
        $.getJSON('listaReproduccion/1', function(listaReproduccion) {
            $('#respuesta').text(listaReproduccion.nombre);
        });
    });
});