<%@ page import="java.util.*" %>
<%@ page import="com.Entity.Brand" %>
<%@ page import="com.DBConnection.DBConnection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>挑個牌子</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="/ico/favicon.ico">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    <!-- Bootstrap icons-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <!-- Core theme CSS (includes Bootstrap)-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel = "stylesheet" href = "https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src = "https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src = "https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src = "https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="/css/styles.css" rel="stylesheet" />
  </head>
  <body>
    <!-- Navigation
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav> -->
    <!-- Header-->
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container px-5">
          <!-- <a class="navbar-brand" href="#!">Start Bootstrap</a> -->
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ms-5 mb-2 mb-lg-0">
                  <li class="nav-item"><a class="nav-link active" aria-current="page" href="./">Home</a></li>
                  <!-- <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
                  <li class="nav-item"><a class="nav-link" href="#!">Services</a></li> -->
              </ul>


          </div>
          <script src="https://accounts.google.com/gsi/client" async defer></script>
          <div id="g_id_onload" data-client_id="1068544910867-saj93p4veeu4piudfb382ka7qatb8jsu.apps.googleusercontent.com"
               data-callback="onSignIn1"></div>
          <div class="g_id_signin"  theme="dark" width="240" height="50" longtitle="true"></div>
          <span id="GOOGLE_STATUS_1"></span>
          <script src="/js/login.js"></script>
      </div>
    </nav>
    <header class="bg-dark py-5">
      <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
          <h1 class="display-4 fw-bolder">後悔高中花錢裝很吵的排氣管</h1>
          <p class="lead fw-normal text-white-50 mb-0">
            讓你在有限預算內買到最好機車
          </p>
        </div>
      </div>
    </header>
    <!-- Section-->
    <section class="py-5">
      <div class="container px-4 px-lg-5 mt-5">
        <div
          class="
            row
            gx-4 gx-lg-5
            row-cols-2 row-cols-md-3 row-cols-xl-4
            justify-content-center
          "
        >
        <c:forEach var="brand" items="${brandList}">
          <div class="col mb-5">
            <div class="card h-100">
              <!-- Product image-->
              <img class="card-img-top" src="/img/brand/${brand.name}.jpeg" alt="..."/>
              <!-- Product details-->
              <div class="card-body p-4">
                <div class="text-center">
                  <!-- Product name-->
                  <h5 class="fw-bolder">${brand.name}</h5>
                  <!-- Product price-->
                </div>
              </div>
              <!-- Product actions-->
              <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                <div class="text-center">
                  <form action='./brand' method="get">
                    <input type='hidden' id='brandId' name='brandId' value='${brand.id}'>
                    <input type='hidden' id='brandName' name='brandName' value='${brand.name}'>
                    <a class="btn btn-outline-dark mt-auto" href="javascript:void(0)" onclick="parentNode.submit()"
                        >進入品牌</a
                    >
                  </form>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
        </div>
      </div>
    </section>
    <!-- Footer-->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">
          Copyright &copy; Your Website 2023
        </p>
      </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
  </body>
</html>
