package com.pvh.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/**
 * Configuration class to secure rest api end point by username and password
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * override method From WebSecurityConfigureAdapeter.
     * Used for making all rest end point protected except /api/docs-which used to see rest
     * api documentation.
     *
     * @param http reference of HttpSecurity
     * @throws Exception throw exception
     */
    @Override
    protected  void configure(HttpSecurity http) throws Exception
    {
       http.authorizeRequests().antMatchers("/api-docs").permitAll().
                antMatchers("/api/**").authenticated().and().formLogin().and().httpBasic();
        http.csrf().disable();
    }

    /**
     * method to set user details through which one can access rest end point
     *
     * @return instance of UserDetailsService
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withUsername("admin")
                        .password("{noop}password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

}
