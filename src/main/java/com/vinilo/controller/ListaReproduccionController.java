package com.vinilo.controller;

import com.vinilo.model.ListaReproduccion;
import com.vinilo.service.ListaReproduccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ListaReproduccionController {

    @Autowired
    private ListaReproduccionService listaReproduccionService;
    
    @RequestMapping(value = "/listasReproduccion", method = RequestMethod.GET)
    @ResponseBody 
    public List<ListaReproduccion> buscarTodas() {
        return listaReproduccionService.buscarTodas();
    }
    
    @RequestMapping(value = "/listaReproduccion/{id}", method = RequestMethod.GET)
    @ResponseBody 
    public ListaReproduccion buscarPorId(@PathVariable Long id) {
        return listaReproduccionService.buscarPorId(id);
    }
}
