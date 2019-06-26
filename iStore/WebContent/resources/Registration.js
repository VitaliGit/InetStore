
function passVerification(){
var first=document.getElementById('first');
var second=document.getElementById('second');
    if(first.value===second.value){
        second.setCustomValidity('');
    }else{
        second.setCustomValidity('Les mots de passe ne coïncident pas');
    }
    var bar = document.getElementById('barPass');
    var counter=0;
    if ( /[a-zA-Z0-9]/.test(first.value) ) { counter++; }
    
    bar.value = first.value.length * counter;
}

$(document).ready(function(){
$("#phone").mouseover(function(event){
$(this).after("<i>Par example : +37525XXXXXXX</i> ");
});
$("#phone").mousedown(function(event){
$(this).removeChild();
});
});



function finish(){
    var login = document.getElementById('login').value;
    if(second.value===second.value && login.matches(/[a-zA-Z0-9]/)){
        document.location="/mainConnected.jsp";
    }
}
