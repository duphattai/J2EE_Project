/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlyvexe;

/**
 *
 * @author Tai
 */
public class TraCuuChuyenDiForm extends org.apache.struts.action.ActionForm {
    
    private int maBenDi;
    private int maBenDen;
    private String khoiHanh;
    
    public int getMaBenDi() {
        return maBenDi;
    }

    public void setMaBenDi(int maBenDi) {
        this.maBenDi = maBenDi;
    }

    public int getMaBenDen() {
        return maBenDen;
    }

    public void setMaBenDen(int maBenDen) {
        this.maBenDen = maBenDen;
    }

    public String getKhoiHanh() {
        return khoiHanh;
    }

    public void setKhoiHanh(String khoiHanh) {
        this.khoiHanh = khoiHanh;
    }

}
