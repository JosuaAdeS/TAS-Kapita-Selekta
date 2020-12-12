/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.LaporanInput;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.services.LaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author acer
 */
@Controller
public class LaporanController {

    @Autowired
    LaporanService lapService;
    
    @PostMapping("savelaporan")
    public String saveLaporan(LaporanInput input, Divisi divisi, Status currentStatus) {
        lapService.saveLaporan(input, divisi, currentStatus);
        return "redirect:/home";
    }
    
    @PostMapping("updatelaporan")
    public String updateLaporan(Laporan input) {
        lapService.updateLaporan(input);
        return "redirect:/home";
    }
    
}
