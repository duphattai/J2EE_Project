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


    <html:form styleClass="form-horizontal" action="tracuuvexe.do?method=traCuuVeXe">
        <div class="form-group">
            <div class="col-xs-12">
                <label class="col-xs-1 control-label" style="padding-right: 0;">Bến xe đi</label>
                <div class="col-xs-2">
                    <html:select property="mabendi" styleClass="form-control" >
                        <c:forEach var="benxe" items="${listbenxedi}">
                            <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                        </c:forEach>
                    </html:select>
                </div>
                <label class="col-xs-1 control-label" style="padding-right: 0;">Họ tên</label>
                <div class="col-xs-2">
                    <html:text property="hoten" styleClass="form-control"></html:text>
                </div>
                <label class="col-xs-1 control-label" style="padding-right: 0;">Khởi hành</label>
                <div class="col-xs-3">
                    <div class='input-group date datetimepicker'>
                        <html:text styleClass="form-control" property="ngaydi"></html:text>
                        <span class="input-group-addon">
                            <span class="fa fa-calendar">
                            </span>
                        </span>
                    </div>
                </div> 
                <div class="col-xs-2">
                    <input type="submit" class="btn btn-primary active" value="Tìm kiếm"/>
                </div>	
            </div>
            <div class="col-xs-12" style="margin-top: 10px;">
                <label class="col-xs-1 control-label" style="padding-right: 0;">Bến xe đến</label>
                <div class="col-xs-2">
                    <html:select property="mabenden" styleClass="form-control">
                        <c:forEach var="benxe" items="${listbenxeden}">
                            <option value="${benxe.mabenxe}">${benxe.tenbenxe}</option>
                        </c:forEach>
                    </html:select>
                </div>
                <label class="col-xs-1 control-label" style="padding-right: 0;">Điện thoại</label>
                <div class="col-xs-2">
                    <html:text property="dienthoai" styleClass="form-control"></html:text>
                </div>
            </div>
        </div>
    </html:form>
    
    <div class="row">
        <table  class="table table-striped">
            <thead>
                <tr>
                    <th class="col-2-sm">Họ tên</th>
                    <th class="col-2-sm">Số điện thoại</th>
                    <th class="col-2-sm">Tuyến</th>
                    <th class="col-2-sm">Ngày đi</th>
                    <th class="col-1-sm">Ghế</th>
                    <th class="col-2-sm"></th>
                    <th class="col-1-sm"></th>
                </tr>
            </thead>
            <tbody id="placeSearchVe">
                <c:forEach var="phieudatcho" items="${listvexe}">
                    <tr>
                        <td>${phieudatcho.hoten}</td>
                        <td>${phieudatcho.dienthoai}</td>
                        <td>${phieudatcho.tuyenxe}</td>
                        <td>${phieudatcho.ngaydi}</td>
                        <td>${phieudatcho.danhsachghe}</td>
                        <td>
                             <a href="#" class="btn btn-primary btn-sm" style="float:right; margin-right:5px;">Sửa</a>
                        </td>
                        <td>
                            <html:link styleClass="btn btn-warning btn-sm" onclick="return confirm('Bạn chắc muốn hủy vé?')" 
                                       action="tracuuvexe.do?method=huyVe&maphieu=${phieudatcho.maphieu}">Hủy vé</html:link>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

