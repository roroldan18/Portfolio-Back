package com.rrportafolio.portafolio.service;

import java.util.*;
import com.rrportafolio.portafolio.model.User;

public interface IUserService {
    
    //Traigo todos los users
    public List<User> getUsers();
    
    //Creo un user
    public void saveUser(User user);
    
    //borrar usuario
    public void deleteUser(Long id);
    
    //Find one user by id
    public User getOneUserById(Long id);
    
    //Find one user by username
    public Optional<User> getOneUserByUsername(String username);
    
    //Check if user exists
    public boolean existsByUsername(String username);
    
    //Check if user exists
    public boolean existsById(Long id);

}
