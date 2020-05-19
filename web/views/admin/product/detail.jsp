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
        <div class="navbar-brand-wrapper d-flex align-items-center">
            <a class="navbar-brand brand-logo" href="../../index.html">
                <img src="${pageContext.request.contextPath}/resources/images/logo.svg" alt="logo" class="logo-dark"/>
            </a>
            <a class="navbar-brand brand-logo-mini" href="../../index.html"><img
                    src="${pageContext.request.contextPath}/resources/images/logo-mini.svg"
                    alt="logo"/></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center flex-grow-1">
            <h5 class="mb-0 font-weight-medium d-none d-lg-flex">Welcome stallar dashboard!</h5>
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
                                                    href="${pageContext.request.contextPath}/product?action=">Xem sản
                                phẩm</a>
                            </li>
                            <li class="nav-item"><a class="nav-link"
                                                    href="${pageContext.request.contextPath}/product?action=add">Thêm
                                sản
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
                            <li class="nav-item"><a class="nav-link" href="dashboard?action=view_user">Xem nhà cung
                                cấp</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="dashboard?action=create_user">Thêm nhà cung
                                cấp</a></li>
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
                <div class="page-header">
                    <h3 class="page-title">Bảng sản phẩm</h3>
                </div>
                <div class="row">
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Lịch sử nhập hàng</h4>
                                <p class="card-description"> Ngày cập nhật <code>.table-bordered</code>
                                </p>
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th> #</th>
                                        <th> Ngày nhập</th>
                                        <th> Số lượng</th>
                                        <th> Đơn giá</th>
                                        <th> Thành tiền</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td> 1</td>
                                        <td> Herman Beck</td>
                                        <td> Herman Beck</td>
                                        <td> $ 77.99</td>
                                        <td> May 15, 2015</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Bordered table</h4>
                                <p class="card-description"> Add class <code>.table-bordered</code>
                                </p>
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th> #</th>
                                        <th> First name</th>
                                        <th> Progress</th>
                                        <th> Amount</th>
                                        <th> Deadline</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td> 1</td>
                                        <td> Herman Beck</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-success" role="progressbar"
                                                     style="width: 25%" aria-valuenow="25" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $ 77.99</td>
                                        <td> May 15, 2015</td>
                                    </tr>
                                    <tr>
                                        <td> 2</td>
                                        <td> Messsy Adam</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-danger" role="progressbar"
                                                     style="width: 75%" aria-valuenow="75" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $245.30</td>
                                        <td> July 1, 2015</td>
                                    </tr>
                                    <tr>
                                        <td> 3</td>
                                        <td> John Richards</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-warning" role="progressbar"
                                                     style="width: 90%" aria-valuenow="90" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $138.00</td>
                                        <td> Apr 12, 2015</td>
                                    </tr>
                                    <tr>
                                        <td> 4</td>
                                        <td> Peter Meggik</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-primary" role="progressbar"
                                                     style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $ 77.99</td>
                                        <td> May 15, 2015</td>
                                    </tr>
                                    <tr>
                                        <td> 5</td>
                                        <td> Edward</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-danger" role="progressbar"
                                                     style="width: 35%" aria-valuenow="35" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $ 160.25</td>
                                        <td> May 03, 2015</td>
                                    </tr>
                                    <tr>
                                        <td> 6</td>
                                        <td> John Doe</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-info" role="progressbar" style="width: 65%"
                                                     aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $ 123.21</td>
                                        <td> April 05, 2015</td>
                                    </tr>
                                    <tr>
                                        <td> 7</td>
                                        <td> Henry Tom</td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-warning" role="progressbar"
                                                     style="width: 20%" aria-valuenow="20" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td> $ 150.00</td>
                                        <td> June 16, 2015</td>
                                    </tr>
                                    </tbody>
                                </table>
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
<!-- endinject -->
<!-- Custom js for this page -->
<!-- End custom js for this page -->
</body>
</html>
