$(document).ready(function () {
    var $cbArtistsInSong = $('#song-artist'),
            $cbArtistsInAlbum = $('#album-artist'),
            $cbAlbumes = $('#song-album'),
            $cbHosting = $('#song-link-hostingAccount'),
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
        var url = '/hostings';
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
                    url: url,
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

    $cbArtistsInSong.on("change", function (e) {
        loadAlbumsByArtists(e.val);
    });

    $("#uploadSongForm").on('submit', function (event) {
        var track = $("#song-track").val();
        var name = $("#song-name").val();
        var id_album = $("#song-album").val();
        var id_hosting = $("#song-link-hostingAccount").val();
        var url = $("#song-link-url").val();

        var songJson = {};
        if (name !== "") {
            songJson.name = name;
        }
        if (id_album !== null) {
            songJson.album = {};
            songJson.album.id_album = id_album;
        }
        songJson.link = {};
        if (url !== "") {
            songJson.link.url = url;
        }
        if (id_hosting !== null) {
            songJson.link.hostingAccount = {};
            songJson.link.hostingAccount.id_hostingAccount = id_hosting;
        }
        songJson.track = track;

        $.ajax({
            url: "/song",
            data: JSON.stringify(songJson),
            type: "post",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function () {
                $("#mainContainer").prepend('<div data-alert class="alert-box success radius">Song was saved!<a href="#" class="close">&times;</a></div>').foundation();
                $(window).scrollTop(0);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });

    $("#artistForm").on('submit', function (event) {
        var name = $("#artist-name").val();
        var info = $("#artist-info").val();

        var artistJson = {};
        if (name !== "") {
            artistJson.name = name;
        }
        if (info !== "") {
            artistJson.info = info;
        }

        $.ajax({
            url: "/artist",
            data: JSON.stringify(artistJson),
            type: "post",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function () {
                $('#newArtistModal').foundation('reveal', 'close');
                $('#artistForm')[0].reset();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });

    $("#albumForm").on('submit', function (event) {
        
        var name = $("#album-name").val();
        var releaseYear = $("#album-releaseYear").val();

        var artistJson = {};
        if (name !== "") {
            artistJson.name = name;
        }
        if (releaseYear !== "") {
            artistJson.info = releaseYear;
        }

        $.ajax({
            url: "/artist",
            data: JSON.stringify(artistJson),
            type: "post",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function () {
                $('#newArtistModal').foundation('reveal', 'close');
                $('#artistForm')[0].reset();
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