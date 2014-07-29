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
        List<Artist> artists = query.getResultList();
        if (artists.isEmpty()) {
            return null;
        } else {
            return artists.get(0);
        }
    }

    @Override
    public Artist save(Artist artist) {
        return em.merge(artist);
    }

    @Override
    public void remove(Artist artist) {
        Artist mergedArtist = em.merge(artist);
        em.remove(mergedArtist);
    }

    @Override
    public Artist searchByName(String name) {
        TypedQuery<Artist> query = em.createNamedQuery("Artist.searchByName", Artist.class);
        query.setParameter("name", name);
        List<Artist> artists = query.getResultList();
        if (artists.isEmpty()) {
            return null;
        } else {
            return artists.get(0);
        }
    }
}