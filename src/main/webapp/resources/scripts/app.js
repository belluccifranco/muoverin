var playlist = null;
var songSearcher = null;

jQuery(document).on('pagebeforecreate', '#playlist-page', function(){
    soundManager.setup({
        url: '/vinilo/resources/scripts/soundmanager2/swf/',
        //flashVersion: 9,
        //debugFlash : true,
        preferFlash: false,
        ontimeout: function() {
            console.error('No se pudo iniciar SoundManager2');
        }
    });

    playlist = new PlayListUI();
});

jQuery(document).on('pageinit', '#playlist-page', function(){
    var firstTime = true;
    soundManager.onready(function(){
        if (firstTime) {
            firstTime = false;
            $.ajax({
                url: "/vinilo/canciones",
                type: "get",
                dataType: "json",
                success: function(data){
                    playlist.setPlaylist(data);
                    //playlist.play();
                }
            });
        }
    });
});

jQuery(document).on('pagebeforecreate', '#search-music-page', function(){

});

jQuery(document).on('pageinit', '#search-music-page', function(){
    songSearcher = new SearcherUI({
         listId: 'song-search-list',
         inputId: 'song-search-input',
         buttonId: 'song-search-button'
    });
});

jQuery(document).on('pageshow', '#search-music-page', function(){
    var $searchInput = $(this).find("#song-search-input");
    $searchInput.focus();
});
