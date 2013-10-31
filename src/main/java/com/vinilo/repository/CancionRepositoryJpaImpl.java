package com.vinilo.repository;

import com.vinilo.model.Album;
import com.vinilo.model.Artista;
import com.vinilo.model.Cancion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class CancionRepositoryJpaImpl implements CancionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cancion> buscarTodas() {
        List<Cancion> canciones = em.createNamedQuery("Cancion.buscarTodas", Cancion.class).getResultList();
        return canciones;
    }

    @Override
    public Cancion buscarPorId(Long id) {
        TypedQuery<Cancion> query = em.createNamedQuery("Cancion.buscarPorId", Cancion.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Cancion guardar(Cancion cancion) {
        if (cancion.getId_cancion() == null) {
            //log.info("Inserting new contact");
            em.persist(cancion);
        } else {
            em.merge(cancion);
            //log.info("Updating existing contact");
        }
        //log.info("Contact saved with id: " + contact.getId());
        return cancion;
    }

    @Override
    public void eliminar(Cancion cancion) {
        Cancion mergedCancion = em.merge(cancion);
        em.remove(mergedCancion);
        //log.info("Contact with id: " + contact.getId() + " deleted successfully");
    }

    @Override
    public List<Cancion> buscarConCriteria(String criteria) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Cancion> query = builder.createQuery(Cancion.class);
        Root<Cancion> cancion = query.from(Cancion.class);
        Join<Cancion, Artista> artista = cancion.join("artista");
        Join<Cancion, Album> album = cancion.join("album");

        List<Predicate> conditions = new ArrayList();
        conditions.add(builder.like(builder.upper(cancion.<String>get("nombre")), "%" + criteria.toUpperCase() + "%"));
        conditions.add(builder.like(builder.upper(artista.<String>get("nombre")), "%" + criteria.toUpperCase() + "%"));
        conditions.add(builder.like(builder.upper(album.<String>get("nombre")), "%" + criteria.toUpperCase() + "%"));

        query.where(builder.or(conditions.toArray(new Predicate[]{})));
        TypedQuery<Cancion> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
}
