package com.vinilo.controller;

import com.vinilo.model.Artist;
import com.vinilo.service.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Artist> searchAll() {
        return artistService.searchAll();
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET, params = {"criteria"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Artist> searchByNameLike(@RequestParam(value = "criteria") String criteria) {
        return artistService.searchByNameLike(criteria);
    }

}
