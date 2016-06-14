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
public class TuyenXeForm extends org.apache.struts.action.ActionForm {
    
    private int matuyen;
    private int mabendi;
    private int mabenden;
    private String tenbendi;
    private String tenbenden;
    private int thoigiandi;
    private int dongia;
    
    public TuyenXeForm(int matuyen, int mabendi, int mabenden, String tenbendi, String tenbenden) {
        this.matuyen = matuyen;
        this.mabendi = mabendi;
        this.mabenden = mabenden;
        this.tenbendi = tenbendi;
        this.tenbenden = tenbenden;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThoigiandi() {
        return thoigiandi;
    }

    public void setThoigiandi(int thoigiandi) {
        this.thoigiandi = thoigiandi;
    }

    public int getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(int matuyen) {
        this.matuyen = matuyen;
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

    public String getTenbendi() {
        return tenbendi;
    }

    public void setTenbendi(String tenbendi) {
        this.tenbendi = tenbendi;
    }

    public String getTenbenden() {
        return tenbenden;
    }

    public void setTenbenden(String tenbenden) {
        this.tenbenden = tenbenden;
    }
    
    public TuyenXeForm() {
        super();
        // TODO Auto-generated constructor stub
    }
}
