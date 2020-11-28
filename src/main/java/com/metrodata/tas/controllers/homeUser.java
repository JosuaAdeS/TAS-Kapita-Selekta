/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author acer
 */
@Controller
public class homeUser {
    
    @GetMapping("/home")
    public String homeUser(){
        return "home";
    }
}
