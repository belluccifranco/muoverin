(function($){
    var getArtists = function(obj){
            var artists = '', i;
            for (i=0; i<obj.album.artists.length; i+=1) {
                artists += obj.album.artists[i].name;
            }
            return artists;
        },
        songSearcherOptions = {
            getDataElementHtml: function(obj) {
                var itmTpl = '';

                itmTpl += '<input class="item-checkbox" type="checkbox" value="' + obj.id_song + '" id="itmchkbx_' + obj.id_song + '">';
                itmTpl += '<label class="item-info" for="itmchkbx_' + obj.id_song + '">';
                itmTpl += '    <div class="other-info ellipsis">' + getArtists(obj) + ' - ' + obj.album.name + '</div>';
                itmTpl += '    <div class="main-info ellipsis">' + obj.name + '</div>';
                itmTpl += '</label>';

                return itmTpl;
            },
            bindActionsEvents: function($ac, $list) {
                var $checkAllButton = $ac.find('.check-all-button'),
                    $addSelectedButton = $ac.find('.add-selected-button');

                $checkAllButton.on('click', function(e){
                    var $listCheckboxes = $list.find('li > input[type="checkbox"]');
                    $listCheckboxes.prop('checked', true);
                    e.preventDefault();
                });

                $addSelectedButton.on('click', function(e){
                    var $listCheckboxes = $list.find('li > input[type="checkbox"]'),
                        data = [];
                    $listCheckboxes.each(function(i){
                        if ($(this).is(':checked')) {
                            data.push(app.elements.$songSearcher.jqViniloSearch('getData', i));
                        }
                    });

                    if (data.length > 0) {
                        app.elements.$currentList.jqViniloPlayer('addSounds', data);
                        app.toggleSearcher();
                    }

                    e.preventDefault();
                })
            }
        },
        playingListOptions = {
            sortableHandleSelector: '.item-img',
            playButtonSelector: '#jqvp-play',
            pauseButtonSelector: '#jqvp-pause',
            prevButtonSelector: '#jqvp-prev',
            nextButtonSelector: '#jqvp-next',
            getDataElementHtml: function(obj) {
                var itmTpl = '';

                itmTpl += '<div class="item-img"><i class="fi-music size2x"></i></div>';
                itmTpl += '<div class="item-info">';
                itmTpl += '    <div class="other-info ellipsis">' + getArtists(obj) + ' - ' + obj.album.name + '</div>';
                itmTpl += '    <div class="main-info ellipsis">' + obj.name + '</div>';
                itmTpl += '</div>';

                return itmTpl;
            }
        },
        app = {
            elements: {
                $menuToggle: $('#menu-toggle'),
                $searchToggle: $('#search-toggle'),
                $mainMenu: $('#main-menu'),
                $mainSearcher: $('#main-searcher'),//.hide(),
                $songSearcher: $('#song-searcher').jqViniloSearch(songSearcherOptions),
                $playingList: $('#playing-list').jqViniloPlayer(playingListOptions),

                //current list. It can be playing list or a playlist
                //to reuse the searcher.
                $currentList: null,
                $main: $('#main')
            },
            toggleMenu: function() {
                var self = this;
                self.elements.$mainMenu.toggle();
                if (self.elements.$mainMenu.is(':visible')) {
                    self.elements.$menuToggle.addClass('pressed');
                } else {
                    self.elements.$menuToggle.removeClass('pressed');
                }
            },
            toggleSearcher: function() {
                var self = this;
                self.elements.$mainSearcher.toggle();
                if (self.elements.$mainSearcher.is(':visible')) {
                    self.elements.$searchToggle.addClass('pressed');
                } else {
                    self.elements.$searchToggle.removeClass('pressed');
                }
            },
            bindEvents: function() {
                var self = this;
                self.elements.$menuToggle.on('click', function(){
                    self.toggleMenu();
                });
                self.elements.$searchToggle.on('click', function() {
                    self.toggleSearcher();
                });
                self.elements.$mainMenu.on('click', 'a#upload', function(e){
                    var url = $(this).attr('href');
                    e.preventDefault();
                    app.addView(url);
                    app.toggleMenu();
                });
            },
            init: function() {
                var self = this;
                self.bindEvents();
                self.elements.$currentList = self.elements.$playingList;
            },
            addView: function(url) {
                $.ajax({
                    url: url,
                    dataType: 'html',
                    success: function(data) {
                        app.elements.$main.html(data);
                    }
                });
            }
        };

    app.init();

    //make touch scroll
    touchScroll('#song-search-list');
    touchScroll('#playing-list', '.item-img');

    soundManager.setup({
        url: '/resources/scripts/public/soundmanager2/swf',
        flashVersion: 9,
        onready: function() {
            //console.log('sm2 ready');
        }
    });
})(jQuery);