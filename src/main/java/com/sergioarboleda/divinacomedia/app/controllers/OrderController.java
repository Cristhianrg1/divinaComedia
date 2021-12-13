/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.controllers;

import com.sergioarboleda.divinacomedia.app.models.Order;
import com.sergioarboleda.divinacomedia.app.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristhianrg
 */
@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService service;
    
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }
    
    
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/user/{id}")
    public List<Order> getAllOrdersBySalesManId(@PathVariable("id") Integer id){
        return service.getOrdersBySalesManId(id);
    }
    
    
    /**
     * 
     * @param order
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }
    
    
    /**
     * 
     * @param order
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }
    
    
    
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return service.getOrderByIdOrder(id);
    }
    
    /**
     * 
     * @param zone
     * @return 
     */
    @GetMapping("/zona/{zone}")
    public List<Order> getAllOrdersBySalesManIdZone(@PathVariable("zone") String zone){
        return service.getOrdersBySalesManZone(zone);
    }
}
