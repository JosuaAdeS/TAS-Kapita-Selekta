/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.services;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.entities.Status;
import com.metrodata.tas.entities.Tracking;
import com.metrodata.tas.entities.User;
import com.metrodata.tas.repositories.LaporanRespository;
import com.metrodata.tas.repositories.TrackingRespository;
import com.metrodata.tas.repositories.UserRepository;
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
    
    @Autowired
    TrackingRespository trackingRespository;
    
    @Autowired
    UserRepository userRepository;
    
    public boolean saveLaporan(Laporan input){
        try {
            repository.save(input);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateLaporan(Laporan input){
        try {
            repository.save(input);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<Laporan> getAll(){
        return repository.findAll();
    }
    
    public Laporan getById(int id){
        return repository.findById(id).get();
    }
    
    public List<Laporan> findByDivisi(int id){
        return (List<Laporan>) repository.findByDivisi_Id(id);
    }
    
    public List<Laporan> findByUser(String id){
        return (List<Laporan>) repository.findByUser_Id(id);
    }    
    
    public List<Laporan> findByDivisiAndStatus(int divisi,int status){
        return (List<Laporan>) repository.findByDivisi_IdAndCurrentStatus_Id(divisi, status);
    }    
    
    public List<User> findByEmail(String email){
        return (List<User>) userRepository.findByEmail(email);
    }    
    
}
