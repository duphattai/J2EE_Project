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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tblxekhach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblxekhach.findAll", query = "SELECT t FROM Tblxekhach t"),
    @NamedQuery(name = "Tblxekhach.findByMaxe", query = "SELECT t FROM Tblxekhach t WHERE t.maxe = :maxe"),
    @NamedQuery(name = "Tblxekhach.findByMaloaixe", query = "SELECT t FROM Tblxekhach t WHERE t.maloaixe = :maloaixe"),
    @NamedQuery(name = "Tblxekhach.findByTaixe", query = "SELECT t FROM Tblxekhach t WHERE t.taixe = :taixe"),
    @NamedQuery(name = "Tblxekhach.findByBiensoxe", query = "SELECT t FROM Tblxekhach t WHERE t.biensoxe = :biensoxe"),
    @NamedQuery(name = "Tblxekhach.findByMatuyen", query = "SELECT t FROM Tblxekhach t WHERE t.matuyen = :matuyen"),
    @NamedQuery(name = "Tblxekhach.findBySoghe", query = "SELECT t FROM Tblxekhach t WHERE t.soghe = :soghe")})
public class Tblxekhach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxe")
    private Integer maxe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maloaixe")
    private int maloaixe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "taixe")
    private String taixe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "biensoxe")
    private String biensoxe;
    @Column(name = "matuyen")
    private Integer matuyen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soghe")
    private int soghe;

    public Tblxekhach() {
    }

    public Tblxekhach(Integer maxe) {
        this.maxe = maxe;
    }

    public Tblxekhach(Integer maxe, int maloaixe, String taixe, String biensoxe, int soghe) {
        this.maxe = maxe;
        this.maloaixe = maloaixe;
        this.taixe = taixe;
        this.biensoxe = biensoxe;
        this.soghe = soghe;
    }

    public Integer getMaxe() {
        return maxe;
    }

    public void setMaxe(Integer maxe) {
        this.maxe = maxe;
    }

    public int getMaloaixe() {
        return maloaixe;
    }

    public void setMaloaixe(int maloaixe) {
        this.maloaixe = maloaixe;
    }

    public String getTaixe() {
        return taixe;
    }

    public void setTaixe(String taixe) {
        this.taixe = taixe;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public Integer getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maxe != null ? maxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblxekhach)) {
            return false;
        }
        Tblxekhach other = (Tblxekhach) object;
        if ((this.maxe == null && other.maxe != null) || (this.maxe != null && !this.maxe.equals(other.maxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblxekhach[ maxe=" + maxe + " ]";
    }
    
}
