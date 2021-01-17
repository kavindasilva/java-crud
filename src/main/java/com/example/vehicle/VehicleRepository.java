package com.example.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    // reference: https://stackoverflow.com/a/53817222
    @Query(value = "SELECT id, reg_no, color, make, model, transmission, available, license_expiry_date FROM Vehicle", nativeQuery = true)
    List<VehicleBasicData> findAllVehicleBasicData();
}

interface VehicleBasicData {
    Integer getId();
    String getReg_no();
    String getLicense_expiry_date();
    String getColor();
    String getMake();
    String getModel();
    String getTransmission();
    boolean isAvailable();
}

interface CarRepository extends CrudRepository<Car, Integer> {
//    Optional<Car> findByVehicleId(int vehicle_id);
}

interface LorryRepository extends CrudRepository<Lorry, Integer> {
}

//interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
//}

