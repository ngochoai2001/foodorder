<%-- 
    Document   : header
    Created on : May 8, 2022, 12:50:20 PM
    Author     : ACER
--%>

<%@page import="model.CartItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Header</title>

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
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href="#"><img src="img/logo.png" alt=""></a>
            </div>
            <div class="humberger__menu__cart">
                <ul>
                    <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                    <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                </ul>
                <div class="header__cart__price">item: <span>$150.00</span></div>
            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="img/language.png" alt="">
                    <div>English</div>
                    <span class="arrow_carrot-down"></span>
                    <ul>
                        <li><a href="#">Spanis</a></li>
                        <li><a href="#">English</a></li>
                    </ul>
                </div>
                <div class="header__top__right__auth">
                    <a href="#"><i class="fa fa-user"></i> Login</a>
                </div>
            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <c:if test = "${user.roleid==1}">
                        <li class="active"><a href="home">Home</a></li>
                        </c:if>
                        <c:if test = "${user.roleid==2}">
                        <li class="active"><a href="admin?action=viewOrder">Home</a></li>
                        </c:if>
                    <!--<li><a href="./shop-grid.html">Shop</a></li>-->
                    <li><a href="#">Pages</a>
                        <ul class="header__menu__dropdown">
                            <!--<li><a href="./shop-details.html">Shop Details</a></li>-->
                            <li><a href="cart.jsp">Shoping Cart</a></li>
                            <li><a href="register?action=changeProfile">Check Out</a></li>
                            <li><a href="product?action=viewHistory">Blog Details</a></li>
                        </ul>
                    </li>
                    <!--<li><a href="./blog.html">Blog</a></li>-->
                    <!--<li><a href="./contact.html">Contact</a></li>-->
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
            <div class="header__top__right__social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-pinterest-p"></i></a>
            </div>
            <div class="humberger__menu__contact">
                <ul>
                    <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                    <li>Miễn phí vận chuyển cho đơn từ 150.000đ</li>
                </ul>
            </div>
        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <header class="header">

            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <!--                            <a href="home"><img src="img/logo.png" alt="" width = "100px" height="100px"></a>  -->

                            <c:if test = "${user.roleid==1||user==null}">
                                <a href="home"><img src="img/logo.png" alt="" width = "100px" height="100px"></a>  
                                </c:if>
                                <c:if test = "${user.roleid==2}">
                                <a href="admin?action=viewOrder"><img src="img/logo.png" alt="" width = "100px" height="100px"></a>                                </c:if>
                                <c:if test = "${user.roleid==3}">
                                <a href="admin"><img src="img/logo.png" alt="" width = "100px" height="100px"></a>  
                                </c:if>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <c:if test = "${user.roleid==1}">
                                    <li class="active"><a href="home">Home</a></li>
                                    </c:if>
                                    <c:if test = "${user.roleid==2}">
                                    <li class="active"><a href="admin?action=viewOrder">Home</a></li>
                                    </c:if>
                                    <c:if test = "${user.roleid==1}">
                                    <li><a href="#">Lựa chọn người dùng</a>
                                        <ul class="header__menu__dropdown">
                                            <!--<li><a href="./shop-details.html">Shop Details</a></li>-->
                                            <li><a href="cart.jsp">Shoping Cart</a></li>
                                            <li><a href="register?action=changeProfile">Check Out</a></li>
                                            <li><a href="order?action=viewHistory">My order</a></li>
                                        </ul>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <c:if test = "${user!=null && user.roleid==1}">
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
                                <ul>
                                    <!--<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>-->
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-bag"></i> <span><%=cartList.size()%></span></a></li>
                                </ul>
                                <div class="header__cart__price">item: <span><%=totalmoney%>đ</span></div>

                            </c:if>
                            <c:if test = "${user==null}">
                                <a href="login"><i class="fa fa-user"></i> Login</a>
                                <a href="register"><i class="fa fa-user"></i> Register</a>

                            </c:if>
                            <c:if test = "${user!=null}">
                                <a href="logout"><i class="fa fa-user"></i>Logout</a>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
            <!-- Hero Section Begin -->

        </header>
    </body>
</html>
