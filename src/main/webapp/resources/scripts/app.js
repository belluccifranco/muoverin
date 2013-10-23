var playlist = null;

jQuery(document).on('pageinit', '#playlist-page', function(){
    playlist = new PlayListUI('main-song-list', 'jquery_jplayer_1' , {
            swfPath: "/vinilo/resources/scripts/jplayer",
            supplied: "mp3",
            wmode: "window",
            autoPlay: false,
            preload: "auto",
            keyEnabled: true,
            errorAlerts: true,
            warningAlerts: false
        });
        
        var list = [
            {"id_cancion":1,"nroOrden":1,"nombre":"Highway to Hell","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":2,"nroOrden":2,"nombre":"Girls Got Rhythm","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":3,"nroOrden":3,"nombre":"Walk All Over You","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":4,"nroOrden":4,"nombre":"Touch Too Much","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":5,"nroOrden":5,"nombre":"Beating Around The Bush","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":6,"nroOrden":6,"nombre":"Shot Down in Flames","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":7,"nroOrden":7,"nombre":"Get it Hot","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":8,"nroOrden":8,"nombre":"If You Want Blood (You ve Got It)","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":9,"nroOrden":9,"nombre":"Love Hungry Man","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null},
            {"id_cancion":10,"nroOrden":10,"nombre":"Night Prowler","duracion":"","letra":"","artista":{"id_artista":1,"nombre":"AC DC","canciones":null},"album":{"id_album":1,"nombre":"Highway to Hell","anio":1979,"cantCanciones":10,"canciones":null},"links":null,"listasReproduccion":null}
        ];
    
        $('<button >Set Playlist</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
            playlist.setPlaylist(list);
        });
        
        $('<button >Play</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
            playlist.play();
        });
        
        $('<button >Pause</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
            playlist.pause();
        });
        
        $('<button >Stop</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
            playlist.stop();
        });
        
        $('<button >Prev</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
            playlist.prev();
        });
        
        $('<button >Next</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
            playlist.next();
        });
    
    //playlist.play(0);
    
    /*playlist = new PlayUIInterface('main-song-list', {
            playlistOptions: {
                autoPlay: false
            },
            swfPath: "/vinilo/resources/scripts/jplayer",
            supplied: "mp3",
            wmode: "window",
            autoPlay: false,
            preload: "auto",
            keyEnabled: true,
            errorAlerts: false,
            warningAlerts: false
        });

    var list = [
            {
                title: "Rock and Roll Train",
                artist: "AC DC",
                mp3: 'http://' + window.location.host +"/vinilo/reproductor/1"
            },
            {
                title: "Skies On Fire",
                artist: "AC DC",
                mp3: 'http://' + window.location.host +"/vinilo/reproductor/2"
            }
        ];
    
    playlist.setPlaylist(list);*/
});