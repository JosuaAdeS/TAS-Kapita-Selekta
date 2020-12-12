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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String homeUser(Model model) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        getService.getProfileBasic(getId.id);
        if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            model.addAttribute("laporan", lapService.getAll());
            model.addAttribute("divisi", new Divisi());
            model.addAttribute("status", new Status());
            return "homeDivisi";
        } else if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_LEARNER"))) {
            model.addAttribute("basic", getService.getProfileBasic(getId.id));
            model.addAttribute("input", new LaporanInput());
            model.addAttribute("divisi", new Divisi());
            model.addAttribute("status", new Status());
            return "home";
        }
        return "";
    }

    @GetMapping("/history")
    public String historyUser() {
        return "history";
    }

    @PostMapping("savelaporan")
    public String saveLaporan(LaporanInput input, Divisi divisi, Status currentStatus) {
        lapService.saveLaporan(input, divisi, currentStatus);
        return "redirect:/home";
    }
    
    @RequestMapping(value = "update/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(Model model, @PathVariable("id") String id) {
        model.addAttribute("person", lapService.getById(id));
        return "personUpdate";
    }
}
