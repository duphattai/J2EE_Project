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
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.css" />" >
    <script src="<c:url value="/resources/js/moment.js"/>" ></script>
    <script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js"/>" ></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/datve.css" />" >
    <script src="<c:url value="/resources/js/datve.js"/>" ></script>
    

    <html:form styleClass="form-horizontal" action="vexe" styleId="searchChuyenDi">
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
    <div id="lapVeModal" class="modal fade" role="dialog">
        <div style="width:1024px; margin:auto;" class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header"><h4 class="modal-title">Modal Header</h4></div>
                <html:javascript formName="VeXeForm"/>
                <html:form action="vexe/lapphieu.do?method=taoPhieuDatCho"
                           onsubmit="return lapPhieuDatCho(this);">
                   
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
                                                <td><i class="fa fa-circle ml5" style="color: #D4D4D4;"></i>Chưa thanh toán</td>
                                                <td><i class="fa fa-circle ml5" style="color: red;"></i>Đã thanh toán</td>
                                            </tr>
                                        </table>
                                        <table class="table" id="placeSeat">
                                        </table>									
                                    </td>

                                    <td>
                                        <table class="table">
                                            <tr>
                                                <td>Tuyến đường</td>
                                                <td>
                                                    <html:hidden property="machuyendi" styleId="lapve_machuyendi"></html:hidden>
                                                    <strong id="lapve_tuyendi"></strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Khởi hành</td>
                                                <td>
                                                    <input name="ngaydi" id="lapve_khoihanh" readonly="true" style="border: 0; width:100%"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Giá vé</td>
                                                <td>
                                                    <span name="180000" id="lapve_giave"></span> ₫/người
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Số ghế</td>
                                                <td>
                                                    <span id="text_amount_seat"></span>
                                                    <html:hidden styleId="vexe_danhsachghe" property="danhsachghe"></html:hidden>
                                                </td>
                                            </tr>
                                            <tr style="border-top: 1px solid rgb(189, 189, 189);">
                                                <td><strong>Tổng tiền:</strong></td>
                                                <td><span id="text_total_price_seat">0</span></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="radio-inline">
                                                        <input name="thanhtoan" value="1" checked type="radio">Đã thanh toán
                                                    </label>
                                                </td>
                                                <td>
                                                    <label class="radio-inline">
                                                        <input name="thanhtoan" value="0" type="radio">Chưa thanh toán
                                                    </label>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>

                                    <td>
                                        <div class="form" role="form" style="padding-top: 8px;">
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <div class="input-group-addon" style="background-color: #eee;"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></div>
                                                    <html:text property="hoten" styleId="vexe_hoten" styleClass="form-control"></html:text>
                                                    <html:hidden property="maphieu"></html:hidden>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <div class="input-group-addon" style="background-color: #eee;">@</div>
                                                    <html:text styleClass="form-control" styleId="vexe_email" property="email"></html:text>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <div class="input-group-addon" style="background-color: #eee;"><i class="fa fa-phone" aria-hidden="true"></i></div>
                                                    <html:text styleClass="form-control" styleId="vexe_dienthoai" property="dienthoai"></html:text>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div name="message"></div>
                    </div>
                    <div class="modal-footer">
                        <html:submit styleClass="btn btn-primary">Đồng ý</html:submit>
                        <button type="button" data-dismiss="modal"  class="btn btn-default">Hủy</button>
                    </div>
                </html:form>
            </div>
        </div>  
    </div>
</div>

