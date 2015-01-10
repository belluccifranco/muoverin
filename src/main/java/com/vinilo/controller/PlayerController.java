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

    private final SongService songService;
    private static final Logger logger = Logger.getLogger(PlayerController.class);

    @Autowired
    public PlayerController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping(value = "/player/{idSong}", method = RequestMethod.GET)
    public void playSong(@PathVariable long idSong, HttpServletResponse response) {
        try {
            MegaHandler mh = new MegaHandler();
            String urlStorage = songService.searchById(idSong).getLink().getUrl();
            response.setContentType("audio/mpeg");
            int contentLength = mh.getContentLength(urlStorage);
            response.setContentLength(contentLength);            
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Range", "bytes 0-" + (contentLength - 1) + "/" + contentLength);
            mh.downloadToOutputStream(urlStorage, response.getOutputStream());

        } catch (Exception ex) {
            logger.error(ex);
        }
    }
}
