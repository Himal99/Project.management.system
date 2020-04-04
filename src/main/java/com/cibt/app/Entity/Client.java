/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Entity;

import com.mysql.cj.jdbc.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tbl_clients")
public class Client extends Masterentity {

    @Column(name = "name")
    private String name;
    @Column(name = "image")
    
    private String image;
    @Column(name = "email")

    private String email;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "address")
    private String address;
    @Column(name = "website")
    private String website;
    @Column(name = "created_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Column(name = "status")
    private boolean status;

    public Client() {
    }

    public Client(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", address=" + address + ", website=" + website + '}';
    }

    public String toJSON() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
