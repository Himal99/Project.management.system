/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tbl_projects")
public class Project extends Masterentity {

    @Column(name = "name")
    private String name;
    @Type(type = "text")
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private Client client;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date dateline;
    @Column(name = "budget")
    private int budget;
    @Column(name = "created_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified_date", nullable = true)
    private Date modified;

    @JoinTable(name = "tbl_project_status",
            joinColumns = {
                @JoinColumn(name = "project_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "status_id", referencedColumnName = "id")})
    @ManyToMany()
    @JsonIgnore
    private List<MasterProjectStatus> status;
    
    @JoinTable(name = "tbl_project_employees",
            joinColumns = {
                @JoinColumn(name = "project_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "employee_id", referencedColumnName = "id")})
    @ManyToMany()
    @JsonIgnore
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    Project() {

    }

    public List<MasterProjectStatus> getStatus() {
        return status;
    }

    public void setStatus(List<MasterProjectStatus> status) {
        this.status = status;
    }

    Project(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

   
}
