package com.cristianortega.portfolio.domain.service.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioDetailService implements UserDetailsService  {

    private final static String USER_NAME = "c.ortegamu@gmail.com";

    public PortfolioDetailService() {
        //users.add(new User("c.ortegamu@gmail.com", "{noop}residentstrike1.", new ArrayList<>()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (USER_NAME.equals(username)) {
            return new User("c.ortegamu@gmail.com", "{noop}residentstrike1.", new ArrayList<>());
        }

        return null;
    }

}
