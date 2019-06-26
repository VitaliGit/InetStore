<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


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
	

			<c:forEach	items="${allTablets}" var="all">
        	<c:url var="updateLink" value="/tablet_for_admin_update">
						<c:param name="tabletId" value="${all.id}" />
			</c:url>
			
			<c:url var="removeLink" value="/tablet_for_admin_removal">
						<c:param name="tabletId" value="${all.id}" />
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
<input type="button" value="Rajouter un tablet"
				   onclick="window.location.href='tablet_for_admin_addition'; return false;"
			/>
</body>
</html>