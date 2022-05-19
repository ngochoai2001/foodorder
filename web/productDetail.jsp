<%@page import="model.Account"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderItem"%>
<%@page import="java.util.List"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : productDetail
    Created on : May 8, 2022, 1:14:31 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Food Order">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Chi tiết sản phẩm</title>

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
            <!-- Hero Section End -->
            <section class="hero">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-9">
                            <div class="hero__search">
                                <div class="hero__search__form">
                                    <form action="product?action=search">
                                        <input type="text" placeholder="What do yo u need?" name = "key">
                                        <button type="submit" class="site-btn">SEARCH</button>
                                    </form>
                                </div>
                                <div class="hero__search__phone">
                                    <div class="hero__search__phone__icon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <div class="hero__search__phone__text">
                                        <h5>+65 11.188.888</h5>
                                        <span>support 24/7 time</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Hero Section End -->
            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Vegetable’s Package</h2>
                                <div class="breadcrumb__option">
                                    <a href="home">Home</a>
                                    <!--<span>Vegetable’s Package</span>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Product Details Section Begin -->
            <section class="product-details spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="product__details__pic">
                                <div class="product__details__pic__item">
                                    <img class="product__details__pic__item--large"
                                         src="img/product/${p.displayimg}" alt="">
                            </div>
                            <div class="product__details__pic__slider owl-carousel">
                                <c:forEach var = "i" items = "${p.img}">
                                    <img src="img/product/${i}" alt="">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__text">
                            <h3>${p.name}</h3>
                            <div class="product__details__rating">
                                <c:forEach begin="1" end = "${p.pointRating}">
                                    <i class="fa fa-star"></i>
                                </c:forEach>
                                <span>(${p.rating.size()} reviews)</span>
                            </div>
                            <div class="product__details__price">${p.price}đ</div>
                            <p>${p.describe}</p>
                            <form action = "addtocart" method = "post">
                                <input type = "hidden" name = "action" value = "add">
                                <input type = "hidden" name = "proid" value = "${p.proid}">
                                <div class="product__details__quantity">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="text" value="1" name = "quantity">
                                        </div>
                                    </div>
                                </div>

                                <input type = "submit" class="primary-btn" value = "ADD TO CARD">
                                <!--<a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>-->
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                       aria-selected="true">Reviews <span>(${p.rating.size()})</span></a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane" id="tabs-3" role="tabpanel">
                                    <div class="product__details__tab__desc">

                                        <c:forEach var = "i" items = "${p.rating}">
                                            <i>${i.username}</i>                                 
                                            </br>
                                            <c:forEach begin="1" end = "${i.point}">
                                                <i class="fa fa-star"></i>
                                            </c:forEach>
                                            <p>${i.content}</p>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <% 
                                   Account a =(Account) session.getAttribute("user");
                                   if(a!=null) if(a.getRoleid()==1){
                                   List<OrderItem> history = (ArrayList<OrderItem>)session.getAttribute("history");
                                   Product p =(Product) request.getAttribute("p");
                                   for(OrderItem o: history){
                                       if(o.getCartitem().getProduct().getProid()==p.getProid()){
                                           %>
                                   
                                <form action = "product" method = "post">
                                    <input type = "hidden" name = "action" value = "insertRating">
                                    <input type = "hidden" name = "proid" value = "${p.proid}">
                                    <input type = "number" name = "rate" value = "1" min = "1" max = "5">
                                    <input type = "content" name = "content" >

                                    <input type = "submit" class="primary-btn" value = "Đánh giá">
                                    <!--<a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>-->
                                </form>
                                    <%    break;}
                                   }}
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Details Section End -->


    
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
