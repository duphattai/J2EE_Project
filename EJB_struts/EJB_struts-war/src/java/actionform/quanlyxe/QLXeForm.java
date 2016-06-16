/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlyxe;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author HaiHamHo
 */
public class QLXeForm extends org.apache.struts.action.ActionForm {
    
    private int maxe;
    private int maloaixe;
    private String loaixe;
    private String taixe;
    private String biensoxe;
    private int matuyen;
    private int soghe;
    private String tuyen;

    public QLXeForm(int matuyen, String tuyen) {
        this.matuyen = matuyen;
        this.tuyen = tuyen;
    }
       
    public QLXeForm(int maxe, String loaixe, String taixe, String biensoxe, int soghe, String tuyen) {
        this.maxe = maxe;
        this.loaixe = loaixe;
        this.taixe = taixe;
        this.biensoxe = biensoxe;
        this.soghe = soghe;
        this.tuyen = tuyen;
    }

    
    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public String getTuyen() {
        return tuyen;
    }

    public void setTuyen(String tuyen) {
        this.tuyen = tuyen;
    }
    
    
    public int getMaxe() {
        return maxe;
    }

    public void setMaxe(int maxe) {
        this.maxe = maxe;
    }

    public int getMaloaixe() {
        return maloaixe;
    }

    public void setMaloaixe(int maloaixe) {
        this.maloaixe = maloaixe;
    }

    public String getTaixe() {
        return taixe;
    }

    public void setTaixe(String taixe) {
        this.taixe = taixe;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public int getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(int matuyen) {
        this.matuyen = matuyen;
    }

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }
    
    
    public QLXeForm() {
        super();
        // TODO Auto-generated constructor stub
    }

}
