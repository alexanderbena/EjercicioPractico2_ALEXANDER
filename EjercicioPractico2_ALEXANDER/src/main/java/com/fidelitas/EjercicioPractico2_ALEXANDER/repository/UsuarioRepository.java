/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.repository;

import com.fidelitas.EjercicioPractico2_ALEXANDER.domain.Usuario;
import com.fidelitas.EjercicioPractico2_ALEXANDER.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Buscar usuarios por rol
    List<Usuario> findByRol(Rol rol);

    //Buscar usuarios creados en un rango de fechas
    List<Usuario> findByFechaCreacionBetween(LocalDateTime inicio, LocalDateTime fin);

    //Buscar usuarios por coincidencia parcial en correo o nombre
    List<Usuario> findByEmailContainingIgnoreCaseOrNombreContainingIgnoreCase(String email, String nombre);

    //Contar usuarios activos vs inactivos
    long countByActivoTrue();
    long countByActivoFalse();

    //Obtener usuarios ordenados por fecha de creación
    List<Usuario> findAllByOrderByFechaCreacionDesc();
}

