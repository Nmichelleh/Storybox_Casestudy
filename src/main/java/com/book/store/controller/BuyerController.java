package com.book.store.controller;

import com.book.store.dao.BuyerDAO;
import com.book.store.dao.UserDAO;
import com.book.store.enitity.Buyer;
import com.book.store.enitity.User;
import com.book.store.form.CreateBuyerForm;
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
public class BuyerController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private BuyerDAO buyerDAO;

    @RequestMapping(value = "/buyer", method = RequestMethod.GET)
    public ModelAndView createBuyerPage() {
        ModelAndView result = new ModelAndView("buyer/buyerUpdate");
        result.addObject("form", new CreateBuyerForm());
        //  result.addObject("difficulty", Difficulty.values());

        User user = userDao.findByEmail(getUserEmail());
        Buyer buyer = buyerDAO.findById(user.getId());

        result.addObject("buyer", buyer);

        return result;
    }


    @RequestMapping(value = "/buyer", method = RequestMethod.POST)
    public ModelAndView createBuyerSumit(@Valid CreateBuyerForm form, BindingResult bindingResult) throws Exception {
        ModelAndView result = new ModelAndView("buyer/buyerUpdate");

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
        Buyer buyer = new Buyer();
        //user.setEmail(form.getEmail());
        buyer.setFirstName(form.getFirstName());
        buyer.setLastName(form.getFirstName());
        buyer.setBusiness_name(form.getBusiness_name());
        buyer.setAddress(form.getAddress());

        user = userDao.findByEmail(getUserEmail());
        buyer.setId(user.getId());
        buyerDAO.save(buyer);

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
