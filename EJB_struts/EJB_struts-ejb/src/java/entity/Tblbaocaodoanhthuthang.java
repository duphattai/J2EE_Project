/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tai
 */
@Entity
@Table(name = "tblbaocaodoanhthuthang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbaocaodoanhthuthang.findAll", query = "SELECT t FROM Tblbaocaodoanhthuthang t"),
    @NamedQuery(name = "Tblbaocaodoanhthuthang.findByThang", query = "SELECT t FROM Tblbaocaodoanhthuthang t WHERE t.tblbaocaodoanhthuthangPK.thang = :thang"),
    @NamedQuery(name = "Tblbaocaodoanhthuthang.findByNam", query = "SELECT t FROM Tblbaocaodoanhthuthang t WHERE t.tblbaocaodoanhthuthangPK.nam = :nam"),
    @NamedQuery(name = "Tblbaocaodoanhthuthang.findBySochuyendi", query = "SELECT t FROM Tblbaocaodoanhthuthang t WHERE t.sochuyendi = :sochuyendi"),
    @NamedQuery(name = "Tblbaocaodoanhthuthang.findByDoanhthu", query = "SELECT t FROM Tblbaocaodoanhthuthang t WHERE t.doanhthu = :doanhthu"),
    @NamedQuery(name = "Tblbaocaodoanhthuthang.findByTile", query = "SELECT t FROM Tblbaocaodoanhthuthang t WHERE t.tile = :tile")})
public class Tblbaocaodoanhthuthang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblbaocaodoanhthuthangPK tblbaocaodoanhthuthangPK;
    @Column(name = "sochuyendi")
    private Integer sochuyendi;
    @Column(name = "doanhthu")
    private Integer doanhthu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tile")
    private Float tile;

    public Tblbaocaodoanhthuthang() {
    }

    public Tblbaocaodoanhthuthang(TblbaocaodoanhthuthangPK tblbaocaodoanhthuthangPK) {
        this.tblbaocaodoanhthuthangPK = tblbaocaodoanhthuthangPK;
    }

    public Tblbaocaodoanhthuthang(int thang, int nam) {
        this.tblbaocaodoanhthuthangPK = new TblbaocaodoanhthuthangPK(thang, nam);
    }

    public TblbaocaodoanhthuthangPK getTblbaocaodoanhthuthangPK() {
        return tblbaocaodoanhthuthangPK;
    }

    public void setTblbaocaodoanhthuthangPK(TblbaocaodoanhthuthangPK tblbaocaodoanhthuthangPK) {
        this.tblbaocaodoanhthuthangPK = tblbaocaodoanhthuthangPK;
    }

    public Integer getSochuyendi() {
        return sochuyendi;
    }

    public void setSochuyendi(Integer sochuyendi) {
        this.sochuyendi = sochuyendi;
    }

    public Integer getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Integer doanhthu) {
        this.doanhthu = doanhthu;
    }

    public Float getTile() {
        return tile;
    }

    public void setTile(Float tile) {
        this.tile = tile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblbaocaodoanhthuthangPK != null ? tblbaocaodoanhthuthangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblbaocaodoanhthuthang)) {
            return false;
        }
        Tblbaocaodoanhthuthang other = (Tblbaocaodoanhthuthang) object;
        if ((this.tblbaocaodoanhthuthangPK == null && other.tblbaocaodoanhthuthangPK != null) || (this.tblbaocaodoanhthuthangPK != null && !this.tblbaocaodoanhthuthangPK.equals(other.tblbaocaodoanhthuthangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbaocaodoanhthuthang[ tblbaocaodoanhthuthangPK=" + tblbaocaodoanhthuthangPK + " ]";
    }
    
}
