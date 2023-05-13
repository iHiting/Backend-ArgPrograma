/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.SpringBoot.repository;

import com.portafolio.SpringBoot.entity.Contactos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Gaston
 */
@Repository
public interface RContactos extends JpaRepository<Contactos, Integer>{
    public Optional<Contactos> findByImg(String img);
    public boolean existsByImg(String img);
}