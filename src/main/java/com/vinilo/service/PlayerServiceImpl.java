package com.vinilo.service;

import com.vinilo.model.Cancion;
import com.vinilo.repository.CancionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private CancionRepository cancionRepository;

    @Autowired
    public PlayerServiceImpl(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> buscarTodasLasCanciones() {
        return cancionRepository.buscarTodas();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> buscarTodasLasCancionesConDetalles() {
        return cancionRepository.buscarTodasConDetalles();
    }

    @Override
    @Transactional(readOnly = true)
    public Cancion buscarCancionPorId(Long id) {
        return cancionRepository.buscarPorId(id);
    }

    @Override
    public Cancion guardarCancion(Cancion cancion) {
        return cancionRepository.guardar(cancion);
    }

    @Override
    public void eliminarCancion(Cancion cancion) {
        cancionRepository.eliminar(cancion);
    }
}
