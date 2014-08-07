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
        List<Album> albums = query.getResultList();
        if (albums.isEmpty()) {
            return null;
        } else {
            return albums.get(0);
        }
    }

    @Override
    public Album save(Album album) {
        return em.merge(album);
    }

    @Override
    public void remove(Album album) {
        Album mergedAlbum = em.merge(album);
        em.remove(mergedAlbum);
    }

    @Override
    public List<Album> searchByArtists(List<Long> artists_id) {
        TypedQuery<Album> query = em.createNamedQuery("Album.searchByArtist", Album.class);
        query.setParameter("artists_id", artists_id);
        query.setParameter("artists_count", (long) artists_id.size());
        return query.getResultList();
    }

    @Override
    public Album searchByName(String name) {
        TypedQuery<Album> query = em.createNamedQuery("Album.searchByName", Album.class);
        query.setParameter("name", name);
        List<Album> albums = query.getResultList();
        if (albums.isEmpty()) {
            return null;
        } else {
            return albums.get(0);
        }
    }
}
