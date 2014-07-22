(function($){
    var songSearcherOptions = {
            getDataElementHtml: function(obj) {
                var itmTpl = '';

                function getArtists() {
                    var artists = '', i;
                    for (i=0; i<obj.album.artists.length; i+=1) {
                        artists += obj.album.artists[i].name;
                    }
                    return artists;
                }

                itmTpl += '<input class="item-checkbox" type="checkbox" value="' + obj.id_song + '" id="itmchkbx_' + obj.id_song + '">';
                itmTpl += '<label class="item-info" for="itmchkbx_' + obj.id_song + '">';
                itmTpl += '    <div class="other-info ellipsis">' + getArtists() + ' - ' + obj.album.name + '</div>';
                itmTpl += '    <div class="main-info ellipsis">' + obj.name + '</div>';
                itmTpl += '</label>';

                return itmTpl;
            }
        },
        app = {
            elements: {
                $menuToggle: $('#menu-toggle'),
                $mainMenu: $('#main-menu'),
                $songSearcher: $('#song-searcher').jqViniloSearch(songSearcherOptions),

                //current list. I can be playing list or a playlist
                //to reuse the searcher.
                currentList: null
            },
            bindEvents: function() {
                var self = this;
                this.elements.$menuToggle.on('click', function(){
                    self.elements.$mainMenu.toggle();
                });
            },
            init: function() {
                var self = this;
                self.bindEvents();
            }
        };

    app.init();

    //make touch scroll
    touchScroll('song-search-list');

    soundManager.setup({
        url: '/resources/scripts/soundmanager2/swf',
        preferFlash: true,
        onready: function() {
            //console.log('sm2 ready');
        }
    });
})(jQuery);