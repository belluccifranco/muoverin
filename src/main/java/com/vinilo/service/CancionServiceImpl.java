package com.vinilo.service;

import com.vinilo.model.Cancion;
import com.vinilo.repository.CancionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancionServiceImpl implements CancionService {

    private CancionRepository cancionRepository;

    @Autowired
    public CancionServiceImpl(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> buscarTodas() {
        return cancionRepository.buscarTodas();
    }

    @Override
    @Transactional(readOnly = true)
    public Cancion buscarPorId(Long id) {
        return cancionRepository.buscarPorId(id);
    }

    @Override
    public Cancion guardar(Cancion cancion) {
        return cancionRepository.guardar(cancion);
    }

    @Override
    public void eliminar(Cancion cancion) {
        cancionRepository.eliminar(cancion);
    }

    @Override
    public List<Cancion> buscarConCriteria(String criteria) {
        return cancionRepository.buscarConCriteria(criteria);
    }
}
