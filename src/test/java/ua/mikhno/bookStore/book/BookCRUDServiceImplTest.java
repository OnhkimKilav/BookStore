/*
package ua.mikhno.bookStore.book;

import com.exception.IdenticalBookToDBException;
import com.model.Book;
import com.model.Genre;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BookCRUDServiceImplTest {
    private BookCRUDServiceImpl bookCRUDService = new BookCRUDServiceImpl();

    @Test
    public void saveIdenticalBooks(){
        Book book = new Book(
                "Мастер и Маргарита",
                new Date(),
                "Хороша книга",
                Genre.ROMANCE_NOVEL,
                true,
                355.5,
                true,
                false);
        assertThatThrownBy(() -> {
            bookCRUDService.save(book);
        }).isInstanceOf(IdenticalBookToDBException.class)
                .hasMessageContaining("Книга с такими данными уже существует в БД");
    }
}*/
