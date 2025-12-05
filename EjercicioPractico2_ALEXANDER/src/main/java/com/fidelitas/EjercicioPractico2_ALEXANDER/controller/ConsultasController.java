/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.controller;

/**
 *
 * @author alexa
 */
import com.fidelitas.EjercicioPractico2_ALEXANDER.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    private final UsuarioService usuarioService;

    public ConsultasController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String index() {
        return "consultas/index"; // Vista principal de consultas
    }

    @GetMapping("/por-rol")
    public String porRol(@RequestParam String rol, Model model) {
        model.addAttribute("usuarios", usuarioService.buscarPorRol(rol));
        return "consultas/resultados";
    }

    @GetMapping("/rango-fechas")
    public String rangoFechas(@RequestParam String inicio,
                              @RequestParam String fin,
                              Model model) {
        // convertir inicio/fin a LocalDateTime y llamar al service
        return "consultas/resultados";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String texto, Model model) {
        model.addAttribute("usuarios",
            usuarioService.buscarPorEmailONombre(texto));
        return "consultas/resultados";
    }
}
