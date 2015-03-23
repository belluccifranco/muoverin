$(document).ready(function () {
    var $cbArtistsInSong = $('#song-artist'),
            $cbArtistsInAlbum = $('#album-artists'),
            $cbAlbumes = $('#song-album'),
            $cbHosting = $('#song-link-hostingAccount'),
            $songForm = $("#songForm"),
            $artistForm = $("#artistForm"),
            $albumForm = $("#albumForm"),
            $hostingAccountForm = $("#hostingAccountForm"),
            artistsUrl = '/artists';
    var $artistsS2Configs = {
        width: '100%',
        multiple: true,
        minimumInputLength: 2,
        placeholder: 'Select Artists...'
    };
    var formatArtistDataForS2 = function (obj) {
        return {
            id: obj.id_artist,
            text: obj.name
        }
    };

    function loadAlbumsByArtists(id_artists) {
        if (id_artists.length === 0) {
            $cbAlbumes.html('');
        } else {
            var url = '/albums?artists=' + id_artists.toString();
            $.ajax({
                url: url,
                type: 'get',
                dataType: 'json',
                success: function (data) {
                    var options = '';
                    $.each(data, function (i, album) {
                        options += '<option value="' + album.id_album + '">' + album.name + '</option>';
                    });
                    $cbAlbumes.html(options);
                }
            });
        }
    }

    function loadHostingCombo() {
        var url = '/hostingAccounts';
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            success: function (data) {
                var options = '';
                $.each(data, function (i, hosting) {
                    options += '<option value="' + hosting.id_hostingAccount + '">' + hosting.username + '</option>';
                });
                $cbHosting.html(options);
            }
        });
    }

    function populateCustomFieldErrors(errorFormInfo) {
        $.each(errorFormInfo.fieldErrors, function (index, fieldErrorDTO) {
            var errorTag = $("#" + errorFormInfo.objectName + "-" + fieldErrorDTO.fieldName + "-error");
            errorTag.text(fieldErrorDTO.fieldError);
            errorTag.closest('div').addClass("error");

        });
    }

    $artistsS2Configs = $.extend($artistsS2Configs, {
        ajax: {
            url: artistsUrl,
            dataType: 'json',
            data: function (term, page) {
                return {
                    criteria: term
                };
            },
            results: function (data, page) {
                return {
                    results: (function () {
                        var ret = [], i;
                        for (i = 0; i < data.length; i += 1) {
                            ret.push(formatArtistDataForS2(data[i]));
                        }
                        return ret;
                    }())
                };
            }
        },
        initSelection: function (element, callback) {
            var id = $(element).val();
            if (id !== "") {
                $.ajax({                    
                    data: {id: id.split(',')},
                    dataType: "json"
                }).done(function (data) {
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
    $cbArtistsInSong.select2($artistsS2Configs);
    $cbArtistsInAlbum.select2($artistsS2Configs);

    $cbArtistsInSong.on("change", function (event) {
        loadAlbumsByArtists(event.val);
    });

    $songForm.on('submit', function (event) {
        var songJson = {};
        songJson.name = $("#song-name").val();
        songJson.album = {};
        songJson.album.id_album = $("#song-album").val();
        songJson.link = {};
        songJson.link.url = $("#song-link-url").val();
        songJson.link.hostingAccount = {};
        songJson.link.hostingAccount.id_hostingAccount = $("#song-link-hostingAccount").val();
        songJson.track = $("#song-track").val();

        $.ajax({
            url: "/song",
            data: JSON.stringify(songJson),
            type: "post",
            contentType: 'application/json',
            success: function () {
                $("#mainContainer").prepend('<div data-alert class="alert-box success radius">Song was saved!<a href="#" class="close">&times;</a></div>').foundation();
                $songForm[0].reset();
                $(window).scrollTop(0);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });

    $artistForm.on('submit', function (event) {
        var artistJson = {};
        artistJson.name = $("#artist-name").val();
        artistJson.info = $("#artist-info").val();

        $.ajax({
            url: "/artist",
            data: JSON.stringify(artistJson),
            type: "post",
            contentType: 'application/json',
            success: function () {
                $('#newArtistModal').foundation('reveal', 'close');
                $artistForm[0].reset();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });

    $albumForm.on('submit', function (event) {
        var artists = $("#album-artists").select2("val");
        var albumJson = {};
        albumJson.artists = [];
        for (i = 0; i < artists.length; i++) {
            var artistObj = {id_artist: artists[i]};
            albumJson.artists[i] = artistObj;
        }
        albumJson.name = $("#album-name").val();
        albumJson.releaseYear = $("#album-releaseYear").val();

        $.ajax({
            url: "/album",
            data: JSON.stringify(albumJson),
            type: "post",
            contentType: 'application/json',
            success: function () {
                $('#newAlbumModal').foundation('reveal', 'close');
                $albumForm[0].reset();
                loadAlbumsByArtists($cbArtistsInAlbum.val());
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });

    $hostingAccountForm.on('submit', function (event) {
        var hostingJson = {};
        hostingJson.url = $("#hostingAccount-url").val();
        hostingJson.username = $("#hostingAccount-username").val();
        hostingJson.password = $("#hostingAccount-password").val();

        $.ajax({
            url: "/hostingAccount",
            data: JSON.stringify(hostingJson),
            type: "post",
            contentType: 'application/json',
            success: function () {
                $('#newHostingAccountModal').foundation('reveal', 'close');
                $hostingAccountForm[0].reset();
                loadHostingCombo();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });

    loadHostingCombo();
    $(document).foundation();
});