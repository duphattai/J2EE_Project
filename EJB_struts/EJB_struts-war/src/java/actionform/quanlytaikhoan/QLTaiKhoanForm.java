/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlytaikhoan;

import java.text.SimpleDateFormat;


/**
 *
 * @author HaiHamHo
 */
public class QLTaiKhoanForm extends org.apache.struts.action.ActionForm {
    
    private String tentaikhoan;
    private int maquyen;
    private String quyen;
    private String matkhau;
    private String hoten;
    private String cmnd;
    private String diachi;
    private String ngaysinh;

    public QLTaiKhoanForm(String tentaikhoan, String quyen, String matkhau, String hoten, String cmnd, String diachi, String ngaysinh) {
        this.tentaikhoan = tentaikhoan;
        this.quyen = quyen;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
    }

    
    public String getQuyen() {
        return quyen;
    }
    
    public QLTaiKhoanForm(String tentaikhoan, int maquyen, String quyen, String matkhau, String hoten, String cmnd, String diachi, String ngaysinh) {
        this.tentaikhoan = tentaikhoan;
        this.maquyen = maquyen;
        this.quyen = quyen;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
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

    public String getNgaysinh() {        
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    
    public QLTaiKhoanForm() {
        super();
        // TODO Auto-generated constructor stub
    }
}
