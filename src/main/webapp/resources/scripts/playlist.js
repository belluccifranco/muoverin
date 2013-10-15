var Playlist = function(listId, playerId) {
    this.player = $('#' + playerId);
    this.uiList = $('#' + listId);
    this.list = [];
    this.current = -1;
    this.init();
};

Playlist.prototype = function() {
    var playPos = function(pos) {

        },
        prev = function() {
            if (this.current > 0) {
                this.current--;
                playPos.call(this, this.current);
            }
        },        
        setList = function(list) {
            this.list = list;
            
            var lista = this.list;
            
            var innerSongListMarkup = '';
            
            this.current = -1;
            
            if (list.length > 0) {
                this.current = 0;
                for (var i=0; i<this.list.length; i++) {
                    if (i === this.current) {
                        innerSongListMarkup += '<li class="ui-btn-active">' + lista[i].artista.nombre + ' - ' + lista[i].nombre + '</li>';
                    } else {
                        innerSongListMarkup += '<li>' + lista[i].artista.nombre + ' - ' + lista[i].nombre + '</li>';
                    }

                }
            }
            
            this.uiList.html(innerSongListMarkup).listview("refresh");
            
        },
        init = function() {
            /*this.player.jPlayer({
                swfPath: "http://www.jplayer.org/latest/js/Jplayer.swf",
                supplied: "mp3",
                wmode: "window",
                preload:"auto",
                autoPlay: true,
                errorAlerts:false,
                warningAlerts:false
            });*/
            this.player.jPlayer({
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
        },
        bindEvents = function() {

        };
    return {
        init: init,
        setList: setList
    };
}();


