package com.example.vehicle;

import com.example.user.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public @ResponseBody Iterable<VehicleBasicData> getAllVehicles() {
        return vehicleService.findAllVehiclesBasicData();
    }

    @PostMapping(path = "/lorry")
    public @ResponseBody Vehicle addNewLorry(@RequestBody Lorry newLorry){
        return vehicleService.addLorry(newLorry);
    }

    @GetMapping(path="/lorry")
    public @ResponseBody Iterable<Lorry> getAllLorries() {
        return vehicleService.getAllLorries();
    }

    // @TODO: Throw 404 when not found
    @GetMapping(path="/lorry/{id}")
    public @ResponseBody Optional<Lorry> getLorryById(@PathVariable int id ) throws ChangeSetPersister.NotFoundException {
        return vehicleService.findLorryById(id);
//        return vehicleService.findLorryById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
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