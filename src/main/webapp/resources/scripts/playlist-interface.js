var PlayListUI = function(options) {
    this.init($.isPlainObject(options) ? options : {});
};

PlayListUI.prototype = function() {
    var self,
        defaults = {
            'uiListSelector': '#playlist',
            'playBtnId'  : '#play',
            'nextBtnId'  : '#next',
            'prevBtnId'  : '#prev',
            'playClass'  : 'play',
            'pauseClass' : 'pause',
            'getInfoHtml': function(info) {
                return info.nroOrden + ') ' + info.artista.nombre + info.nombre;
            }
        },
        init = function(options){
            self = this;
            self.playlist = new SM2Playlist();
            self.options = $.extend(self.options, options);

            self.uiList = $(self.options.uiListSelector);
            self.playButton = $('#' + self.options.playBtnId);
            self.nextButton = $('#' + self.options.nextBtnId);
            self.prevButton = $('#' + self.options.prevBtnId);
            bindEvents();
        },
        setPlaylist = function(data) {
            var i, length,
                list = [];

            for (i=0, length=data.length; i<length; i += 1) {
                var id = 's' + data['id'];
                list.push({
                    info: data,
                    id: id,
                    sound: soundManager.createSound({id: id, url: list['url']})
                })
            }

            self.playlist.setPlaylist(list);
        },
        bindEvents = function() {
            self.playButton.click(function(e){
                var $this = $(this);
                e.preventDefault();
                self.playlist.togglePause();
                $this.removeClass(self.options.playClass)
                    .removeClass(self.options.pauseClass);
                if (self.playlist.isPaused()) {
                    $this.addClass(self.options.pauseClass);
                } else {
                    $this.addClass(self.options.playClass);
                }
            });

            self.nextButton.click(function(e){
                e.preventDefault();
                self.playlist.next();
            });

            self.prevButton.click(function(e){
                e.preventDefault();
                self.playlist.next();
            });
        };
    return {
        init: init
    }
}();
