<%-- 
    Document   : index
    Created on : Jun 5, 2016, 1:31:45 PM
    Author     : Tai
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
<html:javascript formName="BenXeForm"/>
<div class="container">   
    <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#thembenxe" style="width: 120px;margin-bottom: 5px;">Thêm</button>
    <div id="thembenxe" class="collapse" style="width: 40%">
        <html:form action="/benxe.do?method=them" onsubmit="return validateBenXeForm(this);">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center; font-size: 20px"><b>Thêm Bến Xe</b></div>
                <div class="panel-body">
                    <form class="col-md-12">
                        <div class="form-group">
                            <!--<input name="mabenxe" type="text" class="form-control  _34px" placeholder="Mã bến xe">-->
                        </div>
                        <div class="form-group">
                            <input name="tenbenxe" type="text" class="form-control  _34px" placeholder="Tên bến xe">
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
            <div class="panel-heading" style="text-align: center;font-size: 20px"><b>Danh Sách Bến Xe</b></div>
            <div class="panel-body">
                <div id="loaixe">
                    <table id="dataTable" class="table table-hover">
                        <thead>
                            <tr>
                                <th>Mã Bến Xe</th>
                                <th>Tên Bến Xe</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listbenxe}" var="xe">
                                <html:form action="benxe.do?method=update">
                                <tr>
                                    <td id="mabenxe">${xe.mabenxe}  
                                    <input name="mabenxe" value="${xe.mabenxe}" type="hidden"></td>
                                    <td id="vBenxe">${xe.tenbenxe}</td>
                                    <td id="uBenxe" class="an"><input name="tenbenxe" value="${xe.tenbenxe}" type="text" class="form-control  _34px" placeholder="Tên bến xe"></td>
                                    <td>
                                        <label class="btn btn-primary" id="update">Update</label>
                                        <label class="btn btn-primary an" id="cancel">Cancel</label>
                                        <button type="submit" class="btn btn-success an" id="luu">Lưu</button>
                                        <a href="benxe.do?method=delete&&mabenxe=${xe.mabenxe}" class="btn btn-danger" id="delete" onclick="return confirm('Bạn có muốn xóa không?')">Delete</a>
                                        
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
              
        $( "#dataTable tbody tr" ).on( "click","#update", function() {
            console.log("davao");
            $(this).closest("tr").find("#vBenxe").addClass("an"); 
            $(this).closest("tr").find("#uBenxe").removeClass("an");
            
            $(this).closest("tr").find("#luu").removeClass("an"); 
            $(this).closest("tr").find("#cancel").removeClass("an"); 
            $(this).closest("tr").find("#update").addClass("an"); 
            $(this).closest("tr").find("#delete").addClass("an"); 
        });
        
        $( "#dataTable tbody tr" ).on( "click","#cancel", function() {           
            $(this).closest("tr").find("#uBenxe").addClass("an"); 
            $(this).closest("tr").find("#vBenxe").removeClass("an");
                      
            $(this).closest("tr").find("#luu").addClass("an");            
            $(this).closest("tr").find("#update").removeClass("an");
            $(this).closest("tr").find("#cancel").addClass("an");
            $(this).closest("tr").find("#delete").removeClass("an");
        });
		
    });
        
</script>