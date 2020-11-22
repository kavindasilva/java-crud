package com.example.rentsystem;

//import com.example.javabill.It;
//import com.example.javabill.BillItemRepository;
//import com.example.javabill.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

        import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ItemRepository itemRepository;
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
        String returnData = "";
        BillItem bill_item = new BillItem();
        Bill b = new Bill();

        b.setCashier(1); // hardcoded phase 1
        b.setBill_time( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        b.setBill_total(newBill.getBill_total());
//        b.setItems(newBill.getItems());
        billRepository.save(b);
        returnData += "bill: "+b.getBill_id()+" created; ";

        Iterator bill_item_list=newBill.getItems().iterator();
        while( bill_item_list.hasNext() ){
//            BillItem bill_item2 = new BillItem();

//            bill_item2.setBill_id( b.getBill_id() );
//            bill_item2.setQty( bill_item_list.next(). );
//            bill_item2.setItem( bItem.getItem() );

//            bill_item.setBill_id( b.getBill_id() );
//            bill_item.setQty( bItem.getQty() );
//            bill_item.setItem( bItem.getItem() );
        }
        return returnData;

//        if( false && !newBill.getItems().isEmpty() ){
//            for( BillItem bItem : newBill.getItems() ){
//                bill_item.setBill_id( b.getBill_id() );
//                bill_item.setQty( bItem.getQty() );
//                bill_item.setItem( bItem.getItem() );
////                bill_item.setItem( itemRepository.findById(1) );
////                bill_item.setItem( 1 );
//
//                Optional<Item> item_data = itemRepository.findById( 2 );
//                if( item_data.isPresent() ){
////                    returnData += bItem.getItem().getItem_id()+" not found;";
////                    returnData += item_data.ge()+" not found;";
////                    continue;
////                    bill_item.setItem( item_data );
//
//                }
//                billItemRepository.save(bill_item);
////                billItemRepository.save(bItem);
//                returnData += "bill_item: "+ bill_item.getBill_item_id()+" added; "; /* */
//            }
////            return "1";
//        }
//        return returnData;
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