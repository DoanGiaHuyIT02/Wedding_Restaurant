<%-- 
    Document   : thongTinSanh
    Created on : Jul 28, 2023, 8:32:32 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/thongTinSanh" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý sảnh</h1>\
     <div>
         <a href="<c:url value="/themSanh"/>" class="btn btn-info">Thêm sảnh</a>
    </div>
    <table class="table table-hover text-center">
        <thead>
            <tr>
                <th>Id</th>
                <th>Loại sảnh</th>
                <th>Tên sảnh</th>
                <th>Số lượng bàn</th>
                <th>Đơn giá</th>
                <th>Loại tiệc</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${thongTinSanh}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.loaiSanh}</td>
                    <td>${s.tenSanh}</td>
                    <td>${s.soLuongBan}</td>
                    <td>${s.donGiaToiThieu} VNĐ</td>
                    <td>${s.loaiTiecId.tenLoaiTiec}</td>
                    <td>
                        <a href="<c:url value="/themSanh/${s.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>