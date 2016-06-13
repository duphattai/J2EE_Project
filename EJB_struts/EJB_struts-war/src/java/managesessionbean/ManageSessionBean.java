/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesessionbean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import service.TblbaocaodoanhthuchuyendiFacadeLocal;
import service.TblbaocaodoanhthunamFacadeLocal;
import service.TblbaocaodoanhthuthangFacadeLocal;
import service.TblbenxeFacadeLocal;
import service.TblchitietphieudatchoFacadeLocal;
import service.TblchitiettuyenFacadeLocal;
import service.TblchuyendiFacadeLocal;
import service.TblloaixeFacadeLocal;
import service.TblphanquyenFacadeLocal;
import service.TblphieudatchoFacadeLocal;
import service.TbltaikhoanFacadeLocal;
import service.TblthamsoFacadeLocal;
import service.TbltuyenxeFacadeLocal;
import service.TblxekhachFacadeLocal;

/**
 *
 * @author Tai
 */
public class ManageSessionBean {

    public TblxekhachFacadeLocal tblxekhachFacade = lookupTblxekhachFacadeLocal();

    public TbltuyenxeFacadeLocal tbltuyenxeFacade = lookupTbltuyenxeFacadeLocal();

    public TblthamsoFacadeLocal tblthamsoFacade = lookupTblthamsoFacadeLocal();

    public TblphieudatchoFacadeLocal tblphieudatchoFacade = lookupTblphieudatchoFacadeLocal();

    public TblphanquyenFacadeLocal tblphanquyenFacade = lookupTblphanquyenFacadeLocal();

    public TblloaixeFacadeLocal tblloaixeFacade = lookupTblloaixeFacadeLocal();

    public TblchuyendiFacadeLocal tblchuyendiFacade = lookupTblchuyendiFacadeLocal();

    public TblchitiettuyenFacadeLocal tblchitiettuyenFacade = lookupTblchitiettuyenFacadeLocal();

    public TblchitietphieudatchoFacadeLocal tblchitietphieudatchoFacade = lookupTblchitietphieudatchoFacadeLocal();

    public TblbaocaodoanhthuthangFacadeLocal tblbaocaodoanhthuthangFacade = lookupTblbaocaodoanhthuthangFacadeLocal();

    public TblbaocaodoanhthunamFacadeLocal tblbaocaodoanhthunamFacade = lookupTblbaocaodoanhthunamFacadeLocal();

    public TblbaocaodoanhthuchuyendiFacadeLocal tblbaocaodoanhthuchuyendiFacade = lookupTblbaocaodoanhthuchuyendiFacadeLocal();

    public TblbenxeFacadeLocal tblbenxeFacade = lookupTblbenxeFacadeLocal();
    
    public TbltaikhoanFacadeLocal tbltaikhoanFacade = lookupTbltaikhoanFacadeLocal();
    
    public ManageSessionBean(){
    }
    private TblbenxeFacadeLocal lookupTblbenxeFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblbenxeFacadeLocal) c.lookup("java:comp/env/TblbenxeFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblbaocaodoanhthuchuyendiFacadeLocal lookupTblbaocaodoanhthuchuyendiFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblbaocaodoanhthuchuyendiFacadeLocal) c.lookup("java:comp/env/TblbaocaodoanhthuchuyendiFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblbaocaodoanhthunamFacadeLocal lookupTblbaocaodoanhthunamFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblbaocaodoanhthunamFacadeLocal) c.lookup("java:comp/env/TblbaocaodoanhthunamFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblbaocaodoanhthuthangFacadeLocal lookupTblbaocaodoanhthuthangFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblbaocaodoanhthuthangFacadeLocal) c.lookup("java:comp/env/TblbaocaodoanhthuthangFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblchitietphieudatchoFacadeLocal lookupTblchitietphieudatchoFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblchitietphieudatchoFacadeLocal) c.lookup("java:comp/env/TblchitietphieudatchoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblchitiettuyenFacadeLocal lookupTblchitiettuyenFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblchitiettuyenFacadeLocal) c.lookup("java:comp/env/TblchitiettuyenFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblchuyendiFacadeLocal lookupTblchuyendiFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblchuyendiFacadeLocal) c.lookup("java:comp/env/TblchuyendiFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblloaixeFacadeLocal lookupTblloaixeFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblloaixeFacadeLocal) c.lookup("java:comp/env/TblloaixeFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblphanquyenFacadeLocal lookupTblphanquyenFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblphanquyenFacadeLocal) c.lookup("java:comp/env/TblphanquyenFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblphieudatchoFacadeLocal lookupTblphieudatchoFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblphieudatchoFacadeLocal) c.lookup("java:comp/env/TblphieudatchoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblthamsoFacadeLocal lookupTblthamsoFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblthamsoFacadeLocal) c.lookup("java:comp/env/TblthamsoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TbltuyenxeFacadeLocal lookupTbltuyenxeFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TbltuyenxeFacadeLocal) c.lookup("java:comp/env/TbltuyenxeFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TblxekhachFacadeLocal lookupTblxekhachFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TblxekhachFacadeLocal) c.lookup("java:comp/env/TblxekhachFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private TbltaikhoanFacadeLocal lookupTbltaikhoanFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TbltaikhoanFacadeLocal) c.lookup("java:comp/env/TbltaikhoanFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
