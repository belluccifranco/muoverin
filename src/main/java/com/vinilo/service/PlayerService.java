package com.vinilo.service;

import com.vinilo.model.Cancion;
import java.util.List;

public interface PlayerService {

    public List<Cancion> buscarTodasLasCanciones();

    public List<Cancion> buscarTodasLasCancionesConDetalles();

    public Cancion buscarCancionPorId(Long id);

    public Cancion guardarCancion(Cancion cancion);

    public void eliminarCancion(Cancion cancion);
}
