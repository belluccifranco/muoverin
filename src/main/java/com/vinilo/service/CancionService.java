package com.vinilo.service;

import com.vinilo.model.Cancion;
import com.vinilo.model.Paginacion;
import java.util.List;

public interface CancionService {

    public List<Cancion> buscarTodas();

    public Cancion buscarPorId(Long id);

    public Cancion guardar(Cancion cancion);

    public void eliminar(Cancion cancion);

    public Paginacion<Cancion> buscarPorNombreCancionNombreArtistaNormbreAlbum(String criteria, int indicePagina);
}
