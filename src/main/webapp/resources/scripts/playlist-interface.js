var PlayUIInterface = function(uiListId, options) {
    this.uiList = $('#' + uiListId);
    this.init(options);
};

PlayUIInterface.prototype = function(){
    var pl = null;
        init = function(options) {
            pl = new jPlayerPlaylist({},[],options);
        },
        refreshUI = function() {
            this.uiList.listview('refresh');
        },
        clear = function(){
            this.uiList.html('');
        },
        appendToUI = function(list){
            var i = 0,
                html = '';
            for(;i<list.length;i++) {
                html += '<li><a href="#">' + list[i].artist + ' - ' + list[i].title + '</a></li>'
            }
            
            this.uiList.append(html);
            refreshUI.call(this);
        },
        setPlaylist = function(list){
            pl.setPlaylist(list);
            clear.call(this);
            appendToUI.call(this, list);
            this.uiList.children('li').first().addClass("ui-btn-active");
        };
    return {
        init: init,
        setPlaylist: setPlaylist
    };
}();
