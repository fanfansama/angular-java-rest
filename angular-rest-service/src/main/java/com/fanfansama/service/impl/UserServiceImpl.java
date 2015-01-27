package com.fanfansama.service.impl;

import com.fanfansama.dal.dao.UserDao;
import com.fanfansama.dal.model.User;
import com.fanfansama.service.UserService;
import com.fanfansama.service.dto.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by fanfan on 12/01/2015.
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Transactional( readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = this.findByName(username);
		if (null == user) {
			throw new UsernameNotFoundException("The user with name " + username + " was not found");
		}
		return new UserSecurity(user);
	}

	@Transactional(readOnly = true)
	public User findByName(String name)
	{
		return userDao.findOneByName(name);
	}

	@Transactional(readOnly = true)
	public List<User> findAll(){
		return userDao.findAll();
	}

}
