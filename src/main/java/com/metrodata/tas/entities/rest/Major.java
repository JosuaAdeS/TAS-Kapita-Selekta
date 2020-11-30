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
public class Major {
    private String id;
    private String name;
    private int count;
    private boolean value;
}
