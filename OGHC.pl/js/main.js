var psc = document.querySelector('#Psc');
var pp = document.querySelector('#PP');
var card = document.querySelector('#card');
var sms = document.querySelector('#sms');
var nick = document.querySelector('#name');
const dane = document.querySelector('.dane');
var price = document.querySelector('#price');
var nickname = document.querySelector('#nicknames');

var backend = document.querySelector("#arrow");

function newPage(num) {
    var url=new Array();
    url[0]="./files/vip.html";
    window.location=url[num];``
}

nickname.addEventListener("input", e => {
    nick.innerHTML = `${nickname.value}`;
});

backend.addEventListener("click", e => {
    console.log("es");
    window.location.href = "../index.html"
});

function checkeds() {
    if(psc.checked) {
        price.innerHTML = "10 PLN";
    }else if(pp.checked){
        price.innerHTML = "10 PLN";
    }else if(card.checked){
        price.innerHTML = "10 PLN";
    }else if(sms.checked){
        price.innerHTML = "13 PLN";
    }
}