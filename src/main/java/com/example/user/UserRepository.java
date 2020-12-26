package com.example.user;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByName(String name);
}

//interface UserTypeRepository extends CrudRepository<UserType, Integer> {
//}
