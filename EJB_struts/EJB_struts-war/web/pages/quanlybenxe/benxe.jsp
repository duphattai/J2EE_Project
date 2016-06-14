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
    <div class="container">	 
        <div>
            <h1 style="text-align: center; color:#0066ff;">Quản Lý Bến Xe</h1>
        </div >
        <div id="benXeModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <html:javascript formName="BenXeForm" />
                    <html:form action="benxe.do?method=them" onsubmit="return addBenXe(this);">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Thông tin bến xe</h4>
                        </div>
                        <div class="modal-body">
                            <label for="male">Tên bến xe</label>
                            <html:text property="tenBenXe" styleClass="form-control"></html:text>
                            <div name="message"></div>
                        </div>
                        <div class="modal-footer">
                            <html:submit styleClass="btn btn-primary">Đồng ý</html:submit>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                        <html:errors />
                    </html:form>
                </div>

            </div>
        </div>
        <div class="container">
            <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#benXeModal">Thêm bến xe</button>
        </div>
        <div class="row">
            <table  class="table table-striped" style="width:70%; margin-left: 10%">
                <thead>
                    <tr style="color: rgb(255, 255, 255);background-color: rgb(36, 97, 170);text-transform: uppercase;font-size: 14px;font-weight: 700;">
                        <th class="col-3-sm">Mã bến xe</th>
                        <th class="col-3-sm">Tên bến xe</th>
                        <th class="col-2-sm"></th>
                        <th class="col-2-sm"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="benxe" items="${listbenxe}">
                        <tr class="text_middle">
                            <td>${benxe.mabenxe}</td>
                            <td>${benxe.tenbenxe}</td>
                            <td>
                                <a href="#" class="btn btn-warning">Sửa</a>
                            </td>
                            <td>
                                <html:link styleClass="btn btn-warning" action="benxe.do?method=delete&mabenxe=${benxe.mabenxe}" onclick="return confirm('Bạn chắc muốn xóa?')">Xóa</html:link>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <script>
        function addBenXe(form) {
            if(validateBenXeForm(form)){
                $.post($(form).attr('action'), $(form).serialize(), function (response) {
                    $("div[name='message']").html($(response).find('MESSAGE').html());
                }, "text");
            }
            return false;
        }

    </script>
</div>

