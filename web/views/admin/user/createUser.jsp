<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/05/2020
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Stellar Admin</title>
    <link rel="stylesheet" href="resources/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="resources/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="resources/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="resources/vendors/select2/select2.min.css">
    <link rel="stylesheet" href="resources/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="shortcut icon" href="resources/images/favicon.png"/>
</head>
<body>
<div class="container-scroller">
    <%--header--%>
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
                <form class="search-form d-none d-md-block" action="#">
                    <i class="icon-magnifier"></i><input type="search" class="form-control" placeholder="Tìm kiếm" title="Search here">
                </form>
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
                        <a href="/admin" class="dropdown-item"><i class="dropdown-item-icon icon-power text-primary"></i>Sign Out</a>
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
        <%--left menu--%>
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
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=view_product">Xem sản phẩm</a></li>
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=create_product">Thêm sản phẩm</a></li>
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
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=view_catalog">Xem danh mục</a></li>
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=create_catalog">Thêm danh mục</a></li>
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
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=view_bill">Xem hóa đơn</a></li>
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
                            <li class="nav-item"> <a class="nav-link" href="/user?action=view_user">Xem người dùng</a></li>
                            <li class="nav-item"> <a class="nav-link" href="/user?action=create_user">Thêm người dùng</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Thêm người dùng </h3>
                </div>
                <div class="row">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <form method="post" class="form-sample" name="userForm" onsubmit="return validate();">
                                    <p class="card-description"> Thông tin cá nhân </p>
                                    <div class="row">
                                        <%--first name--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Tên</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="firstName" class="form-control"/>
                                                    <div id="firstNameError"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--last name--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Họ và tên đệm</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="lastName" class="form-control"/>
                                                    <div id="lastNameError"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <%--gender--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Giới tính</label>
                                                <div class="col-sm-9">
                                                    <select class="form-control" name="gender">
                                                        <option name="male" value="1">Nam</option>
                                                        <option name="female" value="0">Nữ</option>
                                                    </select>
                                                    <div id="genderError"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--date of birth--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Ngày sinh</label>
                                                <div class="col-sm-9">
                                                    <input type="date" name="dateOfBirth" class="form-control"/>
                                                    <div id="dateOfBirthError"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <%--phone number--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Số điện thoại</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="phoneNumber" class="form-control"/>
                                                    <div id="phoneNumberError"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--email--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Email</label>
                                                <div class="col-sm-9">
                                                    <input type="email" name="email" class="form-control"/>
                                                    <div id="emailError"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <%--username--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Tên đăng nhập</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="username" class="form-control"/>
                                                    <div id="usernameError"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--password--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Mật khẩu</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="password" class="form-control"/>
                                                    <div id="passwordError"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <%--role--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Loại tài khoản</label>
                                                <div class="col-sm-9">
                                                    <select class="form-control" name="role">
                                                        <option name="user" value="1">Người dùng</option>
                                                        <option name="vipUser" value="3">Người dùng VIP 1</option>
                                                        <option name="admin" value="2">Admin</option>
                                                    </select>
                                                    <div id="roleError"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--status--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Trạng thái</label>
                                                <div class="col-sm-9">
                                                    <select class="form-control" name="status">
                                                        <option name="admin" value="1">Đang hoạt động</option>
                                                        <option name="user" value="0">Bị khóa</option>
                                                    </select>
                                                    <div id="statusError"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <p class="card-description"> Địa chỉ </p>
                                    <div class="row">
                                        <%--address--%>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Địa chỉ</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="address" class="form-control"/>
                                                    <div id="addressError"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <%--button--%>
                                        <button type="submit" class="btn btn-primary mr-2">Lưu</button>
                                        <button type="reset" class="btn btn-light">Xóa</button>
                                    </div>
                                    <%--message--%>
                                    <div class="row" style="margin-top: 20px">
                                        <p>
                                            <c:if test='${message != null}'>
                                                <span style="font-size: 20px" class="badge badge-success">${message}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="d-sm-flex justify-content-center justify-content-sm-between">
                    <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2017 <a
                            href="https://www.bootstrapdash.com/" target="_blank">Bootstrap Dash</a>. All rights reserved.</span>
                        <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i
                                class="icon-heart text-danger"></i></span>
                    </div>
                </footer>
            </div>
        </div>
    </div>
    <script src="resources/vendors/js/vendor.bundle.base.js"></script>
    <script src="resources/vendors/select2/select2.min.js"></script>
    <script src="resources/vendors/typeahead.js/typeahead.bundle.min.js"></script>
    <script src="resources/js/off-canvas.js"></script>
    <script src="resources/js/misc.js"></script>
    <script src="resources/js/typeahead.js"></script>
    <script src="resources/js/select2.js"></script>
    <script src="resources/js/validateUser.js"></script>
</body>
</html>