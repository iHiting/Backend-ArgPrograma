/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.Service;

import com.portafolio.SpringBoot.entity.Presentacion;
import com.portafolio.SpringBoot.repository.RPresentacion;
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
public class SPresentacion {
    @Autowired 
    RPresentacion rpresentacionRepo;
     
    
    public List<Presentacion> list(){
        return rpresentacionRepo.findAll();
    }
    
    public Optional<Presentacion> getOne(int id){
        return rpresentacionRepo.findById(id);
    }
    
    public Optional<Presentacion> getByNombre(String nombre){
        return rpresentacionRepo.findByNombre(nombre);
    }
    
    public void save(Presentacion present){
        rpresentacionRepo.save(present);
    }
    
    public void delete(int id){
        rpresentacionRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rpresentacionRepo.existsById(id);
        
    }
    
    public boolean existsByNombre(String nombre){
        return rpresentacionRepo.existsByNombre(nombre);
    }   
}
