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
@Table(name = "tblbaocaodoanhthuchuyendi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbaocaodoanhthuchuyendi.findAll", query = "SELECT t FROM Tblbaocaodoanhthuchuyendi t"),
    @NamedQuery(name = "Tblbaocaodoanhthuchuyendi.findByMachuyendi", query = "SELECT t FROM Tblbaocaodoanhthuchuyendi t WHERE t.machuyendi = :machuyendi"),
    @NamedQuery(name = "Tblbaocaodoanhthuchuyendi.findByThoigian", query = "SELECT t FROM Tblbaocaodoanhthuchuyendi t WHERE t.thoigian = :thoigian"),
    @NamedQuery(name = "Tblbaocaodoanhthuchuyendi.findBySove", query = "SELECT t FROM Tblbaocaodoanhthuchuyendi t WHERE t.sove = :sove"),
    @NamedQuery(name = "Tblbaocaodoanhthuchuyendi.findByDoanhthu", query = "SELECT t FROM Tblbaocaodoanhthuchuyendi t WHERE t.doanhthu = :doanhthu"),
    @NamedQuery(name = "Tblbaocaodoanhthuchuyendi.findByTile", query = "SELECT t FROM Tblbaocaodoanhthuchuyendi t WHERE t.tile = :tile")})
public class Tblbaocaodoanhthuchuyendi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "machuyendi")
    private Integer machuyendi;
    @Column(name = "thoigian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;
    @Column(name = "sove")
    private Integer sove;
    @Column(name = "doanhthu")
    private Integer doanhthu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tile")
    private Float tile;

    public Tblbaocaodoanhthuchuyendi() {
    }

    public Tblbaocaodoanhthuchuyendi(Integer machuyendi) {
        this.machuyendi = machuyendi;
    }

    public Integer getMachuyendi() {
        return machuyendi;
    }

    public void setMachuyendi(Integer machuyendi) {
        this.machuyendi = machuyendi;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public Integer getSove() {
        return sove;
    }

    public void setSove(Integer sove) {
        this.sove = sove;
    }

    public Integer getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Integer doanhthu) {
        this.doanhthu = doanhthu;
    }

    public Float getTile() {
        return tile;
    }

    public void setTile(Float tile) {
        this.tile = tile;
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
        if (!(object instanceof Tblbaocaodoanhthuchuyendi)) {
            return false;
        }
        Tblbaocaodoanhthuchuyendi other = (Tblbaocaodoanhthuchuyendi) object;
        if ((this.machuyendi == null && other.machuyendi != null) || (this.machuyendi != null && !this.machuyendi.equals(other.machuyendi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbaocaodoanhthuchuyendi[ machuyendi=" + machuyendi + " ]";
    }
    
}
