/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlychuyendi;

import entity.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Tai
 */
public class ChuyenDiForm extends org.apache.struts.action.ActionForm {
    
    private int machuyendi;
    private int maxekhach;
    
    private String biensoxe;
    private String loaixe;
    private int soghe;
    private String benxedi;
    private String benxeden;
    private String khoihanh;
    private int thoigiandi;
    private String ketthuc;
    private String taixe;
    private String []ngaytrongtuan;
    private String thu;
    
    public ChuyenDiForm(Tblchuyendi cd, Tblxekhach xk, Tblbenxe bxdi, Tblbenxe bxden, Tblloaixe lx, Tbltuyenxe tx) {
        if(cd != null){
            this.machuyendi = cd.getMachuyendi();
            
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
            this.khoihanh = sf.format(cd.getKhoihanh());
            this.ketthuc = sf.format(cd.getKetthuc());
            
            String[] dayOfWeek = {"Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy", "Chủ nhật"};
            setNgaytrongtuan(new String[]{cd.getKhoihanh().getDay() + ""});
            thu = dayOfWeek[cd.getKhoihanh().getDay()];
        }
            
        this.maxekhach = xk.getMaxe();
        this.biensoxe = xk.getBiensoxe();
        this.loaixe = lx.getLoaixe();
        this.soghe = xk.getSoghe();
        this.benxedi = bxdi.getTenbenxe();
        this.benxeden = bxden.getTenbenxe();
        this.thoigiandi = tx.getThoigian();
        this.taixe = xk.getTaixe();
    }

    public String getThu() {
        return thu;
    }

    public String[] getNgaytrongtuan() {
        return ngaytrongtuan;
    }

    public void setNgaytrongtuan(String[] ngaytrongtuan) {
        this.ngaytrongtuan = ngaytrongtuan;
    }
    
    public String getTaixe() {
        return taixe;
    }

    public void setTaixe(String taixe) {
        this.taixe = taixe;
    }

    public ChuyenDiForm() {
    }

    public int getThoigiandi() {
        return thoigiandi;
    }

    public void setThoigiandi(int thoigiandi) {
        this.thoigiandi = thoigiandi;
    }
    
    
    public int getMachuyendi() {
        return machuyendi;
    }

    public void setMachuyendi(int machuyendi) {
        this.machuyendi = machuyendi;
    }

    public int getMaxekhach() {
        return maxekhach;
    }

    public void setMaxekhach(int maxekhach) {
        this.maxekhach = maxekhach;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }

    public String getBenxedi() {
        return benxedi;
    }

    public void setBenxedi(String benxedi) {
        this.benxedi = benxedi;
    }

    public String getBenxeden() {
        return benxeden;
    }

    public void setBenxeden(String benxeden) {
        this.benxeden = benxeden;
    }

    public String getKhoihanh() {
        return khoihanh;
    }

    public void setKhoihanh(String khoihanh) {
        this.khoihanh = khoihanh;
    }

    public String getKetthuc() {
        return ketthuc;
    }

    public void setKetthuc(String ketthuc) {
        this.ketthuc = ketthuc;
    }

}
