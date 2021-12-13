/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories.crud;

import com.sergioarboleda.divinacomedia.app.models.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author cristhianrg
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone':?0}")
    List<Order> findBySalesManZone(String zone);
    
    @Query("{'salesMan.id':?0}")
    List<Order> findBySalesManId(Integer id);
    
    List<Order> findByRegisterDayAndSalesMan_Id(Date registerDay, Integer id);
    
    List<Order> findByStatusAndSalesMan_Id(String status, Integer id);
}
