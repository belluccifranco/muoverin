package com.vinilo.repository.jpa;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;
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
    public List<Song> searchAll() {
        return em.createNamedQuery("Song.searchAll", Song.class).getResultList();
    }

    @Override
    public Song searchById(long id) {
        TypedQuery<Song> query = em.createNamedQuery("Song.searchById", Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Song save(Song song) {
        if (song.getId_song() == 0) {
            em.persist(song);            
        } else {
            em.merge(song);
        }
        return song;
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

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Song> query = builder.createQuery(Song.class);
        Root<Song> song = query.from(Song.class);
        Predicate likeSong = builder.like(builder.upper(song.<String>get("name")), "%" + criteria.toUpperCase() + "%");
        Predicate likeArtist = builder.like(builder.upper(song.get("artist").<String>get("name")), "%" + criteria.toUpperCase() + "%");
        Predicate likeAlbum = builder.like(builder.upper(song.get("album").<String>get("name")), "%" + criteria.toUpperCase() + "%");
        query.select(song);
        query.where(builder.or(likeAlbum, likeSong, likeArtist));
        TypedQuery<Song> typedQuery = em.createQuery(query);
        typedQuery.setMaxResults(maxResultsPerPage);
        typedQuery.setFirstResult((pageIndex - 1) * maxResultsPerPage);
        List<Song> data = typedQuery.getResultList();
        pagination.setData(data);
        pagination.setRowsInCurrentPage(data.size());

        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(Song.class)));
        countQuery.where(builder.or(likeAlbum, likeSong, likeArtist));
        pagination.setTotalRows(em.createQuery(countQuery).getSingleResult());

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
