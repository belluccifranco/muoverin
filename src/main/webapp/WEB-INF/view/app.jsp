<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Playlist app</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css"/>
    <!--<link rel="stylesheet" href="http://www.jplayer.org/latest/skin/blue.monday/jplayer.blue.monday.css"/>-->
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
    <script src="http://www.jplayer.org/latest/js/jquery.jplayer.min.js"></script>
    <script src="/vinilo/resources/scripts/app.js"></script>
    
    <style>
        .segmented-control { text-align:center; }
        .segmented-control .ui-controlgroup { margin: 0.2em; }
        .ui-control-active, .ui-control-inactive { border-style: solid; border-color: gray; }
        .ui-control-active { background: #BBB; }
        .ui-control-inactive { background: #DDD; }

        .ui-header .ui-title, .ui-footer .ui-title { margin-right: 0 !important; margin-left: 0 !important; }
    </style>
    
    <script>
        var playlists = [];
//<![CDATA[
$(document).ready(function(){

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
        
});
//]]>


    </script>
    
</head>
<body>
<div data-role="page" id="playlists-page">
    <div data-role="header" data-position="fixed">
        <h1>Canciones</h1>
        <a href="#search-music-page" data-rel="dialog" data-icon="search" class="ui-btn-right">Buscar</a>
    </div><!-- /header -->

    <div data-role="content">
        <ul data-role="listview"  id="main-song-list">
            
        </ul>
    </div><!-- /content -->

    <div data-role="footer" data-position="fixed">
        <div id="jquery_jplayer_1" class="jp-jplayer"></div>
        <div  id="jp_container_1" class="jp-audio" style="margin: 0 auto; width: 100px; text-align: center;">
            <div class="jp-controls">
                <a href="javascript:;" class="jp-play" data-role="button" data-inline="true">play</a>
                <a href="javascript:;" class="jp-pause" data-role="button" data-inline="true">pause</a>
            </div>
        </div>
<!--        <div id="jp_container_1" class="jp-audio" style="margin: 0 auto;">
			<div class="jp-type-single">
				<div class="jp-gui jp-interface">
					<ul class="jp-controls">
						<li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
						<li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
						<li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
						<li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
						<li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
						<li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a></li>
					</ul>
                                    <div class="jp-progress">
						<div class="jp-seek-bar">
							<div class="jp-play-bar"></div>
						</div>
					</div>
					<div class="jp-volume-bar">
						<div class="jp-volume-bar-value"></div>
					</div>
					<div class="jp-time-holder">
						<div class="jp-current-time"></div>
						<div class="jp-duration"></div>

						<ul class="jp-toggles">
							<li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
							<li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
						</ul>
					</div>
				</div>
				<div class="jp-no-solution">
					<span>Update Required</span>
					To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
				</div>
			</div>
		</div>-->
    </div>
    
    <script type="text/javascript">
        (function () {
            $('#playlists-page').on("pagebeforecreate", function(){
            $.ajax({
                url: 'listaReproduccion/1',
                dataType: 'json',
                success: function(data) {
                   console.log(data);
//                   playlists = data;
//                   
//                   var list = "";
//                   for (var i=0;i< playlists.length;i++) {
//                       
//                   }
                    }
                });
            });
        })(jQuery);
    </script>
</div><!-- /page -->

<div data-role="page" id="search-music-page">
    <div data-role="header" data-theme="b">
        <h1>Buscador de temas</h1>
    </div>
    <div data-role="content" data-theme="b">
        <ul data-role="listview"  data-filter="true" data-filter-placeholder="Ingrese texto a buscar...">
            
        </ul>
    </div>
</div>

</body>
</html>
