/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tblchuyendi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblchuyendi.findAll", query = "SELECT t FROM Tblchuyendi t"),
    @NamedQuery(name = "Tblchuyendi.findByMachuyendi", query = "SELECT t FROM Tblchuyendi t WHERE t.machuyendi = :machuyendi"),
    @NamedQuery(name = "Tblchuyendi.findByMaxe", query = "SELECT t FROM Tblchuyendi t WHERE t.maxe = :maxe"),
    @NamedQuery(name = "Tblchuyendi.findByKhoihanh", query = "SELECT t FROM Tblchuyendi t WHERE t.khoihanh = :khoihanh"),
    @NamedQuery(name = "Tblchuyendi.findByKetthuc", query = "SELECT t FROM Tblchuyendi t WHERE t.ketthuc = :ketthuc"),
    @NamedQuery(name = "Tblchuyendi.findBySoghetrong", query = "SELECT t FROM Tblchuyendi t WHERE t.soghetrong = :soghetrong"),
    @NamedQuery(name = "Tblchuyendi.findBySoghedat", query = "SELECT t FROM Tblchuyendi t WHERE t.soghedat = :soghedat")})
public class Tblchuyendi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "machuyendi")
    private Integer machuyendi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxe")
    private int maxe;
    @Column(name = "khoihanh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date khoihanh;
    @Column(name = "ketthuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ketthuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soghetrong")
    private int soghetrong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soghedat")
    private int soghedat;

    public Tblchuyendi() {
    }

    public Tblchuyendi(Integer machuyendi) {
        this.machuyendi = machuyendi;
    }

    public Tblchuyendi(Integer machuyendi, int maxe, int soghetrong, int soghedat) {
        this.machuyendi = machuyendi;
        this.maxe = maxe;
        this.soghetrong = soghetrong;
        this.soghedat = soghedat;
    }

    public Integer getMachuyendi() {
        return machuyendi;
    }

    public void setMachuyendi(Integer machuyendi) {
        this.machuyendi = machuyendi;
    }

    public int getMaxe() {
        return maxe;
    }

    public void setMaxe(int maxe) {
        this.maxe = maxe;
    }

    public Date getKhoihanh() {
        return khoihanh;
    }

    public void setKhoihanh(Date khoihanh) {
        this.khoihanh = khoihanh;
    }

    public Date getKetthuc() {
        return ketthuc;
    }

    public void setKetthuc(Date ketthuc) {
        this.ketthuc = ketthuc;
    }

    public int getSoghetrong() {
        return soghetrong;
    }

    public void setSoghetrong(int soghetrong) {
        this.soghetrong = soghetrong;
    }

    public int getSoghedat() {
        return soghedat;
    }

    public void setSoghedat(int soghedat) {
        this.soghedat = soghedat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machuyendi != null ? machuyendi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblchuyendi)) {
            return false;
        }
        Tblchuyendi other = (Tblchuyendi) object;
        if ((this.machuyendi == null && other.machuyendi != null) || (this.machuyendi != null && !this.machuyendi.equals(other.machuyendi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblchuyendi[ machuyendi=" + machuyendi + " ]";
    }
    
}
