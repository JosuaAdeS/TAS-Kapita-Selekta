/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.User;
import com.metrodata.tas.repositories.DeskripsiTrackingRepository;
import com.metrodata.tas.repositories.DivisiRespository;
import com.metrodata.tas.repositories.StatusRepository;
import com.metrodata.tas.repositories.UserRepository;
import com.metrodata.tas.services.EmailService;
import com.metrodata.tas.services.GetRestService;
import com.metrodata.tas.services.LaporanService;
import com.metrodata.tas.services.TrackingService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    
    @Autowired
    TrackingService trackingService;
    
    @Autowired
    DeskripsiTrackingRepository deskripsiTrackingRepository;
    
    public String currentId = null;
    
    @GetMapping("/home")
    public String homeUser(Model model, Divisi d, Principal principal) {
        
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getName();
        String temp = lapService.findByEmail(username).toString();
        currentId = temp.substring(37, 47);
        
        if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            int idDiv = userRepository.findById(currentId).get().getDivisi().getId();
            
            model.addAttribute("laporan", lapService.findByDivisi(idDiv));
            model.addAttribute("statuses", statusRepository.findAll());
            model.addAttribute("divisies", divisiRespository.findAll());
            model.addAttribute("nama", userRepository.findById(currentId).get().getNama());
            return "homeDivisi";
        } else if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_LEARNER"))) {
            model.addAttribute("basic", getService.getProfileBasic(currentId));
            model.addAttribute("statuses", statusRepository.findAll());
            model.addAttribute("divisies", divisiRespository.findAll());
            model.addAttribute("userid", currentId);
            return "home";
        }else if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_SUPER_ADMIN"))){
            return "homeAdmin";
        }
        return "";
    }

    @GetMapping("/history")
    public String historyUser(Model model) {
        model.addAttribute("laporan", lapService.findByUser(currentId));
        return "history";
    }
    
    @RequestMapping(value = "tracking/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String tracking(Model model, @PathVariable("id") int id) {
        model.addAttribute("tracking", trackingService.findByLaporan(id));
        return "tracking";
    }
    
}
