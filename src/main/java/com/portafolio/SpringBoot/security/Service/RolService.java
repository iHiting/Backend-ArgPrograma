/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.SpringBoot.security.Service;

import com.portafolio.SpringBoot.security.Entity.Rol;
import com.portafolio.SpringBoot.security.Repository.iRolRepository;
import com.portafolio.SpringBoot.security.enums.RolNombre;
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
public class RolService {
    @Autowired
    iRolRepository irolRepository; 
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        System.out.println("Buscando rol: " + rolNombre);
        System.out.println("Rol encontrado: " + irolRepository.findByRolNombre(rolNombre));
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
