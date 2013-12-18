package com.vinilo.repository.jpa;

import com.vinilo.model.CuentaUsuario;
import com.vinilo.repository.CuentaUsuarioRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaUsuarioRepositoryJpaImpl implements CuentaUsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public CuentaUsuario buscarUsuarioPorNombre(String nombre) {
        TypedQuery<CuentaUsuario> query = em.createNamedQuery("CuentaUsuario.buscarUsuarioPorNombre", CuentaUsuario.class);
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }
}