/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app;

import org.jboss.jandex.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author user
 */
@SpringBootApplication
public class AppStarter {
    public static void main(String[] args){
        
        SpringApplication.run(AppStarter.class, args);
    }
    
}
