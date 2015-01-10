package com.vinilo.service;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;

public interface SongService extends BaseService<Song> {

    public Pagination<Song> searchByCriteria(String criteria, int pageIndex);
}
