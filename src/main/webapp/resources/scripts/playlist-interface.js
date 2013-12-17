var PlayListUI = function(options) {
    this.init($.isPlainObject(options) ? options : {});
};

PlayListUI.prototype = function() {
    var self, options, playlistUL, current,
        playButton, pauseButton, nextButton, prevButton,
        sounds = [],
        defaults = {
            loop: true,
            ulId : 'main-play-list',
            selectLineClass: 'ui-btn-active',
            playButtonId: 'play',
            pauseButtonId: 'pause',
            nextButtonId: 'next',
            prevButtonId: 'prev',
            getLineHtml: function(obj) {
                return '<a href="#">' + obj.artista.nombre + ' - ' + obj.nombre + '</a>';
            },
            onSoundFinish: function() {
                next();
            },
            onPlay: function() {
                pauseButton.removeClass('ui-screen-hidden');
                playButton.addClass('ui-screen-hidden');
            },
            onPause: function() {
                playButton.removeClass('ui-screen-hidden');
                pauseButton.addClass('ui-screen-hidden');
            },
            onResume: function() {
                pauseButton.removeClass('ui-screen-hidden');
                playButton.addClass('ui-screen-hidden');
            }
        },
        init = function(opts){
            self = this;
            options  = $.extend(defaults, opts);
            playlistUL = $('#' + options.ulId);
            playButton = $('#' + options.playButtonId);
            pauseButton = $('#' + options.pauseButtonId);
            nextButton = $('#' + options.nextButtonId);
            prevButton = $('#' + options.prevButtonId);
            current = -1;

            bindEvents();
        },
        refreshUI = function() {
            playlistUL.listview("refresh");
        },
        clearUI = function(){
            playlistUL.html('');
        },
        getUILineByPos = function(pos) {
            return playlistUL.children('li').eq(pos);
        },
        selectLine = function(pos) {
            var line = getUILineByPos(pos);
            if (line.length > 0 && !line.hasClass(options.selectLineClass)) {
                playlistUL.children('li').removeClass(options.selectLineClass);
                line.addClass(options.selectLineClass);
            }
        },
        deleteLine = function(pos) {
            getUILineByPos(pos).remove();
        },
        clearList = function(){
            var i, length;
            for (i = 0, length = sounds.length; i<length; i += 1) {
                removeSong(i, false);
            }
            clearUI();
            refreshUI();
        },
        addSong = function(obj) {
            var sound, soundId, url;
            soundId = 's' + obj['id_cancion'];
            url = '/vinilo/reproductor/' + obj['id_cancion'];
            sound = soundManager.createSound({
                id: soundId,
                url: url,
                onfinish: options.onSoundFinish,
                onplay: options.onPlay,
                onpause: options.onPause,
                onresume: options.onResume
            });
            sounds.push(sound);
            playlistUL.append('<li id="' + soundId + '">' + options.getLineHtml(obj) + '</li>');
        },
        removeSong = function(pos, refresh) {
            refresh = refresh || true;
            if (isPlayablePos(pos)) {
                deleteLine(pos);
                getSound(pos).unload();
                sounds.splice(pos, 1);
            }
            if (refresh) {
                refreshUI();
            }
        },
        setPlaylist = function(data) {
            var i, length;
            clearList();
            for (i=0, length=data.length; i<length; i += 1) {
                addSong(data[i]);
            }
            //playlistUL.append(lis);
            refreshUI();
            if (data.length > 0) {
                current = 0;
                selectLine(current);
            }
        },
        isPlayablePos = function(pos) {
            return pos >= 0 && pos < playlistUL.children('li').length;
        },
        getSound = function(pos) {
            return sounds[pos];
        },
        doAction = function(action) {
            console.log(current, action);
            var sound;
            if (isPlayablePos(current)) {
                sound = getSound(current);
                sound[action]();
            }
        },
        play = function(pos) {
            pos = !isNaN(parseInt(pos)) ? pos : current;
            if (isPlayablePos(pos)) {
                current = pos;
                selectLine(pos);
            }
            doAction('play');
        },
        stop = function() {
            doAction('stop');
        },
        prev = function() {
            stop();
            var prevPos = current-1;
            if (current === 0) {
                prevPos = options.loop ? playlistUL.children('li').length - 1 : current;
            }
            play(prevPos);
        },
        next = function() {
            stop();
            var nextPos = current + 1;
            if (current === playlistUL.children('li').length - 1) {
                if (options.loop) {
                    nextPos = 0
                } else {
                    return;
                }
            }
            play(nextPos);
        },
        pause = function() {
            doAction('pause');
        },
        togglePause = function() {
            doAction('togglePause');
        },
        isPaused = function() {
            if (isPlayablePos(current)) {
                return getSound(current).paused;
            }
            return true;
        },
        bindEvents = function() {
            playButton.click(function(e){
                e.preventDefault();
                togglePause();
            });
            pauseButton.click(function(e){
                e.preventDefault();
                togglePause();
            });
            nextButton.click(function(e){
                e.preventDefault();
                next();
            });
            prevButton.click(function(e){
                e.preventDefault();
                prev();
            });
            playlistUL.on('click', '>li', function() {
                var index = $(this).index();
                if (index === current) {
                    if (isPaused()) {
                        togglePause();
                    }
                } else {
                    stop();
                    play(index);
                }
            });
        };
    return {
        init: init,
        clearList: clearList,
        setPlaylist: setPlaylist,
        play: play,
        pause: pause,
        stop: stop,
        prev: prev,
        next: next,
        togglePause: togglePause,
        addSong: addSong,
        removeSong: removeSong
    }
}();
