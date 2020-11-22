package com.example.rentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller // This means that this class is a Controller
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private VehicleOwnerRepository ownerRepository;

//    @PostMapping(path="/bill") // POST /user  ;  Map ONLY POST Requests
//    public @ResponseBody String createNewBill (@RequestBody Bill newBill) {
//        return "";
//    }

    @GetMapping(path="/vehicles") // GET /users
    public @ResponseBody Iterable<Vehicle> getAllVehicles() {
        // This returns a JSON or XML with the users
        return vehicleRepository.findAll();
    }

    @GetMapping(path="/vehicle/{id}") // GET user/:id
    public @ResponseBody Optional<Vehicle> getVehicleById(@PathVariable int id ) {
        return vehicleRepository.findById(id);
    }

    @GetMapping(path="/car") // GET /users
    public @ResponseBody Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping(path="/vehicle/{id}") // GET user/:id
    public @ResponseBody Optional<Car> getCarById(@PathVariable int id ) {
        return carRepository.findById(id);
    }

}