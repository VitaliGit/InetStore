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
           	<form:form action="search" method="POST">
                <p class="searchTitle">Chercher des utilisateurs</p> 
                <input type="text" placeholder="par prénom" name="userName"/>
                <input type="text" placeholder="par rôle" name="authorities"  />
                <input type="submit" value="Chercher" /><br>
            </form:form>
       <table>
				<tr>
					<th>ID</th>
					<th>Prénom</th>
					<th>Rôle</th>
					<th>Opération</th>
				</tr>   
			<c:forEach	items="${set}" var="set" >
			<c:url var="updateLink" value="/authority/update">
						<c:param name="id" value="${set.id}" />
			</c:url>
			<tr>
        				<td> ${set.id} </td>
						<td> ${set.userName.userName} </td>
						<td> 
							<c:choose><c:when test="${set.authority eq 'ROLE_REGULAR'}">REGULAR</c:when> 
							<c:when test="${set.authority eq 'ROLE_ADMIN'}">ADMIN</c:when> </c:choose></td>						
						<td>
							<a href="${updateLink}">Mettre à jour</a>
						</td>	
			</tr>
			</c:forEach>
						
			<c:forEach	items="${wholeList}" var="all" >
   			<c:url var="updateLink" value="/authority/update">
						<c:param name="id" value="${all.id}" />
			</c:url>
						
			<tr>
        				<td> ${all.id} </td>
						<td> ${all.userName.userName} </td>
						<td> 
							<c:choose><c:when test="${all.authority eq 'ROLE_REGULAR'}">REGULAR</c:when> 
							<c:when test="${all.authority eq 'ROLE_ADMIN'}">ADMIN</c:when> </c:choose></td>						
						<td>
							<a href="${updateLink}">Mettre à jour</a>
						</td>	
			</tr>
			</c:forEach>
    </table>
    <br>

</body>
</html>