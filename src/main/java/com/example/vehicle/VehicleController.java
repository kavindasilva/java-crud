package com.example.vehicle;

import com.example.user.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
    public @ResponseBody Iterable<VehicleBasicData> getAllVehicles() {
        return vehicleService.findAllVehiclesBasicData();
    }


    @PostMapping(path = "/lorry")
    public @ResponseBody Vehicle addNewLorry(@RequestBody Lorry newLorry){
        return vehicleService.addLorry(newLorry);
    }

    @PostMapping(path = "/car")
    public @ResponseBody Vehicle addNewCar(@RequestBody Car newCar){
        return vehicleService.addCar(newCar);
    }


    @GetMapping(path="/lorry")
    public @ResponseBody Iterable<Lorry> getAllLorries() {
        return vehicleService.getAllLorries();
    }

    @GetMapping(path="/car")
    public @ResponseBody Iterable<Car> getAllCars() {
        return vehicleService.getAllCars();
    }


    @GetMapping(path="/lorry/{id}")
    public @ResponseBody Lorry getLorryById(@PathVariable int id ) throws ResponseStatusException {
        try {
            return vehicleService.findLorryById(id);
        }
        catch (Exception e){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "id: "+id+"\n"+e.getMessage() );
        }
    }

    @GetMapping(path="/car/{id}")
    public @ResponseBody Car getCarById(@PathVariable int id ) throws ResponseStatusException {
        try {
            return vehicleService.findCarById(id);
        }
        catch (Exception e){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "id: "+id+"\n"+e.getMessage() );
        }
    }

//    @GetMapping(path="/{id}") // GET vechicle/:id
//    public @ResponseBody Vehicle getVehicleById(@PathVariable int id ) throws ChangeSetPersister.NotFoundException {
//        return vehicleRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
//    }
    @GetMapping(path="/car1") //
    public @ResponseBody String getVehicleById() {
        return "vehicleRepository.findById(id)";
    }

    @GetMapping(path="/car2/{id}") //
    public @ResponseBody
    VehicleResponse getVehicleById2(@PathVariable int id, @RequestParam("for") Optional<Integer> purpose) {
        return new VehicleResponse( vehicleRepository.findById(id), purpose.orElse(1) );
    }

//    @GetMapping(path="/cars") // GET /users
//    public @ResponseBody Iterable<Car> getAllCars() {
////        return carRepository.findAll();
//        Iterable<Car> allCars = carRepository.findAll();
////        allCars.forEach( car ->  );
//        for (Car c: allCars) {
//            c.setId(20);
//        }
//        return  allCars;
//    }

//    @GetMapping(path="/car/{id}") // GET user/:id
//    public @ResponseBody Optional<Car> getCarById(@PathVariable int id ) {
//        return carRepository.findById(id);
//    }

}