<%-- 
    Document   : cart
    Created on : May 8, 2022, 2:48:20 PM
    Author     : ACER
--%>

<%@page import="model.CartItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Giỏ hàng</title>
                                <%
                                    int totalquantity = 0;
//                                    float totalmoney = 0;
                                    List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");
                                    float total = 0;
                                    for (CartItem i : cartList) {
                                        total += i.getQuantity() * i.getProduct().getPrice();
                                    }
                                    int totalmoney = Float.valueOf(total).intValue();
                                %>
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
    </head>

    <body>
        <jsp:include page = "header.jsp"></jsp:include>
            <!-- Header Section End -->



            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Shopping Cart</h2>
                                <div class="breadcrumb__option">
                                    <a href="home">Home</a>
                                    <span>Shopping Cart</span>
                                </div>
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
                                            <th class="shoping__product">Products</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var = "i" items = "${cartList}">
                                        <tr>
                                            <td class="shoping__cart__item">
                                                <img src="img/product/${i.product.displayimg}" alt="" width="100px" height="100px">
                                                <h5>${i.product.name}</h5>
                                            </td>
                                            <td class="shoping__cart__price">
                                                ${i.product.price}
                                            </td>
                                    <form action = "addtocart" method ="post">
                                        <td class="shoping__cart__quantity">

                                            <input type = "hidden" name = "action" value = "update">
                                            <input type ="hidden" name = "proid" value="${i.product.proid}">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <!--<input type="text" value="1">-->
                                                    <input  type = "text" name = "quantity" value = "${i.quantity}" min = "1" >
                                                </div>
                                            </div>
                                            <input class=" justify-content-end btn border" type = "submit" value="Cập nhật số lượng">

                                        </td>

                                    </form>

                                    <td class="shoping__cart__total">
                                        ${i.product.price * i.quantity }đ
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <a href="addtocart?action=delete&proid=${i.product.proid}"><span class="icon_close"></span></a>
                                    </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__btns">
                            <a href="home" class="primary-btn cart-btn">Tiếp tục mua hàng</a>
                            
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__continue">
<!--                            <div class="shoping__discount">
                                <h5>Discount Codes</h5>
                                <form action="#">
                                    <input type="text" placeholder="Enter your coupon code">
                                    <button type="submit" class="site-btn">APPLY COUPON</button>
                                </form>
                            </div>-->
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Tổng giỏ hàng</h5>
                            <ul>
                                <!--<li>Subtotal <span>$454.98</span></li>-->
                                <li>Tổng <span><%=totalmoney%>đ</span></li>
                            </ul>
                            <form action = "order" method = "post">
                                <input type = "submit"class="primary-btn" value = "Đặt hàng">
                            </form>
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