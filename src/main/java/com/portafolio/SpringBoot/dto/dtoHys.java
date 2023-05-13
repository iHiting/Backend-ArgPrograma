/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Gaston
 */


public class dtoHys {
    @NotBlank  
    private String nombre;
    @NotBlank  
    private int porcentaje;
    @NotBlank
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    public dtoHys() {
    }

    public dtoHys(String nombre, int porcentaje, String img) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
