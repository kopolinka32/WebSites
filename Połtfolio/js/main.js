const page = document.querySelector('.fa-pager');
const dsc = document.querySelector(".fa-discord");
const domen = document.querySelector(".fa-laptop-code");
const mc = document.querySelector(".fa-th-large");
const offer = document.querySelector('.offer');




const pg = () => {
    offer.innerHTML='Jeżeli jesteś zainteresowany kupnem strony dla twojej firmy lub dla serwera minecraft to dobrze trafiłeś. <br> Tutaj zakupisz strone specjalnie dla cb. <br> Co posiada taka strona ? : <br> - Responsywność <br>';
}

const dc = () => {
    offer.innerHTML='EssaDC';
}
const dm = () => {
    offer.innerHTML='EssaDM';
}

const mcc = () => {
    offer.innerHTML='EssaMCC';
}

var as = () => {
    offer.scrollIntoView();
}

page.addEventListener('click', pg);
dsc.addEventListener('click', dc);
domen.addEventListener('click', dm);
mc.addEventListener('click', mcc);

var scrollvalue = document.querySelector('.scroll');
var a = document.querySelector('.menu');
var a1 = document.querySelector('.menu1');
var a2 = document.querySelector('.menu2');
var a3 = document.querySelector('.menu3');
var a4 = document.querySelector('.menu4');

a.addEventListener('click', as);

window.addEventListener('scroll', (event) => {
    let scroll = this.scrollY;
    scrollvalue.innerHTML = scroll;

    if( scroll >= 0 && scroll <= 799) {
        a.classList.add('active');
        a1.classList.remove('active');
        a2.classList.remove('active');
    }
    if(scroll >= 800 && scroll <= 2099) {
        a1.classList.add('active');
        a.classList.remove('active');
        a2.classList.remove('active');
    }
    if(scroll >= 2100 && scroll <= 2600) {
        a2.classList.add('active');
        a.classList.remove('active');
        a1.classList.remove('active');
    }
})