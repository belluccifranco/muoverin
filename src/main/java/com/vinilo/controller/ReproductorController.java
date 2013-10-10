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

    private MegaHandler mh = new MegaHandler("cuentavinilo01@gmail.com", "Ninguna01");
    private CancionService cancionService;

    @Autowired
    public ReproductorController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar() {
        /*try {            
            mh.login();
        } catch (IOException ex) {
            System.out.println(ex);
        }*/
        return "home";
    }

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public String goToPlayer() {
        return "player";
    }
    
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String goApp() {
        return "app";
    }
    
    @RequestMapping(value = "/reproductor/{idCancion}", method = RequestMethod.GET)
    public void reproducirCancion(@PathVariable Long idCancion, HttpServletResponse response) {
        try {
            response.addHeader("Connection", "Keep-Alive");
            response.addHeader("Keep-Alive", "timeout=600"); //600 seg = 10 min
            response.setContentType("audio/mpeg");
            String urlMega = cancionService.buscarPorId(idCancion).getUrl();            
            mh.streamToOutputStream(urlMega, response);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
