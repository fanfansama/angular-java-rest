package com.fanfansama.service;

import com.fanfansama.dal.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by fanfan on 12/01/2015.
 */
public interface UserService extends UserDetailsService {
    List<User> findAll();
    //UserDetails loadUserByUsername(String user);
}
