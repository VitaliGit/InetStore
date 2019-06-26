$(document).ready(function(){
    $("div.con").slideUp(0);
    $("div.lab").slideUp(0);
    $("#appearance").click(function(event){
        $("#appearance").hide(1500);
        $("div.lab").slideDown(500);});
    $("div.lab").click(function(event){
    $(this).next().slideDown(500);}    );
    $("div.lab").hover(function(event){
    $(this).next().slideUp(4500);
    });
});
