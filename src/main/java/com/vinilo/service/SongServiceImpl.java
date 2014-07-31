package com.vinilo.service;

import com.vinilo.model.Pagination;
import com.vinilo.model.Song;
import com.vinilo.repository.AlbumRepository;
import com.vinilo.repository.SongRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;    
    private static final int MAX_ROWS_SEARCH = 50;

    @Autowired
    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Song> searchAll() {
        return songRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Song searchById(long id) {
        return songRepository.searchById(id);
    }

    @Override        
    @Transactional
    public Song save(Song song) {        
        return songRepository.save(song);
    }

    @Override
    public void remove(Song song) {
        songRepository.remove(song);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination<Song> searchByCriteria(String criteria, int pageIndex) {
        return songRepository.searchByCriteria(criteria, MAX_ROWS_SEARCH, pageIndex);
    }
}
