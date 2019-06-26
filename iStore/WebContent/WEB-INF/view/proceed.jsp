<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang='fr'>

<head>
	<script	src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script> 
	<link rel='stylesheet' href='${pageContext.request.contextPath}/resources/Main.css'>

    <script src='${pageContext.request.contextPath}/resources/Main.js' charset="utf-8"></script>
    <meta charset='utf-8'>
    <title>Welcome to our Web Store!</title>
</head>

<body>
    		<security:authentication var="userName" property="principal.username"/>

    <h1>Bonjour, ${userName}! Nous sommes ravis de vous accueillir :)</h1>

    <form:form action="${pageContext.request.contextPath}/logout"   method="POST"> 
        <input id='btnConnect' type="submit" value="Se déconnecter">        
    </form:form> 
    <security:authorize access="hasRole('ADMIN')"> 	 												<%-- invisible for others --%>
        <a href='${pageContext.request.contextPath}/user/management'>Gérer des utilisateurs</a><br>
        <a href='${pageContext.request.contextPath}/authority/management'>Gérer des autorités</a><br>
    </security:authorize><br></br>
     <p id='appearance'>Afin d'observer les catégories des biens sur notre site, veuillez cliquer ici</p>

    <div class='items'>
         <div class='lab'>LIVRES</div>
        <div class='con'><br>
        <a href='${pageContext.request.contextPath}/export_books'>Télécharger la liste des livres</a><br>
        <a href='${pageContext.request.contextPath}/book/search'>Chercher des livres en ligne</a><br>
        <security:authorize access="hasRole('ADMIN')"> 												<%-- invisible for others --%>
        <a href='${pageContext.request.contextPath}/book/management'>La gestion des livres</a><br>
        <a href='${pageContext.request.contextPath}/rest_api/book'>La gestion au niveau RESTful</a>
        </security:authorize><br></br>
        </div>
        <div class='lab'>ORDINATEURS</div>
        <div class='con'><br>
        <a href='${pageContext.request.contextPath}/export_laptops'>Télécharger la liste des ordinateurs</a><br>
        <a href='${pageContext.request.contextPath}/laptop/search'>Chercher des ordinateurs  en ligne</a><br>
        <security:authorize access="hasRole('ADMIN')"> 												<%-- invisible for others --%>
        <a href='${pageContext.request.contextPath}/laptop/management'>La gestion des ordinateurs</a><br>
        <a href='${pageContext.request.contextPath}/rest_api/laptop'>La gestion au niveau RESTful</a>
        </security:authorize><br></br>
        </div>
        <div class='lab'>TABLETTES</div>
        <div class='con'><br>
        <a href='${pageContext.request.contextPath}/export_tablets'>Télécharger la liste des tablettes </a><br>
        <a href='${pageContext.request.contextPath}/tablet_search'>Chercher des tablettes en ligne</a><br>
        <security:authorize access="hasRole('ADMIN')">
        <a href='${pageContext.request.contextPath}/tablet_for_admin'>La gestion des tablettes</a>
        </security:authorize><br></br>
        </div>
        <div class='lab'>SMARTPHONES</div>
        <div class='con'><br>
        <a href='${pageContext.request.contextPath}/export_phones'>Télécharger la liste des smartphones</a><br>
        <a href='${pageContext.request.contextPath}/phone/search'>Chercher des smartphones en ligne</a><br>
        <security:authorize access="hasRole('ADMIN')"> 												<%-- invisible for others --%>
        <a href='${pageContext.request.contextPath}/phone/management'>La gestion des smartphones</a><br>
        <a href='${pageContext.request.contextPath}/rest_api/phone'>La gestion au niveau RESTful</a>
        </security:authorize><br></br>
        </div>
    </div>
    <div id='copyright'>Copyright © 2019 </div>
</body>

</html>