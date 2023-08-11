<%-- 
    Document   : dichVu
    Created on : Jul 23, 2023, 8:43:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/dichVu" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý dich vụ</h1>
    <div>
        <a href="<c:url value="/themDichVu"/>" class="btn btn-info">Thêm dịch vụ</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Loại dịch vụ</th>
                <th>Giá dịch vụ</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dichVu}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.loaiDichVu}</td>
                    <td>${p.giaDichVu}</td>
                    <td>
                        <a href="#" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>