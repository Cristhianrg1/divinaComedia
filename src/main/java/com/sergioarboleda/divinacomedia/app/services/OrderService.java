/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.services;


import com.sergioarboleda.divinacomedia.app.models.Order;
import com.sergioarboleda.divinacomedia.app.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristhianrg
 */
@Service    
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    
    /**
     * 
     * @return 
     */
    public List<Order> getAll(){
        return repository.getAll();
    }
    
    
    
    
    /**
     * 
     * @param id
     * @return 
     */
    public Order getOrderByIdOrder(Integer id){
        return repository.getById(id).orElse(new Order());
    }
    
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order save(Order order){
        Optional<Order> existProduct = repository.getById(order.getId());
        if(existProduct.isEmpty()){
            return repository.save(order);
        }else{
            return order;
        }
    }
    
    
    public void delete(Integer id){
        repository.delete(id);
    }
    
    
    
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order update(Order order) {
        Optional<Order> existsOrder = repository.getById(order.getId());
        if(!existsOrder.isEmpty()){
            existsOrder.get().setStatus(order.getStatus());
            return repository.save(existsOrder.get());
        }else{
            return order;
        }
    }
    
    
    /**
     * 
     * @param id
     * @return 
     */
    public List<Order> getOrdersBySalesManId(Integer id){
        return repository.getAllOrderBySalesManId(id);
    }
    
    /**
     * 
     * @param zone
     * @return 
     */
    public List<Order> getOrdersBySalesManZone(String zone){
        return repository.getAllOrderBySalesManZone(zone);
    }
    
}
