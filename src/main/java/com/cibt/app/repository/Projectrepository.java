/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.MasterProjectStatus;

import com.cibt.app.Entity.Project;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface Projectrepository extends JpaRepository<Project, Integer>{
    
}
