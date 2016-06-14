<%-- 
    Document   : index
    Created on : Jun 11, 2016, 9:40:17 AM
    Author     : TuanAnh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>         

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/path/to/bootstrap/js/bootstrap.min.js"></script>

<style>
    .an {
        display: none;
    }
    ._34px{
        height: 34px !important;
    }
    #cancel, #luu, #update, #delete {
        width: 65px;
    }
</style>

<div class="container">   
    <a type="button" class="btn btn-primary" data-toggle="collapse" data-target="#themtaikhoan" style="width: 120px;margin-bottom: 5px;">Thêm</a>
    <div id="themtaikhoan" class="collapse" style="width: 40%">
        <html:form action="/taikhoan.do?method=add">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center; font-size: 20px"><b>Thêm Tài Khoản</b></div>
                <div class="panel-body">
                    <form class="col-md-12">
                        <div class="form-group">
                            <input name="tentaikhoan" type="text" class="form-control  _34px" placeholder="Tên tài khoản">
                        </div>
                        <div class="form-group">
                            <html:select property="maquyen" styleId="maquyen" styleClass="form-control _34px" >
                                <c:forEach var="quyen" items="${listquyen}">
                                    <option value="${quyen.id}">${quyen.quyen}</option>
                                </c:forEach>
                            </html:select>
                        </div> 
                        <div class="form-group">
                            <input name="matkhau" type="text" class="form-control  _34px" placeholder="Mật khẩu">
                        </div>
                        <div class="form-group">
                            <input name="hoten" type="text" class="form-control  _34px" placeholder="Họ tên">
                        </div>
                        <div class="form-group" style="display: flex">
                            <input name="ngaysinh" type="text" class="form-control _34px" placeholder="Ngày sinh" style="width: 60%">
                            <label style="margin-left: 5px;"> (dd/mm/yyyy)</label>                           
                        </div>
                        <div class="form-group">
                            <input name="cmnd" type="text" class="form-control _34px" placeholder="CMND">
                        </div>
                        <div class="form-group">
                            <input name="diachi" type="text" class="form-control _34px" placeholder="Địa chỉ">
                        </div>
                        <div class="form-group">
                            <button id="btnThem" class="btn btn-primary btn-lg btn-block" >Thêm</button>			
                        </div>
                    </form>
                </div>
            </div>
        </html:form>
    </div>

    <div id="dstaikhoan" style="width: 90%">
        <div class="panel panel-default">
            <div class="panel-heading" style="text-align: center;font-size: 20px"><b>Danh Sách Tài Khoản</b></div>
            <div class="panel-body">
                <div id="taikhoan">
                    <table id="dataTable" class="table table-hover">
                        <thead>
                            <tr>
                                <th>Tên tài khoản</th>
                                <th>Quyền</th>
                                <th>Mật khẩu</th>
                                <th>Họ tên</th>
                                <th>Ngày sinh</th>
                                <th>CMND</th>
                                <th>Địa chỉ</th>                              
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="tk">
                                <html:form action="taikhoan.do?method=update" method="POST">
                                <tr>
                                    <td>${tk.tentaikhoan}
                                        <input name="tentaikhoan" value="${tk.tentaikhoan}" type="hidden" >
                                    </td>
                                    <td class="vAn">${tk.quyen}</td>
                                    <td class="uAn an">
                                        <html:select property="maquyen" styleId="maquyen" styleClass="form-control _34px" style="width:100px">
                                            <c:forEach var="quyen" items="${listquyen}">
                                                <option value="${quyen.id}">${quyen.quyen}</option>
                                            </c:forEach>
                                        </html:select>
                                    </td>
                                    <td class="vAn">${tk.matkhau}</td>
                                    <td class="uAn an"><input name="matkhau" type="text" value="${tk.matkhau}" class="form-control _34px" placeholder="Mật khẩu"></td>
                                    <td class="vAn">${tk.hoten}</td>
                                    <td class="uAn an"><input name="hoten" type="text" value="${tk.hoten}" class="form-control _34px" placeholder="Họ tên"></td>
                                    <td class="vAn">${tk.ngaysinh}</td>
                                    <td class="uAn an">
                                        <input name="ngaysinh" type="text" value="${tk.ngaysinh}" class="form-control  _34px" placeholder="Ngày sinh" >                                           
                                    </td>
                                    <td class="vAn">${tk.cmnd}</td>
                                    <td class="uAn an"><input name="cmnd" type="text" value="${tk.cmnd}" class="form-control  _34px" placeholder="CMND"></td>
                                    <td class="vAn">${tk.diachi}</td>
                                    <td class="uAn an"><input name="diachi" type="text" value="${tk.diachi}" class="form-control  _34px" placeholder="Địa chỉ"></td>
                                    <td style="width: 150px">
                                        <label class="btn btn-primary" id="update">Update</label>
                                        <label class="btn btn-primary an" id="cancel">Cancel</label>
                                        <button type="submit" class="btn btn-success an" id="luu">Lưu</button>
                                        <a href="taikhoan.do?method=delete&&tentaikhoan=${tk.tentaikhoan}" class="btn btn-danger" id="delete">Delete</a>
                                    </td>                                    
                                </tr>
                                </html:form>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- <%--Modal add--%> -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Thêm loại xe</h4>
            </div>
            <html:form>
                <div class="modal-body">
                    <div id="content">
                        <div class="panel panel-default">
                            <div class="panel-heading" style="text-align: center;">Thêm Loại Xe</div>
                            <div class="panel-body">
                                <form class="col-md-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control input-lg" placeholder="Mã loại xe">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control input-lg" placeholder="Tên loại xe">
                                    </div>                                           
                                </form>
                            </div>
                        </div>	
                    </div>
                    <p class="mess"></p>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-sm-6">
                            <button type="button" class="btn btn-success modal-ok" style="float: right; width: 100px">OK</button></div>
                        <div class="col-sm-6">
                            <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 100px; float: left">Close</button></div>
                    </div>
                </div>
            </html:form>
        </div>
    </div>
