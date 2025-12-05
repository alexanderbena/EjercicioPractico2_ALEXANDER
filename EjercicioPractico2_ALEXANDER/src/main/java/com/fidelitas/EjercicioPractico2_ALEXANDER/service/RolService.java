/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.service;

import com.fidelitas.EjercicioPractico2_ALEXANDER.domain.Rol;
import com.fidelitas.EjercicioPractico2_ALEXANDER.repository.RolRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    // Constructor con inyección de dependencias
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    // Métodos CRUD básicos
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}
