package com.example.vehicle;

import com.example.user.AppUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleDAO{
    // reference: https://stackoverflow.com/a/53817222
//    @Query(value = "SELECT id, reg_no, color, make, model, transmission, available, license_expiry_date FROM Vehicle", nativeQuery = true)
//    List<VehicleBasicData> findAllVehicleBasicData();

//    public void save(Vehicle v);
//    public List<Vehicle> findAll();
//    public Optional<Vehicle> findById(int id);
//    public void update(Vehicle v);
    public void deleteById(int id);
    public List<VehicleBasicData> findAllVehicleBasicData();
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

