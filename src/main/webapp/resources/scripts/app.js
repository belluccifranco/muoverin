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
    playlist.loop = true;
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
});

jQuery(document).on('pageinit', '#search-music-page', function(){
    var $this = $(this),
        $searchInput = $this.find("#song-search-input"),
        $searchBtn   = $this.find("#song-search-button"),
        $searchList  = $this.find("#song-search-list");
        
   $searchBtn.click(function(e){
      e.preventDefault();
      
      var criteria = $searchInput.val();
      var indice = 0;
      
      if ($.trim(criteria) === '') {
          return;
      }
      
      $.ajax({
	url: '/vinilo/canciones?criteria=' + encodeURIComponent(criteria) + '&indice=' + indice,
	type: 'get',
	dataType: 'json',
	success: function(data) {
            var lis = '';
            $.each(data, function(i, v){ 
                lis += '<li><a href="#">' + v.artista.nombre + ' - ' + v.nombre + '</a></li>';
            });
            
            $searchList.html(lis).listview("refresh");
	}
      });
   });
   
   $searchInput.keyup(function(e){
       var code = e.keyCode || e.which;
       if(code == 13) {
           $searchBtn.click();
       } 
   });
});

jQuery(document).on('pageshow', '#search-music-page', function(){
    var $searchInput = $(this).find("#song-search-input");
    $searchInput.focus();
});
