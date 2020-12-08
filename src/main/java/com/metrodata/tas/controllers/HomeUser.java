/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.getId;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.entities.LaporanInput;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.User;
import com.metrodata.tas.services.GetRestService;
import com.metrodata.tas.services.LaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author acer
 */
@Controller
public class HomeUser {
    @Autowired
    GetRestService getService;
    
    @Autowired
    LaporanService lapService;
    
    @GetMapping("/home")
    public String homeUser(Model model){
        getService.getProfileBasic(getId.id);
        model.addAttribute("basic", getService.getProfileBasic(getId.id));
        model.addAttribute("input", new LaporanInput());
        model.addAttribute("divisi", new Divisi());
        model.addAttribute("status", new Status());
        return "home";
    }
    
    @GetMapping("/history")
    public String historyUser(){
        return "history";
    }
    
    @PostMapping("savelaporan")
    public String saveLaporan(LaporanInput input, Divisi divisi, Status currentStatus){
        lapService.saveLaporan(input, divisi, currentStatus);
        return "redirect:/";
    }
}
