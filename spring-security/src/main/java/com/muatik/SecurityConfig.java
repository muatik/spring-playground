package com.muatik;

import com.muatik.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mustafaatik on 26/12/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserDetailsService userDetailsService;
    @Autowired
    UserServiceBean userServiceBean;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .antMatchers(
                        "/index/",
                        "/about/",
                        "/api/users/"
                )
                .permitAll()
                .antMatchers("/verySecured/").hasRole("ADMIN")
                .antMatchers("/api/users/").hasRole("EDITOR")
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                com.muatik.models.User user = userServiceBean.findOneByEmail(email);

                if (user == null) {
                    throw new UsernameNotFoundException("user not found");
                }

                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_EDITOR");
                return new User(
                        user.getEmail(),
                        user.getHashedPassword(),
                        Collections.singletonList(authority));
            }
        }).passwordEncoder(new BCryptPasswordEncoder());
    }

//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//    }

}
