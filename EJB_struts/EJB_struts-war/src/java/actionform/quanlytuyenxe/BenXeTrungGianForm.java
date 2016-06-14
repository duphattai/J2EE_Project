/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlytuyenxe;

/**
 *
 * @author Quoc
 */
public class BenXeTrungGianForm extends org.apache.struts.validator.ValidatorForm {
    
   private int machitiettuyen;
   private String tenbenxe;
   private int mabenxe;
   private String ghichu;
   private int thoigiandung;

    public int getMachitiettuyen() {
        return machitiettuyen;
    }

    public void setMachitiettuyen(int machitiettuyen) {
        this.machitiettuyen = machitiettuyen;
    }

    public String getTenbenxe() {
        return tenbenxe;
    }

    public void setTenbenxe(String tenbenxe) {
        this.tenbenxe = tenbenxe;
    }

    public int getMabenxe() {
        return mabenxe;
    }

    public void setMabenxe(int mabenxe) {
        this.mabenxe = mabenxe;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getThoigiandung() {
        return thoigiandung;
    }

    public void setThoigiandung(int thoigiandung) {
        this.thoigiandung = thoigiandung;
    }
   
   
}
