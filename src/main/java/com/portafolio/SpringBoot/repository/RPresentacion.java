/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.SpringBoot.repository;



import com.portafolio.SpringBoot.entity.Presentacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gaston
 */
public interface RPresentacion extends JpaRepository<Presentacion, Integer>{
    public Optional<Presentacion> findByNombre (String nombre);
    public boolean existsByNombre(String nombre);
    
}
