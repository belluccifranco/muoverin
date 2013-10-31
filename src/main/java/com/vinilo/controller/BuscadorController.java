package com.vinilo.controller;

import com.vinilo.model.Cancion;
import com.vinilo.service.CancionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuscadorController {

    private CancionService cancionService;

    @Autowired
    public BuscadorController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @RequestMapping(value = "/canciones", method = RequestMethod.GET)
    @ResponseBody
    public List<Cancion> buscarTodasLasCanciones() {
        return cancionService.buscarTodas();
    }
    
    @RequestMapping(value = "/canciones/{entrada}", method = RequestMethod.GET)
    @ResponseBody
    public List<Cancion> buscarConCriteria(@PathVariable String entrada) {
        return cancionService.buscarConCriteria(entrada);
    }
}
