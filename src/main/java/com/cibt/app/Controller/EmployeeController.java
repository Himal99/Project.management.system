/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import com.cibt.app.Entity.Employee;
import com.cibt.app.repository.EmployeeRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController extends Crudcontroller<Employee, Integer>{

    public EmployeeController() {
        pageTitle="Employee";
        pageURI="employees";
        viewpath="employees";
       
        
        
        
    }
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping(value = "/project-notassigned/{projectId}")
    @ResponseBody
    public List<Employee> getNotAssignedEmployees(@PathVariable("projectId")int projectId){
        return employeeRepository.findEmployeeNotIn(projectId);
    }
       
   
    
    
    
}
