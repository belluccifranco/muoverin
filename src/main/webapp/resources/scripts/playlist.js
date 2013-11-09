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
