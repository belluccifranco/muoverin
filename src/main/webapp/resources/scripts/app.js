var playlist = null;

jQuery(document).on('pageinit', '#playlist-page', function(){
    //alert('yes'); 

    playlist = new PlayUIInterface('main-song-list', {
            playlistOptions: {
                autoPlay: false
            },
            swfPath: "/vinilo/resources/scripts/jplayer",
            supplied: "mp3",
            wmode: "window",
            preload:"auto",
            autoPlay: false,
            keyEnabled: true,
            errorAlerts:true,
            warningAlerts:false
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
    
    playlist.setPlaylist(list);
});