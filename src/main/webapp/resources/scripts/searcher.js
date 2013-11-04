var SearcherUI = function(options) {
    options = $.isPlainObject(options) ? options : {};
    this.init(options);
};

SearcherUI.prototype = function(){
    var defaults = {
        listId: null,
        inputId: null,
        buttonId: null,
        searchUrl: '/vinilo/canciones',
        getLineHtml: function(obj) {
            return '<a href="#">' + obj.artista.nombre + ' - ' + obj.nombre + '</a>';
            //throw 'Debe especificar la opción getLineHtml (function).';
        },
        inputEvents: function($input, searchObj) {
            $input.keyup(function(e){
                var code = e.keyCode || e.which;
                if(code == 13) { searchObj.uiButton.click(); }
            });
        },
        buttonEvents: function($button, searchObj) {
            console.log($button, searchObj);
            $button.click(function(e){
                e.preventDefault();
                searchObj.search(searchObj.uiInput.val(), 0)
            });
        },
        setCustomUIEvents: function($listObj) {}
    },
    init = function(options) {
        this.list = [];
        this.options = $.extend(defaults, options);

        this.uiList = typeof(this.options.listId) === 'string' ? $('#' + this.options.listId) : null;
        this.uiInput = typeof(this.options.inputId) === 'string' ? $('#' + this.options.inputId) : null;
        this.uiButton = typeof(this.options.buttonId) === 'string' ? $('#' + this.options.buttonId) : null;

        this.page = 0;

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
        if (null === this.uiList) { return; }

        clearUI.call(this);
        var lis = '';
        for (var i=0; i<this.list.length; i++) {
            lis += '<li>' + this.options.getLineHtml(this.list[i]) + '</li>';
        }

        this.uiList.html(lis);
        refreshUI.call(this);
    },
    search = function(q, p) {
        var self = this;

        this.page = !isNaN(parseInt(p)) ? parseInt(p):0;
        q = $.trim(q);

        if (q === '') {
            clearUI.call(self);
            return;
        }

        $.ajax({
            url: self.options.searchUrl,
            data: { criteria: q, indice: this.page},
            type: 'get',
            dataType: 'json',
            success: function(data) {
                self.list = data;
                updateUI.call(self);
            }
        });
    },
    bindEvents = function() {
        if (null !== this.uiInput) { this.options.inputEvents(this.uiInput ,this); }
        if (null !== this.uiButton) { this.options.buttonEvents(this.uiButton ,this); }
        if (null !== this.uiList) { this.options.setCustomUIEvents(this.uiList); }
    };
    return {
        init: init,
        search: search
    }
}();