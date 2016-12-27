package com.muatik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by mustafaatik on 27/12/16.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserServiceBean userServiceBean;
    private org.springframework.security.core.userdetails.User SecurityUser;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.muatik.models.User user = userServiceBean.findOneByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        return new User(
                user.getEmail(),
                user.getHashedPassword(),
                Arrays.asList(authority));
    }
}
