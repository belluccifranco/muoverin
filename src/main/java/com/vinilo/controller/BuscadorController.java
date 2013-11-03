package com.vinilo.controller;

import com.vinilo.model.Cancion;
import com.vinilo.service.CancionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/canciones", method = RequestMethod.GET, params = {"criteria", "indice"})
    @ResponseBody
    public List<Cancion> buscarConCriteria(@RequestParam(value = "criteria") String criteria,
            @RequestParam(value = "indice", defaultValue = "1") int indice) {

        return cancionService.buscarConCriteria(criteria, indice);
    }
}
