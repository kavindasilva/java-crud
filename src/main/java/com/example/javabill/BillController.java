package com.example.javabill;

import com.example.javabill.Bill;
import com.example.javabill.BillItem;
//import com.example.javabill.It;
//import com.example.javabill.BillItemRepository;
//import com.example.javabill.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class BillController {
    @Autowired // This means to get the bean called userRepository
    private BillRepository billRepository;

    @Autowired // This means to get the bean called userRepository
    private BillItemRepository billItemRepository;

//    @PostMapping(path="/user") // POST /user  ;  Map ONLY POST Requests
//    public @ResponseBody String addNewUser (@RequestBody User newUserData) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//        BillItem n = new BillItem();
//        n.setName(newUserData.getName());
//        n.setEmail(newUserData.getEmail());
//        billRepository.save(n);
//        return n.getId()+" created";
//    }

    @GetMapping(path="/bills") // GET /user
    public @ResponseBody Iterable<Bill> getBills() {
        // This returns a JSON or XML with the users
        return billRepository.findAll();
    }
    @GetMapping(path="/billItems") // GET /user
    public @ResponseBody Iterable<BillItem> getAllBillItems() {
        // This returns a JSON or XML with the users
        return billItemRepository.findAll();
    }

//    @GetMapping(path="/user/get") // GET user/get?id=1
//    //public @ResponseBody Optional<User> getUserById(@RequestParam Optional<Integer> id ) {
//    public @ResponseBody Optional<User> getUserById(@RequestParam int id ) {
//            return userRepository.findById(id);
//    }
//    @GetMapping(path="/user/{id}") // GET user/:id
//    public @ResponseBody Optional<User> getUserByUrlId(@PathVariable int id ) {
//        return userRepository.findById(id);
//    }

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