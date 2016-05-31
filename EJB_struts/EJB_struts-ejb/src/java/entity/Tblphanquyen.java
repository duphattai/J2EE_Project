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
@Table(name = "tblphanquyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblphanquyen.findAll", query = "SELECT t FROM Tblphanquyen t"),
    @NamedQuery(name = "Tblphanquyen.findById", query = "SELECT t FROM Tblphanquyen t WHERE t.id = :id"),
    @NamedQuery(name = "Tblphanquyen.findByQuyen", query = "SELECT t FROM Tblphanquyen t WHERE t.quyen = :quyen")})
public class Tblphanquyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Quyen")
    private String quyen;

    public Tblphanquyen() {
    }

    public Tblphanquyen(Integer id) {
        this.id = id;
    }

    public Tblphanquyen(Integer id, String quyen) {
        this.id = id;
        this.quyen = quyen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
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
        if (!(object instanceof Tblphanquyen)) {
            return false;
        }
        Tblphanquyen other = (Tblphanquyen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblphanquyen[ id=" + id + " ]";
    }
    
}
