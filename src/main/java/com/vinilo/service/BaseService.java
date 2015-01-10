package com.vinilo.service;

import java.util.List;

public interface BaseService<T> {

    public T save(T entity);

    public void remove(T entity);

    public List<T> searchAll();

    public T searchById(long id);
}
