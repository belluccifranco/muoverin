package com.muoverin.controller;

import com.muoverin.exception.BusinessValidationException;
import com.muoverin.model.Artist;
import com.muoverin.service.ArtistService;
import com.muoverin.service.ArtistValidator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    private ArtistValidator artistValidator;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> searchAll() {
        return artistService.searchAll();
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET, params = {"criteria"})
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> searchByNameLike(@RequestParam(value = "criteria") String criteria) {
        return artistService.searchByNameLike(criteria);
    }

    @RequestMapping(value = "/artists", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody @Valid Artist artist, HttpServletResponse response, WebRequest webRequest, BindingResult result) {
        artistValidator.validate(artist, result);
        if (result.hasErrors()) {
            throw new BusinessValidationException(result);
        }
        Artist createdArtist = artistService.save(artist);
        response.setHeader("Location", webRequest.getContextPath() + "/artist/" + createdArtist.getId_artist());
    }
}
