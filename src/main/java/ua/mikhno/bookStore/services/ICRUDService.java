package ua.mikhno.bookStore.services;

import ua.mikhno.bookStore.exception.IsEmptyBooksList;

import java.util.List;

public interface ICRUDService<T> {
    void create(T t) throws Exception;
    List<T> read() throws IsEmptyBooksList;
    T read(long id);

    void update(T t);

    void delete(long id);
}
