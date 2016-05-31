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
import javax.persistence.Lob;
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
@Table(name = "tblchitiettuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblchitiettuyen.findAll", query = "SELECT t FROM Tblchitiettuyen t"),
    @NamedQuery(name = "Tblchitiettuyen.findByMatuyen", query = "SELECT t FROM Tblchitiettuyen t WHERE t.matuyen = :matuyen"),
    @NamedQuery(name = "Tblchitiettuyen.findByMabenxetrunggian", query = "SELECT t FROM Tblchitiettuyen t WHERE t.mabenxetrunggian = :mabenxetrunggian"),
    @NamedQuery(name = "Tblchitiettuyen.findByThoigiandung", query = "SELECT t FROM Tblchitiettuyen t WHERE t.thoigiandung = :thoigiandung")})
public class Tblchitiettuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "matuyen")
    private Integer matuyen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mabenxetrunggian")
    private int mabenxetrunggian;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigiandung")
    private int thoigiandung;
    @Lob
    @Size(max = 65535)
    @Column(name = "ghichu")
    private String ghichu;

    public Tblchitiettuyen() {
    }

    public Tblchitiettuyen(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public Tblchitiettuyen(Integer matuyen, int mabenxetrunggian, int thoigiandung) {
        this.matuyen = matuyen;
        this.mabenxetrunggian = mabenxetrunggian;
        this.thoigiandung = thoigiandung;
    }

    public Integer getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public int getMabenxetrunggian() {
        return mabenxetrunggian;
    }

    public void setMabenxetrunggian(int mabenxetrunggian) {
        this.mabenxetrunggian = mabenxetrunggian;
    }

    public int getThoigiandung() {
        return thoigiandung;
    }

    public void setThoigiandung(int thoigiandung) {
        this.thoigiandung = thoigiandung;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
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
        if (!(object instanceof Tblchitiettuyen)) {
            return false;
        }
        Tblchitiettuyen other = (Tblchitiettuyen) object;
        if ((this.matuyen == null && other.matuyen != null) || (this.matuyen != null && !this.matuyen.equals(other.matuyen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblchitiettuyen[ matuyen=" + matuyen + " ]";
    }
    
}
