/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.SpringBoot.security.Repository;

import com.portafolio.SpringBoot.security.Entity.Rol;
import com.portafolio.SpringBoot.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gaston
 */

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
   Optional<Rol> findByRolNombre (RolNombre rolNombre);  
}
 