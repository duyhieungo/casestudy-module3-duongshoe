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
                    <a class="nav-link" href="/bills">
                        <span class="menu-title">Dashboard</span>
                        <i class="icon-screen-desktop menu-icon"></i>
                    </a>
                </li>
                <li class="nav-item nav-category"><span class="nav-link">UI Elements</span></li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false"
                       aria-controls="ui-basic">
                        <span class="menu-title">Bill Menu</span>
                        <i class="icon-layers menu-icon"></i>
                    </a>
                    <div class="collapse" id="ui-basic">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"><a class="nav-link" href="/bills">List Bill</a></li>
                            <li class="nav-item"><a class="nav-link" href="/bills?action=create">Create Bill</a>
                            </li>
                        </ul>
                    </div>
                </li>
                </li>
            </ul>
        </nav>


        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Bill Create</h3>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Create Bill</h4>
                                <p class="card-description"> Create Bill Basic </p>
                                <form class="forms-sample" method="post">
                                    <table border="1" cellpadding="5">
                                    <caption>
                                        <h2>Add New Bill</h2>
                                    </caption>
                                        <tr>
                                            <th>User_id</th>
                                            <td>
                                                <input type="text" name="user_id" id="user_id" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Amount</th>
                                            <td>
                                                <input type="text" name="amount" id="amount" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Message:</th>
                                            <td>
                                                <input type="text" name="message" id="message" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Discount:</th>
                                            <td>
                                                <input type="text" name="discount" id="discount" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Shipping_fee:</th>
                                            <td>
                                                <input type="text" name="shipping_fee" id="shipping_fee" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Payment:</th>
                                            <td>
                                                <input type="text" name="payment" id="payment" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Date_of_payment:</th>
                                            <td>
                                                <input type="date" name="date_of_payment" id="date_of_payment" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Status:</th>
                                            <td>
                                                <input type="text" name="status" id="status" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Create_date:</th>
                                            <td>
                                                <input type="date" name="create_date" id="create_date" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Update_date:</th>
                                            <td>
                                                <input type="date" name="update_date" id="update_date" size="45"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <button type="submit" value ="Save" class="btn btn-primary mr-2">Submit</button>
                                                <button class="btn btn-light" href="bills?action=create">Cancel</button>
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
