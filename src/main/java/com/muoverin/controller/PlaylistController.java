package com.muoverin.controller;

import com.muoverin.model.Playlist;
import com.muoverin.service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @RequestMapping(value = "/playlist", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Playlist> searchAll() {
        return playlistService.searchAll();
    }

    @RequestMapping(value = "/playlist/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Playlist searchById(@PathVariable long id) {
        return playlistService.searchById(id);
    }
}
