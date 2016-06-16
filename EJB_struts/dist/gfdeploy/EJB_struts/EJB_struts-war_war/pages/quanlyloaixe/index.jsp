<%-- 
    Document   : index
    Created on : Jun 11, 2016, 9:40:17 AM
    Author     : TuanAnh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>         

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .an {
        display: none;       
    }
    ._34px{
        height: 34px;
    }
    #cancel, #luu, #update, #delete {
        width: 65px;
    }
</style>
<div class="container">   
    <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#themloaixe" style="width: 120px;margin-bottom: 5px;">Thêm</button>
    <div id="themloaixe" class="collapse" style="width: 40%">
        <html:form action="/quanlyloaixe.do?method=add">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center; font-size: 20px"><b>Thêm Loại Xe</b></div>
                <div class="panel-body">
                    <form class="col-md-12">
                        <div class="form-group">
                            <!--<input name="maloaixe" type="text" class="form-control  _34px" placeholder="Mã loại xe">-->
                        </div>
                        <div class="form-group">
                            <input name="loaixe" type="text" class="form-control  _34px" placeholder="Tên loại xe">
                        </div> 
                        <div class="form-group">
                            <button id="btnThem" class="btn btn-primary btn-lg btn-block" >Thêm</button>			
                        </div>
                    </form>
                </div>
            </div>
        </html:form>
    </div>
    
    <div id="dsloaixe" style="width: 85%">
        <div class="panel panel-default">
            <div class="panel-heading" style="text-align: center;font-size: 20px"><b>Danh Sách Loại Xe</b></div>
            <div class="panel-body">
                <div id="loaixe">
                    <table id="dataTable" class="table table-hover">
                        <thead>
                            <tr>
                                <th>Mã Loại Xe</th>
                                <th>Tên Loại Xe</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="xe">
                                <html:form action="quanlyloaixe.do?method=update">
                                <tr>
                                    <td id="maloaixe">${xe.maloaixe}  
                                    <input name="maloaixe" value="${xe.maloaixe}" type="hidden"></td>
                                    <td id="vLoaixe">${xe.loaixe}</td>
                                    <td id="uLoaixe" class="an"><input name="loaixe" value="${xe.loaixe}" type="text" class="form-control  _34px" placeholder="Tên loại xe"></td>
                                    <td>
                                        <label class="btn btn-primary" id="update">Update</label>
                                        <label class="btn btn-primary an" id="cancel">Cancel</label>
                                        <button type="submit" class="btn btn-success an" id="luu">Lưu</button>
                                        <a href="quanlyloaixe.do?method=delete&&maloaixe=${xe.maloaixe}" class="btn btn-danger" id="delete" onclick="return confirm('Bạn có muốn xóa không?')">Delete</a>
                                        <!--<label data-id="${xe.maloaixe}" class="btn btn-danger" id="delete">Delete</label>-->
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
                <h4 class="modal-title">Cập nhật loại xe</h4>
            </div>  
            <html:form  method="POST">
                <div class="modal-body">                    
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
              
        $( "#dataTable tbody tr" ).on( "click","#update", function() {
            console.log("davao");
            $(this).closest("tr").find("#vLoaixe").addClass("an"); 
            $(this).closest("tr").find("#uLoaixe").removeClass("an");
            
            $(this).closest("tr").find("#luu").removeClass("an"); 
            $(this).closest("tr").find("#cancel").removeClass("an"); 
            $(this).closest("tr").find("#update").addClass("an"); 
            $(this).closest("tr").find("#delete").addClass("an"); 
        });
        
        $( "#dataTable tbody tr" ).on( "click","#cancel", function() {           
            $(this).closest("tr").find("#uLoaixe").addClass("an"); 
            $(this).closest("tr").find("#vLoaixe").removeClass("an");
                      
            $(this).closest("tr").find("#luu").addClass("an");            
            $(this).closest("tr").find("#update").removeClass("an");
            $(this).closest("tr").find("#cancel").addClass("an");
            $(this).closest("tr").find("#delete").removeClass("an");
        });
		
    });
        
</script>