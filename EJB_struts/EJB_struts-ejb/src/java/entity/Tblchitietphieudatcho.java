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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tblchitietphieudatcho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblchitietphieudatcho.findAll", query = "SELECT t FROM Tblchitietphieudatcho t"),
    @NamedQuery(name = "Tblchitietphieudatcho.findById", query = "SELECT t FROM Tblchitietphieudatcho t WHERE t.id = :id"),
    @NamedQuery(name = "Tblchitietphieudatcho.findByMaphieu", query = "SELECT t FROM Tblchitietphieudatcho t WHERE t.maphieu = :maphieu"),
    @NamedQuery(name = "Tblchitietphieudatcho.findByMachuyendi", query = "SELECT t FROM Tblchitietphieudatcho t WHERE t.machuyendi = :machuyendi"),
    @NamedQuery(name = "Tblchitietphieudatcho.findByLayve", query = "SELECT t FROM Tblchitietphieudatcho t WHERE t.layve = :layve"),
    @NamedQuery(name = "Tblchitietphieudatcho.findByVitrighe", query = "SELECT t FROM Tblchitietphieudatcho t WHERE t.vitrighe = :vitrighe"),
    @NamedQuery(name = "Tblchitietphieudatcho.findByNgaylay", query = "SELECT t FROM Tblchitietphieudatcho t WHERE t.ngaylay = :ngaylay")})
public class Tblchitietphieudatcho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maphieu")
    private int maphieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "machuyendi")
    private int machuyendi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "layve")
    private boolean layve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vitrighe")
    private String vitrighe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaylay")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaylay;

    public Tblchitietphieudatcho() {
    }

    public Tblchitietphieudatcho(Integer id) {
        this.id = id;
    }

    public Tblchitietphieudatcho(Integer id, int maphieu, int machuyendi, boolean layve, String vitrighe, Date ngaylay) {
        this.id = id;
        this.maphieu = maphieu;
        this.machuyendi = machuyendi;
        this.layve = layve;
        this.vitrighe = vitrighe;
        this.ngaylay = ngaylay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(int maphieu) {
        this.maphieu = maphieu;
    }

    public int getMachuyendi() {
        return machuyendi;
    }

    public void setMachuyendi(int machuyendi) {
        this.machuyendi = machuyendi;
    }

    public boolean getLayve() {
        return layve;
    }

    public void setLayve(boolean layve) {
        this.layve = layve;
    }

    public String getVitrighe() {
        return vitrighe;
    }

    public void setVitrighe(String vitrighe) {
        this.vitrighe = vitrighe;
    }

    public Date getNgaylay() {
        return ngaylay;
    }

    public void setNgaylay(Date ngaylay) {
        this.ngaylay = ngaylay;
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
        if (!(object instanceof Tblchitietphieudatcho)) {
            return false;
        }
        Tblchitietphieudatcho other = (Tblchitietphieudatcho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblchitietphieudatcho[ id=" + id + " ]";
    }
    
}
