/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.EjercicioPractico2_ALEXANDER.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alexa
 */
@Controller
public class HomeController {
     @GetMapping("/")
    public String index() {
        return "index"; // busca templates/index.html
    }

}
