package com.vinilo.service;

import com.vinilo.model.ListaReproduccion;
import java.util.List;

public interface ListaReproduccionService {
    
    public List<ListaReproduccion> buscarTodas();
    
    public ListaReproduccion buscarPorId(Long id);
    
    public ListaReproduccion guardar(ListaReproduccion listaReproduccion);

    public void eliminar(ListaReproduccion listaReproduccion);
}
