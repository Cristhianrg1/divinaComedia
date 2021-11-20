/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories.crud;

import com.sergioarboleda.divinacomedia.app.models.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author cristhianrg
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    
    
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> findByName(String name);
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    public List<User> findByNameOrEmail(String name, String email);
    
    /**
     * 
     * @param email
     * @return 
     */
    public Optional<User> findByEmail(String email);
   
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
