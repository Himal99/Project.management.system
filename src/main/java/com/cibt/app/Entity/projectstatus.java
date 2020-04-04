/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tbl_project_status")
public class projectstatus extends Masterentity {

    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne
    private Project project;
    @JoinColumn(name = "status_id", referencedColumnName = "id",updatable = true)
    @ManyToOne
    private MasterProjectStatus masterstatus;
    @Column(name = "created_date")
    private Date createdDate;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public MasterProjectStatus getMasterstatus() {
        return masterstatus;
    }

    public void setMasterstatus(MasterProjectStatus masterstatus) {
        this.masterstatus = masterstatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
