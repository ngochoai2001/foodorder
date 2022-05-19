<%-- 
    Document   : index
    Created on : May 8, 2022, 12:49:33 PM
    Author     : ACER
--%>

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
        <title>Trang chủ</title>

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
            <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="hero__categories">
                                <div class="hero__categories__all">
                                    <i class="fa fa-bars"></i>
                                    <span>All category</span>
                                </div>
                                <ul>
                                <c:forEach var = "i" items = "${category}">
                                    <li><a href="#">${i}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="product">
                                    <input name = "action" value = "search" type = hidden>
                                    <input type="text" placeholder="What do you need?" name = "key">
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
                        <div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
                            <div class="hero__text">
                                <span>FRUIT FRESH</span>
                                <h2>Nguyên liệu <br />100% Organic</h2>
                                <p>Free Pickup and Delivery Available</p>
                                <a href="#" class="primary-btn">Đặt món ngay</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->
        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container">
                <div class="row">
                    <div class="categories__slider owl-carousel">
                        <c:forEach var = "c" items = "${category}">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="img/categories/${c.imgurl}">
                                    <h5><a href="#">${c.name}</a></h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Sản phẩm</h2>
                        </div>
<!--                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*">All</li>
                                    <c:forEach var = "c" items = "${category}">
                                    <li data-filter=".${c.catid}">${c.name}</li>
                                    </c:forEach>


                            </ul>
                        </div>-->
                    </div>
                </div>
                <div class="row featured__filter">
                    <c:forEach var = "p" items = "${plist}"> 
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges ${p.catid}">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="img/product/${p.displayimg}">
                                    <form action = "addtocart" method = "post">
                                        <input name = "action" value = "add" type="hidden">
                                        <input name ="proid" value ="${p.proid}" type="hidden">
                                    <ul class="featured__item__pic__hover">
                                        <li>
                                        <div class="product__details__quantity">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1" name = "quantity">
                                                </div>
                                            </div>
                                        </div>
                                        </li>
                                        <li><button><i class="fa fa-shopping-cart"></i></button></li>
                                    </ul>
                                        </form>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="product?action=detail&proid=${p.proid}">${p.name}</a></h6>
                                    <h5>${p.price}đ</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>
        <!-- Featured Section End -->


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
