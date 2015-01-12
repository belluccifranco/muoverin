package com.muoverin.repository;

import java.util.List;

public interface BaseRepository<T> {

    public T save(T entity);

    public void remove(T entity);

    public List<T> searchAll();

    public T searchById(long id);
}
