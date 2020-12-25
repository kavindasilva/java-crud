package com.example.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByName(String name);
}

//interface UserTypeRepository extends CrudRepository<UserType, Integer> {
//}
