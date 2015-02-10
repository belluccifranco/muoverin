package com.muoverin.repository.jpa;

import com.muoverin.model.Artist;
import com.muoverin.repository.ArtistRepository;
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
        return em.createNamedQuery("Artist.allAlbums", Artist.class).getResultList();
    }

    @Override
    public Artist searchById(long id) {
        TypedQuery<Artist> query = em.createNamedQuery("Artist.artistById", Artist.class);
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
        TypedQuery<Artist> query = em.createNamedQuery("Artist.artistByName", Artist.class);
        query.setParameter("name", name.toUpperCase());
        List<Artist> artists = query.getResultList();
        if (artists.isEmpty()) {
            return null;
        } else {
            return artists.get(0);
        }
    }

    @Override
    public List<Artist> searchByNameLike(String name) {
        TypedQuery<Artist> query = em.createNamedQuery("Artist.artistByNameLike", Artist.class);        
        query.setParameter("name", "%" + name.toUpperCase() + "%");
        return query.getResultList();        
    }
}