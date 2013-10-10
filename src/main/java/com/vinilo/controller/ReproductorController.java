package com.vinilo.controller;

import com.vinilo.model.Cancion;
import com.vinilo.service.CancionService;
import com.vinilo.service.mega.MegaHandler;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReproductorController {

    private MegaHandler mh = new MegaHandler("cuentavinilo01@gmail.com", "Ninguna01");
    private CancionService CancionService;

    @Autowired
    public ReproductorController(CancionService cancionService) {
        this.CancionService = cancionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        try {
            //List<Cancion> canciones = CancionService.buscarTodas();
            mh.login();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return "home";
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public void playMusic(HttpServletResponse response) {
        try {
            response.addHeader("Connection", "Keep-Alive");
            response.addHeader("Keep-Alive", "timeout=600"); //600 seg = 10 min
            response.setContentType("audio/mpeg");
            String urlMega = "https://mega.co.nz/#!u05HDKSC!DauTn0lUVaUOjauoxXXqpk5Y4qYi3wVCA46XLZbontk";
            mh.streamToOutputStream(urlMega, response);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public String goToPlayer() {
        return "player";
    }
    
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String goApp() {
        return "app";
    }
}
