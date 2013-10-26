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
        <div id="jquery_jplayer_1"></div>
        <div id="player_container">
            <a class="jp-plui-prev" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                <img alt="prev" src="/vinilo/resources/images/prev.png">
            </a>
            <a class="jp-plui-play" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                <img alt="prev" src="/vinilo/resources/images/play.png">
            </a>
            <a class="jp-plui-pause" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                <img alt="prev" src="/vinilo/resources/images/pause.png">
            </a>
            <a class="jp-plui-next" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                <img alt="prev" src="/vinilo/resources/images/next.png">
            </a>
        </div>
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
