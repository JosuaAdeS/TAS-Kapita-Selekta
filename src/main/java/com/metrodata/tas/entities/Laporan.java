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
import javax.persistence.Id;
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
@Table(name = "laporan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laporan.findAll", query = "SELECT l FROM Laporan l")
    , @NamedQuery(name = "Laporan.findById", query = "SELECT l FROM Laporan l WHERE l.id = :id")
    , @NamedQuery(name = "Laporan.findByUser", query = "SELECT l FROM Laporan l WHERE l.user = :user")
    , @NamedQuery(name = "Laporan.findByDivisi", query = "SELECT l FROM Laporan l WHERE l.divisi = :divisi")
    , @NamedQuery(name = "Laporan.findByCurrentStatus", query = "SELECT l FROM Laporan l WHERE l.currentStatus = :currentStatus")
    , @NamedQuery(name = "Laporan.findByJudulLaporan", query = "SELECT l FROM Laporan l WHERE l.judulLaporan = :judulLaporan")
    , @NamedQuery(name = "Laporan.findByIsiLaporan", query = "SELECT l FROM Laporan l WHERE l.isiLaporan = :isiLaporan")
    , @NamedQuery(name = "Laporan.findByTanggalLaporan", query = "SELECT l FROM Laporan l WHERE l.tanggalLaporan = :tanggalLaporan")
    , @NamedQuery(name = "Laporan.findByDeskripsiStatus", query = "SELECT l FROM Laporan l WHERE l.deskripsiStatus = :deskripsiStatus")})
public class Laporan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "divisi")
    private int divisi;
    @Basic(optional = false)
    @Column(name = "current_status")
    private int currentStatus;
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
    @Basic(optional = false)
    @Column(name = "deskripsi_status")
    private String deskripsiStatus;

    public Laporan() {
    }

    public Laporan(String id) {
        this.id = id;
    }

    public Laporan(String id, String user, int divisi, int currentStatus, String judulLaporan, String isiLaporan, Date tanggalLaporan, String deskripsiStatus) {
        this.id = id;
        this.user = user;
        this.divisi = divisi;
        this.currentStatus = currentStatus;
        this.judulLaporan = judulLaporan;
        this.isiLaporan = isiLaporan;
        this.tanggalLaporan = tanggalLaporan;
        this.deskripsiStatus = deskripsiStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getDivisi() {
        return divisi;
    }

    public void setDivisi(int divisi) {
        this.divisi = divisi;
    }

    public int getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(int currentStatus) {
        this.currentStatus = currentStatus;
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
