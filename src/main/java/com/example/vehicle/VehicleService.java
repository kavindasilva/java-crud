package com.example.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

interface CarService{
//    public void addCar(Car car);
//    public void updateCar(Car car);
//    public Car getCar(int id);
//    public void deleteCar(int id);
}

interface LorryService{
    public void addLorry(Car car);
    public void updateLorry(Car car);
    public Car getLorry(int id);
    public void deleteLorry(int id);
}

@Service
public class VehicleService implements CarService {
    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private LorryRepository lorryRepo;

    @Autowired
    private CarRepository carRepo;


    public Iterable<VehicleBasicData> findAllVehiclesBasicData(){
        return vehicleRepo.findAllVehicleBasicData();
    }

    public Vehicle addLorry(Lorry newLorry){
        vehicleRepo.save(newLorry);
        return newLorry;
    }

    public Vehicle addCar(Car newCar){
        vehicleRepo.save(newCar);
        return newCar;
    }

    public Vehicle editCar(Car newCar){
        vehicleRepo.save(newCar);
        return newCar;
    }

    // @TODO: do same for lorry
//    public Vehicle deleteCar(int id){
////        vehicleRepo.save(newCar);
//        return vehicleRepo.findById(id).orElseThrow(Exception("ss"));
//    }

    public Iterable<Lorry> getAllLorries(){
        return lorryRepo.findAll();
    }
    // @TODO: do same for car

    public Optional<Lorry> findLorryById(int id){
        return lorryRepo.findById(id);
//        return lorryRepo.findById(id).orElseThrow(() -> new EntityNotFoundException( String.valueOf(id) ));
    }
    // @TODO: do same for car

//    public Iterable<Lorr> findVehiclesBasicData(){
//        return vehicleRepo.findAllVehicleBasicData();
//    }
}
