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
    public List<Playlist> searchAll() {
        List<Playlist> playlists = em.createNamedQuery("Playlist.searchAll", Playlist.class).getResultList();
        return playlists;
    }

    @Override
    public Playlist searchById(long id) {
        TypedQuery<Playlist> query = em.createNamedQuery("Playlist.searchById", Playlist.class);
        query.setParameter("id", id);        
        List<Playlist> playlists = query.getResultList();        
        if (playlists.isEmpty()) {
            return null;
        } else {
            return playlists.get(0);
        }
    }

    @Override
    public Playlist save(Playlist playlist) {
        if (playlist.getId_playlist() == 0) {            
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
