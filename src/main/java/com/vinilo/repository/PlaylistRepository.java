package com.vinilo.repository;

import com.vinilo.model.ListaReproduccion;
import java.util.List;

public interface PlaylistRepository {

    public List<ListaReproduccion> searchAllPlaylists();

    public ListaReproduccion searchById(Long id);

    public ListaReproduccion save(ListaReproduccion playlist);

    public void remove(ListaReproduccion playlist);
}
