/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "laporan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laporan.findAll", query = "SELECT l FROM Laporan l")
    , @NamedQuery(name = "Laporan.findById", query = "SELECT l FROM Laporan l WHERE l.id = :id")
    , @NamedQuery(name = "Laporan.findByJudulLaporan", query = "SELECT l FROM Laporan l WHERE l.judulLaporan = :judulLaporan")
    , @NamedQuery(name = "Laporan.findByIsiLaporan", query = "SELECT l FROM Laporan l WHERE l.isiLaporan = :isiLaporan")
    , @NamedQuery(name = "Laporan.findByTanggalLaporan", query = "SELECT l FROM Laporan l WHERE l.tanggalLaporan = :tanggalLaporan")
    , @NamedQuery(name = "Laporan.findByDeskripsiStatus", query = "SELECT l FROM Laporan l WHERE l.deskripsiStatus = :deskripsiStatus")})
public class Laporan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "judul_laporan")
    private String judulLaporan;
    @Basic(optional = false)
    @Column(name = "isi_laporan")
    private String isiLaporan;
    @Basic(optional = false)
    @Column(name = "tanggal_laporan")
    @Temporal(TemporalType.DATE)
    private Date tanggalLaporan;
    @Column(name = "deskripsi_status")
    private String deskripsiStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laporan", fetch = FetchType.LAZY)
    private List<Tracking> trackingList;
    @JoinColumn(name = "current_status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status currentStatus;
    @JoinColumn(name = "divisi", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Divisi divisi;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Laporan() {
    }

    public Laporan(Integer id) {
        this.id = id;
    }

    public Laporan(Integer id, String judulLaporan, String isiLaporan, Date tanggalLaporan) {
        this.id = id;
        this.judulLaporan = judulLaporan;
        this.isiLaporan = isiLaporan;
        this.tanggalLaporan = tanggalLaporan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudulLaporan() {
        return judulLaporan;
    }

    public void setJudulLaporan(String judulLaporan) {
        this.judulLaporan = judulLaporan;
    }

    public String getIsiLaporan() {
        return isiLaporan;
    }

    public void setIsiLaporan(String isiLaporan) {
        this.isiLaporan = isiLaporan;
    }

    public Date getTanggalLaporan() {
        return tanggalLaporan;
    }

    public void setTanggalLaporan(Date tanggalLaporan) {
        this.tanggalLaporan = tanggalLaporan;
    }

    public String getDeskripsiStatus() {
        return deskripsiStatus;
    }

    public void setDeskripsiStatus(String deskripsiStatus) {
        this.deskripsiStatus = deskripsiStatus;
    }

    @XmlTransient
    public List<Tracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<Tracking> trackingList) {
        this.trackingList = trackingList;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Divisi getDivisi() {
        return divisi;
    }

    public void setDivisi(Divisi divisi) {
        this.divisi = divisi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Laporan)) {
            return false;
        }
        Laporan other = (Laporan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrodata.tas.entities.Laporan[ id=" + id + " ]";
    }
    
}
