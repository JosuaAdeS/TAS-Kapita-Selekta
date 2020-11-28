/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.entities.rest;

import java.util.List;
import lombok.Data;

/**
 *
 * @author acer
 */
@Data
public class UserOutput {
    private String id, name, email;
    private List<String> roles;
}
