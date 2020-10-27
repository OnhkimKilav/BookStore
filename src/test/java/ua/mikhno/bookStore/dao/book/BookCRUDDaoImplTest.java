package ua.mikhno.bookStore.dao.book;

import ua.mikhno.bookStore.models.Book;
import ua.mikhno.bookStore.models.Genre;
import org.junit.Assert;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BookCRUDDaoImplTest {
    private BookCRUDDAOImpl crud = new BookCRUDDAOImpl();

    @org.junit.Test
    @Transactional
    @Rollback()
    public void save() throws Exception {
        Book book = new Book(
                "Мастер и Маргарита",
                new Date(),
                "Хороша книга",
                Genre.ROMANCE_NOVEL,
                true,
                355.5,
                true,
                false);
        crud.save(book);

        Book book1 = new Book();

        List<Book> books = crud.findAll();
        Assert.assertEquals(1, books.size());
        Assert.assertEquals(book.getTitle(), books.get(0).getTitle());
    }

    @org.junit.Test
    @Transactional
    @Rollback()
    public void findAll() throws ParseException {
        List<Book> booksDb = crud.findAll();
        Assert.assertEquals(1, booksDb.size());
    }

    @org.junit.Test
    @Transactional
    @Rollback()
    public void findById() {
        Book book = crud.findById(29);
        Assert.assertEquals(29, book.getId());
    }

    @org.junit.Test
    @Transactional
    @Rollback()
    public void update() {
        Book book = (Book) crud.findById(31);
        book.setDiscount(true);

        crud.update(book);

        List<Book> booksDb = crud.findAll();

        Assert.assertEquals(book, booksDb.get(0));
    }

    @org.junit.Test
    @Transactional
    @Rollback()
    public void delete() {
        crud.delete(32);
        Assert.assertEquals(new ArrayList<>(),crud.findAll());
    }
}