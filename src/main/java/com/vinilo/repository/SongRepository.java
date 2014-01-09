package com.vinilo.repository;

import com.vinilo.model.Cancion;
import com.vinilo.model.Paginacion;
import java.util.List;

public interface SongRepository {

    public List<Cancion> searchAllSongs();

    public Cancion searchById(Long id);

    public Cancion save(Cancion song);

    public void remove(Cancion song);

    public Paginacion<Cancion> searchByCriteria(String criteria, int maxResultsPerPage, int pageIndex);
}
