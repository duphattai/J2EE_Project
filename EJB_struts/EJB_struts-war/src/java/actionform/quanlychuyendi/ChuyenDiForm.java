/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlychuyendi;

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
    private String ketthuc;

    public ChuyenDiForm(int machuyendi, int maxekhach, String biensoxe, String loaixe, int soghe, String benxedi, String benxeden, String khoihanh, String ketthuc) {
        this.machuyendi = machuyendi;
        this.maxekhach = maxekhach;
        this.biensoxe = biensoxe;
        this.loaixe = loaixe;
        this.soghe = soghe;
        this.benxedi = benxedi;
        this.benxeden = benxeden;
        this.khoihanh = khoihanh;
        this.ketthuc = ketthuc;
    }

    public ChuyenDiForm() {
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
