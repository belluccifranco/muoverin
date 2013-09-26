package com.vinilo.controller;

import com.vinilo.model.Cancion;
import com.vinilo.service.PlayerService;
import com.vinilo.service.mega.MegaHandler;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController {

    private MegaHandler mh = new MegaHandler("belluccifranco@gmail.com", "mega01");
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        try {
            List<Cancion> canciones = playerService.buscarTodasLasCanciones();
            mh.login();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return "home";
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public void playMusic(HttpServletResponse response) {
        try {
            //"https://mega.co.nz/#!5VRhBA4C!EOoONX5nCjzhkqdsmLkX0XkKbuxYALsCvvrkX8psoR0"
            //"https://mega.co.nz/#!AUIRxSqS!FYZsZEPIISDuqz6eDTDTGD_WNBBH9SHnu8yCVnXiykk"

            response.addHeader("Connection", "Keep-Alive");
            response.addHeader("Keep-Alive", "timeout=600"); //600 seg = 10 min
            response.setContentType("audio/mpeg");
            String urlMega = "https://mega.co.nz/#!AUIRxSqS!FYZsZEPIISDuqz6eDTDTGD_WNBBH9SHnu8yCVnXiykk";
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
