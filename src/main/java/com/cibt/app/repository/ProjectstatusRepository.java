/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.Employee;
import com.cibt.app.Entity.projectstatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface ProjectstatusRepository extends JpaRepository<projectstatus, Integer> {

    @Query(value = "select *from tbl_project_status where status_id=3", nativeQuery = true)
    List<projectstatus> findByStatus();

    @Query(value = "select *from tbl_project_status where status_id=1", nativeQuery = true)
    List<projectstatus> findByCompleted();

    @Query(value = "select *from tbl_project_status where status_id=5", nativeQuery = true)
    List<projectstatus> findByCanceled();

    @Query(value = "select *from tbl_project_status where status_id=4", nativeQuery = true)
    List<projectstatus> findByWorkinprogress();
    
//  =====================
    @Modifying 
    
    @Query(value = "UPDATE tbl_project_status SET status_id=? WHERE project_id=?", nativeQuery = true)
     int changeProjectStatus(int statusId,int projectId);
}
