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
        <h1>Vous devez bien indiquer votre identifiant afin procéder!</h1>
            <form:form  id='registration' method='POST' modelAttribute="user" action="verify_present" >
                 <label>Identifiant : </label>
                	<input id='login'  name='userName' 	value='${userName}'		type ='text'/>
                	<c:if test="${userName==null}">
        				<i>Cet identifiant n'existe pas! <br></i>
            		</c:if>
            		
                	<br>	           	
                <input type = 'submit' value='Accepter'>
            </form:form>
        </body>
    </html>