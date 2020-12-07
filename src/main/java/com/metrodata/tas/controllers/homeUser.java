/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.getId;
import com.metrodata.tas.services.GetRestService;
import com.metrodata.tas.services.LaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author acer
 */
@Controller
public class homeUser {
    @Autowired
    GetRestService getService;
    
    @GetMapping("/home")
    public String homeUser(Model model){
        getService.getProfileBasic(getId.id);
        model.addAttribute("basic", getService.getProfileBasic(getId.id));
        return "home";
    }
    
    @GetMapping("/history")
    public String historyUser(){
        return "history";
    }
    
    @Autowired
    LaporanService lapService;
    @GetMapping("laporan")
    public String saveLaporan(Model model){
        lapService.saveLaporan();
        return "redirect:/";
    }
}
