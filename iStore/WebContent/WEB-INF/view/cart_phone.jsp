<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	<!DOCTYPE html >
	<html lang="fr">
	<head>
	<meta charset="utf-8">
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/search.css'>
        <title>Found</title>
      <!--  <script src='TabletsSearch.js' ></script>   -->
    </head>
    <body>
			<security:authentication var="userName" property="principal.username"/>
			<input type="hidden" name ="userName" id="userName" value="${userName}">
    		<h1>&emsp; Vos produits, ${userName} :</h1>
			   <table>
				<tr>
					<th>ID</th>
					<th>Prix</th>
					<th>Smartphone(s)</th>
					<th>Date</th>
					</tr> 
			<c:forEach	items="${list}" var="list">
				<tr>
        				<td> ${list.id} </td>
        				<td> ${list.totalPrice} </td>
						<td> ${list.idPhone} </td>
						<td> ${list.orderDate} </td>
						
			</tr>
			</c:forEach>
			 </table>
    </body>
    
</html>