package com.book.store.controller;

import com.book.store.dao.BookDAO;
import com.book.store.dao.CategoryDAO;
import com.book.store.enitity.Book;
import com.book.store.enitity.Category;
import com.book.store.form.CreateBookForm;
import com.book.store.form.EditBookForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {


    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView createRecipePage() {
        ModelAndView result = new ModelAndView("book/bookUpdate");
        result.addObject("form", new CreateBookForm());
        // result.addObject("difficulty", Difficulty.values());
        return result;
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView createRecipeSumit(@Valid CreateBookForm form, BindingResult bindingResult) throws Exception {
        ModelAndView result = new ModelAndView("book/bookUpdate");

        // form validation
        result.addObject("form", form);

        System.out.println(form);

        if (bindingResult.hasErrors()) {

            List<String> errors = new ArrayList<String>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + " = " + error.getDefaultMessage());
                errors.add(error.getDefaultMessage());
            }

            result.addObject("errorFields", bindingResult.getFieldErrors());
            result.addObject("errors", errors);

            return result;
        }

        Book book = new Book();
        Category category = new Category();

        book.setBookName(form.getBookName());
        book.setAuthor(form.getAuthor());
        book.setPrice(form.getPrice());
        book.setQuantity(form.getQuantity());

        category.setCategory_name(form.getCategory());
        Set<Category> categories = new HashSet<Category>();
        categories.add(category);
        book.setCategories(categories);
        bookDAO.save(book);
        categoryDAO.save(category);

        return result;
    }

    @RequestMapping(value = "/bookEdit", method = RequestMethod.GET)
    public ModelAndView courseEditPage() {
        ModelAndView result = new ModelAndView("book/bookEdit");
        result.addObject("form", new EditBookForm());
        //	result.addObject("difficulty", Difficulty.values());
        return result;
    }


    @RequestMapping(value = "/bookEdit", method = RequestMethod.POST)
    public ModelAndView courseEditSumit(@Valid EditBookForm form, BindingResult bindingResult) throws Exception {
        ModelAndView result = new ModelAndView("book/bookEdit");

        // form validation
        result.addObject("form", form);

        System.out.println(form);

        if (bindingResult.hasErrors()) {

            List<String> errors = new ArrayList<String>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + " = " + error.getDefaultMessage());
                errors.add(error.getDefaultMessage());
            }

            result.addObject("errorFields", bindingResult.getFieldErrors());
            result.addObject("errors", errors);

            return result;
        }

        Book book;
        Category category = new Category();

        book = bookDAO.findById(Integer.parseInt(form.getId()));

        book.setBookName(form.getBookName());
        book.setAuthor(form.getAuthor());
        book.setPrice(form.getPrice());
        book.setQuantity(form.getQuantity());

     //   category = categoryDAO.findById(product.getCategories().equals())

        category.setCategory_name(form.getCategory());
        Set<Category> categories = new HashSet<Category>();
        categories.add(category);
        book.setCategories(categories);
        bookDAO.save(book);
        //categoryDAO.save(category);

        return result;
    }

}
