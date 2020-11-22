package com.example.rentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@Controller // This means that this class is a Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleOwnerRepository ownerRepository;

//    @PostMapping(path="/bill") // POST /user  ;  Map ONLY POST Requests
//    public @ResponseBody String createNewBill (@RequestBody Bill newBill) {
//        return "";
//    }

    @GetMapping(path="/users") // GET /users
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/user/{id}") // GET user/:id
    public @ResponseBody Optional<User> getItemByUrlId(@PathVariable int id ) {
        return userRepository.findById(id);
    }

    @GetMapping(path="/owners") // GET /users
    public @ResponseBody Iterable<VehicleOwner> getAllVehicleOwners() {
        return ownerRepository.findAll();
    }

}