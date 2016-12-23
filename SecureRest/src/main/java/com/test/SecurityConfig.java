package com.test;

import com.test.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by mustafaatik on 23/12/16.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/index/",
                        "/about/",
                        "/users/registration/")
                .permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and().csrf().disable();
//                .and()
//                .formLogin()
//                .loginPage("/about/");
//                .antMatchers("/secured/")
//                .authenticated()
//                .antMatchers("/users/")
//                .fullyAuthenticated();
//        http.authorizeRequests()
//                .antMatchers("/", "/public/**").permitAll();
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .usernameParameter("email")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .permitAll();
    }
}
