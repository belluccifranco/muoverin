(function(){
    var SongSearcherUI = function(options) {
        options = $.isPlainObject(options) ? options : {};
        this.init(options);
    };
    
    SongSearcherUI.prototype = function(){
        var defaults = {
            listId: null,
            inputId: null,
            buttonId: null,
            searchUrl: '/vinilo/canciones'
        },
        init = function(options) {
            this.list = [];
            this.options = $.extend(defaults, options);
            bindEvents.call(this);
        },
        clear = function(){
            this.list.length = 0;
        },
        clearUI = function(){
            this.uiList.html('');
        },
        refreshUI = function() {
            this.uiList.listview("refresh");
        },
        updateUI = function() {
            clearUI.call(this);
            var lis = '';
            for (var i=0; i<this.list.length; i++) {
                lis += '<li><a href="#">' + this.list[i].artista.nombre + ' - ' + this.list[i].nombre + '</a></li>'
            }
            this.uiList.html(lis);
            refreshUI.call(this);
            //selectCurrentUI.call(this);
        },
        search = function(q) {
            var self = this;
            if (undefined === q || $.trim(q) === '') {
                return;
            }
            $.ajax({
                url: self.searcUrl + '/' + encodeURIComponent(q),
                type: 'get',
                dataType: 'json',
                success: function(data) {
                    self.list = data;
                    updateUI.call(this);
                }
            });
        },
        bindEvents = function() {
            
        };
        return {
            init: init
        }
    }();
})();


