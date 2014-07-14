package com.vinilo.repository.jpa;

import com.vinilo.model.Artist;
import com.vinilo.repository.ArtistRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistRepositoryJpaImpl implements ArtistRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Artist> searchAll() {
        return em.createNamedQuery("Artist.searchAll", Artist.class).getResultList();
    }

    @Override
    public Artist searchById(long id) {
        TypedQuery<Artist> query = em.createNamedQuery("Artist.searchById", Artist.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Artist save(Artist artist) {
        if (artist.getId_artist() == 0) {
            em.persist(artist);            
        } else {
            em.merge(artist);
        }
        return artist;
    }

    @Override
    public void remove(Artist artist) {
        Artist mergedArtist = em.merge(artist);
        em.remove(mergedArtist);
    }
    
}
