/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlytaikhoan;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author HaiHamHo
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    private String tentaikhoan;
    private String matkhau;
    private int maquyen;

    public int getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(int maquyen) {
        this.maquyen = maquyen;
    }
    
    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public LoginForm(String tentaikhoan, String matkhau) {
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
    }
    
    public boolean checkLogin(){
        return true;
    }
    
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
        super.reset(mapping, request);
        tentaikhoan = "";
        matkhau = "";
    }
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

}
