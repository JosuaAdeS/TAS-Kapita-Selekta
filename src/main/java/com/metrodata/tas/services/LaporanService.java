/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.services;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.User;
import com.metrodata.tas.entities.getId;
import com.metrodata.tas.repositories.LaporanRespository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class LaporanService {
    @Autowired
    LaporanRespository repository;
    
    public boolean saveLaporan(){
        try {
            Status status = new Status(1);
            Divisi divisi = new Divisi(1);
            User user = new User(getId.id);
            
            Laporan laporan = new Laporan("LAP004", "coba", "AC Mati",new Date(),"Acnya di kantor ini mati pak", status, divisi, user);
            repository.save(laporan);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
