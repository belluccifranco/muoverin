(function($){
    var songSearcherOptions = {
            listId: 'song-search-list',
            inputId: 'song-search-input',
            buttonId: 'song-search-button',
            pagerNextButtonId: null,
            pagerPrevButtonId: null,
            getLineHtml: function(obj) {
                var itmTpl = '';
                itmTpl += '<div class="item-img"></div>';
                itmTpl += '<label><div class="item-info">';
                itmTpl += '    <div class="other-info ellipsis"><input type="checkbox"> ' + obj.artist.name + ' - ' + obj.album.name + '</div>';
                itmTpl += '    <div class="main-info ellipsis">' + obj.name + '</div>';
                itmTpl += '</div></label>';

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