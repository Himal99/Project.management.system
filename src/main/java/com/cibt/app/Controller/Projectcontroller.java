/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import com.cibt.app.Entity.Client;
import com.cibt.app.Entity.Employee;
import com.cibt.app.Entity.MasterProjectStatus;
import com.cibt.app.Entity.Masterentity;
import com.cibt.app.Entity.Project;
import com.cibt.app.Entity.ProjectEmployee;
import com.cibt.app.repository.EmployeeRepository;
import com.cibt.app.repository.ProjectEmployeeRepository;
import com.cibt.app.repository.Projectrepository;
import java.util.List;
import javax.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/projects")
public class Projectcontroller extends Crudcontroller<Project, Integer>{

    @Autowired
    private Projectrepository projectRepository;
    @Autowired
    private ProjectEmployeeRepository employeeRepository;
    

    
    public Projectcontroller() {
        pageTitle="project";
        viewpath=pageURI="projects";
    }
    
    
    @GetMapping(value = "/employees/{projectId}")
    @ResponseBody
    public List<Employee> getEmployees(@PathVariable("projectId")int projectId){
        Project project= projectRepository.findById(projectId).get();
        return project.getEmployees();
    }
    
   @GetMapping(value = "getclients/{clientId}")
   @ResponseBody
   @Transactional
   public Client getclient(@PathVariable("clientId")int clinetId){
       Project project=projectRepository.findById(clinetId).get();
       return project.getClient();
   }
    
    @PostMapping(value = "/remove-employee")
    @ResponseBody
    @Transactional
    public String removeEmployee(@RequestParam("projectId")int
            projectId,@RequestParam("employeeId")int
            employeeId){
        employeeRepository.deleteByProjectIdAndEmployeeId(projectId, employeeId);
        return "project:"+projectId+"employeeId"+employeeId;
        
        
        
    }
    
    @PostMapping(value = "/add-employee")
    @ResponseBody
    @Transactional
    public String addEmployee(@RequestParam("project")Project
            project,@RequestParam("employee")List<Employee>
            employees){
        
        for(Employee employee:employees){
            ProjectEmployee projectEmployee=new ProjectEmployee();
            projectEmployee.setProject(project);
            projectEmployee.setEmployee(employee);
            employeeRepository.save(projectEmployee);
        }
        return "success";
    }
    
   
    
}
