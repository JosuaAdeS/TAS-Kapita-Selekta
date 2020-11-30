
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.rest.RegisterUser;
import com.metrodata.tas.services.GetRestService;
import com.metrodata.tas.services.RegistrationRestService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Controller
public class RegistrationRestController {
    @Autowired
    RegistrationRestService service;
    @Autowired
    GetRestService getService;
    
    @GetMapping("registrasi")
    public String regris(Model model){
        model.addAttribute("registrasi",new RegisterUser());
        model.addAttribute("universities", getService.getAllUniversity());
        model.addAttribute("majors", getService.getAllMajor());
        return "formRegistrasi";
    }
    
    @PostMapping("save")
    public String register(RegisterUser input){
         System.out.println(input);
         System.out.println(service.register(input));
         return "redirect:/";
    }
}
