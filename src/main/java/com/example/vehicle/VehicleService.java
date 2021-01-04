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


    public Vehicle editCar(int id, Vehicle car) throws  RuntimeException{
//        vehicleRepo.save(car);
        try{
            Vehicle eCar = this.findCarById(id);
            eCar.setAvailable(car.isAvailable());
            eCar.setColor(car.getColor());
            eCar.setDeleted(car.isDeleted());
            eCar.setLicense_expiry_date(car.getLicense_expiry_date());
            eCar.setMake(car.getMake());
            eCar.setModel(car.getModel());
            eCar.setTransmission(car.getTransmission());
            vehicleRepo.save(eCar);
            return eCar;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
//        return car;
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
    }
    public Car findCarById(int id) throws  RuntimeException{
        return carRepo.findById(id).orElseThrow( RuntimeException::new );
    }

}
