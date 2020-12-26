package com.example.rentsystem;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Integer> {
//    User findByUsername(String username);
}

interface UserTypeRepository extends CrudRepository<UserType, Integer> {
}

interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
}

