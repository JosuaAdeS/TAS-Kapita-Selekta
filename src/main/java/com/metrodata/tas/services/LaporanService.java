/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.services;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.entities.LaporanInput;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.User;
import com.metrodata.tas.entities.getId;
import com.metrodata.tas.repositories.LaporanRespository;
import java.util.Date;
import java.util.List;
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
    
    public boolean saveLaporan(LaporanInput input, Divisi divisi, Status currentStatus){
        try {
            Status status = new Status(currentStatus.getId());
            Divisi div = new Divisi(divisi.getId());
            User user = new User(getId.id);
            
            Laporan lap = new Laporan(null, input.getJudulLaporan(), input.getIsiLaporan(), new Date(), input.getDeskripsiStatus(), currentStatus, divisi, user);
            repository.save(lap);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<Laporan> getAll(){
        return repository.findAll();
    }
    
    public Laporan getById(String id){
        return repository.findById(id).get();
    }
}
