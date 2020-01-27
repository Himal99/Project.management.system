/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.MasterProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author user
 */

public interface MstStatusRepository extends JpaRepository<MasterProjectStatus, Integer>{
    
}
