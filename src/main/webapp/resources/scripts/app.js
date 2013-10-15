jQuery(document).ready(function(){

    /*jQuery("#jquery_jplayer_1").jPlayer({
        swfPath: "http://www.jplayer.org/latest/js/Jplayer.swf",
        supplied: "mp3",
        wmode: "window",
        preload:"auto",
        autoPlay: true,
        errorAlerts:false,
        warningAlerts:false
    });*/

    $("#jquery_jplayer_1").jPlayer({
            ready: function (event) {
                    $(this).jPlayer("setMedia", {
                            m4a:"http://www.jplayer.org/audio/m4a/TSP-01-Cro_magnon_man.m4a",
                            oga:"http://www.jplayer.org/audio/ogg/TSP-01-Cro_magnon_man.ogg"
                    });
            },
            swfPath: "js",
            supplied: "m4a, oga",
            wmode: "window",
            smoothPlayBar: true,
            keyEnabled: true,
            size: {
                width: "200px"
            }
    });

    var lista = [
            {
                    "id_cancion":1,
                    "nroOrden":1,
                    "nombre":"Rock and Roll Train",
                    "duracion":"4:21",
                    "url":"https://mega.co.nz/#!AY4EkCwL!A2GGQlFV0keoyGXHYIarFCiiuUdaIua_qsNhuBQcr68",
                    "letra":"",
                    "artista":{"id_artista":1,"nombre":"AC DC","canciones":null},
                    "album":{
                            "id_album":1,
                            "nombre":"Black Ice",
                            "anio":2008,
                            "cantCanciones":15,
                            "cuentaHosting":{
                                    "id_cuentaHosting":1,
                                    "url":"https://g.api.mega.co.nz",
                                    "usuario":"belluccifranco@gmail.com",
                                    "password":"mega01",
                                    "albumes":null
                            },
                            "canciones":null
                    }
            },
            {
                    "id_cancion":2,
                    "nroOrden":2,
                    "nombre":"Skies On Fire",
                    "duracion":"3:34",
                    "url":"https://mega.co.nz/#!wcpwzJAZ!ClvMGB-tyqCJ7RahB67ugzqDOqMcSfQ3owgabxIL1CM",
                    "letra":"",
                    "artista":{"id_artista":1,"nombre":"AC DC","canciones":null},
                    "album":{
                            "id_album":1,
                            "nombre":"Black Ice",
                            "anio":2008,
                            "cantCanciones":15,
                            "cuentaHosting":{
                                    "id_cuentaHosting":1,
                                    "url":"https://g.api.mega.co.nz",
                                    "usuario":"belluccifranco@gmail.com",
                                    "password":"mega01",
                                    "albumes":null
                            },
                            "canciones":null
                    }
            }
        ],
        listContainer = $("#main-song-list");
    
    var innerSongListMarkup = '';
    for (var i=0; i<lista.length; i++) {
        if (i == 0) {
            innerSongListMarkup += '<li class="ui-btn-active">' + lista[i].artista.nombre + ' - ' + lista[i].nombre + '</li>';
        } else {
            innerSongListMarkup += '<li>' + lista[i].artista.nombre + ' - ' + lista[i].nombre + '</li>';
        }
        
    }
    listContainer.html(innerSongListMarkup).listview("refresh");
});