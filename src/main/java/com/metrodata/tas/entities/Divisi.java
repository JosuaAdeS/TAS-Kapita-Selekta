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
@Table(name = "divisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisi.findAll", query = "SELECT d FROM Divisi d")
    , @NamedQuery(name = "Divisi.findById", query = "SELECT d FROM Divisi d WHERE d.id = :id")
    , @NamedQuery(name = "Divisi.findByNamaDivisi", query = "SELECT d FROM Divisi d WHERE d.namaDivisi = :namaDivisi")})
public class Divisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama_divisi")
    private String namaDivisi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisi", fetch = FetchType.LAZY)
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisi", fetch = FetchType.LAZY)
    private List<Laporan> laporanList;

    public Divisi() {
    }

    public Divisi(Integer id) {
        this.id = id;
    }

    public Divisi(Integer id, String namaDivisi) {
        this.id = id;
        this.namaDivisi = namaDivisi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaDivisi() {
        return namaDivisi;
    }

    public void setNamaDivisi(String namaDivisi) {
        this.namaDivisi = namaDivisi;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Laporan> getLaporanList() {
        return laporanList;
    }

    public void setLaporanList(List<Laporan> laporanList) {
        this.laporanList = laporanList;
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
        if (!(object instanceof Divisi)) {
            return false;
        }
        Divisi other = (Divisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrodata.tas.entities.Divisi[ id=" + id + " ]";
    }
    
}
