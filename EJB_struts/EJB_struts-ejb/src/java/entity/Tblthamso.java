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
@Table(name = "tblthamso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblthamso.findAll", query = "SELECT t FROM Tblthamso t"),
    @NamedQuery(name = "Tblthamso.findById", query = "SELECT t FROM Tblthamso t WHERE t.id = :id"),
    @NamedQuery(name = "Tblthamso.findByTenthamso", query = "SELECT t FROM Tblthamso t WHERE t.tenthamso = :tenthamso"),
    @NamedQuery(name = "Tblthamso.findByGiatri", query = "SELECT t FROM Tblthamso t WHERE t.giatri = :giatri")})
public class Tblthamso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenthamso")
    private String tenthamso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giatri")
    private int giatri;

    public Tblthamso() {
    }

    public Tblthamso(Integer id) {
        this.id = id;
    }

    public Tblthamso(Integer id, String tenthamso, int giatri) {
        this.id = id;
        this.tenthamso = tenthamso;
        this.giatri = giatri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenthamso() {
        return tenthamso;
    }

    public void setTenthamso(String tenthamso) {
        this.tenthamso = tenthamso;
    }

    public int getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
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
        if (!(object instanceof Tblthamso)) {
            return false;
        }
        Tblthamso other = (Tblthamso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblthamso[ id=" + id + " ]";
    }
    
}
