package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AppUserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(AppUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public AppUser signUp(@RequestBody AppUser appUser) {
        System.out.println("sign-up called...");
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
//        appUser.setPassword(appUser.getPassword());
        userRepository.save(appUser);
        return appUser;
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @Secured("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/allu", method = RequestMethod.GET)
//    @GetMapping(path="/allu")
    public @ResponseBody Iterable<AppUser> getAllUsers2() {
        return userRepository.findAll();
    }

}