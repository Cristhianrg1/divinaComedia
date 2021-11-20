/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cristhianrg
 */


@Data //evitamos tener que agregar los getter and setters
@NoArgsConstructor //evitamos el constructor vacio
@AllArgsConstructor //evitamos tener de agregar e onstructor con los parametros
@Entity
@Table(name="user") // con table le damos el nombre a la tabla
public class User implements Serializable{
    
    
    
    @Id // se debe definir un Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Con esto generamos el Id de forma incremental automatico
    private Integer id;
    @Column(name="user_mail", unique = true, length = 50, nullable = false) // Dar nombre a la columna, indicar que es unica, el tamano y si puede ser null o no
    private String email;
    @Column(name="user_password", length = 50, nullable = false) // Dar nombre a la columna, indicar que es unica, el tamano y si puede ser null o no
    private String password;
    @Column(name="user_name", length = 80, nullable = false) // Dar nombre a la columna, indicar que es unica, el tamano y si puede ser null o no
    private String name;
    
    
}
