/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.getId;
import com.metrodata.tas.entities.rest.ProfileBasic;
import com.metrodata.tas.services.GetRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author user
 */
@Controller
public class ProfileRestController {
    @Autowired
    GetRestService service;
    
    @GetMapping("basic")
    public String profileBasic(Model model){
        model.addAttribute("basic", service.getProfileBasic(getId.id));
        System.out.println(service.getProfileBasic(getId.id));
        return "profileBasic";
    }
    
    @PostMapping("/savebasic")
    public String saveBasic(ProfileBasic input){
        System.out.println(input);
        System.out.println(service.updateProfileBasic(input));
        return "redirect:/basic";
    }
}
