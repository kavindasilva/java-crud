package com.example.rentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /item (after Application path)
public class ItemController {
    @Autowired // This means to get the bean called userRepository
    private ItemRepository itemRepository;

    @PostMapping(path="/item") // POST /item  ;  Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody Item newUserData) {
        Item n = new Item();

        n.setItem_batch( newUserData.getItem_batch() );
        n.setItem_name( newUserData.getItem_name() );
        n.setBuy_price( newUserData.getBuy_price() );
        n.setSell_price( newUserData.getSell_price() );

        itemRepository.save(n);
        return n.getItem_id()+" created";
    }

    @GetMapping(path="/item") // GET /item
    public @ResponseBody Iterable<Item> getBills() {
        return itemRepository.findAll();
    }

    @GetMapping(path="/item/{id}") // GET user/:id
    public @ResponseBody
    Optional<Item> getItemByUrlId(@PathVariable int id ) {
        return itemRepository.findById(id);
    }

//    @DeleteMapping(path="/user/{id}") // DELETE /user/:id
//    public @ResponseBody boolean deleteUserById(@PathVariable int id) {
//        System.out.println("User id "+id+" searching to delete");
//        Optional<User> u1 = userRepository.findById(id);
//        if(null == u1){
//            // not working. handled by spring
//            System.out.println("User id "+id+" not found to delete");
//            return  true;
//        }
//        else {
//            userRepository.deleteById(id);
////            if( null != userRepository.findById(id) )
////                return false;
//            return true;
//        }
//    }
//
//    @PutMapping(path = "/user/{id}") // PUT /user/:id
//    public @ResponseBody Optional<User> editUser (@RequestBody User newUserData, @PathVariable int id){
////        Optional<User> u2 = userRepository.findById(id);
//        return userRepository.findById(id)
//                .map( userdata -> {
//                    userdata.setName(newUserData.getName());
//                    userdata.setEmail(newUserData.getEmail());
//                    return userRepository.save(userdata);
//                });
//    }
//
//    @PatchMapping(path = "/user/{id}") // PATCH /user/:id
//    public @ResponseBody Optional<User> patchUser (@RequestBody User newUserData, @PathVariable int id){
//        System.out.println(newUserData);
//        return userRepository.findById(id)
//                .map( userdata -> {
//                    userdata.setName( (newUserData.getName() != null) ? newUserData.getName() : userdata.getName() );
//                    userdata.setEmail( (newUserData.getEmail() != null) ? newUserData.getEmail() : userdata.getEmail() );
//                    return userRepository.save(userdata);
//                });
//    }

}