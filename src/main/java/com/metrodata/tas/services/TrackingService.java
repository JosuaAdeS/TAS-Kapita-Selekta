/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.services;

import com.metrodata.tas.entities.Tracking;
import com.metrodata.tas.repositories.TrackingRespository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class TrackingService {
    @Autowired
    TrackingRespository repository;
    
    public List<Tracking> findByLaporan(int id){
        return repository.findByLaporan_Id(id);
    }
}
