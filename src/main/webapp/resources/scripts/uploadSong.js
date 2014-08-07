$(document).ready(function() {

    var $cbArtists = $('#artist-combo'),
            $artistsS2Configs = {
                width: '100%',
                multiple: true,
                minimumInputLength: 2,
                placeholder: 'Select Artists...'
            },
    artistsUrl = '/artists',
            formatArtistDataForS2 = function(obj) {
                return {
                    id: obj.id_artist,
                    text: obj.name
                }
            };

    $artistsS2Configs = $.extend($artistsS2Configs, {
        ajax: {
            url: artistsUrl,
            dataType: 'json',
            data: function(term, page) {
                return {
                    criteria: term
                };
            },
            results: function(data, page) {
                return {
                    results: function() {
                        var ret = [], i;
                        for (i = 0; i < data.length; i++) {
                            ret.push(formatArtistDataForS2(data[i]));
                        }
                        return ret;
                    }()
                };
            }
        },
        initSelection: function(element, callback) {
            var id = $(element).val();
            if (id !== "") {
                $.ajax({
                    url: url,
                    data: {id: id.split(',')},
                    dataType: "json"
                }).done(function(data) {
                    var ret = [], i;
                    for (i = 0; i < data.length; i++) {
                        ret.push(formatArtistDataForS2(data[i]));
                    }
                    if ($artistsS2Configs.multiple) {
                        callback(ret);
                    } else {
                        callback(ret[0]);
                    }
                });
            }
        }
    });

    $cbArtists.select2($artistsS2Configs);

    var $cbAlbumes = $('#album-combo');
    var $cbHosting = $('#hosting-combo');

    /*function loadArtistCombo() {
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
     }*/

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

    loadHostingCombo();

    $(document).foundation();
});