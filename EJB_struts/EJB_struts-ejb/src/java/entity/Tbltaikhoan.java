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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tbltaikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbltaikhoan.findAll", query = "SELECT t FROM Tbltaikhoan t"),
    @NamedQuery(name = "Tbltaikhoan.findByTentaikhoan", query = "SELECT t FROM Tbltaikhoan t WHERE t.tentaikhoan = :tentaikhoan"),
    @NamedQuery(name = "Tbltaikhoan.findByMaquyen", query = "SELECT t FROM Tbltaikhoan t WHERE t.maquyen = :maquyen"),
    @NamedQuery(name = "Tbltaikhoan.findByMatkhau", query = "SELECT t FROM Tbltaikhoan t WHERE t.matkhau = :matkhau"),
    @NamedQuery(name = "Tbltaikhoan.findByHoten", query = "SELECT t FROM Tbltaikhoan t WHERE t.hoten = :hoten"),
    @NamedQuery(name = "Tbltaikhoan.findByCmnd", query = "SELECT t FROM Tbltaikhoan t WHERE t.cmnd = :cmnd"),
    @NamedQuery(name = "Tbltaikhoan.findByDiachi", query = "SELECT t FROM Tbltaikhoan t WHERE t.diachi = :diachi"),
    @NamedQuery(name = "Tbltaikhoan.findByNgaysinh", query = "SELECT t FROM Tbltaikhoan t WHERE t.ngaysinh = :ngaysinh")})
public class Tbltaikhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tentaikhoan")
    private String tentaikhoan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maquyen")
    private int maquyen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "matkhau")
    private String matkhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hoten")
    private String hoten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cmnd")
    private String cmnd;
    @Size(max = 100)
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaysinh;

    public Tbltaikhoan() {
    }

    public Tbltaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public Tbltaikhoan(String tentaikhoan, int maquyen, String matkhau, String hoten, String cmnd) {
        this.tentaikhoan = tentaikhoan;
        this.maquyen = maquyen;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.cmnd = cmnd;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public int getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(int maquyen) {
        this.maquyen = maquyen;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tentaikhoan != null ? tentaikhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbltaikhoan)) {
            return false;
        }
        Tbltaikhoan other = (Tbltaikhoan) object;
        if ((this.tentaikhoan == null && other.tentaikhoan != null) || (this.tentaikhoan != null && !this.tentaikhoan.equals(other.tentaikhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbltaikhoan[ tentaikhoan=" + tentaikhoan + " ]";
    }
    
}
