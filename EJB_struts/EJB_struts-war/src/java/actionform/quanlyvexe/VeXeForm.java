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
public class VeXeForm extends org.apache.struts.validator.ValidatorForm {
    
    private int maphieu;
    private String hoten;
    private String dienthoai;
    private String ngaydat;
    private String ngaydi;
    private String email;
    private String danhsachghe;
    private boolean thanhtoan;
    private int machuyendi;
    private String tuyenxe;

    public String getTuyenxe() {
        return tuyenxe;
    }

    public void setTuyenxe(String tuyenxe) {
        this.tuyenxe = tuyenxe;
    }
    
    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public int getMachuyendi() {
        return machuyendi;
    }

    public void setMachuyendi(int machuyendi) {
        this.machuyendi = machuyendi;
    }
    
    public int getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(int maphieu) {
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

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDanhsachghe() {
        return danhsachghe;
    }

    public void setDanhsachghe(String danhsachghe) {
        this.danhsachghe = danhsachghe;
    }

    public boolean isThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(boolean thanhtoan) {
        this.thanhtoan = thanhtoan;
    }
    
    
  
}
