/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.Service;

import com.portafolio.SpringBoot.entity.Contactos;

import com.portafolio.SpringBoot.repository.RContactos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gaston
 */
@Service
@Transactional
public class SContactos {
    @Autowired
    RContactos sContactos;
    
    public List<Contactos> list() {
        return sContactos.findAll();
    }
    
    public Optional<Contactos> getOne(int id){
        return sContactos.findById(id);
    }
    
    public Optional<Contactos> getByImg (String img){
        return sContactos.findByImg(img);
    }
    
    public void save(Contactos contacto){
        sContactos.save(contacto);
    }
    
    public void delete(int id){
        sContactos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return sContactos.existsById(id);
    }
    
    public boolean existsByImg(String img){
        return sContactos.existsByImg(img);
    }     
}
