package com.example.vehicle;

import com.example.common.CrudRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleDAO extends CrudRepo<Vehicle> {
    // reference: https://stackoverflow.com/a/53817222
//    @Query(value = "SELECT id, reg_no, color, make, model, transmission, available, license_expiry_date FROM Vehicle", nativeQuery = true)
//    List<VehicleBasicData> findAllVehicleBasicData();
    public List<Vehicle> findAllVehicleBasicData();
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

@Repository
interface CarDAO extends CrudRepo<Car>{
}

@Repository
interface LorryDAO extends CrudRepo<Lorry>{
}


