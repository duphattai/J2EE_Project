/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tbltuyenxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbltuyenxe.findAll", query = "SELECT t FROM Tbltuyenxe t"),
    @NamedQuery(name = "Tbltuyenxe.findByMatuyen", query = "SELECT t FROM Tbltuyenxe t WHERE t.matuyen = :matuyen"),
    @NamedQuery(name = "Tbltuyenxe.findByMabendi", query = "SELECT t FROM Tbltuyenxe t WHERE t.mabendi = :mabendi"),
    @NamedQuery(name = "Tbltuyenxe.findByMabenden", query = "SELECT t FROM Tbltuyenxe t WHERE t.mabenden = :mabenden"),
    @NamedQuery(name = "Tbltuyenxe.findByThoigian", query = "SELECT t FROM Tbltuyenxe t WHERE t.thoigian = :thoigian"),
    @NamedQuery(name = "Tbltuyenxe.findByDongia", query = "SELECT t FROM Tbltuyenxe t WHERE t.dongia = :dongia")})
public class Tbltuyenxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "matuyen")
    private Integer matuyen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mabendi")
    private int mabendi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mabenden")
    private int mabenden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian")
    private int thoigian;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dongia")
    private int dongia;

    public Tbltuyenxe() {
    }

    public Tbltuyenxe(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public Tbltuyenxe(Integer matuyen, int mabendi, int mabenden, int thoigian, int dongia) {
        this.matuyen = matuyen;
        this.mabendi = mabendi;
        this.mabenden = mabenden;
        this.thoigian = thoigian;
        this.dongia = dongia;
    }

    public Integer getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public int getMabendi() {
        return mabendi;
    }

    public void setMabendi(int mabendi) {
        this.mabendi = mabendi;
    }

    public int getMabenden() {
        return mabenden;
    }

    public void setMabenden(int mabenden) {
        this.mabenden = mabenden;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matuyen != null ? matuyen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbltuyenxe)) {
            return false;
        }
        Tbltuyenxe other = (Tbltuyenxe) object;
        if ((this.matuyen == null && other.matuyen != null) || (this.matuyen != null && !this.matuyen.equals(other.matuyen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbltuyenxe[ matuyen=" + matuyen + " ]";
    }
    
}
