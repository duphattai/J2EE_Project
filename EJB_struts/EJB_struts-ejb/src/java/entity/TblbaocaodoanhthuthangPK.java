/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tai
 */
@Embeddable
public class TblbaocaodoanhthuthangPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "thang")
    private int thang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam")
    private int nam;

    public TblbaocaodoanhthuthangPK() {
    }

    public TblbaocaodoanhthuthangPK(int thang, int nam) {
        this.thang = thang;
        this.nam = nam;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) thang;
        hash += (int) nam;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblbaocaodoanhthuthangPK)) {
            return false;
        }
        TblbaocaodoanhthuthangPK other = (TblbaocaodoanhthuthangPK) object;
        if (this.thang != other.thang) {
            return false;
        }
        if (this.nam != other.nam) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblbaocaodoanhthuthangPK[ thang=" + thang + ", nam=" + nam + " ]";
    }
    
}
