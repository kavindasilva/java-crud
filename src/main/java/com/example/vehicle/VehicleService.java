package com.example.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

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
            car.setId(id); // don't let update PK
//
//            car.forEach((k, v) -> {
//                System.out.println("k,v: " + k + v);
//                Field field = ReflectionUtils.findField(Car.class, k); // find field in the object class
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, eCar, v); // set given field for defined object to value V
//            });
//            eCar.setAvailable(car.isAvailable());
//            eCar.setColor(car.getColor());
//            eCar.setDeleted(car.isDeleted());
//            eCar.setLicense_expiry_date(car.getLicense_expiry_date());
//            eCar.setMake(car.getMake());
//            eCar.setModel(car.getModel());
//            eCar.setTransmission(car.getTransmission());
            vehicleRepo.save(car);
            return eCar;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
//        return car;
    }

    // @TODO: same as car
    public Lorry editLorry(Lorry lorry){
        vehicleRepo.save(lorry);
        return lorry;
    }

    public Vehicle patchCar(int id, Map<String, String> fields) throws  RuntimeException{
        try{
            Car eCar = this.findCarById(id);
            System.out.println("ID " + fields.get("id"));
            fields.remove("id"); // don't let update PK

            fields.forEach((k, v) -> {
                System.out.println("k,v: " + k + v);
                Field field = ReflectionUtils.findField(Car.class, k); // find field in the object class
                field.setAccessible(true);
                ReflectionUtils.setField(field, eCar, v); // set given field for defined object to value V
            });

            carRepo.save(eCar);
            return eCar;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    // @TODO: refactor to Lorry
    public Vehicle patchLorry(int id, Map<String, String> fields) throws  RuntimeException{
        try{
            Car eCar = this.findCarById(id);
            System.out.println("ID " + fields.get("id"));
            fields.remove("id"); // don't let update PK

            fields.forEach((k, v) -> {
                System.out.println("k,v: " + k + v);
                Field field = ReflectionUtils.findField(Car.class, k); // find field in the object class
                field.setAccessible(true);
                ReflectionUtils.setField(field, eCar, v); // set given field for defined object to value V
            });

            carRepo.save(eCar);
            return eCar;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
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


    public Car findCarById(int id) throws  RuntimeException{
        return carRepo.findById(id).orElseThrow( RuntimeException::new );
    }

    public Lorry findLorryById(int id) throws  RuntimeException{
        return lorryRepo.findById(id).orElseThrow( RuntimeException::new );
    }

}
