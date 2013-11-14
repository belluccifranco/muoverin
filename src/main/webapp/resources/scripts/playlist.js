soundManager.setup({
    url: '/vinilo/resources/scripts/soundmanager2/swf/',
    //flashVersion: 9,
    //debugFlash : true,
    preferFlash: false,
    onready: function() {

    },
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

        },
        init = function(options) {
            this.current = -1;
            this.options = $.extend(this.options, options);
            this.list = [];
        },
        isValidPos = function(pos) {
            return $.isNumeric(pos) && pos>=0 && pos < this.list.length;
        },
        current = function() {
            if (arguments.length > 0) {
                var pos = arguments[0];
                if (isValidPos.call(this, pos)) {
                    this.current = pos;
                }
            } else {
                return this.current;
            }
        },
        setPlaylist = function(data) {
            this.current = -1;
            this.list = $.isArray(data) ? data : [];
            if (this.list.length > 0) {
                current.call(this, 0);
            }
        },
        play = function() {

        },
        pause = function() {

        },
        stop = function() {

        },
        prev = function() {

        };
        return {
            init: init
        };
};

$(document).ready(function(){
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

});
