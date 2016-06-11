<%-- 
    Document   : index
    Created on : Jun 11, 2016, 10:25:28 PM
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
    <link rel="stylesheet" href="<c:url value="/resources/css/chuyendi.css" />" >
    <script src="<c:url value="resources/js/chuyendi.js"/>" ></script>

    <html:form styleClass="form-horizontal" action="quanlychuyendi.do?method=index" method="post" 
               onsubmit="return traCuuChuyenDi(this);">
       
        <div class="form-group">	
            <label class="col-xs-1 control-label" style="padding-right: 0;">Bến xe đi</label>
            <div class="col-xs-2">
                <select class="form-control" name="mabendi" >
                    <option value="-1">Vui lòng chọn bến</option>
                    <c:forEach var="benxe" items="${listbenxedi}">
                        <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                    </c:forEach>
                </select>
            </div>
            <label class="col-xs-1 control-label" style="padding-right: 0;">Bến xe đến</label>
            <div class="col-xs-2">
                <select class="form-control" name="mabenden" >
                    <option value="-1">Vui lòng chọn bến</option>
                    <c:forEach var="benxe" items="${listbenxeden}">
                        <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-xs-2">
                <input type="submit" class="btn btn-primary active" value="Tìm kiếm"/>
            </div>	
        </div>   
    </html:form>	
    <div>
        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#lapChuyenDiModal">Thêm</button>
    </div>

    <!---------------------------------------------------->
    <div id="placeSearchChuyenDi">
        <c:forEach var="chuyendi" items="${listchuyendi}">
            <div id="${chuyendi.machuyendi}" class="col-sm-4" style="padding:5px;">
                <div  class="col-sm-12" style="border-bottom:1px solid; background: white; border-top-left-radius:5px;border-top-right-radius:5px;">
                    <div class="col-sm-4">
                        <span>Biển số</span>
                        <h5 style="margin-top: 5px;">${chuyendi.biensoxe}</h5>                
                    </div>
                    <div class="col-sm-5">
                        <span>${chuyendi.loaixe}</span>
                        <h5 style="margin-top: 5px;">Số ghế: ${chuyendi.soghe}</h5>                
                    </div>
                    <div class="col-sm-3" style="padding:5px 0px; text-align:right">
                        <a href="#" class="save" role="button" style="font-size:1.2em; display:none;"><span><i class="fa fa-check-circle" aria-hidden="true"></i></span></a>
                        <a href="#${chuyendi.machuyendi}" onclick="return editChuyenDi(this);" role="button" style="font-size:1.2em;"><span><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span></a>
                        <a href="#" role="button" style="font-size:1.2em;"><span><i class="fa fa-times-circle" aria-hidden="true"></i></span></a>
                    </div>
                </div>
                <div class="col-sm-12" style="padding:5px; background: white; background: white; border-bottom-left-radius:5px;border-bottom-right-radius:5px;">
                    <div class="col-sm-5">
                        <span style="color: rgb(123, 123, 123);">Bến xe đi</span>
                        <h4 style="margin:0;">${chuyendi.benxedi}</h4>
                        <h4 style="margin-bottom:0;">
                            <div class="input-group date">
                                <input class="input-group-addon datetimepicker" id="editKH" style="width:70%; border:none; background:white" type="text" value="${chuyendi.khoihanh}" disabled/>
                            </div>
                        </h4>
                    </div>
                    <div class="col-sm-2">
                        <h3>→</h3>
                    </div>
                    <div class="col-sm-5" style="margin-left">
                        <span style="color: rgb(123, 123, 123);">Bến xe đến</span>
                        <h4 style="margin:0;">${chuyendi.benxeden}</h4>
                        <h4 style="margin-bottom:0;">
                            <div class="input-group date">
                                <input class="input-group-addon datetimepicker" id="editKT" style="width:70%; border:none; background:white" readonly type="text" value="${chuyendi.ketthuc}" disabled/>
                            </div>
                        </h4>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <!---------------PopUp--------------->
    <!-- Modal -->
    <div id="lapChuyenDiModal" class="modal fade" role="dialog">
        <div class="modal-dialog" style="width:704px">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Lập lịch chuyến đi</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">	
                            <label class="col-xs-2 control-label" style="padding-right: 0;">Bến xe đi</label>
                            <div class="col-xs-3">
                                <select class="form-control">
                                    <option>Nha Trang</option>
                                    <option>Vũng Tàu</option>
                                    <option>Sài Gòn</option>
                                </select>
                            </div>
                            <label class="col-xs-2 control-label" style="padding-right: 0;">Bến xe đến</label>
                            <div class="col-xs-3">
                                <select class="form-control">
                                    <option>Nha Trang</option>
                                    <option>Vũng Tàu</option>
                                    <option>Sài Gòn</option>
                                </select>
                            </div>
                            <div class="col-xs-2">
                                <a href="#" class="btn btn-primary active" role="button">Tìm kiếm</a>
                            </div>	
                        </div>
                    </form>	

                    <!-- Danh sach xe-->
                    <form class="form-horizontal">
                        <table  class="table table-striped">
                            <thead>
                                <tr class="tr_header">
                                    <th class="col-1-sm">Mã xe</th>
                                    <th class="col-2-sm">Biển số xe</th>
                                    <th class="col-3-sm">Tuyến</th>
                                    <th class="col-3-sm">Tài xế</th>
                                    <th class="col-3-sm"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="text_middle">
                                    <td>1</td>
                                    <td>855.48</td>
                                    <td>Cần thơ - Sóc trăng</td>
                                    <td>Nguyễn Văn A</td>
                                    <td>
                                        <button class="btn btn-warning btn-sm" style="float:right; margin-right:5px;" data-toggle="collapse" data-target="#formll_1" >Lập lịch</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="5">
                                        <!-- Form lập lịch-->
                                        <div class="collapse" id="formll_1">
                                            <form>

                                                <div class="col-sm-12" style="padding:5px; background: white; border: 1px solid rgb(204, 204, 204); background: white; border-bottom-left-radius:5px;border-bottom-right-radius:5px;">
                                                    <div class="col-sm-4">
                                                        <div style="width:70%; margin-top: 5px;">
                                                            <div class="input-group date datetimepicker">
                                                                <input class="form-control" type="text" placeholder="Khởi hành"/>
                                                                <span style="" class="input-group-addon">
                                                                    <span class="fa fa-calendar">
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-1">
                                                        <h4>→</h4>
                                                    </div>
                                                    <div class="col-sm-offset-1 col-sm-4" style="margin-left">
                                                        <div style="width:70%; margin-top: 5px;">
                                                            <div class="input-group date datetimepicker">
                                                                <input class="form-control" type="text" placeholder="Kết thúc" disabled/>
                                                                <span style="" class="input-group-addon">
                                                                    <span class="fa fa-calendar">
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2" style="padding-top: 6px;">
                                                        <button type="submit" style="float:right;" class="btn btn-primary btn-sm">Tạo</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    <td>

                                </tr>
                            </tbody>
                        </table>
                    </form>				
                </div>

                <div class="modal-footer"></div>

            </div>

        </div>
    </div>
    <script>
        function lapLichChuyenDi(id) {


            return false;
        }
    </script>
