package com.metrodata.tas.services;

import com.metrodata.tas.entities.rest.RegisterUser;
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
public class RegistrationRestService {
    @Autowired
    RestTemplate restTemplate;
    
    public boolean register(RegisterUser input) {
        HttpEntity<RegisterUser> request = new HttpEntity<>(input, null);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://116.254.101.228:8080/ma_test/register",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Boolean>() {
        }
        );
        return responseEntity.getBody();
    }
}
