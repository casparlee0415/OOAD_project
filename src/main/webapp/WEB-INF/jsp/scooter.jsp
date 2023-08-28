<%@ page import="java.util.*" %>
<%@ page import="com.Entity.Scooter" %>
<%@ page import="com.Entity.Comment" %>
<%@ page import="com.Entity.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                <input type="hidden" id="targetUrl" value="/scooter?scooterId=${scooter.id}">
                <% if(session.getAttribute("user")==null){ %>
                <script src="https://accounts.google.com/gsi/client" async defer></script>
                <div id="g_id_onload" data-client_id="1068544910867-saj93p4veeu4piudfb382ka7qatb8jsu.apps.googleusercontent.com"
                     data-callback="onSignIn1"></div>
                <div class="g_id_signin"  theme="dark" width="240" height="50" longtitle="true"></div>
                <span id="GOOGLE_STATUS_1"></span>
                <script src="/js/login.js"></script>
                <% }else{ %>
                <div>
                    <img style="width: 40px; height: 40px; border-radius: 100%; border: none" src="${sessionScope.user.imgUrl}">
                </div>
                <div class="fw-bolder" style="height:0px;line-height:0px;">
                    <p style="color:white">&nbsp${sessionScope.user.name}&nbsp</p>
                </div>
                <div>
                    <form action="./logout" method="post">
                        <input type="hidden" name="targetUrl" value="/scooter?scooterId=${scooter.id}">
                        <button type="submit" id="GOOGLE_logout" class="btn btn-large btn-warning">登出</button>
                    </form>
                </div>
                <% } %>
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
            <div class="col">
                <%double num= Double.valueOf(request.getAttribute("averageScore").toString());%>
                <%if(num>=1){%>
                <div class="card text-black bg-white my-5 py-4 text-center">
                    <h2 class="card-title text-black">Rate</h2>
                    <div class="card-body">
                        <div class="row gx-4 gx-lg-5 align-items-center my-5">

                            <div style="display: flex;justify-content: center;align-items: center;">
                                <h2><%=num%>&nbsp</h2>
                                <%double N=Double.valueOf((int)num);%>
                                <%for(int i=1;i<=N;i++){%>
                                    <span class="fa fa-star" style="color: orange"></span>
                                <%}%>
                                <%if(num-N>=0.25&&num-N<0.75){%>
                                    <span class="fa fa-star-half" style="color: orange"></span>
                                <%}else if(num-N>=0.75&&num-N<1){%>
                                    <span class="fa fa-star" style="color: orange"></span>
                                <%}%>

                            </div>
                        </div>
                    </div>
                </div>
                <%}%>
                <div class="card text-black bg-white my-5 py-4 text-center" id="commentArea">
                    <h2 class="card-title text-black" id="comment_title">Comment</h2>
                    <div class="card-body" >

                        <div>
                            <div>
                                <%if(session.getAttribute("user")!=null){%>
                                    <div style="display: flex;justify-content: center;align-items: center">
                                        <div style="display:flex; position: relative;top: 0%;  left: 0%; transform: translate(-100%, 0%);">
                                            <div>
                                                <img style="width: 40px; height: 40px; border-radius: 100%; border: none" src="${sessionScope.user.imgUrl}">
                                            </div>
                                            <div class="fw-bolder" style="height:40px;line-height:40px;">
                                                <p style="color:black">&nbsp${sessionScope.user.name}&nbsp</p>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <form action="./addComment" method="post" id="addCommentForm">

                                        <div style="display:flex; position: relative;top: 0%;  left: 34%; transform: translate(0%, 0%);">
                                            <div style="display: flex;justify-content: center;align-items: center">
                                                <p style="height:20%">Rating&nbsp</p>
                                                <select name="score" style="width: 50px;height:40px;line-height: 40px">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3" selected="selected">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                            </div>
                                        </div>
                                        <br>
                                        <div style="display: flex;justify-content: center;align-items: center">
                                            <textarea id="user_comment" rows="5" cols="45" name="discription" ></textarea>
                                        </div>
                                        <input type="hidden" name="scooterId" value="${scooter.id}">
                                        <br>
                                        <div style="display: flex;justify-content: center;align-items: center">
                                            <button class="btn btn-primary" type="submit">Confirm</button>
                                        </div>
                                    </form>
                                <%}%>
                            </div>
                        </div>
                        <br>
                        <%List<Comment> commentList= (List<Comment>)request.getAttribute("commentList"); %>
                        <%for(int i=0;i<commentList.size();i++){%>
                            <div class="card text-black bg-white my-5 py-4 text-center" id="comment<%=i%>">
                                <div style="display: flex;justify-content: center;align-items: center">
                                    <%User commentUser=commentList.get(i).getUser();%>
                                    <div style="display:flex; position: relative;top: 0%;  left: 0%; transform: translate(-100%, 0%);">
                                        <div>
                                            <img style="width: 40px; height: 40px; border-radius: 100%; border: none" src="<%=commentUser.getImgUrl()%>">
                                        </div>
                                        <div class="fw-bolder" style="height:40px;line-height:40px;">
                                            <p style="color:black">&nbsp<%=commentUser.getName()%>&nbsp</p>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div style="display: flex;justify-content: left;align-items: center">
                                    <div style="display: flex;position: relative;top: 0%;  left: 34%; transform: translate(0%, 0%);">
                                            <h2><%=(float)commentList.get(i).getScore()%>&nbsp</h2>
                                            <%int N=commentList.get(i).getScore();%>
                                            <div style="height:40px;line-height:40px;">
                                                <%for(int j=1;j<=N;j++){%>
                                                    <span class="fa fa-star" style="color: orange"></span>
                                                <%}%>
                                            </div>
                                    </div>
                                </div>
                                <br>
                                <div style="display: flex;justify-content: left;align-items: center">
                                    <div style="display: flex;position: relative;top: 0%;  left: 34%; transform: translate(0%, 0%);">
                                        <%SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");%>
                                        <p><%=formatter.format(commentList.get(i).getTimestamp())%></p>
                                    </div>
                                </div>
                                <div class="card-body" style="display: flex;justify-content: center;align-items: center">
                                    <div id="discriptionContent" style="display:flex;width: 400px;height: 150px;border: 1px solid #ccc;overflow: scroll">
                                        <p style="text-align: left"><%=commentList.get(i).getDescription()%></p>
                                    </div>
                                </div>
                                <%if(session.getAttribute("user")!=null){%>
                                    <%if(commentUser.getId().equals(((User)session.getAttribute("user")).getId())){%>
                                        <div style="display: flex;justify-content: center;align-items: center">
                                            <button class="btn btn-primary" onclick="editClick('<%=commentList.get(i).getDescription()%>')">EDIT</button>&nbsp&nbsp&nbsp&nbsp
                                            <script type="text/javascript">
                                                function editClick(str){
                                                    let textarea=document.getElementById("editDisciption");
                                                    textarea.innerHTML=str;
                                                    document.getElementById("editDialog").showModal();
                                                }

                                            </script>
                                            <form action="./deleteComment" method="post">
                                                <input type="hidden" name="commentNum" value="comment<%=i%>">
                                                <input type="hidden" name="commentId" value="<%=commentList.get(i).getId()%>">
                                                <input type="hidden" name="scooterId" value="${scooter.id}">
                                                <button class="btn btn-secondary" type="submit">DELETE</button>
                                            </form>
                                        </div>
                                        <dialog id="editDialog">
                                            <form action="./editComment" method="post">
                                                <div>
                                                    <p>Rating&nbsp</p>
                                                    <select name="score" style="width: 50px">
                                                        <%for(int j=1;j<=5;j++){%>
                                                            <%if(j==commentList.get(i).getScore()){%>
                                                                <option value="<%=j%>" selected="selected"><%=j%></option>
                                                            <%}else{%>
                                                                <option value="<%=j%>"><%=j%></option>
                                                            <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
                                                <br>
                                                <div>
                                                    <p>Discription</p>
                                                    <textarea id="editDisciption" name="discription"></textarea>
                                                    <input type="hidden" name="commentNum" value="comment<%=i%>">
                                                    <input type="hidden" name="commentId" value="<%=commentList.get(i).getId()%>">
                                                    <input type="hidden" name="scooterId" value="${scooter.id}">
                                                    <div style="display: flex;justify-content: center;align-items: center">
                                                        <button type="submit" class="btn btn-primary">Confirm</button>&nbsp
                                                        <button type="reset" class="btn btn-secondary" onclick="document.getElementById('editDialog').close()">Cancel</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </dialog>
                                    <%}%>
                                <%}%>
                            </div>
                            <br>
                        <%}%>
                    </div>
                </div>
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