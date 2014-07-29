package com.vinilo.controller;

import com.vinilo.model.Album;
import com.vinilo.model.Pagination;
import com.vinilo.model.Song;
import com.vinilo.service.AlbumService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    @Autowired
    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)    
    public @ResponseBody List<Song> searchAll() {
        return songService.searchAll();
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET, params = {"criteria", "index"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Pagination<Song> searchByCriteria(@RequestParam(value = "criteria") String criteria,
            @RequestParam(value = "index", defaultValue = "0") int index) {

        return songService.searchByCriteria(criteria, index);
    }

    @RequestMapping(value="/song", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Song upload(@RequestBody @Valid Song song, HttpServletResponse response, WebRequest webRequest) {
        Album album = albumService.searchById(song.getAlbum().getId_album());
        album.getSongs().add(song);
        song.setAlbum(album);        
        Song createdSong = songService.save(song);        
        response.setHeader("Location", webRequest.getContextPath() + "/song/" + createdSong.getId_song());
        return createdSong;
    }
}