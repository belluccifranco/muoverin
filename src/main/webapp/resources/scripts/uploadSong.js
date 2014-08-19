$(document).ready(function() {
    var $cbAlbumes = $('#album-combo');
    var $cbHosting = $('#hosting-combo');
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

    $cbArtists.on("change", function(e) {
        loadAlbumsByArtists(e.val);
    });

    function loadAlbumsByArtists(id_artists) {
        if (id_artists.length === 0) {
            $cbAlbumes.html('');
        } else {
            var url = '/albums?artists=' + id_artists.toString();
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

    loadHostingCombo();

    $("#uploadSongForm").submit(function(event) {
        var name = $("#name").val();
        var id_album = $("#album-combo").val();
        var url = $("#url").val();
        var id_hosting = $("#hosting-combo").val();
        /*var songJson =
                {   "name": name,
                    "album": {
                        "id_album": id_album
                    },
                    "link": {
                        "url": url,
                        "hostingAccount": {
                            "id_hostingAccount": id_hosting
                        }
                    }
                };*/       
        
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

        $.ajax({
            url: "/song",
            data: JSON.stringify(songJson),
            type: "POST",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function() {
                $("#title-band").html("Song was created");
            },
            error: function(jqXHR, textStatus, errorThrown) {
                var respBody = $.parseJSON(jqXHR.responseText);

                $.each(respBody.fieldErrors, function(index, errEntity) {
                    errEntity.fieldName = errEntity.fieldName.replace(".", "-");
                    var errorTag = $("#" + errEntity.fieldName + "-error");
                    errorTag.text(errEntity.fieldError);
                });
            }
        });
        event.preventDefault();
    });

    $(document).foundation();
});