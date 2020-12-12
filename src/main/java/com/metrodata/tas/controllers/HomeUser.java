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
import com.metrodata.tas.repositories.DivisiRespository;
import com.metrodata.tas.repositories.StatusRepository;
import com.metrodata.tas.repositories.UserRepository;
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
    
    @Autowired
    StatusRepository statusRepository;
    
    @Autowired
    DivisiRespository divisiRespository;
    
    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public String homeUser(Model model, Divisi d) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        getService.getProfileBasic(getId.id);
        if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            int id = userRepository.findById(getId.id).get().getDivisi().getId();
            model.addAttribute("laporan", lapService.findByDivisi(id));
            model.addAttribute("statuses", statusRepository.findAll());
            model.addAttribute("divisies", divisiRespository.findAll());
            model.addAttribute("userid", getId.id);
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

    
}
