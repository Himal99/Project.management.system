
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller.master;

import com.cibt.app.Controller.Crudcontroller;
import com.cibt.app.Entity.MasterProjectStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "master/project-status")
public class MasterProjectStatusController extends Crudcontroller<MasterProjectStatus, Integer>{

    public MasterProjectStatusController() {
        pageTitle="Master-Project-Status";
        pageURI="master/project-status";
        viewpath="master/project_status";
    }
    
    
    
}
