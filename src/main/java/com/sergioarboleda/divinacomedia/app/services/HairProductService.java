/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.services;

import com.sergioarboleda.divinacomedia.app.models.HairProduct;
import com.sergioarboleda.divinacomedia.app.repositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristhianrg
 */
@Service
public class HairProductService {
    
    @Autowired
    private HairProductRepository repository;
    
    /**
     * 
     * @return 
     */
    public List<HairProduct> getAll(){
        return repository.getAll();
    }
    
    
    
    /**
     * 
     * @param product
     * @return 
     */
    public HairProduct save(HairProduct product){
        Optional<HairProduct> existProduct = repository.getByReference(product.getId());
        if(existProduct.isEmpty()){
            return repository.save(product);
        }else{
            return product;
        }
    }
    
    
    public void delete(String id){
        repository.delete(id);
    }
    
    
    /**
     * 
     * @param product
     * @return 
     */
    public HairProduct update(HairProduct product) {
        Optional<HairProduct> existsProduct = repository.getByReference(product.getId());
        if (!existsProduct.isEmpty()) {
            existsProduct.get().setId(product.getId());
            existsProduct.get().setBrand(product.getBrand());
            existsProduct.get().setCategory(product.getCategory());
            existsProduct.get().setName(product.getName());
            existsProduct.get().setDescription(product.getDescription());
            existsProduct.get().setAvailability(product.isAvailability());
            existsProduct.get().setPrice(product.getPrice());
            existsProduct.get().setQuantity(product.getQuantity());
            existsProduct.get().setPhotography(product.getPhotography());

            return repository.save(existsProduct.get());
        } else {
            return product;
        }
    }
    
    public Optional<HairProduct> getProductById(String id){
        return repository.getByReference(id);
    }
  
}
