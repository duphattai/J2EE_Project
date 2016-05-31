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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tblbaocaodoanhthunam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbaocaodoanhthunam.findAll", query = "SELECT t FROM Tblbaocaodoanhthunam t"),
    @NamedQuery(name = "Tblbaocaodoanhthunam.findByNam", query = "SELECT t FROM Tblbaocaodoanhthunam t WHERE t.nam = :nam"),
    @NamedQuery(name = "Tblbaocaodoanhthunam.findByDoanhthu", query = "SELECT t FROM Tblbaocaodoanhthunam t WHERE t.doanhthu = :doanhthu")})
public class Tblbaocaodoanhthunam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam")
    private Integer nam;
    @Column(name = "doanhthu")
    private Integer doanhthu;

    public Tblbaocaodoanhthunam() {
    }

    public Tblbaocaodoanhthunam(Integer nam) {
        this.nam = nam;
    }

    public Integer getNam() {
        return nam;
    }

    public void setNam(Integer nam) {
        this.nam = nam;
    }

    public Integer getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Integer doanhthu) {
        this.doanhthu = doanhthu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nam != null ? nam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblbaocaodoanhthunam)) {
            return false;
        }
        Tblbaocaodoanhthunam other = (Tblbaocaodoanhthunam) object;
        if ((this.nam == null && other.nam != null) || (this.nam != null && !this.nam.equals(other.nam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbaocaodoanhthunam[ nam=" + nam + " ]";
    }
    
}
