package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/user") // POST /add  ;  Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return n.getId()+" created";
        //return "Saved";
    }

    @GetMapping(path="/user") // GET /user
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/user/get") // GET user/get?id=1
    //public @ResponseBody Optional<User> getUserById(@RequestParam Optional<Integer> id ) {
    public @ResponseBody Optional<User> getUserById(@RequestParam int id ) {
            return userRepository.findById(id);
    }
    @GetMapping(path="/user/{id}") // GET user/get?id=1
    public @ResponseBody Optional<User> getUserByUrlId(@PathVariable int id ) {
        return userRepository.findById(id);
    }

    @DeleteMapping(path="/user") // DELETE /user
    public @ResponseBody Iterable<User> deleteUserById() {
        return userRepository.findAll();
    }
}