package com.example.vehicle;

import com.example.rentsystem.VehicleOwner;
import org.springframework.data.repository.CrudRepository;

public interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
}
