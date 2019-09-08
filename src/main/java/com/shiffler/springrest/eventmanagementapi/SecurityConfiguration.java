/*package com.shiffler.springrest.eventmanagementapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

    //Setup our Users

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("jshiffler").password("password").roles("USER").and()
        //        .withUser("admin").password("password").roles("ADMIN");

        auth.inMemoryAuthentication().withUser("admin").password("{noop}springsec").roles("ADMIN");

    }

    //Configure the security requirements for different URLs
    //Disable csrf since this an API

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST,"/events").hasRole("ADMIN").
                antMatchers(HttpMethod.PUT,"/events/**").hasRole("ADMIN").
                antMatchers(HttpMethod.PATCH,"/events/**").hasRole("ADMIN");


        http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST,"/events").hasRole("ADMIN").and().csrf().disable();

    }


}
*/