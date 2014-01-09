package com.vinilo.service;

import com.vinilo.model.Cancion;
import com.vinilo.model.Paginacion;
import com.vinilo.repository.SongRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private static final int MAX_ROWS_SEARCH = 3;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> searchAllSongs() {
        return songRepository.searchAllSongs();
    }

    @Override
    @Transactional(readOnly = true)
    public Cancion searchById(Long id) {
        return songRepository.searchById(id);
    }

    @Override
    public Cancion save(Cancion cancion) {
        return songRepository.save(cancion);
    }

    @Override
    public void remove(Cancion cancion) {
        songRepository.remove(cancion);
    }

    @Override
    @Transactional(readOnly = true)
    public Paginacion<Cancion> searchByCriteria(String criteria, int pageIndex) {
        return songRepository.searchByCriteria(criteria, MAX_ROWS_SEARCH, pageIndex);
    }
}
