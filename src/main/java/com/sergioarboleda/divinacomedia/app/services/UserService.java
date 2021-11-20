package com.sergioarboleda.divinacomedia.app.services;

import com.sergioarboleda.divinacomedia.app.models.User;
import com.sergioarboleda.divinacomedia.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cristhianrg
 */
@Service //Definicion del servicio
public class UserService {
    
    //Inyeccion de dependencias
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
        if(user.getId()==null){
            List<User> existUsers = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if(existUsers.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
           
        }else{
            Optional<User> existUser = repository.getUserById(user.getId());
            if (existUser.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
        }
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if(user.isPresent()){
            return user.get();
        }else{
            return new User(null,email, password,"NO DEFINIDO");
        }
    }
    
}
