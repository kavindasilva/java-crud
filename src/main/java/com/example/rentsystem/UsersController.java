package com.example.rentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@Controller // This means that this class is a Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleOwnerRepository ownerRepository;

//    @PostMapping(path="/bill") // POST /user  ;  Map ONLY POST Requests
//    public @ResponseBody String createNewBill (@RequestBody Bill newBill) {
//        return "";
//    }

    @GetMapping(path="/ousers") // GET /users
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
//        "sdds".comp
        return userRepository.findAll();
    }

    @GetMapping(path="/ouser/{id}") // GET user/:id
    public @ResponseBody Optional<User> getItemByUrlId(@PathVariable int id ) {
        return userRepository.findById(id);
    }

    @GetMapping(path="/oowners") // GET /users
    public @ResponseBody Iterable<VehicleOwner> getAllVehicleOwners() {
        return ownerRepository.findAll();
    }

}