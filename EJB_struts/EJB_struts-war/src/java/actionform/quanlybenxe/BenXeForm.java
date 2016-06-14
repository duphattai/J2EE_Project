/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionform.quanlybenxe;

/**
 *
 * @author Tai
 */
public class BenXeForm extends org.apache.struts.validator.ValidatorForm {
    
    private String tenBenXe;
    private int maBenXe;

    public String getTenBenXe() {
        return tenBenXe;
    }

    public void setTenBenXe(String tenBenXe) {
        this.tenBenXe = tenBenXe;
    }

    public int getMaBenXe() {
        return maBenXe;
    }

    public void setMaBenXe(int maBenXe) {
        this.maBenXe = maBenXe;
    }


}
