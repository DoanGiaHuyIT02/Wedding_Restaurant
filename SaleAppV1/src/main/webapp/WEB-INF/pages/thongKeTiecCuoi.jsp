<%-- 
    Document   : thongKeTiecCuoi
    Created on : Aug 25, 2023, 12:20:20 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/thongKeTiecCuoi" var="action" />
<h1>Thống kê mật độ tiệc cưới</h1>
<div>
    <div id="chartContainer" style="height: 300px; width: 100%;"></div>
</div>
<script>
    window.onload = function () {
        var dps = [[]];
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2", // "light1", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Thống kê mật độ sảnh"
            },
            data: [{
                    type: "pie",
                    showInLegend: "true",
                    legendText: "{x}",
                    yValueFormatString: "#,###\"%\"",
                    indexLabelFontSize: 16,
                    indexLabel: "{x} - {y}",
                    dataPoints: dps[0]
                }]
        });
    <c:forEach items="${thongKeTiecCuoi}" var="dataPoint">
        xValue2 = "${dataPoint.name}";
        yValue2  = parseInt(${dataPoint.data});
        dps[0].push({
            x: xValue2,
            y: yValue2
        });
    </c:forEach>
        console.log(dps[0]);
        chart.render();
        
    }
</script>