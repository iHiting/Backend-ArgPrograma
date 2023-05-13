/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.entity;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
    
    @NotNull
    @Size(min = 1, max= 50, message = "no cumple con la longitud")
     private String nombre;
    
    
    @NotNull
    @Size(min = 1, max= 50, message = "no cumple con la longitud")
     private String apellido;
     
    @NotNull
    private String descripcion;
    
    @NotNull
     private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    
    
}
