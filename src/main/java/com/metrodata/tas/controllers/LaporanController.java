/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.controllers;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.services.EmailService;
import com.metrodata.tas.services.LaporanService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    EmailService emailService;

    @PostMapping("savelaporan")
    public String saveLaporan(Laporan input) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date();
        String newDate = formatter.format(date);
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
        input.setTanggalLaporan(date1);
        lapService.saveLaporan(input);
        if (input.getDivisi().getId() == 1) {
            emailService.sendEmail(
                    "josua5ade@gmail.com",
                    "New Laporan",
                    "" + input.getUser().getNama()
                    + " telah mengirimkan laporan baru dengan judul " + input.getJudulLaporan()
                    + "\nSilahkan cek dashboard anda di http://localhost:8084/"
            );
        } else {
            emailService.sendEmail(
                    "robertusbagaskara@gmail.com",
                    "New Laporan",
                    " " + input.getUser().getNama()
                    + " telah mengirimkan laporan baru dengan judul " + input.getJudulLaporan()
                    + "\nSilahkan cek dashboard anda di http://localhost:8084/"
            );
        }
        return "redirect:/home";
    }

    @PostMapping("updatelaporan")
    public String updateLaporan(Laporan input) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date();
        String newDate = formatter.format(date);
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
        input.setTanggalLaporan(date1);
        lapService.updateLaporan(input);
        emailService.sendEmail(
                input.getUser().getEmail(),
                "Perubahan Status Laporan Anda",
                "Status laporan dengan judul " + input.getJudulLaporan()
                + " berubah status menjadi " + input.getCurrentStatus().getStatus()
                + "\n'" + input.getDeskripsiStatus() + "' --Divisi "+input.getDivisi().getNamaDivisi());

        return "redirect:/home";
    }

}
