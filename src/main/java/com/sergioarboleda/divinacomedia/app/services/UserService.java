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
    
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUserById(Integer id){
        return repository.getUserById(id);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public User getUserByIdUser(Integer id){
        return getUserById(id).orElse(new User());
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
        if(user.getId()==null){
            return user;
        }else{
            if(user.getIdentification()==null || user.getEmail()==null || user.getName()==null || user.getPassword()==null || user.getType()==null){
                return user;
            }else{
                List<User> existUsers = repository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                if(existUsers.isEmpty()){
                    return repository.save(user);
                }else{
                    return user;
                }
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
            return new User();
        }
    }
    
    
    /**
     * 
     * @param user
     * @return 
     */
    public User update(User user){
        Optional<User> existUser = repository.getUserById(user.getId());
        if(existUser.isPresent()){
            if(user.getIdentification()!=null){
                existUser.get().setIdentification(user.getIdentification());
            }
            if(user.getName()!=null){
                existUser.get().setName(user.getName());
            }
            
            /*
            if(user.getBirthtDay()!=null){
                existUser.get().setBirthtDay(user.getBirthtDay());
            }
            **/
            
            /*
            if(user.getMonthBirthtDay()!=null){
                existUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
            }
            */
            
            if(user.getAddress()!=null){
                existUser.get().setAddress(user.getAddress());
            }
            if(user.getCellPhone()!=null){
                existUser.get().setCellPhone(user.getCellPhone());
            }
            if(user.getEmail()!=null){
                existUser.get().setEmail(user.getEmail());
            }
            if(user.getPassword()!=null){
                existUser.get().setPassword(user.getPassword());
            }
            if(user.getZone()!=null){
                existUser.get().setZone(user.getZone());
            }
            if(user.getType()!=null){
                existUser.get().setType(user.getType());
            }
            return repository.save(existUser.get());
        }else{
            return user;
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(Integer id){
        Boolean aBoolean = getUserById(id).map(user -> {
            repository.delete(user.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
