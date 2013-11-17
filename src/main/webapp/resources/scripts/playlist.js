soundManager.setup({
    url: '/vinilo/resources/scripts/soundmanager2/swf/',
    //flashVersion: 9,
    //debugFlash : true,
    preferFlash: false,
    ontimeout: function() {
        console.error('No se pudo iniciar SoundManager2');
    }
});

var SM2Playlist = function(options) {
    options = $.isPlainObject(options) ? options : {};
    this.init(options);
};

SM2Playlist.prototype = function() {
    var defaults = {
            loop: false
        },
        init = function(options) {
            this.current = -1;
            this.options = $.extend(this.options, options);
            this.list = [];
        },
        isValidPos = function(pos) {
            return $.isNumeric(pos) && pos>=0 && pos < this.list.length;
        },
        setCurrent = function(pos) {
            if (isValidPos.call(this, pos)) {
                this.current = pos;
            }
        },
        getCurrent = function() {
            return this.current;
        },
        setPlaylist = function(data) {
            this.current = -1;
            this.list = $.isArray(data) ? data : [];
            if (this.list.length > 0) {
                setCurrent.call(this, 0);
            }
        },
        play = function(pos) {
            pos = isValidPos.call(this, pos) ? pos : this.current;
            if (pos > -1) {
                setCurrent.call(this, pos);
                this.list[getCurrent.call(this)]['sound'].play();
            }
        },
        pause = function() {
            this.list[getCurrent.call(this)]['sound'].pause();
        },
        togglePause = function() {
            console.log(this.list[getCurrent.call(this)]);
            this.list[getCurrent.call(this)]['sound'].togglePause();
        },
        stop = function() {
            this.list[getCurrent.call(this)]['sound'].stop();
        },
        prev = function() {
            var cur = getCurrent.call(this);
            if (this.options.loop || cur > 0) {
                var toGo = cur > 0 ?  cur - 1 : this.list.length - 1;
                stop.call(this);
                play.call(this, toGo);
            }
        },
        next = function() {
            var cur = getCurrent.call(this);
            console.log(this.options.loop, cur);
            if (this.options.loop || cur < this.list.length-1) {
                var toGo = cur < this.list.length-1 ?  cur + 1 : 0;
                stop.call(this);
                play.call(this, toGo);
            }
        },
        isPaused = function() {
            return this.list[getCurrent.call(this)]['sound'].paused;
        };
        return {
            init: init,
            setPlaylist: setPlaylist,
            play: play,
            pause: pause,
            togglePause: togglePause,
            stop: stop,
            prev: prev,
            next: next,
            isPaused: isPaused,
            getCurrent: getCurrent
        };
}();

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

/*$(document).ready(function(){
    var list = [],
        current = -1;

    soundManager.setup({
        url: '/vinilo/resources/scripts/soundmanager2/swf/',
        //flashVersion: 9,
        //debugFlash : true,
        preferFlash: false,
        onready: function() {
            list = (function(){
                var res = [];
                for(var i=1; i<5; i++) {
                    var s = soundManager.createSound({
                        id: i + '',
                        url: '/vinilo/reproductor/' + i
                    });
                    res.push({
                        id: i,
                        url: '/vinilo/reproductor/' + i,
                        sound: s
                    });
                }
                return res;
            })();

            if (list.length > 0) {
                current = 0;
            }
        },
        ontimeout: function() {
            console.error('No se pudo iniciar SoundManager2');
        }
    });

    function currentInArray() {
        return current >=0 && current < list.length;
    }

    function stopCurrent() {
        list[current]['sound'].stop();
        //list[current]['sound'].unload();
        //list[current]['sound'].setPosition(0);
    }

    function playCurrent() {
        console.log(current);
        if (!currentInArray()) { return; }
        //list[current]['sound'].setPosition(0);
        list[current]['sound'].play();
    }

    $('.play').on('click', function(){
        if (!currentInArray()) { return; }
        //playCurrent();
        list[current]['sound'].togglePause();
        if (list[current]['sound'].paused) {
            $(this).html('||')
        } else {
            $(this).html('&gt;')
        }
    });
    $('.next').on('click', function(){
        stopCurrent();
        current = current < list.length - 1 ? current + 1 : 0;
        playCurrent();
    });
    $('.prev').on('click', function(){
        stopCurrent();
        current = current > 0 ? current - 1 : list.length - 1;
        playCurrent();
    });

});*/
