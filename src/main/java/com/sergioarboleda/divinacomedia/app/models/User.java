/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.models;


import java.util.Date;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.annotation.Id;

/**
 *
 * @author cristhianrg
 */
@Data //evitamos tener que agregar los getter and setters
@NoArgsConstructor //evitamos el constructor vacio
@AllArgsConstructor //evitamos tener de agregar e onstructor con los parametros
@Document(collection = "usuarios")
public class User {
    
    
    
    @Id // se debe definir un Id 
    private Integer id;
    private String identification;
    private String name;
    private Date birthtDay;
    private String monthBirthtDay;
    private String address;
    private String cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;
}
