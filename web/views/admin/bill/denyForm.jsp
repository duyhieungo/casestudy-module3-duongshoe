<%--
  Created by IntelliJ IDEA.
  User: thuan
  Date: 5/20/20
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin</title>
    <link rel="stylesheet" href="resources/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="resources/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="resources/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="resources/vendors/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="resources/vendors/chartist/chartist.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="shortcut icon" href="resources/images/favicon.png"/>
</head>
<body>

<div class="container-scroller">
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="navbar-brand-wrapper d-flex align-items-center">
            <a class="navbar-brand brand-logo" href="/views/admin/bill/list.jsp">
                <img src="images/logo.svg" alt="logo" class="logo-dark"/>
            </a>
            <a class="navbar-brand brand-logo-mini" href="/views/admin/bill/list.jsp"><img src="images/logo-mini.svg"
                                                                                           alt="logo"/></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center flex-grow-1">
            <h5 class="mb-0 font-weight-medium d-none d-lg-flex">Welcome dashboard!</h5>
        </div>
    </nav>

    <div class="container-fluid page-body-wrapper">

        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item nav-profile">
                    <a href="#" class="nav-link">
                        <div class="profile-image">
                            <img class="img-xs rounded-circle" src="images/faces/face8.jpg" alt="profile image">
                            <div class="dot-indicator bg-success"></div>
                        </div>
                        <div class="text-wrapper">
                            <p class="profile-name">Admin</p>
                            <p class="designation">Administrator</p>
                        </div>
                        <div class="icon-container">
                            <i class="icon-bubbles"></i>
                            <div class="dot-indicator bg-danger"></div>
                        </div>
                    </a>
                </li>
                <li class="nav-item nav-category">
                    <span class="nav-link">Dashboard</span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bills?action=list">
                        <span class="menu-title">Dashboard</span>
                        <i class="icon-screen-desktop menu-icon"></i>
                    </a>
                </li>
                <li class="nav-item nav-category"><span class="nav-link">UI Elements</span></li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false"
                       aria-controls="ui-basic">
                        <span class="menu-title">Danh mục hóa đơn</span>
                        <i class="icon-layers menu-icon"></i>
                    </a>
                    <div class="collapse" id="ui-basic">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"><a class="nav-link" href="/bills?action=list">List Bill</a></li>
                            <%--                            <li class="nav-item"><a class="nav-link" href="/bills?action=create">Create Bill</a>--%>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>


        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> DuongShoe</h3>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Thông tin chi tiết hóa đơn</h4>
                                <p class="card-description"> Thông tin chi tiết hóa đơn</p>
                                <form class="forms-sample" method="post">
                                    <table border="1" cellpadding="5">
                                            <h2>
                                               Xác nhận từ chối hóa đơn
                                            </h2>
                                        <c:if test="${bill != null}">
                                            <input type="hidden" name="id" value="<c:out value='${bill.id}' />"/>
                                        </c:if>
                                        <tr>
                                            <th>Mã số khách hàng:</th>
                                            <td size="45" >
                                                <c:out value="${bill.user_id}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Giá đơn hàng:</th>
                                            <td size="45" >
                                                <c:out value="${bill.amount}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Thông tin:</th>
                                            <td size="45" >
                                                <c:out value="${bill.message}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Chiết khấu:</th>
                                            <td size="45" >
                                                <c:out value="${bill.discount}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Phí vận chuyển:</th>
                                            <td size="45" >
                                                <c:out value="${bill.shipping_fee}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Số thanh toán:</th>
                                            <td size="45" >
                                                <c:out value="${bill.payment}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Ngày thanh toán</th>
                                            <td size="45" >
                                                <c:out value="${bill.date_of_payment}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Ngày tạo hóa đơn:</th>
                                            <td size="45" >
                                                <c:out value="${bill.create_date}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Ngày cập nhật hóa đơn</th>
                                            <td size="45">
                                                <c:out value="${bill.update_date}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <input type="submit" value="Lưu"/>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="resources/vendors/js/vendor.bundle.base.js"></script>
<script src="resources/vendors/chart.js/Chart.min.js"></script>
<script src="resources/vendors/moment/moment.min.js"></script>
<script src="resources/vendors/daterangepicker/daterangepicker.js"></script>
<script src="resources/vendors/chartist/chartist.min.js"></script>
<script src="resources/js/off-canvas.js"></script>
<script src="resources/js/misc.js"></script>
<script src="resources/js/dashboard.js"></script>
</body>
</html>
