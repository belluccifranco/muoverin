package com.vinilo.controller;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;
import com.vinilo.service.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearcherController {

    private SongService cancionService;

    @Autowired
    public SearcherController(SongService cancionService) {
        this.cancionService = cancionService;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    @ResponseBody
    public List<Song> searchAllSongs() {
        return cancionService.searchAllSongs();
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET, params = {"criteria", "index"})
    @ResponseBody
    public Pagination<Song> searchSongsWithCriteria(@RequestParam(value = "criteria") String criteria,
            @RequestParam(value = "index", defaultValue = "0") int index) {

        return cancionService.searchByCriteria(criteria, index);
    }
}
