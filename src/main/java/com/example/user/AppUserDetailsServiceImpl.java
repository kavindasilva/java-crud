package com.example.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private AppUserDAO appUserDAO;

    public AppUserDetailsServiceImpl(AppUserDAO applicationUserRepository) {
        this.appUserDAO = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser applicationUser = null;
        try {
            applicationUser = this.loadUserData(username);
        }
        catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getName(), applicationUser.getPassword(), emptyList());
    }

    public AppUser loadUserData(String username) throws UsernameNotFoundException {
        AppUser applicationUser = appUserDAO.findByName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return applicationUser;
    }
}