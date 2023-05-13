/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.dto;

import com.sun.istack.NotNull;

/**
 *
 * @author Gaston
 */
public class dtoContactos {
   

    @NotNull
    private String img;
    @NotNull
    private String link;

    public dtoContactos() {
    }

    public dtoContactos(String img, String link) {
        this.img = img;
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
