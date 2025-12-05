/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.service;

import com.fidelitas.EjercicioPractico2_ALEXANDER.domain.Usuario;
import com.fidelitas.EjercicioPractico2_ALEXANDER.domain.Rol;
import com.fidelitas.EjercicioPractico2_ALEXANDER.repository.UsuarioRepository;
import com.fidelitas.EjercicioPractico2_ALEXANDER.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    // CRUD básicos
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    // 🔹 Consulta avanzada: búsqueda parcial por email o nombre
    public List<Usuario> buscarPorEmailONombre(String texto) {
        return usuarioRepository
                .findByEmailContainingIgnoreCaseOrNombreContainingIgnoreCase(texto, texto);
    }

    // 🔹 Consulta avanzada: buscar usuarios por rol
    public List<Usuario> buscarPorRol(String rolNombre) {
        Rol rol = rolRepository.findByNombre(rolNombre).orElse(null);
        if (rol != null) {
            return usuarioRepository.findByRol(rol);
        }
        return List.of(); // lista vacía si no existe el rol
    }

    // 🔹 Consulta avanzada: buscar usuarios por rango de fechas
    public List<Usuario> buscarPorFechaCreacionEntre(LocalDateTime inicio, LocalDateTime fin) {
        return usuarioRepository.findByFechaCreacionBetween(inicio, fin);
    }
}

