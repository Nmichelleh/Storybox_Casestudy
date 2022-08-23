package com.book.store.security;

import com.book.store.config.UserPrincipal;
import com.book.store.dao.UserDAO;
import com.book.store.enitity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//@Component
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username '" + username + "' not found in database");
		}

		return new UserPrincipal(user);
	}

}
