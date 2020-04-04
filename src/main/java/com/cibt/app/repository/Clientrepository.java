/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.repository;

import com.cibt.app.Entity.Client;
import com.mysql.cj.jdbc.Blob;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

/**
 *
 * @author user
 */
public interface Clientrepository extends JpaRepository<Client, Integer>{
 
    @Modifying
   @Query(value = "insert into tbl_clients(image) values (?)",nativeQuery = true)
   int insert(String image);

    
    
}
