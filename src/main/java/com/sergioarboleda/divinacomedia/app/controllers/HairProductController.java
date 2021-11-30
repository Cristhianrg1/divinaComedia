/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.controllers;

import com.sergioarboleda.divinacomedia.app.models.HairProduct;
import com.sergioarboleda.divinacomedia.app.services.HairProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author cristhianrg
 */
@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*")
public class HairProductController {
    
    @Autowired
    private HairProductService service;
    
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<HairProduct> getUsers(){
        return service.getAll();
    }
    
    
    /**
     * 
     * @param product
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){
        return service.save(product);
    }
    
    
    /**
     * 
     * @param product
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){
        return service.update(product);
    }
}
