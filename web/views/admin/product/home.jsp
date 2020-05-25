<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 5/17/2020
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Trang chủ Sản phẩm</title>
    <!-- plugins:css -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"><!-- End layout styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.png"/>
</head>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="navbar-menu-wrapper d-flex align-items-center flex-grow-1">
            <h5 class="mb-0 font-weight-medium d-none d-lg-flex">Welcome Duong's Shoe dashboard!</h5>
            <ul class="navbar-nav navbar-nav-right ml-auto">
                <form class="search-form d-none d-md-block" action="#">
                    <i class="icon-magnifier"></i>
                    <input type="search" class="form-control" placeholder="Search Here" title="Search here">
                </form>
                <li class="nav-item dropdown d-none d-xl-inline-flex user-dropdown">
                    <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown"
                       aria-expanded="false">
                        <img class="img-xs rounded-circle ml-2"
                             src="${pageContext.request.contextPath}/resources/images/faces/face8.jpg"
                             alt="Profile image">
                        <span class="font-weight-normal"> Henry Klein </span></a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                        <div class="dropdown-header text-center">
                            <img class="img-md rounded-circle"
                                 src="${pageContext.request.contextPath}/resources/images/faces/face8.jpg"
                                 alt="Profile image">
                            <p class="mb-1 mt-3">Allen Moreno</p>
                            <p class="font-weight-light text-muted mb-0">allenmoreno@gmail.com</p>
                        </div>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-user text-primary"></i> My Profile
                            <span class="badge badge-pill badge-danger">1</span></a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-speech text-primary"></i>
                            Messages</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-energy text-primary"></i>
                            Activity</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-question text-primary"></i> FAQ</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-power text-primary"></i>Sign Out</a>
                    </div>
                </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button"
                    data-toggle="offcanvas">
                <span class="icon-menu"></span>
            </button>
        </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_sidebar.html -->
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
                    <a class="nav-link" href="index.html">
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
                            <li class="nav-item"><a class="nav-link"
                                                    href="${pageContext.request.contextPath}/product?">Danh sách
                                sản
                                phẩm</a>
                            </li>
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
                            <li class="nav-item"><a class="nav-link" href="dashboard?action=view_user">Xem hóa đơn</a>
                            </li>
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
                            <li class="nav-item"><a class="nav-link" href="/dashboard?action=view_user">Xem người
                                dùng</a></li>
                            <li class="nav-item"><a class="nav-link" href="/dashboard?action=create_user">Thêm người
                                dùng</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <%--                <div class="page-header" style="margin-bottom: 5px">--%>
                <%--                    <h4 class="page-title" style="float: left">Chi nhánh Hà Nội</h4>--%>
                <%--                </div>--%>
                <c:if test="${status == 1}">
                    <label class="badge badge-warning" style="font-size: 13px; margin-bottom: 18px; margin-top: 8px ">
                        Xoá thành công
                    </label>
                </c:if>
                <a href="${pageContext.request.contextPath}/product?action=create"
                   class="nav-link" style="float: right; margin-bottom: 10px"><i class="icon-plus"></i> Thêm mới</a>
                <div class="row" style="clear: both">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <p class="card-title" style="margin-bottom: 20px">Các sản phẩm hiện có</p>
                                <table class="table table-hover">
                                    <thead>
                                    <tr style="text-align: center">
                                        <th style="font-weight: bold">STT</th>
                                        <th style="font-weight: bold">Sản phẩm</th>
                                        <th style="font-weight: bold">Hãng</th>
                                        <th style="font-weight: bold">Size</th>
                                        <th style="font-weight: bold">Tình trạng</th>
                                        <th colspan="2" style="font-weight: bold">Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${products}" var="product" varStatus="count">
                                        <tr style="text-align: center">
                                            <td>${pageIndex[count.index]}</td>
                                            <td style="text-align: left">
                                                <a href="${pageContext.request.contextPath}/product?action=detail&type=product&id=${product.getDetailID()}"
                                                   class="nav-link">${product.getProductName()}</a>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/product?action=detail&type=catalog&id=${product.getDetailID()}"
                                                   class="nav-link">${product.getCatalogName()}</a>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/product?action=detail&type=size&id=${product.getDetailID()}"
                                                   class="nav-link">${product.getSize()}</a>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${product.getStatus() == 1}">
                                                        <a href="${pageContext.request.contextPath}/catalog?action=detail&id=${product.getDetailID()}"
                                                           class="nav-link"
                                                           id="status-${product.getDetailID()}"><label
                                                                class="badge badge-success" style="cursor: pointer">
                                                            Đang kinh doanh</label></a>
                                                    </c:when>
                                                    <c:when test="${product.getStatus() == 0}">
                                                        <a href="${pageContext.request.contextPath}/catalog?action=detail&id=${product.getDetailID()}"
                                                           class="nav-link"
                                                           id="status-${product.getDetailID()}"><label
                                                                class="badge badge-danger" style="cursor: pointer">
                                                            Ngừng kinh doanh</label></a>
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td style="width: 10px">
                                                <a href="${pageContext.request.contextPath}/product?action=update&id=${product.getDetailID()}"
                                                   class="nav-link"><i class="icon-pencil"></i></a>
                                            </td>
                                            <td style="width: 10px">
                                                <a class="nav-link" href="#" onclick=confirmDelete()><i
                                                        class="icon-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="d-flex mt-4 flex-wrap">
                                    <p class="text-muted">Hiển thị ${current} trong số ${pages} trang</p>
                                    <nav class="ml-auto">
                                        <ul class="pagination separated pagination-info">
                                            <li class="page-item"><a
                                                    href="${pageContext.request.contextPath}/product?button=previous"
                                                    class="page-link"><i
                                                    class="icon-arrow-left"></i></a></li>
                                            <c:forEach begin="1" end="${pages}" var="page">
                                                <li class="page-item
                                                        <c:if test="${current == page}">
                                                             active
                                                        </c:if>"><a
                                                        href="${pageContext.request.contextPath}/product?button=page&page=${page}"
                                                        class="page-link">${page}</a></li>
                                            </c:forEach>
                                            <li class="page-item"><a
                                                    href="${pageContext.request.contextPath}/product?button=next"
                                                    class="page-link"><i
                                                    class="icon-arrow-right"></i></a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <footer class="footer">
                <div class="d-sm-flex justify-content-center justify-content-sm-between">
                    <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2017 <a
                            href="https://www.bootstrapdash.com/" target="_blank">Bootstrap Dash</a>. All rights reserved.</span>
                    <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i
                            class="icon-heart text-danger"></i></span>
                </div>
            </footer>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="${pageContext.request.contextPath}/resources/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/resources/js/off-canvas.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/misc.js"></script>
<script>
    function confirmDelete() {
        if (confirm("Bạn có chắc chắn muốn xoá ?")) {
            document.location.href = '${pageContext.request.contextPath}/product?action=delete&id=${product.getDetailID()}&confirm=ok'
        }
    }
</script>
<!-- endinject -->
<!-- Custom js for this page -->
<!-- End custom js for this page -->
</body>
</html>
