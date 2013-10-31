package com.vinilo.repository;

import com.vinilo.model.Cancion;
import com.vinilo.model.CancionBusquedaCriteria;
import java.util.List;

public interface CancionRepository {

    public List<Cancion> buscarTodas();

    public Cancion buscarPorId(Long id);

    public Cancion guardar(Cancion cancion);

    public void eliminar(Cancion cancion);
    
    public List<Cancion> buscarConCriteria(CancionBusquedaCriteria criteria);
}
