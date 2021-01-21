package com.example.rentsystem;

import com.example.user.AppUser;
import com.example.user.UserType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDAO{
    public void save(User p);
    public void updateUser(User p);
    public List<User> findAll();
    public User findById(int id);
    public User findByName(String name);
    public void deleteUser(int id);
}

