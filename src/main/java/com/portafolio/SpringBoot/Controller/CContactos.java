/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.Controller;


import com.portafolio.SpringBoot.Service.SContactos;
import com.portafolio.SpringBoot.dto.dtoContactos;
import com.portafolio.SpringBoot.entity.Contactos;

import com.portafolio.SpringBoot.security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gaston
 */
@RestController
@RequestMapping("/contactos")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-argprograma-759a6.web.app"})
public class CContactos {
    @Autowired
    SContactos sContactos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Contactos>> list(){
        List<Contactos> list = sContactos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody dtoContactos dtocontactos){
        if(StringUtils.isBlank(dtocontactos.getImg()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sContactos.existsByImg(dtocontactos.getImg()))
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        
        Contactos contactos = new Contactos(dtocontactos.getImg(), dtocontactos.getLink());
        sContactos.save(contactos);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContactos dtocontactos){
        //Validar existencia de ID
       if(!sContactos.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
       //Comparar nombre de experiencia
       if(sContactos.existsByImg(dtocontactos.getImg()) && sContactos.getByImg(dtocontactos.getImg()).get().getId() != id)
           return new ResponseEntity(new Mensaje("Ese experiencia ya existe"), HttpStatus.BAD_REQUEST);
       //No puede estar vacio
       if(StringUtils.isBlank(dtocontactos.getImg()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
                   
       Contactos contactos = sContactos.getOne(id).get();
       contactos.setImg(dtocontactos.getImg());
       contactos.setLink(dtocontactos.getLink());
  
       sContactos.save(contactos);
       return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Contactos> getById(@PathVariable("id") int id){
        if(!sContactos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Contactos contactos = sContactos.getOne(id).get();
        return new ResponseEntity(contactos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sContactos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sContactos.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }
    
}
