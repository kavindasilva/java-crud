package com.example.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Vehicle addCar(Car newCar){
        vehicleRepo.save(newCar);
        return newCar;
    }

    public Vehicle addLorry(Lorry newLorry){
        vehicleRepo.save(newLorry);
        return newLorry;
    }


    public Car editCar(Car car){
        vehicleRepo.save(car);
        return car;
    }

    public Lorry editLorry(Lorry lorry){
        vehicleRepo.save(lorry);
        return lorry;
    }


    // @TODO: do soft delete
//    public Vehicle deleteLorry(int id){
//        vehicleRepo.save(newCar);
//        return vehicleRepo.findById(id).orElseThrow(Exception("ss"));
//    }
//    public Vehicle deleteCar(int id){
//        vehicleRepo.save(newCar);
//        return vehicleRepo.findById(id).orElseThrow(Exception("ss"));
//    }

    public Iterable<Lorry> getAllLorries(){
        return lorryRepo.findAll();
    }

    public Iterable<Car> getAllCars(){
        return carRepo.findAll();
    }

    public Lorry findLorryById(int id) throws  RuntimeException{
        return lorryRepo.findById(id).orElseThrow( RuntimeException::new );
//        return lorryRepo.findById(id).orElseThrow(() -> new EntityNotFoundException( String.valueOf(id) ));
    }
    // @TODO: do same for car

}
