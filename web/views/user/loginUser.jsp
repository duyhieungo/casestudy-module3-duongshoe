<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/05/2020
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng nhập</title>
    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/login.css">
</head>
<body>
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 login-section-wrapper">
                <div class="brand-wrapper">
                </div>
                <div class="login-wrapper my-auto">
                    <h1 class="login-title">Đăng nhập</h1>
                    <form method="post">
                        <div class="form-group">
                            <label for="username">Tên đăng nhập</label>
                            <input type="text" name="username" id="username" class="form-control">
                        </div>
                        <div class="form-group mb-4">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <input name="login" id="login" class="btn btn-block login-btn" type="submit" value="Đăng nhập">
                        <c:if test="${requestScope.error != null}">
                            <span class="font-weight-light">${requestScope.error}</span>
                        </c:if>
                    </form>
                    <a href="#!" class="forgot-password-link">Quên mật khẩu?</a>
                    <p class="login-wrapper-footer-text">Bạn chưa có tài khoản?</p>
                    <a href="/register_user" class="forgot-password-link">Đăng ký tài khoản</a>
                </div>
            </div>
            <div class="col-sm-6 px-0 d-none d-sm-block">
                <img src="/resources/assets/images/login.jpg" alt="login image" class="login-img">
            </div>
        </div>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
