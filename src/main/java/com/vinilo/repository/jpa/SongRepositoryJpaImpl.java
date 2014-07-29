package com.vinilo.repository.jpa;

import com.vinilo.model.Pagination;
import com.vinilo.model.Song;
import com.vinilo.repository.SongRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class SongRepositoryJpaImpl implements SongRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Song> searchAll() {
        return em.createNamedQuery("Song.searchAll", Song.class).getResultList();
    }

    @Override
    public Song searchById(long id) {
        TypedQuery<Song> query = em.createNamedQuery("Song.searchById", Song.class);
        query.setParameter("id", id);
        List<Song> songs = query.getResultList();
        if (songs.isEmpty()) {
            return null;
        } else {
            return songs.get(0);
        }
    }

    @Override
    public Song save(Song song) {
        return em.merge(song);
    }

    @Override
    public void remove(Song song) {
        Song mergedSong = em.merge(song);
        em.remove(mergedSong);
    }

    @Override
    public Pagination<Song> searchByCriteria(String criteria, int maxResultsPerPage, int pageIndex) {
        Pagination<Song> pagination = new Pagination<>();
        pagination.setCurrentPage(pageIndex);

        criteria = "%" + criteria.toUpperCase() + "%";
        TypedQuery<Long> countQuery = em.createNamedQuery("Song.countCriteria", Long.class);
        countQuery.setParameter("songName", criteria);
        countQuery.setParameter("albumName", criteria);
        countQuery.setParameter("artistName", criteria);
        pagination.setTotalRows(countQuery.getSingleResult());

        TypedQuery<Song> criteriaQuery = em.createNamedQuery("Song.searchByCriteria", Song.class);
        criteriaQuery.setParameter("songName", criteria);
        criteriaQuery.setParameter("albumName", criteria);
        criteriaQuery.setParameter("artistName", criteria);
        criteriaQuery.setMaxResults(maxResultsPerPage);
        criteriaQuery.setFirstResult((pageIndex - 1) * maxResultsPerPage);
        List<Song> data = criteriaQuery.getResultList();
        pagination.setData(data);
        pagination.setRowsInCurrentPage(data.size());

        double total = pagination.getTotalRows();
        Double result = total / maxResultsPerPage;
        if (result > 1.0) {
            result++;
        } else {
            result = 1.0;
        }
        pagination.setPages(result.longValue());
        return pagination;
    }
}
