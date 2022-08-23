package com.book.store.controller;

import com.book.store.dao.BookDAO;
import com.book.store.dao.CartDAO;
import com.book.store.dao.CategoryDAO;
import com.book.store.dao.UserDAO;
import com.book.store.enitity.Book;
import com.book.store.enitity.Cart;
import com.book.store.enitity.Category;
import com.book.store.enitity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookDisplayController {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/bookDisplay", method = RequestMethod.GET)
    public ModelAndView search1() {
        ModelAndView response = new ModelAndView();
        response.setViewName("book/bookDisplay");
        List<Book> books = new ArrayList<Book>();
//		if (!StringUtils.isEmpty(search)) {
//			if(search.contains(" ")){
//				search= search.substring(0, search.indexOf(" "));
//			}

//		}
        books = bookDAO.findAll();



        List<Category> category =new ArrayList<Category>();
        category = categoryDAO.findAll();
        books.contains(category);




        books.forEach(
                (n)->System.out.println(n.toString())
        );
        response.addObject("books", books);
        response.addObject("search", "yes");
        return response;
    }

//	@RequestMapping(value = "/courseDisplay", method = RequestMethod.POST)
//	public ModelAndView search() {
//		ModelAndView response = new ModelAndView();
//		response.setViewName("course/courseDisplay");

//		return response;
//	}

    @RequestMapping(value = "/bookDisp", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView();
        response.setViewName("book/bookDisplay");

        List<Book> books = new ArrayList<Book>();
        if (!StringUtils.isEmpty(search)) {
            if(search.contains(" ")){
                search= search.substring(0, search.indexOf(" "));
            }
            books = bookDAO.findByName(search);
        }

        books.forEach(
                (n)->System.out.println(n.toString())
        );
        response.addObject("books", books);
        response.addObject("search", search);

        return response;
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public ModelAndView addToCart(@RequestParam(required = false) String id,String bookName,String author,String price) {
        ModelAndView response = new ModelAndView();
        response.setViewName("book/bookDisplay");


        Cart cart = new Cart();

        cart.setId(Integer.parseInt(id));
        cart.setBookName(bookName);
        cart.setAuthor(author);
        cart.setPrice(price);
        cart.setQuantity("1");

        User user = new User();
        user = userDAO.findByEmail(getUserEmail());

        cart.setUser_id(user.getId());

        cartDAO.save(cart);

        List<Book> books = new ArrayList<Book>();
        books = bookDAO.findAll();
        books.forEach(
                (n)->System.out.println(n.toString())
        );
        response.addObject("books", books);
        response.addObject("search", "yes");

        return response;
    }

    @Transactional
    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(required = false) int id) {
        ModelAndView response = new ModelAndView();
        response.setViewName("book/bookDisplay");
        bookDAO.removeBookById(id);

        List<Book> books = new ArrayList<Book>();

        books = bookDAO.findAll();
        books.forEach(
                (n)->System.out.println(n.toString())
        );
        response.addObject("books", books);
        response.addObject("search", id);

        return response;
    }

    public String getUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            return username;
        } else {
            String username = principal.toString();
            return "";
        }
    }

}
