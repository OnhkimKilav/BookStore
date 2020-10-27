package ua.mikhno.bookStore.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Order;

import javax.validation.Valid;

public interface ICRUDController<T> {

    @PostMapping()
    String create(@ModelAttribute("order") T t, Model model) throws Exception;

    String read(Model model) throws IsEmptyBooksList;

    @GetMapping("/{id}")
    String read(@PathVariable long id, Model model);

    @PostMapping("/update/{id}")
    String update(@PathVariable("id") long id, @Valid T t,
                         BindingResult result, Model model) throws IsEmptyBooksList;

    @DeleteMapping("/{id}")
    String delete(@PathVariable long id);
}
