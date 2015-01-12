package com.muoverin.service;

import com.muoverin.model.Song;
import com.muoverin.model.Pagination;

public interface SongService extends BaseService<Song> {

    public Pagination<Song> searchByCriteria(String criteria, int pageIndex);
}
