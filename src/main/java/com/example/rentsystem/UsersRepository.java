package com.example.rentsystem;

import com.example.user.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Integer> {
//    User findByUsername(String username);
}

interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, Integer> {
}

