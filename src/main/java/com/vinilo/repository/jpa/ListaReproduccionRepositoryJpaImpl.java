package com.vinilo.repository.jpa;

import com.vinilo.model.ListaReproduccion;
import com.vinilo.repository.ListaReproduccionRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ListaReproduccionRepositoryJpaImpl implements ListaReproduccionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListaReproduccion> buscarTodas() {
        List<ListaReproduccion> listasReproduccion = em.createNamedQuery("ListaReproduccion.buscarTodas", ListaReproduccion.class).getResultList();
        return listasReproduccion;
    }

    @Override
    public ListaReproduccion buscarPorId(Long id) {
        TypedQuery<ListaReproduccion> query = em.createNamedQuery("ListaReproduccion.buscarPorId", ListaReproduccion.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ListaReproduccion guardar(ListaReproduccion listaReproduccion) {
        if (listaReproduccion.getId_listaReproduccion() == null) {
            //log.info("Inserting new contact");
            em.persist(listaReproduccion);
        } else {
            em.merge(listaReproduccion);
            //log.info("Updating existing contact");
        }
        //log.info("Contact saved with id: " + contact.getId());
        return listaReproduccion;
    }

    @Override
    public void eliminar(ListaReproduccion listaReproduccion) {
        ListaReproduccion mergedListaReproduccion = em.merge(listaReproduccion);
        em.remove(mergedListaReproduccion);
    }
}
