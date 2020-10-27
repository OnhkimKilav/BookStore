package ua.mikhno.bookStore.dao.book;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mikhno.bookStore.dao.ICRUDDAO;
import ua.mikhno.bookStore.models.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BookCRUDDAOImpl implements ICRUDDAO<Book> {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Method for save new book to DB
     *
     * @param book object to save to DB
     * @return book object
     */
    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }


    /**
     * Method for find all books to DB
     * And they return to collections
     *
     * @return list books from db
     */
    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT a FROM Book a", Book.class).getResultList();
    }

    /**
     * Find book by id
     *
     * @param id books to db
     * @return book for this id
     */
    @Override
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }


    /**
     * Update existing book to db
     *
     * @param book with changes
     */
    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    /**
     * Delete book to DB by id
     *
     * @param id book which already create to db
     */
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Book.class, id));
    }
}