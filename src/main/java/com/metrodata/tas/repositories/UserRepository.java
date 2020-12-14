/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metrodata.tas.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author acer
 */
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByEmail(String email);
}
