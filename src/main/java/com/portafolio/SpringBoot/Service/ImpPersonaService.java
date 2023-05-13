/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.Service;



import com.portafolio.SpringBoot.entity.Persona;
import com.portafolio.SpringBoot.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gaston
 */
@Transactional
@Service
public class ImpPersonaService{
    @Autowired 
   
    IPersonaRepository ipersonaRepository;
     
    
    public List<Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombreE(String nombreE){
        return ipersonaRepository.findByNombre(nombreE);
    }
    
    public void save(Persona expe){
        ipersonaRepository.save(expe);
    }
    
    public void delete(int id){
        ipersonaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
        
    }
    
    public boolean existsByNombre(String nombreE){
        return ipersonaRepository.existsByNombre(nombreE);
    }

   
}
