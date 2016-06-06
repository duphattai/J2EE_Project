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
    <link rel="stylesheet" href="resources/css/bootstrap-datetimepicker.css" >
    <script src="resources/js/moment.js"></script>
    <script src="resources/js/bootstrap-datetimepicker.min.js"></script>
    <link rel="stylesheet" href="resources/css/datve.css" >
    <script src="resources/js/datve.js"></script>
    

    <html:form styleClass="form-horizontal" styleId="searchChuyenDi">
        <div class="form-group">	
            <label class="col-xs-1 control-label" style="padding-right: 0;">Bến xe đi</label>
            <div class="col-xs-2">
                <html:select property="maBenDi" styleId="maBenDi" styleClass="form-control" >
                    <c:forEach var="benxe" items="${listbenxedi}">
                        <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                    </c:forEach>
                </html:select>
            </div>
            <label class="col-xs-1 control-label" style="padding-right: 0;">Bến xe đến</label>
            <div class="col-xs-2">
                <html:select property="maBenDen" styleId="maBenDen" styleClass="form-control">
                    <c:forEach var="benxe" items="${listbenxeden}">
                        <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                    </c:forEach>
                </html:select>
            </div>
            <label class="col-xs-1 control-label" style="padding-right: 0;">Khởi hành</label>
            <div class="col-xs-3">
                <div class='input-group date' id='datetimepicker'>
                    <html:text styleClass="form-control" styleId="khoiHanh" property="khoiHanh"></html:text>
                    <span class="input-group-addon">
                        <span class="fa fa-calendar">
                        </span>
                    </span>
                </div>
            </div>
            <div class="col-xs-2">
                <input type="button" class="btn btn-primary active" value="Tìm kiếm" onclick="timKiemChuyenDi()"/>
                 <script type="text/javascript">
                    function timKiemChuyenDi(){ 
                        $.post('vexe/tracuu.do', $("#searchChuyenDi").serialize(), function(response){
                            $('#placeSearchChuyenDi').html(response);  
                        }, "text");
                    }
                </script>
            </div>	
        </div>                     
    </html:form>
	
    <div class="row">
        <table  class="table table-striped">
            <thead>
                <tr>
                    <th class="col-3-sm">Tuyến đường</th>
                    <th class="col-2-sm">Khởi hành</th>
                    <th class="col-2-sm">Loại xe</th>
                    <th class="col-2-sm">Số ghế</th>
                    <th class="col-1-sm">Giá</th>
                    <th class="col-2-sm"></th>
                </tr>
            </thead>
            <tbody id="placeSearchChuyenDi">
                
            </tbody>
        </table>
    </div>



    <!-- Modal -->
    <div class="modal fade" id="lapVeModal" role="dialog">
        <div class="modal-dialog" style="width:1024px;">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <thead>
                            <tr class="tr_header">
                                <td style="width:30%">Sơ đồ ghế</td>
                                <td style="width:35%">Thông tin vé</td>
                                <td style="width:35%">Thông tin khách hàng</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <table class="table">
                                        <tr>
                                            <td><i class="fa fa-circle ml5" style="color: #BADF41;"></i>Đang chọn</td>
                                            <td><i class="fa fa-circle ml5" style="color: #F5F5F5;"></i>Ghế trống</td>
                                            <td><i class="fa fa-circle ml5" style="color: #D4D4D4;"></i>Ghế đã đặt</td>
                                        </tr>
                                    </table>
                                    <table class="table" id="placeSeat">
                                    </table>									
                                </td>

                                <td>
                                    <table class="table">
                                        <tr>
                                            <td>Tuyến đường</td>
                                            <td><strong>Sài Gòn - Nha Trang - Khánh Hòa</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Khởi hành</td>
                                            <td><strong>19:00 18-06-2016</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Giá vé</td>
                                            <td>
                                                <span name="180000" id="text_seat_price">180000</span> ₫/người
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Số ghế</td>
                                            <td><span id="text_amount_seat"></span></td>
                                        </tr>
                                        <tr style="border-top: 1px solid rgb(189, 189, 189);">
                                            <td><strong>Tổng tiền:</strong></td>
                                            <td><span id="text_total_price_seat">0</span></td>
                                        </tr>
                                    </table>
                                </td>

                                <td>
                                    <form class="form" role="form" style="padding-top: 8px;">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-addon" style="background-color: #eee;"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></div>
                                                <input type="email" class="form-control" placeholder="Họ tên">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-addon" style="background-color: #eee;">@</div>
                                                <input class="form-control" type="email" placeholder="Enter email">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-addon" style="background-color: #eee;"><i class="fa fa-phone" aria-hidden="true"></i></div>
                                                <input class="form-control" type="email" placeholder="Số điện thoại">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-default">Sign in</button>
                                    </form>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>

            </div>
        </div>  
    </div>
</div>

