package com.muoverin.controller;

import com.muoverin.model.Album;
import com.muoverin.model.Artist;
import com.muoverin.service.AlbumService;
import com.muoverin.service.ArtistService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class AlbumController {

    private final AlbumService albumService;
    private final ArtistService artistService;

    @Autowired
    public AlbumController(AlbumService albumService, ArtistService artistService) {
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET, params = {"artists"})
    @ResponseStatus(HttpStatus.OK)
    public List<Album> searchByArtist(@RequestParam(value = "artists") List<Long> artists) {
        return albumService.searchByArtists(artists);
    }

    @RequestMapping(value = "/album", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody @Valid Album album, HttpServletResponse response, WebRequest webRequest, BindingResult result) {
        List<Artist> artists = new ArrayList<>();
        for (Artist artist : album.getArtists()) {
            Artist art = artistService.searchById(artist.getId_artist());
            art.getAlbums().add(album);
            artists.add(art);
        }
        album.setArtists(artists);
        Album createdAlbum = albumService.save(album);
        response.setHeader("Location", webRequest.getContextPath() + "/album/" + createdAlbum.getId_album());
    }
}
