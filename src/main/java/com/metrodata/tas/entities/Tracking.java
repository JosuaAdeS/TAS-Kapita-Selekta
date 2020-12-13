/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracking.findAll", query = "SELECT t FROM Tracking t")
    , @NamedQuery(name = "Tracking.findById", query = "SELECT t FROM Tracking t WHERE t.id = :id")
    , @NamedQuery(name = "Tracking.findByStatus", query = "SELECT t FROM Tracking t WHERE t.status = :status")
    , @NamedQuery(name = "Tracking.findByWaktu", query = "SELECT t FROM Tracking t WHERE t.waktu = :waktu")})
public class Tracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "waktu")
    @Temporal(TemporalType.DATE)
    private Date waktu;
    @JoinColumn(name = "deskripsi", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DeskripsiTracking deskripsi;
    @JoinColumn(name = "laporan", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Laporan laporan;

    public Tracking() {
    }

    public Tracking(Integer id) {
        this.id = id;
    }

    public Tracking(Integer id, int status, Date waktu) {
        this.id = id;
        this.status = status;
        this.waktu = waktu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public DeskripsiTracking getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(DeskripsiTracking deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Laporan getLaporan() {
        return laporan;
    }

    public void setLaporan(Laporan laporan) {
        this.laporan = laporan;
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
        if (!(object instanceof Tracking)) {
            return false;
        }
        Tracking other = (Tracking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrodata.tas.entities.Tracking[ id=" + id + " ]";
    }
    
}
