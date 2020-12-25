package com.example.user;

import com.example.rentsystem.UserType;
import com.example.rentsystem.VehicleOwner;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}

//interface UserTypeRepository extends CrudRepository<UserType, Integer> {
//}
