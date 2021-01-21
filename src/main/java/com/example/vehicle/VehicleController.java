package com.example.vehicle;

import com.example.user.VehicleOwnerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import com.example.common.SystemConstatnts;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    @Qualifier("VehicleDAOImpl")
    private VehicleDAO vehicleRepository;
    @Autowired
    private CarDAO carRepository;
    @Autowired
    private VehicleOwnerDAO ownerRepository;

    @Autowired
    private VehicleService vehicleService;


    @GetMapping(path="")
    public @ResponseBody Iterable<VehicleBasicData> getAllVehicles() {
        return vehicleService.findAllVehiclesBasicData();
    }


    @PostMapping(path = "/car")
    public @ResponseBody Vehicle addNewCar(@RequestBody Car newCar){
        return vehicleService.addCar(newCar);
    }

    @PostMapping(path = "/lorry")
    public @ResponseBody Vehicle addNewLorry(@RequestBody Lorry newLorry){
        return vehicleService.addLorry(newLorry);
    }


    @GetMapping(path="/car")
    public @ResponseBody Iterable<Car> getAllCars() {
        return vehicleService.getAllCars();
    }

    @GetMapping(path="/lorry")
    public @ResponseBody Iterable<Lorry> getAllLorries() {
        return vehicleService.getAllLorries();
    }


    @GetMapping(path="/car/{id}")
    public @ResponseBody Car getCarById(@PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.findCarById(id);
        }
        catch (Exception e){
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, e.getMessage() );
        }
    }

    @GetMapping(path="/lorry/{id}")
    public @ResponseBody Lorry getLorryById(@PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.findLorryById(id);
        }
        catch (Exception e){
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, e.getMessage() );
        }
    }


    @PutMapping(path="/car/{id}")
    public @ResponseBody Vehicle updateCar(@RequestBody Car car, @PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.editCar(id, car);
        }
        catch (Exception e){
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, e.getMessage() );
        }
    }

    @PutMapping(path="/lorry/{id}")
    public @ResponseBody Vehicle updateLorry(@RequestBody Lorry lorry, @PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.editLorry(id, lorry);
        }
        catch (Exception e){
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, e.getMessage() );
        }
    }


    @PatchMapping(path="/car/{id}")
    public @ResponseBody Vehicle patchCar(@RequestBody Map<String, String> fields, @PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.patchCar(id, fields);
        }
        catch (Exception e){
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, e.getMessage() );
        }
    }

    @PatchMapping(path="/lorry/{id}")
    public @ResponseBody Vehicle patchLorry(@RequestBody Map<String, String> fields, @PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.patchLorry(id, fields);
        }
        catch (Exception e){
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, e.getMessage() );
        }
    }


    @DeleteMapping(path="/car/{id}")
    public @ResponseBody boolean deleteCar(@PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.deleteCar(id);
        }
        catch (Exception e) {
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(path="/lorry/{id}")
    public @ResponseBody boolean deleteLorry(@PathVariable int id, HttpServletResponse response) throws ResponseStatusException {
        try {
            return vehicleService.deleteLorry(id);
        }
        catch (Exception e) {
            response.setHeader(SystemConstatnts.RESPONSE_HEADERS.get("REQUESTED_ID"), String.valueOf(id));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
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

//    @GetMapping(path="/car2/{id}") //
//    public @ResponseBody
//    VehicleResponse getVehicleById2(@PathVariable int id, @RequestParam("for") Optional<Integer> purpose) {
//        return new VehicleResponse( vehicleRepository.findById(id), purpose.orElse(1) );
//    }

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