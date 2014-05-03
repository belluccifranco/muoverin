package com.vinilo.controller;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;
import com.vinilo.service.SongService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService cancionService) {
        this.songService = cancionService;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    @ResponseBody
    public List<Song> searchAllSongs() {
        return songService.searchAllSongs();
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET, params = {"criteria", "index"})
    @ResponseBody
    public Pagination<Song> searchSongsWithCriteria(@RequestParam(value = "criteria") String criteria,
            @RequestParam(value = "index", defaultValue = "0") int index) {

        return songService.searchByCriteria(criteria, index);
    }

    @RequestMapping(value = "/song", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Song uploadSong(@RequestBody @Valid Song song, HttpServletResponse response, WebRequest webRequest) {
        Song createdSong = songService.save(song);
        response.setStatus(HttpStatus.CREATED.value());
        //response.setHeader("Location", webRequest.getContextPath() + "/song/" + createdSong.getId_song());
        return createdSong;
    }
}