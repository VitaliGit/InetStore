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
    		<p>Bonjour, ${userName} !<p>   
        <table>
				<tr>
					<th>ID</th>
					<th>Disponibilité</th>
					<th>Prix</th>
					<th>Réduction</th>
					<th>Action</th>
				</tr>   
	

			<c:forEach	items="${list}" var="list">
			<c:url var="addLink" value="/cart/add_tablet">
					<c:param name="tabletId" value="${list.id}" />
					<c:param name="userName" value="${userName}" />
			</c:url>
			&nbsp; &lt<c:out value="${list}"></c:out>&gt<br>
        	
        	<tr>
        				<td> ${list.id} </td>
        				<td> ${list.available} </td>
						<td> ${list.price} </td>
						<td> ${list.discount} </td>
						
						<td>
							<a href="${addLink}"
							   onclick="if (!(confirm('Vous êtes sûr(e) et certain(e) que vous souhaitiez l\'ajouter au panier?'))) return false" >Rajouter</a>
						</td>
						
			</tr>
			</c:forEach>
    </table>
    </body>
    
</html>