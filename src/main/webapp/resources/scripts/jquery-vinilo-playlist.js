(function($){

    //buffer saves the ids of the sounds that must be in memory.
    //All other sounds must be destroyed when theirs ids are removed from buffer.
    //Internally it's a simple array
    var Buffer = function(options) {
        options = options || {};
        this.init(options);
    };

    Buffer.prototype = function() {
        var self,
            data = [],
            options = {},
            defaults = {
                size: 2,
                onBeforeAdd: null,
                onAfterRemove: null
            },
            init = function(opts) {
                self = this;
                options = $.extend(defaults, opts);
            },
            getIndex = function(id) {
                return data.indexOf(id);
            },
            has = function(id) {
                return data.indexOf(id) >= 0;
            },
            add = function(id) {
                if (!has(id)) {
                    if ((data.length + 1) > options.size) {
                        throw 'Buffer is full. Must contain at most ' + options.size + ' elements.';
                    }
                    if (typeof options.onBeforeAdd === 'function') {
                        options.onBeforeAdd.call(self, id);
                    }
                    data.push(id);
                }
            },
            remove = function(id) {
                var pos = data.indexOf(id);
                if (pos >= 0) {
                    data.splice(pos, 1);
                    if (typeof options.onAfterRemove === 'function') {
                        options.onAfterRemove.call(self, id);
                    }
                }
            },
            getData = function() {
                return data;
            },
            clear = function() {
                data = [];
            },
            getSize = function() {
                return size;
            },
            count = function() {
                return data.length;
            },
            removeNotIn = function(arr) {
                var i = 0;
                while (i < data.length) {
                    if (arr.indexOf(data[i]) < 0) {
                        remove(data[i]);
                    } else {
                        i += 1;
                    }
                }
            };

        return {
            init: init,
            has: has,
            add: add,
            remove: remove,
            getData: getData,
            clear: clear,
            getSize: getSize,
            count: count,
            removeNotIn: removeNotIn
        }
    }();

    //Order manages the logic of the playlist's sounds order.
    var Order = function(options) {
        options = options || {};
        this.init(options);
    };

    Order.prototype = function() {
        var current = -1,
            data = [],
            options = {},
            defaults = {
                allowDuplicates: true
            },
            init = function(opts) {
                options = $.extend(defaults, opts);
            },
            has = function(id) {
                return data.indexOf(id) >= 0;
            },
            add = function(id) {
                if (has(id) && !options.allowDuplicates) {
                    return;
                }
                data.push(id);
                if (data.length === 1) {
                    current = 0;
                }
            },
            remove = function(id) {
                var pos = data.indexOf(id);
                while (pos >= 0) {
                    if (current === pos && pos === data.length - 1) {
                        current = data.length - 2;
                    }
                    data.splice(pos, 1);
                    pos = data.indexOf(id);
                }
            },
            getData = function() {
                return data;
            },
            isLegalPos = function(pos) {
                return current >= 0 && current < data.length;
            },
            get = function(pos) {
                return typeof data[pos] === 'undefined' ? null : data[pos];
            },
            clear = function() {
                data = [];
            },
            getCurrentPos = function() {
                if (!isLegalPos(current) && data.length > 0) {
                    current = 0;
                }
                return current;
            },
            setCurrentPos = function(pos) {
                if (isLegalPos(pos) && pos !== current) {
                    current = pos;
                }
            },
            getCurrent = function() {
                return get(getCurrentPos());
            },
            getNext = function() {
                var next = null;
                if (isLegalPos(current)) {
                    next = current === data.length - 1 ? 0 : current + 1;
                }
                return next === null ? null : get(next);
            },
            getPrev = function() {
                var prev = null;
                if (isLegalPos(current)) {
                    prev = current > 0 ? current - 1 : data.length - 1;
                }
                return prev === null ? null : get(prev);
            },
            next = function() {
                if (isLegalPos(current)) {
                    current = current === data.length - 1 ? 0 : current + 1;
                }
            },
            prev = function() {
                if (isLegalPos(current)) {
                    current = current > 0 ? current - 1 : data.length - 1;
                }
            },
            move = function(from, to) {
                var el;
                if (isLegalPos(from) && isLegalPos(to) && from !== to) {
                    el = data.splice(from, 1)[0];
                    data.splice(to, 0, el);
                    if (from === current) {
                        current = to;
                    } else {
                        if (to <= current && from > current) {
                            current++;
                        }
                        if (from < current && to >= current) {
                            current--;
                        }
                    }
                }
                console.log(data, current);
            };

        return {
            init: init,
            has: has,
            add: add,
            remove: remove,
            getData: getData,
            get: get,
            clear: clear,
            getCurrentPos: getCurrentPos,
            setCurrentPos: setCurrentPos,
            getCurrent: getCurrent,
            getNext: getNext,
            getPrev: getPrev,
            next: next,
            prev: prev,
            move: move
        }

    }();

    var Playlist = function(options) {
        options = options || {};
        this.init(options);
    };

    Playlist.prototype = function() {
        var self,
            data = {},
            options = {},
            defaults = {
                loop: false,
                getSoundId: function(obj) {
                    return 's' + obj.id_cancion;
                },
                getSoundUrl: function(obj) {
                    return 'http://' + window.location.host + ':9966/player/' + obj.id_cancion;
                },
                onSoundFinish: function() {
                    next();
                },
                onPlay: function() {},
                onPause: function() {},
                onResume: function() {},
                onStop: function() {}
            },
            buffer = new Buffer({
                size: 2,
                onBeforeAdd: function(id) {
                    console.log('added: "' + id + '"');
                },
                onAfterRemove: function(id) {
                    soundManager.destroySound(id);
                    console.log('removing: "' + id + '"');
                    //console.log((soundManager.getMemoryUse()/1024/1024).toFixed(2));
                }
            }),
            order = new Order(),
            init = function(opts) {
                self = this;
                options = $.extend(defaults, opts);
            },
            createSound = function(id, url) {
                if (!buffer.has(id)) {
                    soundManager.createSound({
                        id: id,
                        url: url,
                        onfinish: options.onSoundFinish,
                        onplay: options.onPlay,
                        onpause: options.onPause,
                        onresume: options.onResume,
                        onstop: options.onStop
                    });
                    if (order.getCurrent() !== null && order.getCurrent() !== id) {
                        soundManager.load(id);
                    }
                }
            },
            addSound = function(soundData) {
                var id, url;

                if (typeof options.getSoundId !== 'function') {
                    throw 'getSoundId function must be specify in options.'
                }

                if (typeof options.getSoundUrl !== 'function') {
                    throw 'getSoundUrl function must be specify in options.'
                }

                id = options.getSoundId(soundData);
                url = options.getSoundUrl(soundData);

                console.log(id, url);

                data[id] = { id: id, url: url, data: soundData };
                order.add(id);
            },
            removeSound = function(id) {
                order.remove(id);
                buffer.remove(id);
            },
            setList = function(list) {
                var i;
                buffer.clear();
                order.clear();
                for (i = 0; i < list.length; i += 1) {
                    addSound(list[i]);
                }
            },
            setBuffer = function() {
                var ids = [], i, id, url;

                //ids.push(order.getPrev());
                ids.push(order.getCurrent());
                ids.push(order.getNext());
                buffer.removeNotIn(ids);

                for (i = 0; i < ids.length; i += 1) {
                    if (ids[i] !== null) {
                        id = ids[i];
                        url = data[id].url;
                        createSound(id, url);
                        buffer.add(id);
                    }
                }
            },
            isPaused = function() {
                var id = order.getCurrent();
                if (id !== null) {
                    return soundManager.getSoundById(id).paused;
                }
                return false;
            },
            doAction = function(action) {
                var id = order.getCurrent();
                if (id !== null) {
                    soundManager[action](id);
                }
            },
            stop = function() {
                doAction('stop');
            },
            togglePause = function() {
                doAction('togglePause');
            },
            play = function(pos) {
                if (typeof pos !== 'undefined') {
                    order.setCurrentPos(pos);
                }
                setBuffer();
                if (isPaused()) {
                    togglePause();
                } else {
                    doAction('play');
                }
            },
            prev = function() {
                stop();
                order.prev();
                play();
            },
            next = function() {
                stop();
                order.next();
                play();
            },
            getOrder = function() {
                return order;
            };

        return {
            init: init,
            addSound: addSound,
            removeSound: removeSound,
            setList: setList,
            stop: stop,
            togglePause: togglePause,
            play: play,
            prev: prev,
            next: next,
            getOrder: getOrder
        }
    }();

    var methods =  {
        init: function(options) {
            var settings = $.extend(true, {}, $.fn.jqViniloPlayer.defaults, options);

            return this.each(function(){
                var $elem = $(this), $playButton, $pauseButton, $prevButton, $nextButton,
                    pl = new Playlist({
                        getSoundId: function(obj) {
                            return 's' + obj.id_song;
                        },
                        getSoundUrl: function(obj) {
                            var baseUrl = window.location.protocol + '//' + window.location.host;
                            return baseUrl + '/player/' + obj.id_song;
                        },
                        onPlay: function() {
                            $playButton.hide();
                            $pauseButton.show();
                            setPlaying();
                        },
                        onPause: function() {
                            $pauseButton.hide();
                            $playButton.show();
                        },
                        onResume: function() {
                            $playButton.hide();
                            $pauseButton.show();
                        },
                        onStop: function() {

                        }
                    }),
                    isEmpty = function(variable) {
                        var emptyValues = [null, undefined, ''];

                        return emptyValues.indexOf(variable) >= 0;
                    },
                    addSound = function(sound) {
                        $elem.append('<li>' + settings.getDataElementHtml(sound) + '</li>');
                        pl.addSound(sound);
                    },
                    removeSound = function(pos) {

                    },
                    addSounds = function(data){
                        var toAdd = [], i;
                        if (typeof data === 'undefined' || $.isFunction(data)) {
                            return;
                        }
                        if ($.isArray(data)) {
                            toAdd = data;
                        } else {
                            toAdd.push(data);
                        }
                        for (i = 0; i < toAdd.length; i += 1) {
                            addSound(toAdd[i]);
                        }
                    },
                    setSelected = function($li) {
                        $elem.find('> li').removeClass('selected');
                        $li.addClass('selected');
                    },
                    setPlaying =function() {
                        var pos = pl.getOrder().getCurrentPos();
                        if (pos > -1) {
                            $elem.find('li').removeClass('playing').eq(pos).addClass('playing');
                        }
                    },
                    bindEvents = function() {
                        var oldPosition = -1;
                        if (!isEmpty(settings.sortableHandleSelector)) {
                            $elem.sortable({
                                handle: settings.sortableHandleSelector,
                                start: function( event, ui ) {
                                    oldPosition = ui.item.index()
                                },
                                update: function( event, ui ) {
                                    var newPostition = ui.item.index();
                                    pl.getOrder().move(oldPosition, newPostition);
                                }
                            });
                        }

                        if (!isEmpty(settings.playButtonSelector)) {
                            $playButton = $(settings.playButtonSelector);
                            $playButton.on('click', function(e) {
                                pl.play();
                                e.preventDefault();
                            });
                        }

                        if (!isEmpty(settings.pauseButtonSelector)) {
                            $pauseButton = $(settings.pauseButtonSelector);
                            $pauseButton.hide();
                            $pauseButton.on('click', function(e){
                                pl.togglePause();
                                e.preventDefault();
                            });
                        }

                        if (!isEmpty(settings.prevButtonSelector)) {
                            $prevButton = $(settings.prevButtonSelector);
                            $prevButton.on('click', function(e){
                                pl.prev();
                                e.preventDefault();
                            });
                        }

                        if (!isEmpty(settings.nextButtonSelector)) {
                            $nextButton = $(settings.nextButtonSelector);
                            $nextButton.on('click', function(e){
                                pl.next();
                                e.preventDefault();
                            })
                        }

                        $elem.on('mousedown', '> li', function() {
                            setSelected($(this));
                        });
                    };

                this.addSounds = addSounds;

                bindEvents();
            });
        }
    };

    $.fn.jqViniloPlayer = function(methodOrOptions){
        if (this.first().get(0)[methodOrOptions]) {
            //if (methods[methodOrOptions]) {
            //this methods are supposed to be applied to one jquery object. In this case the first
            return this.first().get(0)[methodOrOptions].apply(null, Array.prototype.slice.call(arguments, 1));
            //return methods[methodOrOptions].apply(this.first().get(0), Array.prototype.slice.call(arguments, 1));
        } else if ( $.isPlainObject(methodOrOptions) || !methodOrOptions ) {
            return methods.init.apply(this, arguments);
        } else {
            $.error( 'Method ' +  methodOrOptions + ' does not exist on jQuery.jqViniloSearch' );
        }
    }

    $.fn.jqViniloPlayer.defaults = {
        sortableHandleSelector: '.item-img',
        playButtonSelector: null,
        pauseButtonSelector: null,
        prevButtonSelector: null,
        nextButtonSelector: null,
        getDataElementHtml: function(dataElement) {
            throw 'this function must be implemented.';
        }
    };
})(jQuery);
