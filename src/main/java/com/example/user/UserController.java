package com.example.user;

//import com.example.rentsystem.VehicleOwner;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    private VehicleOwnerRepository ownerRepository;

    public UserController(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);
    }

//    @PostMapping(path="/bill") // POST /user  ;  Map ONLY POST Requests
//    public @ResponseBody String createNewBill (@RequestBody Bill newBill) {
//        return "";
//    }

    @GetMapping(path="/users") // GET /users
    public @ResponseBody Iterable<AppUser> getAllUsers() {
        // This returns a JSON or XML with the users
//        "sdds".comp
        return userRepository.findAll();
    }

    @GetMapping(path="/user/{id}") // GET user/:id
    public @ResponseBody Optional<AppUser> getItemByUrlId(@PathVariable int id ) {
        return userRepository.findById(id);
    }

//    @GetMapping(path="/owners") // GET /users
//    public @ResponseBody Iterable<VehicleOwner> getAllVehicleOwners() {
//        return ownerRepository.findAll();
//    }

}