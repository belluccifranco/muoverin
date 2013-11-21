<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sound Manager 2 Test</title>
</head>
<body>
    <div id="controls">
        <button class="prev">&lt;&lt;</button>
        <button class="play">&gt;</button>
        <button class="next">&gt;&gt;</button>
    </div>
    <script type="text/javascript" src="/vinilo/resources/scripts/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="/vinilo/resources/scripts/soundmanager2/soundmanager2-jsmin.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var playlist = new SM2Playlist({ loop: true });

            soundManager.onready(function(){
                var list = function(){
                    var res = [];
                    for(var i=1; i<5; i++) {
                        var s = soundManager.createSound({
                            id: 's' + i,
                            url: '/vinilo/reproductor/' + i
                        });
                        res.push({
                            id: i,
                            url: '/vinilo/reproductor/' + i,
                            sound: s
                        });
                    }
                    return res;
                }();
                playlist.setPlaylist(list);
            });

            $('.play').on('click', function(){
                playlist.togglePause();
                if (playlist.isPaused()) {
                    $(this).html('||')
                } else {
                    $(this).html('&gt;')
                }
            });

            $('.next').on('click', function(){
                playlist.next();
            });
            $('.prev').on('click', function(){
                playlist.prev();
            });
        });
    </script>
</body>
</html>