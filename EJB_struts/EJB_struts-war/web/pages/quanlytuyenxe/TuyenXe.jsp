<%-- 
    Document   : index
    Created on : Jun 5, 2016, 1:31:45 PM
    Author     : Tai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>           

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<div>
    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap-datetimepicker.css" />" >
    <script src="<c:url value="resources/js/moment.js"/>" ></script>
    <script src="<c:url value="resources/js/bootstrap-datetimepicker.min.js"/>" ></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/tuyenxe.css" />" >
    <html:javascript formName="TuyenXeForm"/>
    
    <div>	
        <div>
            <h1 style="text-align: center; color:#0066ff;">Quản Lý Tuyến Xe</h1>
        </div >
        <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#tuyenXeModal">Thêm</button>
        <div id="tuyenXeModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Thông tin tuyến xe</h4>
                    </div>
                    <div class="modal-body">
                        <div>
                            <div>
                                <ul class="tab">
                                    <li><a href="#" class="tablinks active" onclick="openCity(event, 'tuyenxe')">Tuyến xe</a></li>
                                    <li><a href="#" class="tablinks" id="showtrunggian" style="display:none;" onclick="openCity(event, 'trunggian')">Thông tin chi tiết</a></li>
                                </ul>
                            </div>
                            <div id="tuyenxe" class="tabcontent" style="display: block">
                                <html:form action="Tuyenxe.do?method=add" onsubmit="return addTuyenXe(this);">
                                    <h1 style="text-align: center; color:#0066ff;">Chọn tuyến xe để tạo</h1>
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
                                            <html:text styleClass="form-control" property="thoigiandi"></html:text>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <label class="col-xs-4 control-label">Đơn giá:</label>
                                        <div class="col-sm-5">
                                            <html:text styleClass="form-control" property="dongia"></html:text>
                                        </div>
                                    </div>
                                </html:form>  
                            </div>
                            <div id="trunggian" class="tabcontent" >
                                <h2 style="text-align: center; color:#0066ff;">Nhập thông tin bến xe trung gian</h2>
                                <html:form action="Tuyenxe/capnhat">
                                    <div class="row">
                                        <label class="col-xs-3"style="margin: 10px 0px 0px 0px;">chọn bến trung gian:</label>
                                        <select class="col-xs-5" style="margin: 10px 0px 0px 0px;"name="mabendi">
                                            <c:forEach var="benxe" items="${listbenxe}">
                                                <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="row">
                                        <label style="margin: 10px 0px 0px 0px;" class="col-xs-3" style="padding: 10px 0px 0px 0px;">Chọn thời gian dừng:</label>
                                        <div style="margin: 10px 0px 0px 0px;" class="col-xs-3 input-group">
                                            <input class="form-control" name="thoigiandung"></input>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div>
                                            <label class="col-xs-3" style="margin: 10px 0px 0px 0px;">Ghi chú:</label>
                                            <input style="margin: 10px 0px 0px 0px;" class="col-xs-3" type="text" placeholder="Nhập ghi chú">
                                        </div>
                                    </div>
                                    <div class="col-xs-3">
                                        <button style="margin: 10px 0px 0px 0px;"  class="btn btn-primary" type="button">Thêm</button>
                                    </div>

                                    <!-- DANH SACH BEN TRUNG GIAN-->
                                    <div class="form-group">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th class="col-2-sm">Bến trung gian</th>
                                                    <th class="col-2-sm">Thời gian dừng</th>
                                                    <th class="col-2-sm">Ghi chú</th>
                                                    <th class="col-2-sm">Sữa</th>
                                                    <th class="col-2-sm">Xóa</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="text_middle">
                                                    <td><a href="#">C1</a></td>
                                                    <td>19h00</td>
                                                    <td>Chợ lớn</td>
                                                    <td>
                                                        <a href="#" class="btn btn-warning">Sửa</a>
                                                    </td>
                                                    <td>
                                                        <a href="#" class="btn btn-warning">Xóa</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </html:form>
                            </div>
                        </div>
                        <div name="message"></div>
                    </div>
                    <div class="modal-footer">
                        <html:submit styleId="add_tuyenxe" onclick="show('TuyenXeForm')" styleClass="btn btn-primary">Tạo</html:submit>
                            <button type="button" class="btn btn-default" data-dismiss="modal" style="float: right" onclick="closeModal()">Đóng</button>
                        <html:submit styleId="edit_tuyenxe" onclick="anAdd()" styleClass="btn btn-primary" style="display:none; float:right;" >Cập nhật</html:submit>
                        </div>
                    <html:errors />
                </div>
            </div>
        </div>


        <div class="container">
            <div class="form-group">
                <table  class="table table-striped">
                    <thead>
                        <tr>
                            <th class="col-3-sm">Tuyến xe đi</th>
                            <th class="col-2-sm">Tuyến xe đến</th>
                            <th class="col-2-sm">Sữa</th>
                            <th class="col-2-sm">Xóa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tuyenxe" items="${listtuyenxe}">
                            <tr class="text_middle">
                                <td>${tuyenxe.tenbendi}</td>
                                <td>${tuyenxe.tenbenden}</td>
                                <td>
                                    <a href="#" class="btn btn-warning">Sửa</a>
                                </td>
                                <td>
                                    <a href="#" class="btn btn-warning">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }


    function show($frmName) {
        $("#tuyenXeModal form[name='" + $frmName + "']").submit();
        return true;
    }

    function addTuyenXe(form) {
        if(validateTuyenXeForm(form) == true){
            $.post($(form).attr('action'), $(form).serialize(), function (response) {
                $("#tuyenXeModal div[name='message']").html($(response).find('MESSAGE').text());

                if ($(response).find('ERROR').text() == null) {
                    if ($("#showtrunggian").css('display') == 'none') {
                        $("#showtrunggian").css('display', 'block');
                    }
                    $("#add_tuyenxe").css('display', 'none');
                    $("#edit_tuyenxe").css('display', 'block');
                }
            }, "text");
        }

        return false;
    }

    function editTuyenXe(form) {
        $.post($(form).attr('action'), $(form).serialize(), function (response) {

        }, "text");
        return false;
    }

    function closeModal() {
        $("#showtrunggian").css('display', 'none');
    }

</script>

