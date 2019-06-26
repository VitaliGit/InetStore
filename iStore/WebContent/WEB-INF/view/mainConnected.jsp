<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang='fr'>

<head>
<script	src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>    
<link rel='stylesheet' 	href='${pageContext.request.contextPath}/resources/Main.css'>
<script src='${pageContext.request.contextPath}/resources/Main.js'
	charset="utf-8"></script>
<meta charset='utf-8'>
<title>Welcome to our Web Store!</title>
</head>

<body>
	<h1>N'h�sitez pas � choisir tout!</h1>

	<form method='post' action='connected'>
		<a href='${pageContext.request.contextPath}/WEB-INF/view/main.jsp'> Se d�sinscrire </a>

	</form>
	<p id='appearance'>Afin d'observer les cat�gories des biens sur
		notre site, veuillez appuyer ici</p>
	
	 <div class='items'>
        <div class='lab'>LIVRES</div>
        <div class='con'><a href='export_books'>T�l�charger la liste des livres</a><br>
        <a href='book_search'>Chercher des livres en ligne</a></div>
        <div class='lab'>ORDINATEURS</div>
        <div class='con'><a href='export_laptops'>T�l�charger la liste des ordinateurs</a><br>
        <a href='laptop_search'>Chercher des ordinateurs  en ligne</a></div>
        <div class='lab'>TABLETTES</div>
        <div class='con'><a href='export_tablets'>T�l�charger la liste des tablettes </a><br>
        <a href='tablet_search'>Chercher des tablettes en ligne</a></div>
        <div class='lab'>SMARTPHONES</div>
        <div class='con'><a href='view/export_phones'>T�l�charger la liste des smartphones</a><br>
        <a href='phone_search'>Chercher des smartphones en ligne</a></div>
    </div>
	<div id='copyright'>Copyright � 2019</div>
</body>

</html>