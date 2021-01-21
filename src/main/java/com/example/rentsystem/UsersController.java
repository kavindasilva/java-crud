package com.example.rentsystem;

import com.example.user.VechicleOwnerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
public class UsersController {
    @Autowired
    private usersDAOImpl userRepository;
    @Autowired
    private VechicleOwnerDAOImpl ownerRepository;


    @GetMapping(path="/ousers") // GET /users
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/ouser/{id}") // GET user/:id
    public @ResponseBody Optional<User> getItemByUrlId(@PathVariable int id ) {
        return Optional.ofNullable( userRepository.findById(id) );
    }

    @GetMapping(path="/oowners") // GET /users
    public @ResponseBody Iterable<VehicleOwner> getAllVehicleOwners() {
        return ownerRepository.findAll();
    }

}