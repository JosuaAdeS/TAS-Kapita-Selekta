/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "deskripsi_tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeskripsiTracking.findAll", query = "SELECT d FROM DeskripsiTracking d")
    , @NamedQuery(name = "DeskripsiTracking.findById", query = "SELECT d FROM DeskripsiTracking d WHERE d.id = :id")
    , @NamedQuery(name = "DeskripsiTracking.findByDeskripsiTracking", query = "SELECT d FROM DeskripsiTracking d WHERE d.deskripsiTracking = :deskripsiTracking")})
public class DeskripsiTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "deskripsi_tracking")
    private String deskripsiTracking;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deskripsi", fetch = FetchType.LAZY)
    private List<Tracking> trackingList;

    public DeskripsiTracking() {
    }

    public DeskripsiTracking(Integer id) {
        this.id = id;
    }

    public DeskripsiTracking(Integer id, String deskripsiTracking) {
        this.id = id;
        this.deskripsiTracking = deskripsiTracking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeskripsiTracking() {
        return deskripsiTracking;
    }

    public void setDeskripsiTracking(String deskripsiTracking) {
        this.deskripsiTracking = deskripsiTracking;
    }

    @XmlTransient
    public List<Tracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<Tracking> trackingList) {
        this.trackingList = trackingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeskripsiTracking)) {
            return false;
        }
        DeskripsiTracking other = (DeskripsiTracking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrodata.tas.entities.DeskripsiTracking[ id=" + id + " ]";
    }
    
}
