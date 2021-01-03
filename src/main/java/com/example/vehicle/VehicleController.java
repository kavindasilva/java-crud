package com.example.vehicle;

import com.example.user.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private VehicleOwnerRepository ownerRepository;

    @Autowired
    private VehicleService vehicleService;


    @GetMapping(path="")
    public @ResponseBody Iterable<Object> getAllVehicles() {
//        return vehicleRepository.findAll();
        return vehicleRepository.findAllVechicleBasicData();
    }

    @PostMapping(path = "/lorry")
    public @ResponseBody Vehicle addNewLorry(@RequestBody Lorry newlorry){
        return vehicleService.addLorry(newlorry);
    }

    @GetMapping(path="/{id}") // GET vechicle/:id
    public @ResponseBody Optional<Vehicle> getVehicleById(@PathVariable int id ) {
        return vehicleRepository.findById(id);
    }
    @GetMapping(path="/car1") //
    public @ResponseBody String getVehicleById() {
        return "vehicleRepository.findById(id)";
    }

    @GetMapping(path="/car2/{id}") //
    public @ResponseBody
    VehicleResponse getVehicleById2(@PathVariable int id, @RequestParam("for") Optional<Integer> purpose) {
        return new VehicleResponse( vehicleRepository.findById(id), purpose.orElse(1) );
    }

    @GetMapping(path="/cars") // GET /users
    public @ResponseBody Iterable<Car> getAllCars() {
//        return carRepository.findAll();
        Iterable<Car> allCars = carRepository.findAll();
//        allCars.forEach( car ->  );
        for (Car c: allCars) {
            c.setId(20);
        }
        return  allCars;
    }

    @GetMapping(path="/car/{id}") // GET user/:id
    public @ResponseBody Optional<Car> getCarById(@PathVariable int id ) {
        return carRepository.findById(id);
    }

}