$(document).ready(function(){
$("body").css({"background-color": "rgb(18, 8, 22)"});
});
// $(document).ready(function(){
// $("h1").text('<br>');
// });

$(document).ready(function(){
$("h1>a").before("<br>");
});

$(document).ready(function(){
$("a").hover(function(){
$("h1").find("a:even").text("Il faut revenir");
});
});
$(document).ready(function(){
$("h1").click(function(){
console.log("Clicked "+ this.className);
$(this).append("<p>Prohibé!</p>");
});
});
