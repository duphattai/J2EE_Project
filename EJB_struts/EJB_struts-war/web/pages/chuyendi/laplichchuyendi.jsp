<%-- 
    Document   : laplichchuyendi
    Created on : Jun 12, 2016, 7:09:46 PM
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
    <link rel="stylesheet" href="<c:url value="/resources/css/chuyendi.css" />" >
    <script src="<c:url value="/resources/js/chuyendi.js"/>" ></script>

    
    
    <html:form styleClass="form-horizontal" action="quanlychuyendi" method="get">
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
                <html:hidden property="method" value="tracuuxekhach"></html:hidden>
                <input type="submit" class="btn btn-primary active" value="Tìm kiếm"/>
            </div>	
        </div>   
    </html:form>
    
    <!---------------Danh sách xe--------------->
    <div>
        <!-- Danh sach xe-->
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
            <c:forEach var="chuyendi" items="${listxekhach}">
                <tr class="text_middle">
                    <td>${chuyendi.maxekhach}</td>
                    <td>${chuyendi.biensoxe}</td>
                    <td>${chuyendi.benxedi} - ${chuyendi.benxeden}</td>
                    <td>${chuyendi.taixe}</td>
                    <td>
                        <a href="#" class="btn btn-warning btn-sm" style="float:right; margin-right:5px;" data-toggle="collapse" data-target="#formll_${chuyendi.maxekhach}">Lập lịch</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="5">
                        <!-- Form lập lịch-->
                        <div class="collapse" id="formll_${chuyendi.maxekhach}">
                            <html:form action="quanlychuyendi.do?method=add" onsubmit="return addChuyenDi(this)">
                                <html:hidden property="maxekhach" value="${chuyendi.maxekhach}"/>
                                <div id="div_${chuyendi.maxekhach}" class="col-sm-12" style="padding:5px; background: white; border: 1px solid rgb(204, 204, 204); background: white; border-bottom-left-radius:5px;border-bottom-right-radius:5px;">
                                    <div class="col-sm-4">
                                        <div style="width:70%; margin-top: 5px;">
                                            <div class="input-group date">
                                                <input type="hidden" value="${chuyendi.thoigiandi}"/>
                                                <a href="#div_${chuyendi.maxekhach}" onclick="return false;">
                                                    <input class="form-control datetimepicker editKH" style="cursor: pointer;" name="khoihanh" type="text" placeholder="Khởi hành"/>
                                                </a>
                                                <span class="input-group-addon">
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
                                                <input class="form-control editKT" name="ketthuc" type="text" placeholder="Kết thúc" readonly="true"/>
                                                <span style="" class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-2" style="padding-top: 6px;">
                                        <button type="submit" style="float:right;" class="btn btn-primary btn-sm">Tạo</button>
                                    </div>
                                    <div class="col-sm-12" name="message" style="color: red"></div>
                                </div>                
                            </html:form>
                        </div>
                    <td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
               
</div>
