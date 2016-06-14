<%-- 
    Document   : baocao
    Created on : Jun 14, 2016, 4:26:05 PM
    Author     : MinhNhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> 
<!DOCTYPE html>

<script src="<c:url value="/resources/js/baocaonam.js"/>" ></script>

<html:form styleClass="form-horizontal" action="baocaonam" styleId="searchChuyenDi">
    <div class="form-group">	
        <label class="col-xs-1 control-label" style="padding-right: 0;">Doanh thu</label>
        <div class="col-xs-2">
            <select name="nam" class="form-control">
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
            </select>
        </div>        
        <div class="col-xs-2">
            <input type="button" class="btn btn-primary active" value="Xem" onclick="xemBaoCaoNam()"/>
        </div>	
    </div>
</html:form>
<!-------------------REPORT--------------------->
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
        function initChart(nam, data) {            
            for (i = 0; i < data.length; i++) { 
                data[i] = parseInt(data[i])*140000;
            }
            var a = $('#container').highcharts({
                title: {
                    text: 'Doanh Thu Hàng Tháng',
                    x: -20 //center
                },
                subtitle: {
                    text: "Năm " + nam,
                    x: -20
                },
                xAxis: {
                    categories: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6',
                        'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12']
                },
                yAxis: {
                    title: {
                        text: 'vnđ'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ' vnđ'
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: [{
                    name: 'Lợi nhuận',
                    data: data
                }]
            });
            $(".highcharts-subtitle").css("font-size","1.3em");
            $(".highcharts-subtitle").css("font-weight","bold");
        };
    </script>
