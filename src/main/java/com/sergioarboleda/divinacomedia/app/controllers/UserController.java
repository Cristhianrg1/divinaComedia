package com.sergioarboleda.divinacomedia.app.controllers;


import com.sergioarboleda.divinacomedia.app.models.User;
import com.sergioarboleda.divinacomedia.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author cristhianrg
 */
@RestController
@RequestMapping("user")// Mapeto la url como me la pide la peticion. No necesito definir /api porque en properties ya lo hice
@CrossOrigin(origins = "*") //me habilita el acceso desde cualquier origen
public class UserController {
    
    @Autowired
    private UserService service;
    
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }
    
    
    /**
     * 
     * @param email
     * @return 
     */
    @GetMapping("/{email}")
    public boolean emailExist(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User emailAndPassExist(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
    
}
