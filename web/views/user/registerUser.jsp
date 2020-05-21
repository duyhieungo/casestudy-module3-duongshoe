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
    <!-- Required meta tags-->
<%--    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">--%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Title Page-->
    <title>Duong shoe</title>

<%--    <!-- Icons font CSS-->
    <link href="resources/templateRegisterForm/vendor/mdi-font/css/material-design-iconic-font.min.css"
          rel="stylesheet">
    <link href="resources/templateRegisterForm/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/login.css">--%>

    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/login.css">

    <%--<!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="resources/templateRegisterForm/vendor/select2/select2.min.css" rel="stylesheet">
    <link href="resources/templateRegisterForm/vendor/datepicker/daterangepicker.css" rel="stylesheet">

    <!-- Main CSS-->
    <link href="resources/templateRegisterForm/css/main.css" rel="stylesheet">--%>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 login-section-wrapper">
            <div class="brand-wrapper">
                <%--<img src="/resources/assets/images/logo.svg" alt="logo" class="logo">--%>
            </div>
            <div class="login-wrapper my-auto">
                <h1 class="login-title">Đăng ký tài khoản</h1>
                <form method="post">
                    <div class="form-group">
                        <input type="text" name="firstName" class="form-control" placeholder="Tên">
                    </div>
                    <div class="form-group mb-4">
                        <input type="text" name="lastName"  class="form-control" placeholder="Họ và tên">
                    </div>
                    <div class="form-group">
                        <select name="gender" class="form-control">
                            <option disabled="disabled" selected="selected">Giới tính</option>
                            <option value="1">Nam</option>
                            <option value="0">Nữ</option>
                        </select>
                    </div>
                    <div class="form-group mb-4">
                        <input type="date" class="form-control"  placeholder="Ngày sinh" name="dateOfBirth">
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Số điện thoại" name="phoneNumber" class="form-control">
                    </div>
                    <div class="form-group mb-4">
                        <input type="text" placeholder="Email" name="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Tên đăng nhập" name="username" class="form-control">
                    </div>
                    <div class="form-group mb-4">
                        <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Nhập lại mật khẩu" name="repassword" class="form-control">
                    </div>
                    <div class="form-group mb-4">
                        <input type="text" placeholder="Địa chỉ" name="address" class="form-control">
                    </div>
                    <input name="register" class="btn btn-block login-btn" type="submit" value="Đăng ký">
                </form>
                <c:if test='${message != null}'>
                    <span style="font-size: 20px; color: black">${message}</span>
                </c:if>
            </div>
        </div>
        <div class="col-sm-6 px-0 d-none d-sm-block">
            <img src="/resources/assets/images/login.jpg" alt="login image" class="login-img">
        </div>
    </div>
</div>
<%--<div class="page-wrapper p-t-180 p-b-100 font-poppins">
    <div class="wrapper wrapper--w780">
        <div class="card card-3">
            &lt;%&ndash;<div class="card-heading"></div>&ndash;%&gt;
            <div class="card-body">
                <h2 class="title">Đăng ký tài khoản</h2>
                <form method="post">
                    <div class="input-group">
                        <input class="input--style-3" type="text" placeholder="Tên" name="firstName">
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="text" placeholder="Họ và tên" name="lastName">
                    </div>
                    <div class="input-group">
                        <div class="rs-select2 js-select-simple select--no-search">
                            <select name="gender">
                                <option disabled="disabled" selected="selected">Giới tính</option>
                                <option value="1">Nam</option>
                                <option value="0">Nữ</option>
                            </select>
                            <div class="select-dropdown"></div>
                        </div>
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="date" placeholder="Ngày sinh" name="dateOfBirth">
                        &lt;%&ndash;<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>&ndash;%&gt;
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="text" placeholder="Số điện thoại" name="phoneNumber">
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="text" placeholder="Email" name="email">
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="text" placeholder="Tên đăng nhập" name="username">
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="password" placeholder="Mật khẩu" name="password">
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="password" placeholder="Nhập lại mật khẩu" name="repassword">
                    </div>
                    <div class="input-group">
                        <input class="input--style-3" type="text" placeholder="Địa chỉ" name="address">
                    </div>
                    <div class="p-t-10">
                        <button class="btn btn--pill btn--yellow" type="submit">Đăng ký</button>
                    </div>
                </form>
                <div class="row" style="margin-top: 20px">
                    <p>
                        <c:if test='${message != null}'>
                            <span style="font-size: 20px; color: whitesmoke">${message}</span>
                        </c:if>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>--%>
</body>

<%--<!-- Jquery JS-->
<script src="resources/templateRegisterForm/vendor/jquery/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="resources/templateRegisterForm/vendor/select2/select2.min.js"></script>
<script src="resources/templateRegisterForm/vendor/datepicker/moment.min.js"></script>
<script src="resources/templateRegisterForm/vendor/datepicker/daterangepicker.js"></script>--%>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<%--<!-- Main JS-->
<script src="resources/templateRegisterForm/js/global.js"></script>

<script src="resources/js/validateUser.js"></script>--%>
</html>