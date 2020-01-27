/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import com.cibt.app.Entity.Client;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/clients")
public class Clientcontroller extends Crudcontroller<Client, Integer>{

    public Clientcontroller() {
        pageTitle="client";
        pageURI=viewpath="clients";
    }
   
}
