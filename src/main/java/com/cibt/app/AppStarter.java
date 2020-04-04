/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app;


import com.cibt.app.Controller.Clientcontroller;
import java.io.File;
import org.jboss.jandex.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author user
 */
@SpringBootApplication
@ComponentScan({"com.cibt.app","Controller"})
public class AppStarter {
    public static void main(String[] args){
        new File(Clientcontroller.uploadDirectory).mkdir();
      
        SpringApplication.run(AppStarter.class, args);
    }
    
}
