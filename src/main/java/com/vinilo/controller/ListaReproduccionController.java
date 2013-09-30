package com.vinilo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListaReproduccionController {
    
    @RequestMapping(value = "/listasReproduccion", method = RequestMethod.GET)
    public String mostrar(@PathVariable("id") Long id, Model uiMode) {
        
        return "";
    }
}
