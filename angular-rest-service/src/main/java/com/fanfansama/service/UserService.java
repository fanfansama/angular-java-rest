package com.fanfansama.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by fanfan on 12/01/2015.
 */
public interface UserService {
    UserDetails loadUserByUsername(String user);
}
