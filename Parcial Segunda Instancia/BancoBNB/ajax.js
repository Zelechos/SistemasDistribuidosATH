function llamadaGET(pagina) {
    var ajax = new XMLHttpRequest() 
    ajax.open("get", pagina, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send(); 
}


function llamadaPOST(pagina) {
    var ajax = new XMLHttpRequest() 
    var nrocuenta = document.getElementById('nrocuenta').value;
    var monto = document.getElementById('monto').value;
    var saldo = document.getElementById('saldo').value;
    var parametros ="nrocuenta=" + encodeURI(nrocuenta) +"&monto=" + encodeURI(monto) +"&saldo=" + encodeURI(saldo);
    //+ "&Nocache=" + Math.random();
    ajax.open("post", pagina, true);
    ajax.onreadystatechange = function() { 
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
    ajax.send(parametros); 
}


function llamadaPUT(pagina) {
    var ajax = new XMLHttpRequest() 
    ajax.open("put", pagina, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send(); 
}


function llamadaPATCH(pagina) {
    var ajax = new XMLHttpRequest() 
    ajax.open("patch", pagina, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send(); 
}

function llamadaDELETE(pagina) {
    var nrocuenta = document.getElementById('nrocuenta').value;
    var ajax = new XMLHttpRequest() 
    ajax.open("delete", pagina, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send(); 
}
