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
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Set;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "auth/login"; // Vista Thymeleaf
    }

    @GetMapping("/post-login")
    public String postLogin(Authentication auth) {
        Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/usuarios";
        } else if (roles.contains("ROLE_PROFESOR")) {
            return "redirect:/reportes";
        } else {
            return "redirect:/perfil";
        }
    }
}

