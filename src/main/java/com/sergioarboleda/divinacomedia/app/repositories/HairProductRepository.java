package com.sergioarboleda.divinacomedia.app.repositories;

import com.sergioarboleda.divinacomedia.app.models.HairProduct;
import com.sergioarboleda.divinacomedia.app.repositories.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristhianrg
 */
@Repository
public class HairProductRepository {
    
    // Inyeccion de dependencias
    @Autowired
    private HairProductCrudRepository repository;
    
    /**
     * 
     * @return 
     */
    public List<HairProduct> getAll(){
        return (List<HairProduct>) repository.findAll();
    }
    
    /**
     * 
     * @param reference
     * @return 
     */
    public Optional<HairProduct> getByReference(String reference){
        return repository.findById(reference);
    }
    
    /**
     * 
     * @param product
     * @return 
     */
    public HairProduct save(HairProduct product){
        return repository.save(product);
    }
    
    /**
     * 
     * @param id 
     */
    public void delete(String reference){
        repository.deleteById(reference);
    }
    
}
