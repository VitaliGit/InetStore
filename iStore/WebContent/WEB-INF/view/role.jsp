<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang='fr'>
    <head>
        <meta charset='utf-8'>
	<script	src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>    
    <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/search.css'>
        
        <title>Change the character</title>
       <script src='${pageContext.request.contextPath}/resources/searchcxb.js' charset="utf-8"></script>
    </head>
<body>

		     	
<form:form action="update" modelAttribute="authority" method="POST">
		<form:hidden path="id" />
			<ol>
			<li>Le nouveau  rôle pour l'utilisateur 
            <select name='role'>
            	<option value='admin'>ADMIN</option>
            	<option value='regular' >REGULAR</option>
            </select>
            </li>
		   	</ol>			
        	<input type = 'submit' value='Mettre à jour'>
</form:form>  
</body>
</html>