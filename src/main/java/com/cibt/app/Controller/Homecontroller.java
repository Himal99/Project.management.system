/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/")
public class Homecontroller extends Sitecontroller{

    public Homecontroller() {
        pageTitle="Home";
    }
    
    @GetMapping
    public String index(){
        return "home/index";
       
    }
    
    
    
}
