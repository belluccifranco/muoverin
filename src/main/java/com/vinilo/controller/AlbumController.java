package com.vinilo.controller;

import com.vinilo.model.Album;
import com.vinilo.service.AlbumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET, params = {"artists"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Album> searchByArtist(@RequestParam(value = "artists") List<Long> artists) {
        return albumService.searchByArtists(artists);
    }

}
