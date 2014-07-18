$(document).ready(function() {
    
    var $cbArtists = $('#artist-combo');
    var $cbAlbumes = $('#album-combo');
    
    loadArtistCombo();

    $cbArtists.change(function() {
        loadAlbumsByArtist($cbArtists.val());
    });    

    function loadArtistCombo() {
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
                loadAlbumsByArtist($cbArtists.val());
            }
        });
    }

    function loadAlbumsByArtist(id_artist) {
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