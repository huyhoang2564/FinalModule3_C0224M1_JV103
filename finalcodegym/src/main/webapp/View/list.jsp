<%--
  Created by IntelliJ IDEA.
  User: levancuong
  Date: 23/8/24
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
            integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<html>
<head>
    <title>List Cho Thuê Phòng Trọ</title>
</head>
<body>
<div class="container">

    <h1>Danh mục cho thuê phòng trọ</h1>
    <c:if test="${param.mess=='OK'}">
        <h2>Thành công !</h2>
    </c:if>
    <c:if test="${param.mess=='NOK'}">
        <h2>Thất bại !</h2>
    </c:if>
    <a href="/phongtro?action=add" class="btn btn-primary mb-3">Thêm mới</a>

    <form action="/phongtro?action=search" method="post">
        <div class="input-group">
            <span class="input-group-text mb-3">Tên người thuê trọ</span>
            <input type="text" class="form-control mb-3 " id="search" name="searchName" placeholder="Tìm tên người thuê trọ">
        </div>
        <div class="mb-3">
            <label for="thanhtoan" class="form-label">Chọn hình thức thanh toán</label>
            <select name="searchThanhToan" id="thanhtoan" value="">
                <c:forEach var="thanhtoan" items="${thanhToans}">
                    <option value="${thanhtoan.getId()}">${thanhtoan.getThanhtoan()}</option>
                </c:forEach>
                -- Chọn hinình thức thanh toán --
            </select>
        </div>
        <button type="submit" class="btn btn-primary ">Tìm kiếm</button>
    </form>

    <table class="table ">
        <tr>
            <th>STT</th>
            <th>Tên người thuê trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Ghi chú</th>
            <th>Hình thức thanh toán</th>
            <th>Sửa</th>
            <th>Xóa</th>
        </tr>

        <c:forEach var="phongtro" items="${phongTros}" varStatus="status">
            <tr>
                    <%--                public int getId() {--%>
                    <%--                return id;--%>
                    <%--                }--%>

                    <%--                public void setId(int id) {--%>
                    <%--                this.id = id;--%>
                    <%--                }--%>

                    <%--                public String getName() {--%>
                    <%--                return name;--%>
                    <%--                }--%>

                    <%--                public void setName(String name) {--%>
                    <%--                this.name = name;--%>
                    <%--                }--%>

                    <%--                public String getPhoneNumber() {--%>
                    <%--                return phoneNumber;--%>
                    <%--                }--%>

                    <%--                public void setPhoneNumber(String phoneNumber) {--%>
                    <%--                this.phoneNumber = phoneNumber;--%>
                    <%--                }--%>

                    <%--                public String getStartDate() {--%>
                    <%--                return startDate;--%>
                    <%--                }--%>

                    <%--                public void setStartDate(String startDate) {--%>
                    <%--                this.startDate = startDate;--%>
                    <%--                }--%>

                    <%--                public int getThanhtoan() {--%>
                    <%--                return thanhtoan;--%>
                    <%--                }--%>

                    <%--                public void setThanhtoan(int thanhtoan) {--%>
                    <%--                this.thanhtoan = thanhtoan;--%>
                    <%--                }--%>

                    <%--                public String getDescription() {--%>
                    <%--                return description;--%>
                    <%--                }--%>

                    <%--                public void setDescription(String description) {--%>
                    <%--                this.description = description;--%>
                    <%--                }--%>
                <td>${status.count}</td>
                <td>${phongtro.getName()}</td>
                <td>${phongtro.getPhoneNumber()}</td>
                <td>${phongtro.getStartDate()}</td>
                <td>${phongtro.getDescription()}</td>
                <td>${phongtro.getPaymentType() }</td>
                <td>
                    <form action="/phongtro?action=edit" method="get">
                        <button name="action" value="edit" class="btn btn-warning btn-sm">Sửa</button>
                        <input type="hidden" name="editId" value="${phongtro.getId()}">
                    </form>
                </td>

                <td>
                    <button onclick="deleteInfo('${phongtro.id}','${phongtro.name}')" type="button"
                            class="btn btn-danger btn-sm"
                            data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                        Xóa
                    </button>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/phongtro?action=delete" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Xác nhận xóa người cho thuê phòng trọ</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xóa người cho thue phòng trọ <span id="delete-name"></span> có Id là <span id="delete-id"></span> ?
                </div>
                <input type="hidden" id="hidden-input-id" name="deleteId">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Đồng ý</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function deleteInfo(id, name) {
        document.getElementById("delete-id").innerHTML = id;
        document.getElementById("hidden-input-id").value = id;
        document.getElementById("delete-name").innerHTML = name;
    }
</script>
</body>
</html>