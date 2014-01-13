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

    private PlaylistService listaReproduccionService;

    @Autowired
    public PlaylistController(PlaylistService listaReproduccionService) {
        this.listaReproduccionService = listaReproduccionService;
    }

    @RequestMapping(value = "/playlist", method = RequestMethod.GET)
    @ResponseBody
    public List<Playlist> searchAllPlaylists() {
        return listaReproduccionService.searchAllPlaylists();
    }

    @RequestMapping(value = "/listasReproduccion/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Playlist searchById(@PathVariable Long id) {
        return listaReproduccionService.searchById(id);
    }
}
