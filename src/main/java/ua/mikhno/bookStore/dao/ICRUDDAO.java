package ua.mikhno.bookStore.dao;

import java.util.List;

public interface ICRUDDAO<T>{
    void save(T t);
    List<T> findAll();
    T findById(long id);
    void update(T t);
    void delete(long id);
}
