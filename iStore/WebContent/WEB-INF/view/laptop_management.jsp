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
        
        <title>Choose options</title>
       <script src='${pageContext.request.contextPath}/resources/searchcxb.js' charset="utf-8"></script>
    </head>
<body>
       <table>
				<tr>
					<th>ID</th>
					<th>Disponibilité</th>
					<th>Prix</th>
					<th>Réduction</th>
					<th>Action</th>
				</tr>   
	

			<c:forEach	items="${wholeList}" var="all">
        	<c:url var="updateLink" value="/laptop/update">
						<c:param name="laptopId" value="${all.id}" />
			</c:url>
			
			<c:url var="removeLink" value="/laptop/removal">
						<c:param name="laptopId" value="${all.id}" />
			</c:url>
			
			&nbsp; &lt<c:out value="${all}"></c:out>&gt<br>
        	
        	<tr>
        				<td> ${all.id} </td>
        				<td> ${all.available} </td>
						<td> ${all.price} </td>
						<td> ${all.discount} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Mettre à jour</a>
							|
							<a href="${removeLink}"
							   onclick="if (!(confirm('Vous êtes sûr(e) et certain(e) que vous vouliez l\'éliminer?'))) return false" >Supprimer</a>
						</td>
						
			</tr>
			</c:forEach>
    </table>
    <br>
<input type="button" value="Rajouter un laptop"
				   onclick="window.location.href='addition'; return false;"
			/>
</body>
</html>