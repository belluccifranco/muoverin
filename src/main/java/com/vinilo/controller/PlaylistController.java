package com.vinilo.controller;

import com.vinilo.model.Playlist;
import com.vinilo.service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @RequestMapping(value = "/playlist", method = RequestMethod.GET)
    @ResponseBody
    public List<Playlist> searchAllPlaylists() {
        return playlistService.searchAllPlaylists();
    }

    @RequestMapping(value = "/listasReproduccion/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Playlist searchById(@PathVariable Long id) {
        return playlistService.searchById(id);
    }
}
