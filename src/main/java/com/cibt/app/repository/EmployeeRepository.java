/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
    @Query(value = "select * from tbl_eployees where id not in (select employee_id from tbl_project_employees"
            + " where project_id=?)",nativeQuery = true)
    List<Employee> findEmployeeNotIn(int projectId);
     @Query(value ="select * from tbl_eployees order by created_date desc limit 4",nativeQuery = true)
     List<Employee> findBydesc();
    
}
