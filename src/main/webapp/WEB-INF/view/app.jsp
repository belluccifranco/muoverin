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
    <script src="/vinilo/resources/scripts/jplayer/jquery.jplayer.min.js"></script>
    <script src="/vinilo/resources/scripts/jplayer/add-on/jplayer.playlist.min.js"></script>
    <script src="/vinilo/resources/scripts/playlist-interface.js"></script>
    <script src="/vinilo/resources/scripts/app.js"></script>
</head>
<body>
<div data-role="page" id="playlist-page">
    <div data-role="header" data-position="fixed">
        <h1>Canciones</h1>
        <a href="#search-music-page" data-rel="dialog" data-icon="search" data-iconpos="notext" class="ui-btn-right">Buscar</a>
    </div><!-- /header -->

    <div data-role="content">
        <ul data-role="listview" id="main-song-list">
            
        </ul>
    </div><!-- /content -->

    <div data-role="footer" data-position="fixed">
        <div id="jquery_jplayer_1" class="jp-jplayer"></div>
        <div id="jp_container_1" class="jp-audio" style="margin: 0 auto; text-align: center;">
            <div class="jp-controls">
                <a href="javascript:;" class="jp_prev" data-role="button" data-inline="true" data-theme="b" data-mini="true">
                    <img alt="play" src="/vinilo/resources/images/prev.png">
                </a>
                <a href="javascript:;" class="jp-play" data-role="button" data-inline="true" data-theme="b" data-mini="true">
                    <img alt="play" src="/vinilo/resources/images/play.png">
                </a>
                <a href="javascript:;" class="jp-pause" data-role="button" data-inline="true" data-theme="b" data-mini="true">
                    <img alt="play" src="/vinilo/resources/images/pause.png">
                </a>
                <a href="javascript:;" class="jp_next" data-role="button" data-inline="true" data-theme="b" data-mini="true">
                    <img alt="play" src="/vinilo/resources/images/next.png">
                </a>
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
