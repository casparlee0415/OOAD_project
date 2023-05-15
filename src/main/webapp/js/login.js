window.onSignIn1=(response)=>{
    console.log('fuck');
    var credential = response.credential,
	profile = JSON.parse(decodeURIComponent(escape(window.atob(credential.split(".")[1].replace(/-/g, "+").replace(/_/g, "/"))))),
			target = document.getElementById("GOOGLE_STATUS_1"),
			html = "";
            html += "ID: " + profile.name + "<br/>";
            target.innerHTML=html
    
}