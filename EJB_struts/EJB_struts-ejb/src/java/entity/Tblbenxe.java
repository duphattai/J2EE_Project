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
@Table(name = "tblbenxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbenxe.findAll", query = "SELECT t FROM Tblbenxe t"),
    @NamedQuery(name = "Tblbenxe.findByMabenxe", query = "SELECT t FROM Tblbenxe t WHERE t.mabenxe = :mabenxe"),
    @NamedQuery(name = "Tblbenxe.findByTenbenxe", query = "SELECT t FROM Tblbenxe t WHERE t.tenbenxe = :tenbenxe")})
public class Tblbenxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mabenxe")
    private Integer mabenxe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenbenxe")
    private String tenbenxe;

    public Tblbenxe() {
    }

    public Tblbenxe(Integer mabenxe) {
        this.mabenxe = mabenxe;
    }

    public Tblbenxe(Integer mabenxe, String tenbenxe) {
        this.mabenxe = mabenxe;
        this.tenbenxe = tenbenxe;
    }

    public Integer getMabenxe() {
        return mabenxe;
    }

    public void setMabenxe(Integer mabenxe) {
        this.mabenxe = mabenxe;
    }

    public String getTenbenxe() {
        return tenbenxe;
    }

    public void setTenbenxe(String tenbenxe) {
        this.tenbenxe = tenbenxe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mabenxe != null ? mabenxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblbenxe)) {
            return false;
        }
        Tblbenxe other = (Tblbenxe) object;
        if ((this.mabenxe == null && other.mabenxe != null) || (this.mabenxe != null && !this.mabenxe.equals(other.mabenxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbenxe[ mabenxe=" + mabenxe + " ]";
    }
    
}
