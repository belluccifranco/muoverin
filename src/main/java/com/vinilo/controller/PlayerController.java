package com.vinilo.controller;

import com.vinilo.service.SongService;
import com.vinilo.service.mega.MegaHandler;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController {

    private SongService cancionService;
    private static final Logger logger = Logger.getLogger(PlayerController.class);

    @Autowired
    public PlayerController(SongService cancionService) {
        this.cancionService = cancionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoMainPage() {
        return "main";
    }

    @RequestMapping(value = "/player/{idSong}", method = RequestMethod.GET)
    public void playSong(@PathVariable Long idSong, HttpServletResponse response) {
        try {
            response.addHeader("Connection", "Keep-Alive");
            response.addHeader("Keep-Alive", "timeout=600"); //600 seg = 10 min
            response.setContentType("audio/mpeg");
            MegaHandler mh = new MegaHandler("a", "a");
            String urlStorage = cancionService.searchById(idSong).getLinks().get(0).getUrl();
            mh.streamToOutputStream(urlStorage, response);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
