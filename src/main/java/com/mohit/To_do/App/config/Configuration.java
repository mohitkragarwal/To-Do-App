package com.mohit.To_do.App.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authprovider(){

        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        //Step 1:Disabling the csrf token
        //Step 2:Authorizing all the request
        //Step 3:Making it Stateless
        //Note: No form is required as this is stateless



        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


    //Passing the details of the multiple user along with username and password who can access this
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user= User
//                .withDefaultPasswordEncoder()
//                .username("rounak")
//                .password("1234")
//                .roles("USER")
//                .build();
//
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("Ram")
//                .password("4321")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,user1);
//    }

}

