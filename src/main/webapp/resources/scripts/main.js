var playlist = null;
var songSearcher = null;

jQuery(document).on('pagebeforecreate', '#playlist-page', function() {
    soundManager.setup({
        url: '/vinilo/resources/scripts/soundmanager2/swf/',
        //flashVersion: 9,
        //debugFlash : true,
        //useHTML5Audio: false,
        preferFlash: true,
        ontimeout: function() {
            console.error('Could not start SoundManager2');
        }
    });

    playlist = new PlayListUI();
});

jQuery(document).on('pageinit', '#playlist-page', function() {

});

jQuery(document).on('pagebeforecreate', '#search-music-page', function() {

});

jQuery(document).on('pageinit', '#search-music-page', function() {
    songSearcher = new SearcherUI({
        listId: 'song-search-list',
        inputId: 'song-search-input',
        buttonId: 'song-search-button',
        pagerNextButtonId: 'song-search-pager-next-button',
        pagerPrevButtonId: 'song-search-pager-prev-button',
        setCustomUIEvents: function($listObj) {
            $listObj.on('click', '>li', function() {
                var idx = $(this).index();
                playlist.addSong(songSearcher.getObject(idx));
                window.history.back();
            });
        }
    });
});

jQuery(document).on('pageshow', '#search-music-page', function() {
    var $searchInput = $(this).find("#song-search-input");
    $searchInput.focus();
});
