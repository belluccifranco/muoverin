var Playlist = function(listId, playerId) {
    this.player = $('#' + playerId);
    this.uiList = $('#' + listId);
    this.list = [];
    this.current = -1;
    this.init();
};

Playlist.prototype = function() {
    var baseUrl = 'http://' + window.location.host +"/vinilo/reproductor",
        playPos = function(pos) {
            if (pos >=0 && pos < this.list.length) {
                var url = baseUrl + "/" + this.list[pos].id_cancion;
                console.log(this.player);
                this.player.jPlayer("setMedia", {
                    mp3: url
                });
                this.player.jPlayer("play");
            }
        },
        play = function() {
            playPos.call(this, this.current);
        },
        prev = function() {
            if (this.current > 0) {
                this.current--;
                playPos.call(this, this.current);
            }
        },
        next = function() {
            if (this.current < this.list.length-1) {
                this.current++;
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
                        innerSongListMarkup += '<li class="ui-btn-active"><a href="#">' + lista[i].artista.nombre + ' - ' + lista[i].nombre + '</a></li>';
                    } else {
                        innerSongListMarkup += '<li><a href="#">' + lista[i].artista.nombre + ' - ' + lista[i].nombre + '</a></li>';
                    }

                }
            }
            
            this.uiList.html(innerSongListMarkup).listview("refresh");
            
        },
        init = function() {
            this.player.jPlayer({
                swfPath: "http://www.jplayer.org/2.4.0/js",
                supplied: "mp3",
                wmode: "window",
                preload:"auto",
                autoPlay: false,
                errorAlerts:true,
                warningAlerts:false
            });
            
            
            /*this.player.jPlayer({
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
            });*/
        },
        bindEvents = function() {
            
        };
    return {
        init: init,
        setList: setList,
        prev: prev,
        next: next,
        play: play
    };
}();


