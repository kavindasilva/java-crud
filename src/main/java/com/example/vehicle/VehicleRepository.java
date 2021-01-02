package com.example.vehicle;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}

interface CarRepository extends CrudRepository<Car, Integer> {
//    Optional<Car> findByVehicleId(int vehicle_id);
}

//interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
//}

