<%@ page import="main.java.service.bill.BillServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.java.model.Bill" %>
<%@ page import="java.util.List" %><%--
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
<style>
    @keyframes random{
        0%   {color: red;}
        25%  {color: black;}
        50%  {color: orange;}
        100% {color: green;}
    }
</style>

</head>
<body>


<div class="container-scroller">
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="navbar-brand-wrapper d-flex align-items-center">
            <a class="navbar-brand brand-logo" href="/dashboard">
                <img src="${pageContext.request.contextPath}/resources/images/logo.svg" alt="logo" class="logo-dark"/>
            </a>
            <a class="navbar-brand brand-logo-mini" href="/dashboard"><img
                    src="${pageContext.request.contextPath}/resources/images/logo-mini.svg"
                    alt="logo"/></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center flex-grow-1">
            <h5 class="mb-0 font-weight-medium d-none d-lg-flex">Welcome Duong shoe's dashboard!</h5>
            <ul class="navbar-nav navbar-nav-right ml-auto">
                <li class="nav-item dropdown d-none d-xl-inline-flex user-dropdown">
                    <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown"
                       aria-expanded="false">
                        <img class="img-xs rounded-circle ml-2"
                             src="${pageContext.request.contextPath}/resources/images/faces/face8.jpg"
                             alt="Profile image">
                        <span class="font-weight-normal"> Admin </span></a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                        <div class="dropdown-header text-center">
                            <img class="img-md rounded-circle"
                                 src="${pageContext.request.contextPath}/resources/images/faces/face8.jpg"
                                 alt="Profile image">
                            <p class="mb-1 mt-3">Admin</p>
                            <p class="font-weight-light text-muted mb-0">admin@gmail.com</p>
                        </div>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-user text-primary"></i> My Profile
                            <span class="badge badge-pill badge-danger">1</span></a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-speech text-primary"></i>
                            Messages</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-energy text-primary"></i>
                            Activity</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-question text-primary"></i> FAQ</a>
                        <a href="/admin" class="dropdown-item"><i
                                class="dropdown-item-icon icon-power text-primary"></i>Sign Out</a>
                    </div>
                </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button"
                    data-toggle="offcanvas">
                <span class="icon-menu"></span>
            </button>
        </div>
    </nav>
    <div class="container-fluid page-body-wrapper">
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item nav-profile">
                    <a href="#" class="nav-link">
                        <div class="profile-image">
                            <img class="img-xs rounded-circle"
                                 src="${pageContext.request.contextPath}/resources/images/faces/face8.jpg"
                                 alt="profile image">
                            <div class="dot-indicator bg-success"></div>
                        </div>
                        <div class="text-wrapper">
                            <p class="profile-name">Allen Moreno</p>
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
                    <a class="nav-link" href="/dashboard">
                        <span class="menu-title">Dashboard</span>
                        <i class="icon-screen-desktop menu-icon"></i>
                    </a>
                </li>
                <li class="nav-item nav-category"><span class="nav-link">Cửa hàng</span></li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#product" aria-expanded="false"
                       aria-controls="product">
                        <span class="menu-title">Quản lý sản phẩm</span>
                        <i class="icon-basket-loaded menu-icon"></i>
                    </a>
                    <div class="collapse" id="product">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"><a class="nav-link" href="/admin?action=view_product">Xem sản phẩm</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/admin?action=create_product">Thêm sản
                                phẩm</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#brand" aria-expanded="false"
                       aria-controls="brand">
                        <span class="menu-title">Quản lý Nhà cung cấp</span>
                        <i class="icon-grid menu-icon"></i>
                    </a>

                    <div class="collapse" id="brand">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"><a class="nav-link" href="/admin?action=view_catalog">Xem danh mục</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/admin?action=create_catalog">Thêm danh
                                mục</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#bill" aria-expanded="false"
                       aria-controls="bill">
                        <span class="menu-title">Quản lý hóa đơn</span>
                        <i class="icon-note menu-icon"></i>
                    </a>
                    <div class="collapse" id="bill">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"><a class="nav-link" href="/bills">Xem hóa đơn</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#user" aria-expanded="false"
                       aria-controls="user">
                        <span class="menu-title">Quản lý người dùng</span>
                        <i class="icon-user menu-icon"></i>
                    </a>
                    <div class="collapse" id="user">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"><a class="nav-link" href="/user?action=view_user">Xem người dùng</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/user?action=create_user">Thêm người dùng</a>
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
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div style="text-align: center" class="card-body">
                                <h4 class="card-title" style="color: black;animation:random 5s infinite;">Danh sách hóa đơn</h4>
                                </p>
                                <table class="table">

                                    <thead>
                                    <caption><h2>Danh sách hóa đơn</h2></caption>
                                    <tr>
                                        <th>MSKH</th>
                                        <th>Thông tin hóa đơn</th>
                                        <th>Số tiền thanh toán</th>
                                        <th>Ngày thanh toán</th>
                                        <th>Status</th>
                                        <th style="text-align: center">Công cụ</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="bill" items="${listBill}">
                                        <tr>
                                            <td><c:out
                                                    value="${bill.user_id}"/></td>
                                            <td><c:out
                                                    value="${bill.message}"/></td>
                                            <td><c:out
                                                    value="${bill.payment}"/></td>
                                            <td><c:out
                                                    value="${bill.date_of_payment}"/></td>
                                            <td><c:choose>
                                                <c:when test="${bill.status == 1}">
                                                    <label class="badge badge-success">
                                                        Đã xác nhận</label>
                                                </c:when>
                                                <c:when test="${bill.status == 0}">
                                                    <label class="badge badge-warning">
                                                        Đang chờ</label>
                                                </c:when>
                                                <c:when test="${bill.status == -1}">
                                                    <label class="badge badge-info">Từ chối</label>
                                                </c:when>
                                            </c:choose>
                                            </td>
                                            <td style="word-wrap: break-word;alignment: center">
                                                <button class="btn-success"
                                                        onclick="window.location.href = '/bills?action=confirm&id=${bill.id}';">
                                                    <a class="icon-like">Xác nhận</a>
                                                </button>
                                                <button class="btn-warning"
                                                        onclick="window.location.href = '/bills?action=pending&id=${bill.id}';">
                                                    <a class="icon-bubble" style="color: black">Chờ </a>
                                                </button>
                                                <button class="btn-info"
                                                        onclick="window.location.href = '/bills?action=deny&id=${bill.id}';">
                                                    <a class="icon-dislike">Từ chối</a>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <div class="d-flex mt-4 flex-wrap">
                                        <nav class="ml-auto">
                                            <tr>
                                                <td><p class="text-muted">Hiển thị ${currentPage} trong số ${noOfPages}
                                                    trang</p>
                                                </td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>
                                                    <ul class="pagination separated pagination-info">
                                                        <c:if test="${currentPage !=1}">
                                                            <li class="page-item" style="display: inline">

                                                                <a href="bills?page=${currentPage -1}"
                                                                   class="page-link">
                                                                    <i class="icon-arrow-left"></i>
                                                                </a>

                                                            </li>
                                                        </c:if>
                                                        <c:forEach begin="1" end="${noOfPages}" var="i">
                                                            <li class="page-item" style="display: inline">
                                                                <c:choose>
                                                                    <c:when test="${currentPage eq i}">
                                                                        <a class="page-link">${i}
                                                                        </a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a href="bills?page=${i}" class="page-link">${i}
                                                                        </a>
                                                                    </c:otherwise>
                                                                </c:choose>

                                                            </li>
                                                        </c:forEach>
                                                        <c:if test="${currentPage} <= ${noOfpages}">
                                                            <li class="page-item" style="display: inline">
                                                                <a href="bills?page=${currentPage +1}"
                                                                   class="page-link">
                                                                    <i class="icon-arrow-right"></i>
                                                                </a>
                                                            </li>
                                                        </c:if>
                                                    </ul>
                                                </td>
                                            </tr>
                                        </nav>
                                    </div>
                                    </tbody>
                                </table>
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
