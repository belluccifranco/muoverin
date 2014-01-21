var PlayListUI2 = function(options) {
    this.init($.isPlainObject(options) ? options : {});
}

PlayListUI2.prototype = function(){
    var options, playlistUL, current, playButton,
        pauseButton, nextButton, prevButton, sounds = {},
        defaults = {
            loop: false,
            ulId: 'main-play-list',
            selectLineClass: 'ui-btn-active',
            playButtonId: 'play',
            pauseButtonId: 'pause',
            nextButtonId: 'next',
            prevButtonId: 'prev',
            getLineHtml: function(obj) {
                return '<a href="#">' + obj.artist.name + ' - ' + obj.name + '</a>';
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
        soundsLength = function(){
            var count = 0, k;
            for (k in sounds) {
                if (sounds.hasOwnProperty(k)) {
                    count += 1;
                }
            }
            return count;
        },
        init = function(opts) {
            options = $.extend(defaults, opts);
            playlistUL = $('#' + options.ulId);
            playButton = $('#' + options.playButtonId);
            pauseButton = $('#' + options.pauseButtonId);
            nextButton = $('#' + options.nextButtonId);
            prevButton = $('#' + options.prevButtonId);
            current = '';

            bindEvents();
        },
        isUndefined = function(variable) {
            return typeof variable === 'undefined';
        },
        refreshUI = function() {
            playlistUL.listview("refresh");
        },
        clearUI = function() {
            playlistUL.html('');
        },
        getUILineById = function(id) {
            return playlistUL.children('li#' + id);
        },
        selectLine = function(id) {
            var line = getUILineById(id);
            if (line.length > 0 && !line.hasClass(options.selectLineClass)) {
                playlistUL.children('li').removeClass(options.selectLineClass);
                line.addClass(options.selectLineClass);
            }
        },
        destructSound = function(id) {
            var sound = getSound(id);
            if (sound !== null) {
                sound.destruct();
            }
            delete sounds[id];
        },
        clearList = function() {
            var id;
            for (id in sounds) {
                destructSound(id);
            }
            clearUI();
            refreshUI();
        },
        addSound = function(obj, refresh) {
            var sound, id, url;
            refresh = isUndefined(refresh) ? true : refresh;
            id = 's' + obj['id_song'];
            url = '/vinilo/player/' + obj['id_song'];
            sound = soundManager.createSound({
                id: id,
                url: url,
                onfinish: options.onSoundFinish,
                onplay: options.onPlay,
                onpause: options.onPause,
                onresume: options.onResume
            });
            sounds[id] = sound;
            playlistUL.append('<li id="' + id + '">' + options.getLineHtml(obj) + '</li>');
            if (refresh) {
                refreshUI();
            }
        },
        removeSound = function(id, refresh) {
            refresh = isUndefined(refresh) ? true : refresh;
            if (isPlayableId(id)) {
                getUILineById(id).remove();
                destructSound(id);
            }
            if (refresh) {
                refreshUI();
            }
        },
        setPlaylist = function(data) {
            var i, length;
            clearList();
            for (i = 0, length = data.length; i < length; i += 1) {
                addSound(data[i], false);
            }
            refreshUI();
            if (data.length > 0) {
                current = playlistUL.children('li').first().attr('id');
                selectLine(current);
            }
        },
        isPlayableId = function(id) {
            return !isUndefined(sounds[id]);
        },
        getSound = function(id) {
            return sounds[id].sound || null;
        },
        doAction = function(action) {
            var sound;
            if (isPlayableId(current)) {
                sound = getSound(current);
                sound[action]();
            }
        },
        play = function(id) {
            if (isPlayableId(id)) {
                current = id;
                selectLine(id);
            } else {
                if (soundsLength() > 0) {
                    current = 0;
                } else {
                    return;
                }
            }
            doAction('play');
        },
        stop = function() {
            doAction('stop');
        },
        getFistId = function() {
            return playlistUL.children('li').first().attr('id') || '';
        },
        getLastId = function() {
            return playlistUL.children('li').last().attr('id') || '';
        },
        getPrevId = function() {
            var id = '';
            if (isPlayableId(current)) {
                id = playlistUL.children('li#' + current).prev().attr('id') || '';
                if (id === '' && soundsLength() > 0) {
                    id = getLastId();
                }
            } else {
                if (soundsLength() > 0) {
                    id = getFistId();
                }
            }
            return id;
        },
        getNextId = function() {
            var id = '';
            if (isPlayableId(current)) {
                id = playlistUL.children('li#' + current).next().attr('id') || '';
                if (id === '' && soundsLength() > 0) {
                    id = getFistId();
                }
            } else {
                if (soundsLength() > 0) {
                    id = getFistId();
                }
            }
            return id;
        },
        prev = function() {
            stop();
            var prevId = getPrevId();
            if (current === 0) {
                prevPos = options.loop ? playlistUL.children('li').length - 1 : current;
            }
            play(prevPos);
        };
    return {

    }
}();