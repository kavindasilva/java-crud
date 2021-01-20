package com.example.user;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserDAO {
        public void save(AppUser p);
        public void updateUser(AppUser p);
        public List<AppUser> findAll();
        public AppUser getUserById(int id);
        public AppUser findByName(String name);
        public void deleteUser(int id);
}
