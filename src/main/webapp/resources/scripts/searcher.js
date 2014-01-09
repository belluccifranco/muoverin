var SearcherUI = function(options) {
    options = $.isPlainObject(options) ? options : {};
    this.init(options);
};

SearcherUI.prototype = function(){
    var self, defaults = {
        listId: null,
        inputId: null,
        buttonId: null,
        pagerNextButtonId: null,
        pagerPrevButtonId: null,
        searchUrl: '/vinilo/songs',
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
            $button.click(function(e){
                e.preventDefault();
                searchObj.search(searchObj.uiInput.val(), 1)
            });
        },
        setCustomUIEvents: function($listObj) {}
    },
    init = function(options) {
        self = this;

        self.list = [];
        self.options = $.extend(defaults, options);

        self.uiList = typeof(self.options.listId) === 'string' ? $('#' + self.options.listId) : null;
        self.uiInput = typeof(self.options.inputId) === 'string' ? $('#' + self.options.inputId) : null;
        self.uiButton = typeof(self.options.buttonId) === 'string' ? $('#' + self.options.buttonId) : null;

        self.searchQuery = '';
        self.page = 1;
        self.uiPagerNextButton = typeof(self.options.pagerNextButtonId) === 'string' ? $('#' + self.options.pagerNextButtonId) : null;
        self.uiPagerPrevButton = typeof(self.options.pagerPrevButtonId) === 'string' ? $('#' + self.options.pagerPrevButtonId) : null;

        self.uiPagerNextButton.attr('disabled', 'disabled');
        self.uiPagerPrevButton.attr('disabled', 'disabled');

        bindEvents();

        self.pager =  {
            pagActual: 1,
            cantRegistrosPagActual: 0,
            cantPaginas: 0,
            cantRegistrosTotales: 0
        }
    },
    clear = function(){
        self.list.length = 0;
    },
    clearUI = function(){
        self.uiList.html('');
    },
    refreshUI = function() {
        self.uiList.listview("refresh");
    },
    updateUI = function() {
        if (null === self.uiList) { return; }

        clearUI();
        var lis = '';
        for (var i=0; i<self.list.length; i++) {
            lis += '<li>' + self.options.getLineHtml(self.list[i]) + '</li>';
        }

        self.uiList.html(lis);
        refreshUI();
    },
    updatePagerInfo = function(pagerObj) {
        self.pager = pagerObj;
        self.uiPagerNextButton.attr('disabled', 'disabled');
        self.uiPagerPrevButton.attr('disabled', 'disabled');
        if (self.pager.pagActual < self.pager.cantPaginas) {
            self.uiPagerNextButton.removeAttr('disabled');
        }
        if (self.pager.pagActual > 1) {
            self.uiPagerPrevButton.removeAttr('disabled');
        }
    },
    search = function(q, p) {
        self.page = !isNaN(parseInt(p)) ? parseInt(p):1;

        if (null !== q) {
            self.searchQuery = $.trim(q);
        }

        if (self.searchQuery === '') {
            clearUI();
            return;
        }

        $.ajax({
            url: self.options.searchUrl,
            data: { criteria: self.searchQuery, index: self.page},
            type: 'get',
            dataType: 'json',
            success: function(data) {
                self.list = data.datos;
                updateUI();

                var pager =  {
                    pagActual: data.pagActual,
                    cantRegistrosPagActual: data.cantRegistrosPagActual,
                    cantPaginas: data.cantPaginas,
                    cantRegistrosTotales: data.cantRegistrosTotales
                }

                updatePagerInfo(pager);
            }
        });
    },
    getObject = function(pos) {
        return self.list[pos];
    },
    bindEvents = function() {
        if (null !== self.uiInput) { self.options.inputEvents(self.uiInput ,self); }
        if (null !== self.uiButton) { self.options.buttonEvents(self.uiButton ,self); }
        if (null !== self.uiList) { self.options.setCustomUIEvents(self.uiList); }
        if (null !== self.uiPagerNextButton) {
            self.uiPagerNextButton.on('click', function(){
                self.search(null, self.page + 1);
            });
        }
        if (null !== self.uiPagerPrevButton) {
            self.uiPagerPrevButton.on('click', function(){
                self.search(null, self.page - 1);
            });
        }
    };
    return {
        init: init,
        search: search,
        getObject: getObject
    }
}();