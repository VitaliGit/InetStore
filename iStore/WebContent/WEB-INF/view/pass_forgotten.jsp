<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang = 'fr'>
    <head>
        <meta charset='utf-8'>
        	<script	src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>    
        
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/Main.css'>
        <script src='${pageContext.request.contextPath}/resources/Registration.js' charset="utf-8"></script>
        <title>Enter new password</title>

    </head>
    <body>
        <h1>Maintenant vous pourriez changer votre mot de passe!</h1>
            <form:form  id='registration' method='POST' modelAttribute="user" action="password_change" >
            <form:hidden path="userName"/>
            <form:hidden path="phoneNumber"/>
                <label for='first'>Mot de passe : </label>
                	<input type ='password' 	id='first'	 		oninput="passVerification()">
                		<meter id = 'barPass' 		min='0' max='20' value='0' low='6'></meter><br>
                <label for= 'second'>Assurez-vous que le mot de passe est correct: </label>
                	<form:input type ='password' id='second' path="password" 	oninput="passVerification()"/>
                	<form:errors path="password" class="NonValid"/><br>
                	
                <input type = 'submit' value='Accepter'>
                <input id='submit' type='reset' value='Rétablir'>
            </form:form>
        </body>
    </html>