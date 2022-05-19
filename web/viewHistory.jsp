<%-- 
    Document   : viewHistory
    Created on : May 8, 2022, 3:01:43 PM
    Author     : ACER
--%>

<%@page import="model.OrderItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : cart
    Created on : May 8, 2022, 2:48:20 PM
    Author     : ACER
--%>


<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Đơn mua</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <script src=
                "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
        </script>

        <script type="text/javascript">
            $(document).ready(() => {
                $("#select").val('2');
            });
        </script>
    </head>

    <body>
        <jsp:include page = "header.jsp"></jsp:include>
            <!-- Header Section End -->
        <%
            int totalquantity = 0;
            float totalmoney = 0;
            List<OrderItem> orderList = (List<OrderItem>) session.getAttribute("history");
            float total = 0;
            for (OrderItem i : orderList) {
                total += i.getCartitem().getQuantity() * i.getCartitem().getProduct().getPrice();
            }
        %>


        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <c:if test ="${user.roleid==1}">
                            <h2>Lịch sử mua hàng</h2>
                            <div class="breadcrumb__option">
                                <a href="home">Home</a>
                                <span>Danh sách mặt hàng đã mua</span>
                            </div>
                            </c:if>
                            <c:if test ="${user.roleid!=1}">
                            <h2>Danh sách mặt hàng</h2>
                            </c:if>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__table">
                            <table>
                                <thead>
                                    <tr>
                                        <th class="shoping__product">Sản phẩm</th>
                                        <th>Đơn Giá</th>
                                        <th>Số lượng</th>
                                        <th>Thành tiền</th>
                                        <th>Ngày đặt hàng</th>
                                        <th>Tình trạng đơn hàng</th>
                                        <th>Mã đơn hàng</th>
                                        <c:if test = "${user.roleid!=1}">
                                        <th>Địa chỉ giao hàng</th>
                                                </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var = "i" items = "${history}">
                                        <tr>
                                            <td class="shoping__cart__item">
                                                <img src="img/product/${i.cartitem.product.displayimg}" alt="" width = "250px" height = "200px">
                                                <h5>${i.cartitem.product.name}</h5>
                                            </td>
                                            <td class="shoping__cart__price">
                                                ${i.cartitem.product.price}đ
                                            </td>
                                            <td class="shoping__cart__quantity">

                                                <span color = "red">${i.cartitem.quantity}</span>

                                            </td>
                                            <td class="shoping__cart__total">
                                                ${i.cartitem.product.price * i.cartitem.quantity }đ
                                            </td>
                                            <td style = "width:50px;">
                                                <span  style ="color:red">${i.orderDate}</span>
                                            </td>
                                            <td>
                                                <%--<c:if test = "${user.roleid==1}">--%>
                                                    <span style="color: red">${i.status}</span>
                                                <%--</c:if>--%>
                                                
                                            </td>
                                            <td>${i.orderid}</td>
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    
                    <div class="col-lg-6">
                        <div class="shoping__continue">
                            <div class="shoping__discount">
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Cart Total</h5>
                            <ul>
                                <!--<li>Subtotal <span>$454.98</span></li>-->
                                <li>Total <span><%=total%> đ</span></li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shoping Cart Section End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>


    </body>

</html>