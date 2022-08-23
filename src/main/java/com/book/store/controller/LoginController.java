package com.book.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.book.store.dao.UserDAO;
import com.book.store.enitity.User;
import com.book.store.form.CreateUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Service
@RequestMapping("/")
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDAO userDao;

	public LoginController() {
		System.out.println("PostConstruct Reference to UserDAO = " + userDao);
	}

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct Reference to UserDAO = " + userDao);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUserPage() {
		logger.info("Enter: createUserPage()");
		ModelAndView result = new ModelAndView("login/createUser");
		result.addObject("form", new CreateUserForm());

		logger.info("Exit: createUserPage()");
		return result;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) throws Exception {
		logger.info("Enter: createUserSubmit()");
		ModelAndView result = new ModelAndView("login/createUser");

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
			logger.trace("createUserSubmit() - ERROR: Binding Errors");
			return result;
		}

		// business logic
		User user = new User();

		//User existingUser = userDao.findById(1).get();
		//userDao.delete(user);
		Optional<User> optionalUser = Optional.ofNullable(userDao.findByEmail(form.getEmail()));
		User tempUser = null;
		if (optionalUser.isPresent()) {
			result.addObject("errorFields", bindingResult.getFieldErrors());
			result.addObject("errors", "EMAIL ALREADY IN USE");

			logger.trace("createUserSubmit() - ERROR: Email Already In Use");
			return result;
		}


		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setFullName(form.getFullName());
		user.setRole(form.getRole());
		userDao.save(user);

		// goto the next page
		logger.info("Exit: createUserSubmit()");
		return result;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		logger.info("Enter: login()");
		ModelAndView result = new ModelAndView("login/login");

		logger.info("Exit: login()");
		return result;
	}

	@RequestMapping(value = "/login/login")
	public ModelAndView login2() {
		logger.info("Enter: login2()");
		ModelAndView result = new ModelAndView("login/login");

		logger.info("Exit: login2()");
		return result;
	}
	//Eliana!1234
}
