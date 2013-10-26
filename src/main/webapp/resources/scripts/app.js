var playlist = null;

jQuery(document).on('pagebeforecreate', '#playlist-page', function(){
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
});

jQuery(document).on('pageinit', '#playlist-page', function(){
        var $prev = $('#player_container .jp-plui-prev'),
            $play = $('#player_container .jp-plui-play'),
            $pause = $('#player_container .jp-plui-pause'),
            $next = $('#player_container .jp-plui-next');

        $pause.hide();

        function playPauseToggle() {
            $play.toggle();
            $pause.toggle();
        }

        $prev.click(function(){
            playlist.prev();
            if ($pause.is(':hidden')) {
                playPauseToggle();
            }
        });
        
        $play.click(function(){
            playlist.play();
            playPauseToggle();
        });
        
        $pause.click(function(){
            playlist.pause();
            playPauseToggle();
        });
        
        $next.click(function(){
            playlist.next();
            if ($pause.is(':hidden')) {
                playPauseToggle();
            }
        });
    
        $.ajax({
            url: "/vinilo/canciones",
            type: "get",
            dataType: "json",
            success: function(data){
                playlist.setPlaylist(data);
            }
        });
        
        /*$('<button >Set Playlist</button>').appendTo('#playlist-page div[data-role="footer"]').click(function(){
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
        });*/
});