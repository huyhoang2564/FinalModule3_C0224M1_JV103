<%--
  Created by IntelliJ IDEA.
  User: levancuong
  Date: 23/8/24
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/phongtro?action=update" method="post" class="w-50 ms-5">
        <h2>Sửa thông tin người cho thuê phòng trọ</h2>
        <div class="form-floating mb-3">
            <input type="text" id="id" name="id" class="form-control" placeholder="Nhập Id" value="${phongtro.getId()}"
                   readonly>
            <label for="id">STT</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" id="name" name="name" class="form-control" placeholder="Nhập tên"
                   value="${phongtro.getName()}" required>
            <label for="name" class="form-label">Tên người thuê trọ</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Nhập số điện thoại "
                   value="${phongtro.getPhoneNumber()}" required>
            <label for="phoneNumber" class="form-label">Số điện thoại</label>
        </div>
        <div class="form-floating mb-3">
            <input type="date" id="startDate" name="startDate" class="form-control" placeholder="Nhập ngày bắt đầu cho thuê "
                   value="${phongtro.getStartDate()}" required>
            <label for="startDate" class="form-label">Ngày bắt đầu  thuê</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" id="description" name="description" class="form-control" placeholder="Mô tả"
                   value="${phongtro.getDescription()}" required>
            <label for="description" class="">Ghi chú</label>
        </div>
        <div class="mb-3">
            <label for="thanhtoan" class="form-label"> Hình thức thanh toán</label>
            <select name="thanhtoan" id="thanhtoan" >
                <c:forEach var="thanhtoan" items="${thanhToans}">
                    <option value="${thanhtoan.getId()}">${thanhtoan.getThanhtoan()}</option>
                </c:forEach>
            </select>
        </div>
        <button class="btn btn-success" type="submit">Cập nhật</button>
    </form>
</div>
<script>
    const form = document.querySelector("form");
    form.addEventListener("submit", e => {
        if (!form.checkValidity()) {
            e.preventDefault();
        }
        form.classList.add("was-validated")
    })
</script>
</body>
</html>
