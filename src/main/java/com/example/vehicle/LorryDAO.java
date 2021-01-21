package com.example.vehicle;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LorryDAO extends VehicleDAO{
    public void save(Lorry v);
    public List<Lorry> findAll();
    public Optional<Lorry> findById(int id);
    public void update(Lorry v);
}
