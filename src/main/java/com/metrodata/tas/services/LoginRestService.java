/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.services;

import com.metrodata.tas.entities.Divisi;
import com.metrodata.tas.entities.User;
import com.metrodata.tas.entities.rest.LoginInput;
import com.metrodata.tas.entities.rest.LoginOutput;
import com.metrodata.tas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Service
public class LoginRestService {
    @Autowired
    RestTemplate restTemplate;
    
    public LoginOutput login(LoginInput input){
        HttpEntity<LoginInput> request = new HttpEntity<>(input,null);
        ResponseEntity<LoginOutput> responseEntity = restTemplate.exchange("http://116.254.101.228:8080/ma_test/login", 
                HttpMethod.POST, 
                request, 
                new ParameterizedTypeReference<LoginOutput>(){
                }
        );
        return responseEntity.getBody();
    }
    
    @Autowired
    UserRepository repository;
    public boolean save(User user){
        try {
            repository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean saveDivisi(User user, Divisi d){
        try {
            repository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean getById(String id){
        try {
            repository.findById(id).get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
