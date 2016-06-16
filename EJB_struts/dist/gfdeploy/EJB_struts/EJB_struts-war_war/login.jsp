<%-- 
    Document   : login
    Created on : Jun 13, 2016, 1:37:24 PM
    Author     : HaiHamHo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lý Xe Khách</title>
    </head>
    <body>
        <h1 class="text-center">Quản Lý Xe Khách</h1>
        <div class="center" style="margin: auto; padding: 10px;width: 500px; height: 500px;">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center;"><h3><b>Đăng nhập</b></h3></div>
                <div class="panel-body">
                    <html:form styleClass="col-md-12" action="login.do">
                        <div class="form-group">
                            <input name="tentaikhoan" type="text" class="form-control input-lg" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <input name="matkhau" type="password" class="form-control input-lg" placeholder="Password">
                        </div> 
                        <div class="form-group">
                            <input name="maquen" value="${tk.maquyen}" type="hidden" >
                            <input name="hoten" value="${tk.hoten}" type="hidden" >
                            <input name="ngaysinh" value="${tk.ngaysinh}" type="hidden" >
                            <input name="cmnd" value="${tk.cmnd}" type="hidden" >
                            <input name="diachi" value="${tk.diachi}" type="hidden" >
                            <input name="quyen" value="${tk.quyen}" type="hidden" >
                        </div>  
                        <div class="form-group">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>			
                        </div>
                    </html:form>
                </div>
            </div>	
        </div>
    </body>
</html>
