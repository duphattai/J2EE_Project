<%-- 
    Document   : login
    Created on : Jun 13, 2016, 1:37:24 PM
    Author     : HaiHamHo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lý Xe Khách</title>
    </head>
    <body>
        <h1>Quản Lý Xe Khách</h1>
        <div class="center" style="margin: auto; padding: 10px;width: 500px; height: 500px;">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center;">Đăng nhập</div>
                <div class="panel-body">
                    <form class="col-md-12" action="login.do" method="POST">
                        <div class="form-group">
                            <input name="tentaikhoan" type="text" class="form-control input-lg" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <input name="matkhau" type="password" class="form-control input-lg" placeholder="Password">
                        </div>              
                        <div class="form-group">
                            <button class="btn btn-primary btn-lg btn-block">Login</button>			
                        </div>
                    </form>
                </div>
            </div>	
        </div>
    </body>
</html>
