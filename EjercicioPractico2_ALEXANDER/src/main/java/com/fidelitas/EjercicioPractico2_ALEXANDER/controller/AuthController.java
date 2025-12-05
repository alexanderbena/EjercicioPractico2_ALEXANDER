/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.controller;

/**
 *
 * @author alexa
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
 

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "auth/login"; // Vista Thymeleaf
    }

     @GetMapping("/post-login")
    public String postLogin(Authentication auth) {
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/usuarios";
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PROFESOR"))) {
            return "redirect:/reportes";
        } else {
            return "redirect:/perfil";
        }
    }

}

