package com.vinilo.repository.jpa;

import com.vinilo.model.Playlist;
import com.vinilo.repository.PlaylistRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class PlaylistRepositoryJpaImpl implements PlaylistRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Playlist> searchAllPlaylists() {
        List<Playlist> playlists = em.createNamedQuery("Playlist.searchAllPlaylists", Playlist.class).getResultList();
        return playlists;
    }

    @Override
    public Playlist searchById(Long id) {
        TypedQuery<Playlist> query = em.createNamedQuery("Playlist.searchById", Playlist.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Playlist save(Playlist playlist) {
        if (playlist.getId_playlist() == null) {            
            em.persist(playlist);
        } else {
            em.merge(playlist);            
        }        
        return playlist;
    }

    @Override
    public void remove(Playlist playlist) {
        Playlist mergedPlaylist = em.merge(playlist);
        em.remove(mergedPlaylist);
    }
}
