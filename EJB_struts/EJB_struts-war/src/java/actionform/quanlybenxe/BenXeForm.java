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
public class BenXeForm extends org.apache.struts.action.ActionForm {
    
    private String tenbenxe;
    private int mabenxe;

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

    public BenXeForm() {
        super();
        // TODO Auto-generated constructor stub
    }
}
