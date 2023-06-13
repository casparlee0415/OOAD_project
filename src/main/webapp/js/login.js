function onSignIn1(response){
    console.log('fuck');
    var credential = response.credential,
        profile = JSON.parse(decodeURIComponent(escape(window.atob(credential.split(".")[1].replace(/-/g, "+").replace(/_/g, "/"))))),
        target = document.getElementById("GOOGLE_STATUS_1")
    console.log(profile.email)
    var html="";
    var targetUrl=document.getElementById("targetUrl").value
    html+="<form id = 'login' action = './login' method = 'post'>"
    html+="<input type = 'hidden' id = 'id' name = 'id' value = '"+profile.email+"'>";
    html+="<input type = 'hidden' id = 'name' name = 'name' value = '"+profile.name+"'>";
    html+="<input type = 'hidden' id = 'imgUrl' name = 'imgUrl' value = '"+profile.picture+"'>";
    html+="<input type = 'hidden' id = 'Url' name = 'targetUrl' value = '"+targetUrl+"'>";
    html+="</form>"
    target.innerHTML=html;
    document.getElementById("login").submit()
}

