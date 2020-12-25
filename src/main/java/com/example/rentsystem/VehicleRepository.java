package com.example.rentsystem;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}

interface CarRepository extends CrudRepository<Car, Integer> {
//    Optional<Car> findByVehicleId(int vehicle_id);
}

//interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
//}

