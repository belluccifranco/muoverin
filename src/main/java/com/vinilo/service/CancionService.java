package com.vinilo.service;

import com.vinilo.model.Cancion;
import java.util.List;

public interface CancionService {

    public List<Cancion> buscarTodas();

    public Cancion buscarPorId(Long id);

    public Cancion guardar(Cancion cancion);

    public void eliminar(Cancion cancion);
}
