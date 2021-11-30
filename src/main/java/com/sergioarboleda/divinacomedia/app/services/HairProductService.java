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
     * @param reference
     * @return 
     */
    public Optional<HairProduct> getProductById(String reference){
        return repository.getByReference(reference);
    }
    
    /**
     * 
     * @param product
     * @return 
     */
    public HairProduct save(HairProduct product){
        if(product.getReference()==null){
            return product;
        }else{
            Optional<HairProduct> existProduct = repository.getByReference(product.getReference());
            if(existProduct.isEmpty()){
                return repository.save(product);
            }else{
                return product;
            }
        }
    }
    
    
    /**
     * 
     * @param reference
     * @return 
     */
    public boolean delete(String reference){
        Boolean aBoolean = getProductById(reference).map(product -> {
            repository.delete(product.getReference());
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    /**
     * 
     * @param product
     * @return 
     */
    public HairProduct update(HairProduct product){
        Optional<HairProduct> existProduct = repository.getByReference(product.getReference());
        if(existProduct.isPresent()){
            if(product.getBrand()!=null){
                existProduct.get().setBrand(product.getBrand());
            }
            if(product.getCategory()!=null){
                existProduct.get().setCategory(product.getCategory());
            }
            if(product.getName()!=null){
                existProduct.get().setName(product.getName());
            }
            if(product.getDescription()!=null){
                existProduct.get().setDescription(product.getDescription());
            }
            
            existProduct.get().setPrice(product.getPrice());
            
            
            existProduct.get().setQuantity(product.getQuantity());
            
            
            if(product.getPhotography()!=null){
                existProduct.get().setPhotography(product.getPhotography());
            }
            
            existProduct.get().setAvailability(product.isAvailability());
            
            
            return repository.save(existProduct.get());
        }else{
            return product;
        }
    }
}
