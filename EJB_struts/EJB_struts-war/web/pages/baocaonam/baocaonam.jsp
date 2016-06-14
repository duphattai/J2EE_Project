<%-- 
    Document   : baocao
    Created on : Jun 14, 2016, 4:26:05 PM
    Author     : MinhNhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-------------------REPORT--------------------->
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
        $(function () {
            var a = $('#container').highcharts({
                title: {
                    text: 'Doanh Thu Hàng Tháng',
                    x: -20 //center
                },
                subtitle: {
                    text: 'Năm 2015',
                    x: -20
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                },
                yAxis: {
                    title: {
                        text: 'triệu USD'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: '$'
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: [{
                    name: 'Lợi nhuận',
                    data: [15, 20, 9.5, 24.5, 30, 21, 16, 26, 23, 24, 26, 28]
                }]
            });
        });
    </script>
