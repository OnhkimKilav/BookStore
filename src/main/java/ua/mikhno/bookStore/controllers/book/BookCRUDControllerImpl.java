package ua.mikhno.bookStore.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mikhno.bookStore.controllers.ICRUDController;
import ua.mikhno.bookStore.exception.IdenticalBookToDBException;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Book;
import ua.mikhno.bookStore.services.book.BookCRUDServiceImpl;

import javax.validation.Valid;


@Controller
@RequestMapping("/books")
public class BookCRUDControllerImpl implements ICRUDController<Book> {

    private BookCRUDServiceImpl bookCRUDService;

    @Autowired
    public BookCRUDControllerImpl(BookCRUDServiceImpl bookCRUDService) {
        this.bookCRUDService = bookCRUDService;
    }

    /**
     * 
     *
     * @param book
     * @return
     * @throws IdenticalBookToDBException
     */
    @Override
    @PostMapping()
    public String create(@ModelAttribute("book") Book book, Model model) throws IdenticalBookToDBException {
        bookCRUDService.create(book);
        return "redirect:/books";
    }

    @Override
    @GetMapping()
    public String read(Model model) throws IsEmptyBooksList {
        model.addAttribute("books", bookCRUDService.read());
        return "book/read";
    }

    @Override
    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        model.addAttribute(bookCRUDService.read(id));
        return "book/book";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Book book,
                         BindingResult result, Model model) throws IsEmptyBooksList {
        if (result.hasErrors()) {
            book.setId(id);
            return "book/update";
        }

        bookCRUDService.update(book);
        model.addAttribute("books", bookCRUDService.read());
        return "redirect:/books/{id}";
    }

    @Override
    @PostMapping("/{id}")
    public String delete(@PathVariable long id) {
        bookCRUDService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/create")
    private String callFormCreateBook(@ModelAttribute("book") Book book) {
        return "book/create";
    }

    @GetMapping("/edit/{id}")
    private String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookCRUDService.read(id);
        model.addAttribute("book", book);
        return "book/update";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model;
        if (ex.getClass().equals(IsEmptyBooksList.class)) {
            model = new ModelAndView("book/error/bookList");
        } else {
            model = new ModelAndView("book/error/error");
        }
        model.addObject("error", ex.getMessage());
        return model;
    }

}
