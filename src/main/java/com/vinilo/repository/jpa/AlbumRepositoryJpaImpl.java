package com.vinilo.repository.jpa;

import com.vinilo.model.Album;
import com.vinilo.repository.AlbumRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumRepositoryJpaImpl implements AlbumRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Album> searchAll() {
        return em.createNamedQuery("Album.searchAll", Album.class).getResultList();
    }

    @Override
    public Album searchById(long id) {
        TypedQuery<Album> query = em.createNamedQuery("Album.searchById", Album.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Album save(Album album) {
        if (album.getId_album() == 0) {
            em.persist(album);
        } else {
            em.merge(album);
        }
        return album;
    }

    @Override
    public void remove(Album album) {
        Album mergedAlbum = em.merge(album);
        em.remove(mergedAlbum);
    }

    @Override
    public List<Album> searchByArtist(long id_artist) {
        TypedQuery<Album> query = em.createNamedQuery("Album.searchByArtist", Album.class);
        query.setParameter("id_artist", id_artist);
        return query.getResultList();
    }

}
