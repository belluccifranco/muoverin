$(document).ready(function() {
    
    var $cbArtists = $('#artist-combo');
    var $cbAlbumes = $('#album-combo');
    var $cbHosting = $('#hosting-combo');
    
    loadArtistCombo();
    loadHostingCombo();

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
    
    function loadHostingCombo() {
        var url = '/hostings';
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            success: function(data) {
                var options = '';
                $.each(data, function(i, hosting) {
                    options += '<option value="' + hosting.id_hostingAccount + '">' + hosting.username + '</option>';
                });
                $cbHosting.html(options);                
            }
        });
    }
});