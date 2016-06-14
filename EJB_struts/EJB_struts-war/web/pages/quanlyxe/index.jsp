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
        height: 34px !important;
    }
    #cancel, #luu, #update, #delete {
        width: 65px;
    }
</style>
<div class="container">   
    <a type="button" class="btn btn-primary" data-toggle="collapse" data-target="#themxe" style="width: 120px;margin-bottom: 5px;">Thêm</a>
    <div id="themxe" class="collapse" style="width: 40%">
        <html:form action="/quanlyxe.do?method=add">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center; font-size: 20px"><b>Thêm Xe</b></div>
                <div class="panel-body">
                    <form class="col-md-12">
                        <div class="form-group">
                            <input name="maxe" type="text" class="form-control  _34px" placeholder="Mã xe">
                        </div>
                        <div class="form-group">
                            <html:select property="maloaixe" styleId="maloaixe" styleClass="form-control _34px" >
                                <c:forEach var="maloaixe" items="${listloaixe}">
                                    <option value="${maloaixe.maloaixe}">${maloaixe.loaixe}</option>
                                </c:forEach>
                            </html:select>
                        </div> 
                        <div class="form-group">
                            <input name="taixe" type="text" class="form-control  _34px" placeholder="Tài xế">
                        </div>
                        <div class="form-group">
                            <input name="biensoxe" type="text" class="form-control  _34px" placeholder="Biển số xe">
                        </div>
                        <div class="form-group">
                            <html:select property="matuyen" styleId="matuyen" styleClass="form-control _34px" >
                                <c:forEach var="tuyenxe" items="${listtuyenxe}">
                                    <option value="${tuyenxe.matuyen}">${tuyenxe.tuyen}</option>
                                </c:forEach>
                            </html:select>
                        </div>
                        <div class="form-group">
                            <input name="soghe" type="text" class="form-control  _34px" placeholder="Số ghế">
                        </div>
                        <div class="form-group">
                            <button id="btnThem" class="btn btn-primary btn-lg btn-block" >Thêm</button>			
                        </div>
                    </form>
                </div>
            </div>
        </html:form>
    </div>
    
    <div id="dsxe" style="width: 85%">
        <div class="panel panel-default">
            <div class="panel-heading" style="text-align: center;font-size: 20px"><b>Danh Sách Xe</b></div>
            <div class="panel-body">
                <div id="xe">
                    <table id="dataTable" class="table table-hover">
                        <thead>
                            <tr>
                                <th>Mã Xe</th>
                                <th>Loại Xe</th>
                                <th>Tài xế</th>
                                <th>Biển số xe</th>
                                <th>Tuyến Xe</th>
                                <th>Số ghế</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="xe">
                                <html:form action="quanlyxe.do?method=update">
                                <tr>
                                    <td>${xe.maxe}
                                        <input name="maxe" type="hidden" value="${xe.maxe}">
                                    </td>
                                    <td class="vAn">${xe.loaixe}</td>
                                    <td class="uAn an">
                                        <html:select property="maloaixe" styleId="maloaixe" styleClass="form-control _34px" style="height: 46px">
                                            <c:forEach var="maloaixe" items="${listloaixe}">
                                                <option value="${maloaixe.maloaixe}">${maloaixe.loaixe}</option>
                                            </c:forEach>
                                        </html:select>
                                    </td>
                                    <td class="vAn">${xe.taixe}</td>
                                    <td class="uAn an"><input name="taixe" type="text" value="${xe.taixe}" class="form-control _34px" placeholder="Tài xế"></td>
                                    <td class="vAn">${xe.biensoxe}</td>
                                    <td class="uAn an"><input name="biensoxe" type="text" value="${xe.biensoxe}" class="form-control _34px" placeholder="Biển số xe"></td>
                                    <td class="vAn">${xe.tuyen}</td>
                                    <td class="uAn an">
                                        <html:select property="matuyen" styleId="matuyen" styleClass="form-control _34px" style="height: 46px">
                                            <c:forEach var="tuyenxe" items="${listtuyenxe}">
                                                <option value="${tuyenxe.matuyen}">${tuyenxe.tuyen}</option>
                                            </c:forEach>
                                        </html:select>
                                    </td>
                                    <td class="vAn">${xe.soghe}</td>
                                    <td class="uAn an"><input name="soghe" type="text" value="${xe.soghe}" class="form-control _34px   " placeholder="Số ghế" style="width:80px"></t>
                                    <td style="width: 150px">
                                        <label class="btn btn-primary" id="update">Update</label>
                                        <label class="btn btn-primary an" id="cancel">Cancel</label>
                                        <button type="submit" class="btn btn-success an" id="luu">Lưu</button>
                                        <a href="quanlyxe.do?method=delete&&maxe=${xe.maxe}" class="btn btn-danger" id="delete" onclick="return confirm('Bạn có muốn xóa không?')">Delete</a>
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