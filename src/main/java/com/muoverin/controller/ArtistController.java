package com.muoverin.controller;

import com.muoverin.model.Artist;
import com.muoverin.service.ArtistService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

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
    
    @RequestMapping(value="/artist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody @Valid Artist artist, HttpServletResponse response, WebRequest webRequest, BindingResult result) {        
        Artist createdArtist = artistService.save(artist);
        response.setHeader("Location", webRequest.getContextPath() + "/artist/" + createdArtist.getId_artist());
    }
}
