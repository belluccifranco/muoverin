var playlist = null;
var songSearcher = null;

jQuery(document).on('pagebeforecreate', '#playlist-page', function(){

});

jQuery(document).on('pageinit', '#playlist-page', function(){
    /*$.ajax({
        url: "/vinilo/canciones",
        type: "get",
        dataType: "json",
        success: function(data){
            playlist.setPlaylist(data);
        }
    });*/
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
