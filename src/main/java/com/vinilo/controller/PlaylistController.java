package com.vinilo.controller;

import com.vinilo.model.ListaReproduccion;
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

    @Autowired
    private PlaylistService listaReproduccionService;
    
    @RequestMapping(value = "/playlist", method = RequestMethod.GET)
    @ResponseBody 
    public List<ListaReproduccion> searchAllPlaylists() {
        return listaReproduccionService.searchAllPlaylists();
    }
    
    @RequestMapping(value = "/listasReproduccion/{id}", method = RequestMethod.GET)
    @ResponseBody 
    public ListaReproduccion searchById(@PathVariable Long id) {
        return listaReproduccionService.searchById(id);
    }
}
