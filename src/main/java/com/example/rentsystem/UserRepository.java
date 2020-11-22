package com.example.rentsystem;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

interface UserTypeRepository extends CrudRepository<UserType, Integer> {
}

interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
}

