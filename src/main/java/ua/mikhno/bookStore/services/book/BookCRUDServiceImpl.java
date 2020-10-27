package ua.mikhno.bookStore.services.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mikhno.bookStore.dao.book.BookCRUDDAOImpl;
import ua.mikhno.bookStore.exception.IdenticalBookToDBException;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Book;
import ua.mikhno.bookStore.services.ICRUDService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookCRUDServiceImpl implements ICRUDService<Book> {

    private BookCRUDDAOImpl bookCRUDDAO;

    @Autowired
    public BookCRUDServiceImpl(BookCRUDDAOImpl bookCRUDDAO) {
        this.bookCRUDDAO = bookCRUDDAO;
    }

    /**
     * This method implements the save a book to the database.
     * Before saving the book to the database
     * method checks if there is a duplicate of this book in the database
     *
     * @param book
     * @throws IdenticalBookToDBException
     */
    @Override
    public void create(Book book) throws IdenticalBookToDBException {
        checkCreateBook(book);

        if (book.getReleaseDate() == null)
            book.setReleaseDate(new Date());

        bookCRUDDAO.save(book);
    }

    /**
     * This method implements the read the all books from the database.
     * Before reading a books from the database,
     * the method checks if the any book exists in the database.
     *
     * @return list books
     * @throws IsEmptyBooksList
     */
    @Override
    public List<Book> read() throws IsEmptyBooksList {
        List<Book> books = bookCRUDDAO.findAll();
        checkListBooksOnEmpty(books);

        return books;
    }

    /**
     * This method implements the read the book by id from the database.
     * Before reading a book from the database,
     * the method checks if the book exists in the database.
     *
     * @param id books
     * @return book from database
     */
    @Override
    public Book read(long id) {
        Book book = checkFindByIdOnNull(id);

        return book;
    }

    /**
     * This method implements the update the book to the database.
     * Before updating a book to the database,
     * the method checks if the book exists in the database.
     *
     * @param book
     */
    @Override
    public void update(Book book) {
        checkFindByIdOnNull(book.getId());

        bookCRUDDAO.update(book);
    }

    /**
     * This method implements the deletion of a book from the database.
     * Before deleting a book from the database,
     * the method checks if the book exists in the database.
     *
     * @param id books
     */
    @Override
    public void delete(long id) {
        checkFindByIdOnNull(id);

        bookCRUDDAO.delete(id);
    }

    /**
     * To check a book for a duplicate in the database
     *
     * This method checks the book that the user wants to save to the database
     * if this book has already been created in the database,
     * then the system throws an exception
     *
     * Validation is done using Strem for Collections.
     *
     * @param book which we want save
     * @throws Exception
     */
    private void checkCreateBook(Book book) throws IdenticalBookToDBException {
        List<Book> books = bookCRUDDAO.findAll();
        if (books.stream().filter(a -> a.getTitle().equals(book.getTitle())
                || a.getDescription().equals(book.getDescription())).count() != 0)
            throw new IdenticalBookToDBException("Book with such title and description already create!");
    }

    /**
     * Check book by id on null.
     *
     * When any method want to work with book from DB
     * this method check does this object exist.
     * If object dose not exist into DB method throwing exception.
     *
     * @param id object id
     * @return book
     * @throws NullPointerException
     */

    private Book checkFindByIdOnNull(long id) throws NullPointerException {
        Book book = bookCRUDDAO.findById(id);
        if (book == null) {
            throw new NullPointerException("Book with such id not fond");
        }

        return book;
    }

    /**
     * Check list books on the empty
     *
     * This method check list books from DB
     * if this list is empty then method existing exception
     *
     * @param books list books from DB
     * @throws IsEmptyBooksList
     */

    private void checkListBooksOnEmpty(List<Book> books) throws IsEmptyBooksList {
        if (books.isEmpty()) {
            throw new IsEmptyBooksList("Unfortunately, the list of books is still empty. " +
                    "You must create any book so that the list of books is not empty.");
        }
    }
}
