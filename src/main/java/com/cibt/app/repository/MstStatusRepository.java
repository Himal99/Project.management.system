/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.Employee;
import com.cibt.app.Entity.MasterProjectStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author user
 */

public interface MstStatusRepository extends JpaRepository<MasterProjectStatus, Integer>{
 @Query(value = "select * from mst_project_status where id not in (select status_id "
            + " from tbl_project_status where project_id=?)", nativeQuery = true)
    public List<MasterProjectStatus> getStatusNotInProject(int projectId);

}
