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
public class TraCuuVeXeForm extends org.apache.struts.validator.ValidatorForm {
    
    private int maphieu;
    private String hoten;
    private String dienthoai;
    private String ngaydi;
    private int mabendi;
    private int mabenden;
    
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

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public int getMabendi() {
        return mabendi;
    }

    public void setMabendi(int mabendi) {
        this.mabendi = mabendi;
    }

    public int getMabenden() {
        return mabenden;
    }

    public void setMabenden(int mabenden) {
        this.mabenden = mabenden;
    }

}
