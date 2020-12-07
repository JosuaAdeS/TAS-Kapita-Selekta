/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.entities.rest;

import lombok.Data;

/**
 *
 * @author acer
 */
@Data
public class ProfileBasic {
    private String id;
    private String name;
    private String birthDate;
    private String gender;
    private String email;
}
