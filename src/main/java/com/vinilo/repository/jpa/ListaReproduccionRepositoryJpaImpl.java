package com.vinilo.repository.jpa;

import com.vinilo.model.ListaReproduccion;
import com.vinilo.repository.PlaylistRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ListaReproduccionRepositoryJpaImpl implements PlaylistRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListaReproduccion> searchAllPlaylists() {
        List<ListaReproduccion> listasReproduccion = em.createNamedQuery("ListaReproduccion.buscarTodas", ListaReproduccion.class).getResultList();
        return listasReproduccion;
    }

    @Override
    public ListaReproduccion searchById(Long id) {
        TypedQuery<ListaReproduccion> query = em.createNamedQuery("ListaReproduccion.buscarPorId", ListaReproduccion.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ListaReproduccion save(ListaReproduccion listaReproduccion) {
        if (listaReproduccion.getId_listaReproduccion() == null) {            
            em.persist(listaReproduccion);
        } else {
            em.merge(listaReproduccion);            
        }        
        return listaReproduccion;
    }

    @Override
    public void remove(ListaReproduccion listaReproduccion) {
        ListaReproduccion mergedListaReproduccion = em.merge(listaReproduccion);
        em.remove(mergedListaReproduccion);
    }
}
