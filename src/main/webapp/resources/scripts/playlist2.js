var PlayListUI = function(options) {
    this.init($.isPlainObject(options) ? options : {});
}

PlayListUI.prototype = function(){
    var options, playlistUL, current, playButton,
        pauseButton, stopButton, nextButton, prevButton,
        loopCheckBox, removeButton, upButton, downButton, sounds = {},
        defaults = {
            loop: false,
            ulId: 'main-play-list',
            selectLineClass: 'ui-btn-active',
            playButtonId: 'play',
            pauseButtonId: 'pause',
            stopButtonId: 'stop',
            nextButtonId: 'next',
            prevButtonId: 'prev',
            loopCheckBoxId: 'loop',
            removeSoundButtonId: 'remove-sound',
            upSoundButtonId: 'up-sound',
            downSoundButtonId: 'down-sound',
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
            },
            onStop: function() {
                playButton.removeClass('ui-screen-hidden');
                pauseButton.addClass('ui-screen-hidden');
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
            stopButton = $('#' + options.stopButtonId);
            nextButton = $('#' + options.nextButtonId);
            prevButton = $('#' + options.prevButtonId);
            loopCheckBox = $('#' + options.loopCheckBoxId);
            removeButton = $('#' + options.removeSoundButtonId);
            upButton = $('#' + options.upSoundButtonId);
            downButton = $('#' + options.downSoundButtonId);

            current = '';

            if (options.loop) {
                loopCheckBox.attr('checked', 'checked');
            }

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
            url = '/player/' + obj['id_song'];
            sound = soundManager.createSound({
                id: id,
                url: url,
                onfinish: options.onSoundFinish,
                onplay: options.onPlay,
                onpause: options.onPause,
                onresume: options.onResume,
                onstop: options.onStop
            });
            sounds[id] = {
                data: obj,
                sound: sound
            };
            if (soundsLength() === 1) {
                current = id;
            }
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
                if (null !== sound) {
                    sound[action]();
                }
            }
        },
        play = function(id) {
            if (isPlayableId(id)) {
                current = id;
            }/* else {
                if (soundsLength() > 0) {
                    current = getFistId();
                    selectLine(current);
                } else {
                    return;
                }
            }*/
            selectLine(current);
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
            var id = playlistUL.children('li#' + current).prev().attr('id') || '';
            if (id === '' && soundsLength() > 0 && options.loop) {
                id = getLastId();
            }/* else {
                if (soundsLength() > 0) {
                    id = getFistId();
                }
            }*/
            return id;
        },
        getNextId = function() {
            var id = playlistUL.children('li#' + current).next().attr('id') || '';
            if (id === '' && soundsLength() > 0 && options.loop) {
                id = getFistId();
            }/* else {
                if (soundsLength() > 0) {
                    id = getFistId();
                }
            }*/
            return id;
        },
        prev = function() {
            if (current === getFistId()) {
                if (options.loop) {
                    stop();
                    play(getPrevId());
                }
            } else {
                stop();
                play(getPrevId());
            }
        },
        next = function() {
            if (current === getLastId()) {
                if (options.loop) {
                    stop();
                    play(getNextId());
                }
            } else {
                stop();
                play(getNextId());
            }
        },
        pause = function() {
            doAction('pause');
        },
        togglePause = function() {
            if (!isPlayableId(current) && soundsLength() > 0) {
                play(getFistId());
            } else {
                doAction('togglePause');
            }
        },
        isPaused = function() {
            if (isPlayableId(current)) {
                return getSound(current).paused;
            }
            return true;
        },
        moveSelectedLine = function(direction) {
            var id, li;
            direction = (direction === 'up') ? direction : 'down';
            if (isPlayableId(current)) {
                id = direction === 'down' ? getNextId() : getPrevId();
                if (isPlayableId(id) && (current !== id)) {
                    li = getUILineById(id);
                    if (direction === 'down') {
                        if (current === getLastId()) {
                            return;
                        }
                        getUILineById(current).before(li);
                    } else {
                        if (current === getFistId()) {
                            return;
                        }
                        getUILineById(current).after(li);
                    }
                    refreshUI();
                }
            }
        },
        setLoop = function(loop) {
           options.loop = loop;
        },
        getLoop = function() {
            return options.loop;
        },
        bindEvents = function() {
            playButton.click(function(e) {
                e.preventDefault();
                if (isPaused()) {
                    togglePause();
                } else {
                    play()
                }
            });
            pauseButton.click(function(e) {
                e.preventDefault();
                togglePause();
            });
            stopButton.click(function(e) {
                e.preventDefault();
                stop();
            });
            nextButton.click(function(e) {
                e.preventDefault();
                next();
            });
            prevButton.click(function(e) {
                e.preventDefault();
                prev();
            });
            loopCheckBox.click(function(e){
                setLoop(loopCheckBox.is(':checked'));
            });
            removeButton.click(function(e){
                e.preventDefault();
                if (isSelected()) {
                    stop();
                    removeSound(current, true);
                }
            });
            upButton.click(function(e){
                e.preventDefault();
                if (isSelected()) {
                    //stop();
                    moveSelectedLine('up');
                }
            });
            downButton.click(function(e){
                e.preventDefault();
                if (isSelected()) {
                    //stop();
                    moveSelectedLine('down');
                }
            });
            playlistUL.on('click', '>li', function() {
                var id = $(this).attr('id');
                if (id === current) {
                    if (isPaused()) {
                        togglePause();
                    } else {
                        play();
                    }
                } else {
                    stop();
                    play(id);
                }
            });
        },
        isSelected = function() {
            if (!isPlayableId(current)) {
                return false;
            }
            var ret = getUILineById(current).hasClass(options.selectLineClass) || false;
            return ret;
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
        addSong: addSound,
        removeSong: removeSound,
        getLoop: getLoop,
        moveUp: function() {
            moveSelectedLine('up');
        },
        moveDown: function() {
            moveSelectedLine('down');
        }
    }
}();