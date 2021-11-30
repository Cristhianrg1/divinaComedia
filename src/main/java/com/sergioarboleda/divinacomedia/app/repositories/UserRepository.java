/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories;

import com.sergioarboleda.divinacomedia.app.models.User;
import com.sergioarboleda.divinacomedia.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristhianrg
 */
@Repository // con esta anotacion se define elrepositorio 
public class UserRepository {
    
    // Inyeccion de dependencias
    @Autowired
    private UserCrudRepository repository; 
    
    
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }
    
    
    /**
     * 
     * @param email
     * @return 
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }
    
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
    
    
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
        return repository.save(user);
    }
    
    /**
     * 
     * @param id 
     */
    public void delete(Integer id){
        repository.deleteById(id);
    }
    
    /**
     * 
     * @param id
     * @param email
     * @param name
     * @return 
     */
    public List<User> getUserByIdOrEmailOrName(Integer id, String email, String name){
       return repository.findByIdOrEmailOrName(id, email, name);
    }
            
}
