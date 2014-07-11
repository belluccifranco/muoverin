(function($){
    var songSearcherOptions = {
            listId: 'song-search-list',
            inputId: 'song-search-input',
            buttonId: 'song-search-button',
            pagerNextButtonId: 'main-searcher-next-button',
            pagerPrevButtonId: 'main-searcher-prev-button',
            getLineHtml: function(obj) {
                var itmTpl = '';

                itmTpl += '<input class="item-checkbox" type="checkbox" id="itmchkbx_' + obj.id_song + '">';
                itmTpl += '<label class="item-info" for="itmchkbx_' + obj.id_song + '">';
                itmTpl += '    <div class="other-info ellipsis">' + obj.artist.name + ' - ' + obj.album.name + '</div>';
                itmTpl += '    <div class="main-info ellipsis">' + obj.name + '</div>';
                itmTpl += '</label>';

                return itmTpl;
            }
        },
        app = {
            elements: {
                $menuToggle: $('#menu-toggle'),
                $mainMenu: $('#main-menu'),
                songSearcher: new SearcherUI(songSearcherOptions)
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

    //make div touch scroll
    touchScroll('song-search-list');

    soundManager.setup({
        url: '/resources/scripts/soundmanager2/swf',
        //flashVersion: 8, // optional: shiny features (default = 8)
        // optional: ignore Flash where possible, use 100% HTML5 mode
        preferFlash: true,
        onready: function() {
            console.log('sm2 ready');
        }
    });
})(jQuery);