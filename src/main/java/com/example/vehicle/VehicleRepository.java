package com.example.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
//    @Query(value = "SELECT v.id, v.reg_no, v.color, v.make FROM vehicle v", nativeQuery = true)
    @Query(value = "SELECT id, reg_no, color, make, model FROM Vehicle", nativeQuery = false)
    List<Object> findAllVechicleBasicData();
}

interface VechicleBasicData {
    Integer getId();
    String getReg_no();
//    int getOwner_id(); // @TODO: make a fk to owner table. until that default 1 (user_id 10)
    String getLicense_expiry_date();
    String getColor();
    String getMake();
    String getModel();
//    String getTransmission();
//    boolean isAvailable();
//    boolean isDeleted();
}

interface CarRepository extends CrudRepository<Car, Integer> {
//    Optional<Car> findByVehicleId(int vehicle_id);
}

interface LorryRepository extends CrudRepository<Lorry, Integer> {
}

//interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
//}

