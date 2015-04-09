package com.muoverin.controller;

import com.muoverin.exception.BusinessValidationException;
import com.muoverin.model.Album;
import com.muoverin.model.HostingAccount;
import com.muoverin.model.Pagination;
import com.muoverin.model.Song;
import com.muoverin.service.AlbumService;
import com.muoverin.service.HostingAccountService;
import com.muoverin.service.SongService;
import com.muoverin.service.SongValidator;
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
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;
    private final HostingAccountService hostingAccountService;
    
    @Autowired
    private SongValidator songValidator;
    
    @Autowired
    public SongController(SongService songService, AlbumService albumService, HostingAccountService hostingAccountService) {
        this.songService = songService;
        this.albumService = albumService;
        this.hostingAccountService = hostingAccountService;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)    
    public List<Song> searchAll() {
        return songService.searchAll();
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET, params = {"criteria", "index"})
    @ResponseStatus(HttpStatus.OK)
    public Pagination<Song> searchByCriteria(@RequestParam(value = "criteria") String criteria,
            @RequestParam(value = "index", defaultValue = "0") int index) {

        return songService.searchByCriteria(criteria, index);
    }

    @RequestMapping(value="/songs", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody @Valid Song song, HttpServletResponse response, WebRequest webRequest, BindingResult result) {
        Album album = albumService.searchById(song.getAlbum().getId_album());
        album.getSongs().add(song);
        song.setAlbum(album);
        HostingAccount hosting = hostingAccountService.searchById(song.getLink().getHostingAccount().getId_hostingAccount());
        hosting.getLinks().add(song.getLink());
        song.getLink().setHostingAccount(hosting);    
        songValidator.validate(song, result);
        if (result.hasErrors()) {
            throw new BusinessValidationException(result);
        }        
        Song createdSong = songService.save(song);        
        response.setHeader("Location", webRequest.getContextPath() + "/song/" + createdSong.getId_song());        
    }
}