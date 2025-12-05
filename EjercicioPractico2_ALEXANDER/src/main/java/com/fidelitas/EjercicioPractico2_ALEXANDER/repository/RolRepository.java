/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.repository;

/**
 *
 * @author alexa
 */
import com.fidelitas.EjercicioPractico2_ALEXANDER.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}
