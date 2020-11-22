package com.example.rentsystem;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}

interface CarRepository extends CrudRepository<Car, Integer> {
}

//interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
//}

