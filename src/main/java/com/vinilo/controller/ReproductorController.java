package com.vinilo.controller;

import com.vinilo.service.CancionService;
import com.vinilo.service.mega.MegaHandler;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReproductorController {

    private CancionService cancionService;

    @Autowired
    public ReproductorController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar() {
        return "app";
    }

    @RequestMapping(value = "/reproductor/{idCancion}", method = RequestMethod.GET)
    public void reproducirCancion(@PathVariable Long idCancion, HttpServletResponse response) {
        try {
            response.addHeader("Connection", "Keep-Alive");
            response.addHeader("Keep-Alive", "timeout=600"); //600 seg = 10 min
            response.setContentType("audio/mpeg");
            MegaHandler mh = new MegaHandler("a", "a");
            String urlStorage = cancionService.buscarPorId(idCancion).getLinks().get(0).getUrl();
            mh.streamToOutputStream(urlStorage, response);
        } catch (Exception ex) {
            //Silenciadas las exceptions
            //System.out.println(ex);
        }
    }
}
