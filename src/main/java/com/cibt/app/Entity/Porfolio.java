/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "portfolio")
public class Porfolio extends Masterentity {

    @Column(name = "blog_heading")
    private String heading;
    @Column(name = "blog_deatil")
    private String detail;
    @Column(name = "created_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "modified_date", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date modified;

    @Column(name = "website")
    private String website;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getHeading() {
        return heading;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDeatil() {
        return detail;
    }

    public void setDeatil(String deatil) {
        this.detail = deatil;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Porfolio{" + "heading=" + heading + ", detail=" + detail + ", created=" + created + ", modified=" + modified + ", website=" + website + '}';
    }

}
