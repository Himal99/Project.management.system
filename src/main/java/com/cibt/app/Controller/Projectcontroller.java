/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import com.cibt.app.Entity.Client;
import com.cibt.app.Entity.Employee;
import com.cibt.app.Entity.MasterProjectStatus;

import com.cibt.app.Entity.Project;
import com.cibt.app.Entity.ProjectEmployee;
import com.cibt.app.Entity.projectstatus;
import com.cibt.app.repository.Clientrepository;

import com.cibt.app.repository.MstStatusRepository;
import com.cibt.app.repository.ProjectEmployeeRepository;
import com.cibt.app.repository.Projectrepository;
import com.cibt.app.repository.ProjectstatusRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/projects")
public class Projectcontroller extends Crudcontroller<Project, Integer> {

    @Autowired
    private Projectrepository projectRepository;
    @Autowired
    private ProjectEmployeeRepository employeeRepository;
    @Autowired
    private ProjectstatusRepository projectstatus;
    @Autowired
    private MstStatusRepository masterrepoRepository;
    @Autowired
    private Clientrepository clientrepository;
            

    public Projectcontroller() {
        pageTitle = "project";
        viewpath = pageURI = "projects";
    }

    @GetMapping(value = "/employees/{projectId}")
    @ResponseBody
    public List<Employee> getEmployees(@PathVariable("projectId") int projectId) {
        Project project = projectRepository.findById(projectId).get();
        return project.getEmployees();
    }

    @GetMapping(value = "getclients/{clientId}")
    @ResponseBody
    @Transactional
    public Client getclient(@PathVariable("clientId") int clinetId) {
        Project project = projectRepository.findById(clinetId).get();
        return project.getClient();
    }

    @PostMapping(value = "/remove-employee")
    @ResponseBody
    @Transactional
    public String removeEmployee(@RequestParam("projectId") int projectId, @RequestParam("employeeId") int employeeId) {
        employeeRepository.deleteByProjectIdAndEmployeeId(projectId, employeeId);
        return "project:" + projectId + "employeeId" + employeeId;

    }
    
    

    @PostMapping(value = "/changeStatus")
    @Transactional
    @ResponseBody
    public String statusChange(@RequestParam("statusId") int statusId, @RequestParam("projectId") int projectId) {
        projectstatus.changeProjectStatus(statusId, projectId);
        return "success";

    }

    @PostMapping(value = "/add-employee")
    @ResponseBody
    @Transactional
    public String addEmployee(@RequestParam("project") Project project, @RequestParam("employee") List<Employee> employees) {

        for (Employee employee : employees) {
            ProjectEmployee projectEmployee = new ProjectEmployee();
            projectEmployee.setProject(project);
            projectEmployee.setEmployee(employee);
            employeeRepository.save(projectEmployee);
        }
        return "success";
    }

    @GetMapping(value = "/pending")
    @ResponseBody
    public List<projectstatus> Status() {

        return projectstatus.findByStatus();

    }

    @GetMapping(value = "/completed")
    @ResponseBody
    public List<projectstatus> completed() {

        return projectstatus.findByCompleted();

    }

    @GetMapping(value = "/canceled")
    @ResponseBody
    public List<projectstatus> canceled() {

        return projectstatus.findByCanceled();

    }

    @GetMapping(value = "/workinprogress")
    @ResponseBody
    public List<projectstatus> workinprogress() {

        return projectstatus.findByWorkinprogress();

    }

    @GetMapping(value = "/getallStatus/{id}")
    @ResponseBody
    @Transactional
    public List<MasterProjectStatus> status(@PathVariable("id")int projectId) {
        
    return masterrepoRepository.getStatusNotInProject(projectId);
        
  }

    
    
}
