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
    <a type="button" class="btn btn-primary" data-toggle="collapse" data-target="#themtuyenxe" style="width: 120px;margin-bottom: 5px;">Thêm</a>
    <div id="themtuyenxe" class="collapse" style="width: 40%">
        <html:form action="Tuyenxe.do?method=add">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center; font-size: 20px"><b>Thêm Tuyến Xe</b></div>
                <div class="panel-body">
                    <form class="col-md-12">
                        <div class="row form-group">
                            <label class="col-xs-4 control-label">Bến xe đi:</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="mabendi">
                                    <c:forEach var="benxe" items="${listbenxe}">
                                        <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <label class="col-xs-4 control-label">Bến xe đến:</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="mabenden">
                                    <c:forEach var="benxe" items="${listbenxe}">
                                        <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <label class="col-xs-4 control-label">Thời gian đi:</label>
                            <div class="col-sm-5">
                                <html:text styleClass="form-control" property="thoigian"></html:text>
                            </div>
                        </div>
                        <div class="row form-group">
                            <label class="col-xs-4 control-label">Đơn giá:</label>
                            <div class="col-sm-5">
                                <html:text styleClass="form-control" property="dongia"></html:text>
                            </div>
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
            <div class="panel-heading" style="text-align: center;font-size: 20px"><b>Danh Sách Tuyến Xe</b></div>
            <div class="panel-body">
                <div id="taikhoan">
                    <table id="dataTable" class="table table-hover">
                        <thead>
                            <tr>
                                <th>Mã tuyến</th>
                                <th>Bến xe đi </th>
                                <th>Bến xe đến</th>
                                <th>Thời gian</th>
                                <th>Đơn giá</th>                                                             
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listtuyenxe}" var="tx">
                                <html:form action="Tuyenxe.do?method=update" method="POST">
                                <tr>
                                    <td>${tx.matuyen}
                                        <input name="matuyen" value="${tx.matuyen}" type="hidden" >
                                    </td>
                                    <td class="vAn">${tx.tenbendi}</td>
                                    <td class="uAn an">
                                        <html:select property="mabendi" styleId="mabendi" styleClass="form-control _34px">
                                            <c:forEach var="bx" items="${listbenxe}">
                                                <option value="${bx.mabenxe}">${bx.tenbenxe}</option>
                                            </c:forEach>
                                        </html:select>
                                    </td>
                                    <td class="vAn">${tx.tenbenden}</td>
                                    <td class="uAn an">
                                        <html:select property="mabenden" styleId="mabenden" styleClass="form-control _34px">
                                            <c:forEach var="bx" items="${listbenxe}">
                                                <option value="${bx.mabenxe}">${bx.tenbenxe}</option>
                                            </c:forEach>
                                        </html:select>
                                    </td>
                                    <td class="vAn">${tx.thoigian}</td>
                                    <td class="uAn an"><input name="thoigian" type="text" value="${tx.thoigian}" class="form-control _34px" placeholder="Thời gian"></td>
                                    <td class="vAn">${tx.dongia}</td>
                                    <td class="uAn an"><input name="dongia" type="text" value="${tx.dongia}" class="form-control _34px" placeholder="Đơn giá"></td>                                    
                                    <td style="width: 150px">
                                        <label class="btn btn-primary" id="update">Update</label>
                                        <label class="btn btn-primary an" id="cancel">Cancel</label>
                                        <button type="submit" class="btn btn-success an" id="luu">Lưu</button>
                                        <a href="Tuyenxe.do?method=delete&&matuyen=${tx.matuyen}" class="btn btn-danger" id="delete" onclick="return confirm('Bạn có muốn xóa không?')">Delete</a>
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