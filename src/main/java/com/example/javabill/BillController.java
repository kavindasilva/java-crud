package com.example.javabill;

import com.example.javabill.Bill;
import com.example.javabill.BillItem;
//import com.example.javabill.It;
//import com.example.javabill.BillItemRepository;
//import com.example.javabill.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class BillController {
    @Autowired // This means to get the bean called userRepository
    private BillRepository billRepository;

    @Autowired // This means to get the bean called userRepository
    private BillItemRepository billItemRepository;

        /*"bill_id": 1,
            "cashier": 1,
            "bill_time": "2020-02-16 14:09:05",
            "bill_total": 100.0,
            "items": [
                {
                    "bill_item_id": 1,
                    "qty": 1.0,
                }
            ]*/
    @PostMapping(path="/bill") // POST /user  ;  Map ONLY POST Requests
    public @ResponseBody String createNewBill (@RequestBody Bill newBill) {
        Bill b = new Bill();
        b.setCashier(1); // hardcoded phase 1
        b.setBill_time( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        b.setBill_total(100.0);
//        b.setItems(newBill.getItems());
        if( !newBill.getItems().isEmpty() ){
            for( BillItem bItem : newBill.getItems() ){
                //System.out.println( bItem.getBill_item_id() );
                bItem.set
                billItemRepository.save(bItem);
            }
            return "1";
        }
        billRepository.save(b);
        return b.getBill_id()+" created";
    }

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