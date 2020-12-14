/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.rest.ProfileBasic;
import com.metrodata.tas.services.GetRestService;
import com.metrodata.tas.services.LaporanService;
import java.security.Principal;
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

    @Autowired
    LaporanService lapService;
    String currentId = null;
    
    @GetMapping("basic")
    public String profileBasic(Model model,Principal principal) {
        
        String username = principal.getName();
        String temp = lapService.findByEmail(username).toString();
        currentId = temp.substring(37, 47);
        
        model.addAttribute("basic", service.getProfileBasic(currentId));
        System.out.println(service.getProfileBasic(currentId));
        return "profileBasic";
    }

    @PostMapping("/savebasic")
    public String saveBasic(ProfileBasic input) {
        System.out.println(input);
        System.out.println(service.updateProfileBasic(input));
        return "redirect:/basic";
    }
}
