package com.example.user;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserDAO {
        public void save(AppUser p);
        public void updatePerson(AppUser p);
        public List<AppUser> findAll();
        public AppUser getPersonById(int id);
        public AppUser findByName(String name);
        public void removePerson(int id);
}
