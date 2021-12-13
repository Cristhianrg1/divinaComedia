/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories;

import com.sergioarboleda.divinacomedia.app.models.Order;
import com.sergioarboleda.divinacomedia.app.repositories.crud.OrderCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristhianrg
 */
@Repository
public class OrderRepository {
    
    
    // Inyeccion de dependencias
    @Autowired
    private OrderCrudRepository repository;
    
    /**
     * 
     * @return 
     */
    public List<Order> getAll(){
        return (List<Order>) repository.findAll();
    }
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order save(Order order) {
        return repository.save(order);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Order> getById(Integer id) {
        return repository.findById(id);
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
     * @return 
     */
    public List<Order> getAllOrderBySalesManId(Integer id){
        return repository.findBySalesManId(id);
    }
    
    /**
     * 
     * @param zone
     * @return 
     */
    public List<Order> getAllOrderBySalesManZone(String zone){
        return repository.findBySalesManZone(zone);
    }
}
