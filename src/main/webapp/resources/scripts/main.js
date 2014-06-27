(function($){
    var app = {
        elements: {
            $menuToggle: $('#menu-toggle'),
            $mainMenu: $('#main-menu')
        },
        bindEvents: function() {
            console.log('bindevents');
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
})(jQuery);