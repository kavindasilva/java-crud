package com.example.vehicle;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarDAO extends VehicleDAO{
    public void save(Car v);
    public List<Car> findAll();
    public Optional<Car> findById(int id);
    public void update(Car v);
}
