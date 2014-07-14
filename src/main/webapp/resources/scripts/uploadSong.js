$(document).ready(function() {
    
    var $cbArtists = $('#artist-combo'),
    $cbAlbumes = $('#album-combo');
    
    loadArtistCombo();
    //loadAlbumsByArtist($('#artist-combo').val());

    $cbArtists.change(function() {
        loadAlbumsByArtist($cbArtists.val());
    });
    $cbArtists.change();

    function loadArtistCombo() {
        //var $combo = $('#artist-combo');
        var url = '/artists';
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            success: function(data) {
                var options = '';
                $.each(data, function(i, artist) {
                    options += '<option value="' + artist.id_artist + '">' + artist.name + '</option>';
                });
                $cbArtists.html(options);
            }
        });
    }


    function loadAlbumsByArtist(id_artist) {
        //var $combo = $('#album-combo');
        var url = '/albums?id_artist=' + id_artist;
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            success: function(data) {
                var options = '';
                $.each(data, function(i, album) {
                    options += '<option value="' + album.id_album + '">' + album.name + '</option>';
                });
                $cbAlbumes.html(options);
            }
        });
    }
});