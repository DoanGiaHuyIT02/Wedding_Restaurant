<%-- 
    Document   : nhanVien
    Created on : Jul 24, 2023, 9:19:43 PM
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/nhanVien" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý nhân viên</h1>
    <div>
        <a href="<c:url value="/themNhanVien"/>" class="btn btn-info">Thêm nhân viên</a>
    </div>
    <table class="table table-hover text-center">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên nhân viên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Ngày vào làm</th>
                <th>Địa chỉ</th>
                <th>Chức vụ</th>
                 <th>Chi nhánh</th>
                 <th>Tên đăng nhập</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${nhanVien}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.tenNhanVien}</td>
                    <td>${p.ngaySinh}</td>
                    <c:if test="${p.gioiTinh == 1}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${p.gioiTinh == 0}">
                        <td>Nữ</td>
                    </c:if>
                    <td>${p.soDienThoai}</td>
                    <td>${p.email}</td>
                    <td>${p.ngayVaoLam}</td>
                    <td>${p.diaChi}</td>
                    <td>${p.chucVu}</td>
                    <td>${p.chiNhanh}</td>
                    <td>${p.taiKhoan}</td>
                    <td>
                        <a href="#" class="btn btn-info mb-3">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
