/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.ProjectEmployee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface ProjectEmployeeRepository extends
        JpaRepository<ProjectEmployee, Integer> {

    List<ProjectEmployee> findByProjectId(int projectId);

    int deleteByProjectIdAndEmployeeId(int projectId, int employeeId);
    int deleteByProjectId(int projectId);
}
