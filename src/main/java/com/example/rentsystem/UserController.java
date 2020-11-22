package com.example.rentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired // This means to get the bean called userRepository
    private BillItemRepository billItemRepository;


    @PostMapping(path="/bill") // POST /user  ;  Map ONLY POST Requests
    public @ResponseBody String createNewBill (@RequestBody Bill newBill) {
        return "";
    }

    @GetMapping(path="/users") // GET /user
    public @ResponseBody Iterable<Bill> getBills() {
        // This returns a JSON or XML with the users
        return billRepository.findAll();
    }
    @GetMapping(path="/billItems") // GET /user
    public @ResponseBody Iterable<BillItem> getAllBillItems() {
        // This returns a JSON or XML with the users
        return billItemRepository.findAll();
    }

}