</div>
<script>
	
    $(document).ready(function () {

        $("#themloaixe1").on("click","button", function () {                              
            $.ajax({
                type: "POST",
                url: '${pageContext.request.contextPath}/quanlyloaixe.do?method=add',
                processData: true,
                async: true,                                
                success: function (data) {                    
                    $("#dsloaixe").html($(data).find('div#dsloaixe').html());                    
                },
                error: function (a) {
                    console.log(a.responseText);
                }
            });
        });
		
        $( "#dataTable tbody tr" ).on( "click","#update", function() {           
            $(this).closest("tr").find(".vAn").addClass("an"); 
            $(this).closest("tr").find(".uAn").removeClass("an");
                        
            $(this).closest("tr").find("#luu").removeClass("an"); 
            $(this).closest("tr").find("#cancel").removeClass("an"); 
            $(this).closest("tr").find("#update").addClass("an"); 
            $(this).closest("tr").find("#delete").addClass("an"); 
        });
        
        $( "#dataTable tbody tr" ).on( "click","#cancel", function() {           
            $(this).closest("tr").find(".vAn").removeClass("an"); 
            $(this).closest("tr").find(".uAn").addClass("an");
            
            $(this).closest("tr").find("#luu").addClass("an");            
            $(this).closest("tr").find("#update").removeClass("an");
            $(this).closest("tr").find("#cancel").addClass("an");
            $(this).closest("tr").find("#delete").removeClass("an");
        });

    });
        function themLoaiXe() {
            $.post('quanlyloaixe.do?method=add', $("#dsloaixe").serialize(), function (response) {
                $("#dsloaixe").html($(response).find('div#dsloaixe').html()); 
            }, "text");
        }

	function openmodal()
	{
		var modal = $("#myModal");
		modal.modal();		
	}
	
</script>