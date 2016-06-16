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
@Table(name = "tblloaixe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblloaixe.findAll", query = "SELECT t FROM Tblloaixe t"),
    @NamedQuery(name = "Tblloaixe.findByMaloaixe", query = "SELECT t FROM Tblloaixe t WHERE t.maloaixe = :maloaixe"),
    @NamedQuery(name = "Tblloaixe.findByLoaixe", query = "SELECT t FROM Tblloaixe t WHERE t.loaixe = :loaixe")})
public class Tblloaixe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maloaixe")
    private Integer maloaixe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "loaixe")
    private String loaixe;

    public Tblloaixe() {
    }

    public Tblloaixe(Integer maloaixe) {
        this.maloaixe = maloaixe;
    }

    public Tblloaixe(Integer maloaixe, String loaixe) {
        this.maloaixe = maloaixe;
        this.loaixe = loaixe;
    }

    public Integer getMaloaixe() {
        return maloaixe;
    }

    public void setMaloaixe(Integer maloaixe) {
        this.maloaixe = maloaixe;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maloaixe != null ? maloaixe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblloaixe)) {
            return false;
        }
        Tblloaixe other = (Tblloaixe) object;
        if ((this.maloaixe == null && other.maloaixe != null) || (this.maloaixe != null && !this.maloaixe.equals(other.maloaixe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblloaixe[ maloaixe=" + maloaixe + " ]";
    }
    
}
