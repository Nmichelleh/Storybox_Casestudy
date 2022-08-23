package com.book.store.controller;

import com.book.store.dao.UserDAO;
import com.book.store.enitity.Seller;
import com.book.store.enitity.User;
import com.book.store.form.CreateSellerForm;
import com.book.store.dao.SellerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SellerController {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private SellerDAO sellerDAO;

    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public ModelAndView createRecipePage() {
        ModelAndView result = new ModelAndView("seller/sellerUpdate");
        result.addObject("form", new CreateSellerForm());
        //  result.addObject("difficulty", Difficulty.values());

        User user = userDao.findByEmail(getUserEmail());
        Seller seller = sellerDAO.findById(user.getId());

        result.addObject("seller", seller);

        return result;
    }


    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public ModelAndView createRecipeSumit(@Valid CreateSellerForm form, BindingResult bindingResult) throws Exception {
        ModelAndView result = new ModelAndView("seller/sellerUpdate");

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
        User user = new User();
        Seller seller = new Seller();
        //user.setEmail(form.getEmail());
        seller.setFirstName(form.getFirstName());
        seller.setLastName(form.getLastName());
        seller.setAddress(form.getAddress());

        user = userDao.findByEmail(getUserEmail());
        seller.setId(user.getId());
        sellerDAO.save(seller);

        // goto the next page

        return result;
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
