package com.vinilo.repository;

import com.vinilo.model.Cancion;
import com.vinilo.model.Paginacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
    public Paginacion<Cancion> buscarConCriteria(String criteria, int cantRegistrosPorPagina, int indicePagina) {
        Paginacion<Cancion> paginacion = new Paginacion<Cancion>();
        paginacion.setPagActual(indicePagina);
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Cancion> query = builder.createQuery(Cancion.class);
        Root<Cancion> cancion = query.from(Cancion.class);
        Predicate likeCancion = builder.like(builder.upper(cancion.<String>get("nombre")), "%" + criteria.toUpperCase() + "%");
        Predicate likeArtista = builder.like(builder.upper(cancion.get("artista").<String>get("nombre")), "%" + criteria.toUpperCase() + "%");
        Predicate likeAlbum = builder.like(builder.upper(cancion.get("album").<String>get("nombre")), "%" + criteria.toUpperCase() + "%");
        query.select(cancion);
        query.where(builder.or(likeAlbum, likeCancion, likeArtista));
        TypedQuery<Cancion> typedQuery = em.createQuery(query);
        typedQuery.setMaxResults(cantRegistrosPorPagina);
        typedQuery.setFirstResult((indicePagina-1) * cantRegistrosPorPagina);
        List<Cancion> datos = typedQuery.getResultList();
        paginacion.setDatos(datos);
        paginacion.setCantRegistrosPagActual(datos.size());
        
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(Cancion.class)));
        countQuery.where(builder.or(likeAlbum, likeCancion, likeArtista));
        paginacion.setCantRegistrosTotales(em.createQuery(countQuery).getSingleResult());
        
        double cantTotal = paginacion.getCantRegistrosTotales();
        Double resultado = cantTotal/cantRegistrosPorPagina;
        if (resultado > 1.0) {
            resultado++;
        } else {
            resultado = 1.0;
        }        
        paginacion.setCantPaginas(resultado.longValue());        
        return paginacion;
    }
}
