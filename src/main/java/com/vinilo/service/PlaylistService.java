package com.vinilo.service;

import com.vinilo.model.ListaReproduccion;
import java.util.List;

public interface PlaylistService {
    
    public List<ListaReproduccion> searchAllPlaylists();
    
    public ListaReproduccion searchById(Long id);
    
    public ListaReproduccion save(ListaReproduccion playlist);

    public void remove(ListaReproduccion playlist);
}
