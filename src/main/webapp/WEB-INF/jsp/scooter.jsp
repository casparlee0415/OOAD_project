<%@ page import="java.util.*" %>
<%@ page import="com.Entity.Scooter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>詳細資訊</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/ico/favicon.ico" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!-- Bootstrap icons-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <!-- Core theme CSS (includes Bootstrap)-->
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <script src="/js/login.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel = "stylesheet" href = "https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src = "https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src = "https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src = "https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/scooter_styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-5">
                <!-- <a class="navbar-brand" href="#!">Start Bootstrap</a> -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-5 mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="./index">Home</a></li>
                        <li class="nav-item">
                            <form action="./brand" method="get">
                                <input type="hidden" id='${brand.id}' name="brandId" value="${brand.id}">
                                <a class="nav-link" href="javascript:void(0)" onclick="parentNode.submit()">回到機車選單</a>
                            </form>
                        </li>
                        <!-- <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Services</a></li> -->
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page Content-->
        <div class="container px-4 px-lg-5">
            <!-- Heading Row-->
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="data:image/jpeg;base64, ${scooterImgMap.get(scooter.id)}" alt="..." /></div>
                <div class="col-lg-5">
                    <h1 class="font-weight-light">${scooter.name}</h1>
                    <p><br>車型：${scooter.type}</p>
                    <p>排氣量：${scooter.displacement}</p>
                    <p>價格：${scooter.price}萬</p>
                    <!-- <a class="btn btn-primary" href="#!">Call to Action!</a> -->
                </div>
            </div>
            <!-- Call to Action-->
            <div class="card text-white bg-secondary my-5 py-4 text-center">
                <div class="card-body"><p class="text-white m-0">${scooter.engine}<br>${scooter.transmission}<br>性能：${scooter.performance}</p></div>
            </div>
            <!-- Content Row-->
            <div class="row gx-4 gx-lg-5">
                <c:forEach var="item" items="${otherScooterList}">
                    <div class="col-md-4 mb-5">
                        <div class="card h-100">
                            <div class="card-body">
                                <div class="text-center">
                                    <h2 class="card-title">${item.name}</h2>
                                    <img src="data:image/jpeg;base64, ${scooterImgMap.get(item.id)}" width="250px" alt="">
                                    <p></p>
                                    <p></p>
                                    <h5 class="fw-bolder">${item.price}萬</h5>
                                </div>
                                <!-- <p class="card-text"></p> -->
                            </div>
                            <div class="card-footer">
                                <form action='./scooter' method="get">
                                    <input type='hidden' id='${item.id}' name="scooterId" value='${item.id}'>
                                    <a class="btn btn-primary btn-sm" href="javascript:void(0)" onclick="parentNode.submit()">More Info</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4 px-lg-5"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/js/scripts.js"></script>
    </body>
</html>