/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.Controller;

import com.portafolio.SpringBoot.Service.SPresentacion;
import com.portafolio.SpringBoot.dto.dtoPresentacion;
import com.portafolio.SpringBoot.entity.Presentacion;
import com.portafolio.SpringBoot.security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gaston
 */
@Controller
@RestController
@RequestMapping("/presentacion")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-argprograma-759a6.web.app"})
public class CPresentacion {
    @Autowired SPresentacion presentacionService;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Presentacion>> list(){
        List<Presentacion> list = presentacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Presentacion> getById(@PathVariable("id")int id){
        if(!presentacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Presentacion presentacion = presentacionService.getOne(id).get();
        
        return new ResponseEntity(presentacion, HttpStatus.OK);
    }
    
   

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPresentacion dtopresentacion){
        if (!presentacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if (presentacionService.existsByNombre(dtopresentacion.getNombre()) && presentacionService.getByNombre(dtopresentacion.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopresentacion.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio "), HttpStatus.BAD_REQUEST);
        }
        
        Presentacion presentacion = presentacionService.getOne(id).get();
        
        presentacion.setNombre(dtopresentacion.getNombre());
        presentacion.setImg(dtopresentacion.getImg());
        presentacion.setProfesion(dtopresentacion.getProfesion());
        
        presentacionService.save(presentacion);
        
        return new ResponseEntity(new Mensaje ("Educacion actualizada"), HttpStatus.OK);
    }
}
