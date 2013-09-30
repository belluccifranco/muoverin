package com.vinilo.service;

import com.vinilo.model.ListaReproduccion;
import com.vinilo.repository.ListaReproduccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService {

    private ListaReproduccionRepository listaReproduccionRepository;

    @Autowired
    public ListaReproduccionServiceImpl(ListaReproduccionRepository listaReproduccionRepository) {
        this.listaReproduccionRepository = listaReproduccionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListaReproduccion> buscarTodas() {
        return listaReproduccionRepository.buscarTodas();
    }

    @Override
    @Transactional(readOnly = true)
    public ListaReproduccion buscarPorId(Long id) {
        return listaReproduccionRepository.buscarPorId(id);
    }

    @Override
    public ListaReproduccion guardar(ListaReproduccion listaReproduccion) {
        return listaReproduccionRepository.guardar(listaReproduccion);
    }

    @Override
    public void eliminar(ListaReproduccion listaReproduccion) {
        listaReproduccionRepository.eliminar(listaReproduccion);
    }
}
