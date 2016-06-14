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
@Table(name = "tblphieudatcho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblphieudatcho.findAll", query = "SELECT t FROM Tblphieudatcho t"),
    @NamedQuery(name = "Tblphieudatcho.findByMaphieu", query = "SELECT t FROM Tblphieudatcho t WHERE t.maphieu = :maphieu"),
    @NamedQuery(name = "Tblphieudatcho.findByHoten", query = "SELECT t FROM Tblphieudatcho t WHERE t.hoten = :hoten"),
    @NamedQuery(name = "Tblphieudatcho.findByDienthoai", query = "SELECT t FROM Tblphieudatcho t WHERE t.dienthoai = :dienthoai"),
    @NamedQuery(name = "Tblphieudatcho.findByNgaydat", query = "SELECT t FROM Tblphieudatcho t WHERE t.ngaydat = :ngaydat"),
    @NamedQuery(name = "Tblphieudatcho.findByEmail", query = "SELECT t FROM Tblphieudatcho t WHERE t.email = :email"),
    @NamedQuery(name = "Tblphieudatcho.findByNgaydi", query = "SELECT t FROM Tblphieudatcho t WHERE t.ngaydi = :ngaydi")})
public class Tblphieudatcho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maphieu")
    private Integer maphieu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hoten")
    private String hoten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dienthoai")
    private String dienthoai;
    @Column(name = "ngaydat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaydat;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaydi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaydi;

    public Tblphieudatcho() {
    }

    public Tblphieudatcho(Integer maphieu) {
        this.maphieu = maphieu;
    }

    public Tblphieudatcho(Integer maphieu, String hoten, String dienthoai, Date ngaydi) {
        this.maphieu = maphieu;
        this.hoten = hoten;
        this.dienthoai = dienthoai;
        this.ngaydi = ngaydi;
    }

    public Integer getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(Integer maphieu) {
        this.maphieu = maphieu;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public Date getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(Date ngaydi) {
        this.ngaydi = ngaydi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maphieu != null ? maphieu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblphieudatcho)) {
            return false;
        }
        Tblphieudatcho other = (Tblphieudatcho) object;
        if ((this.maphieu == null && other.maphieu != null) || (this.maphieu != null && !this.maphieu.equals(other.maphieu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblphieudatcho[ maphieu=" + maphieu + " ]";
    }
    
}
