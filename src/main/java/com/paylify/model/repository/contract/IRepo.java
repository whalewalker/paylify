package com.paylify.model.repository.contract;

import org.springframework.data.domain.Page;

public interface IRepo<T> {
    T create(T t);

    Page<T> getAll(int pageNum, int pageSize);

    T getById(long id);

    T update(T t);

    void delete(long id);
}
