<%-- 
    Document   : chiNhanh
    Created on : Jul 23, 2023, 8:42:54 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/chiNhanh" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý chi nhánh</h1>
    <div>
        <a href="<c:url value="/themChiNhanh"/>" class="btn btn-info">Thêm chi nhánh</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên chi nhánh</th>
                <th>Địa chỉ</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${chiNhanh}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.tenChiNhanh}</td>
                    <td>${p.diaChi}</td>
                    <td>
                        <a href="<c:url value="/themChiNhanh/${p.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>