package com.vinilo.repository.jpa;

import com.vinilo.model.Cancion;
import com.vinilo.model.Paginacion;
import com.vinilo.repository.SongRepository;
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
public class SongRepositoryJpaImpl implements SongRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cancion> searchAllSongs() {
        List<Cancion> songs = em.createNamedQuery("Cancion.buscarTodas", Cancion.class).getResultList();
        return songs;
    }

    @Override
    public Cancion searchById(Long id) {
        TypedQuery<Cancion> query = em.createNamedQuery("Cancion.buscarPorId", Cancion.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Cancion save(Cancion song) {
        if (song.getId_cancion() == null) {            
            em.persist(song);
        } else {
            em.merge(song);            
        }        
        return song;
    }

    @Override
    public void remove(Cancion song) {
        Cancion mergedSong = em.merge(song);
        em.remove(mergedSong);        
    }

    @Override
    public Paginacion<Cancion> searchByCriteria(String criteria, int maxResultsPerPage, int pageIndex) {
        Paginacion<Cancion> pagination = new Paginacion<Cancion>();
        pagination.setPagActual(pageIndex);
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Cancion> query = builder.createQuery(Cancion.class);
        Root<Cancion> song = query.from(Cancion.class);
        Predicate likeSong = builder.like(builder.upper(song.<String>get("nombre")), "%" + criteria.toUpperCase() + "%");
        Predicate likeArtist = builder.like(builder.upper(song.get("artista").<String>get("nombre")), "%" + criteria.toUpperCase() + "%");
        Predicate likeAlbum = builder.like(builder.upper(song.get("album").<String>get("nombre")), "%" + criteria.toUpperCase() + "%");
        query.select(song);
        query.where(builder.or(likeAlbum, likeSong, likeArtist));
        TypedQuery<Cancion> typedQuery = em.createQuery(query);
        typedQuery.setMaxResults(maxResultsPerPage);
        typedQuery.setFirstResult((pageIndex-1) * maxResultsPerPage);
        List<Cancion> data = typedQuery.getResultList();
        pagination.setDatos(data);
        pagination.setCantRegistrosPagActual(data.size());
        
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(Cancion.class)));
        countQuery.where(builder.or(likeAlbum, likeSong, likeArtist));
        pagination.setCantRegistrosTotales(em.createQuery(countQuery).getSingleResult());
        
        double total = pagination.getCantRegistrosTotales();
        Double result = total/maxResultsPerPage;
        if (result > 1.0) {
            result++;
        } else {
            result = 1.0;
        }        
        pagination.setCantPaginas(result.longValue());        
        return pagination;
    }
}
