var PlayListUI = function(uiListId, jplayerId, jplayerOptions) {
    this.uiList = $('#' + uiListId);
    this.player = $('#' + jplayerId).jPlayer(jplayerOptions);
    this.loop = false;
    this.init();
};

PlayListUI.prototype = function() {
    var init = function() {
            this.list = [];
            this.current = -1;
            bindEvents.call(this);
        },
        getUrlObject = function(obj) {
            return { mp3: 'http://' + document.location.host + '/vinilo/reproductor/' + obj.id_cancion }
        },
        play = function(pos) {
            if (this.list.length <= 0) { return; };    
            pos = parseInt(pos);
            if (!isNaN(pos)){
                if (pos < 0) {
                    pos = 0;
                } else if (pos >= this.list.length) {
                    pos = this.list.length - 1;
                }
                this.current = pos;
                this.player.jPlayer('stop');
                this.player.jPlayer('setMedia', getUrlObject.call(this, this.list[this.current]));
            }
            this.player.jPlayer('play');
            selectCurrentUI.call(this);
        },
        pause = function(){
            this.player.jPlayer('pause');
        },
        next = function(){
            if (this.current < this.list.length - 1){
                this.current++;
                play.call(this, this.current);
            } else {
                if (this.loop) {
                    this.current = 0;
                    play.call(this, this.current);
                }
            }
        },
        prev = function(){
            if (this.current > 0) {
                this.current--;
                play.call(this, this.current);
            } else {
                if (this.loop) {
                    this.current = this.list.length - 1;
                    play.call(this, this.current);
                }
            }
        }
        stop = function() {
            this.player.jPlayer('stop');
        },
        setPlaylist = function(list) {
            this.current = -1;
            this.list = list;
            if (this.list.length > 0) {
                this.current = 0;
                var media = getUrlObject.call(this, this.list[this.current]);
                this.player.jPlayer('setMedia', media);
                this.player.jPlayer('load');
                updateUI.call(this);
            }
        },
        clearUI = function(){
            this.uiList.html('');
        },
        refreshUI = function() {
            this.uiList.listview("refresh");
        },
        updateUI = function() {
            clearUI.call(this);
            var lis = '';
            for (var i=0; i<this.list.length; i++) {
                lis += '<li><a href="#" class="song">' + this.list[i].artista.nombre + ' - ' + this.list[i].nombre + '</a></li>'
            }
            this.uiList.html(lis);
            refreshUI.call(this);
            selectCurrentUI.call(this);
        },
        selectCurrentUI = function(){
            if (this.current >= 0 && this.current < this.list.length) {
                this.uiList.children('li').removeClass("ui-btn-active").eq(this.current).addClass("ui-btn-active");
            }
        },
        bindEvents = function(){
            var self = this,
                ul = this.uiList;
            ul.on("click", "a.song", function(){
                var index = ul.find("a.song").index($(this));
                self.play(index);
            });
            self.player.on($.jPlayer.event.ended, function(){
                self.next();
            });
        };
    return {
        init: init,
        play: play,
        pause: pause,
        stop: stop,
        setPlaylist: setPlaylist,
        prev: prev,
        next: next
    };
}();
