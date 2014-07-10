package com.vinilo.service;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;
import com.vinilo.repository.SongRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private static final int MAX_ROWS_SEARCH = 10;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Song> searchAllSongs() {
        return songRepository.searchAllSongs();
    }

    @Override
    @Transactional(readOnly = true)
    public Song searchById(Long id) {
        return songRepository.searchById(id);
    }

    @Override        
    @Transactional
    public Song save(Song cancion) {
        return songRepository.save(cancion);
    }

    @Override
    public void remove(Song cancion) {
        songRepository.remove(cancion);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination<Song> searchByCriteria(String criteria, int pageIndex) {
        return songRepository.searchByCriteria(criteria, MAX_ROWS_SEARCH, pageIndex);
    }
}
