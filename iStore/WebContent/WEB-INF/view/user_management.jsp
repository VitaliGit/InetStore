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
                <input type="text" placeholder="par pr�nom" name="theSearchName" />
                <input type="text" placeholder="par t�l�phone" name="phoneNumber" />
                <input type="text" placeholder="par caract�re" name="character" />
                <input type="submit" value="Chercher" /><br>
            </form:form>
       <table>
				<tr>
					<th>Pr�nom</th>
					<th>Acc�s</th>
					<th>Quantit� de connexion</th>
					<th>Caract�re</th>
					<th>Date de mis � jour</th>
					<th>Le num�ro de t�l�phone</th>
					<th>Op�ration</th>
				</tr>   
			<c:forEach	items="${set}" var="set" >
			<c:url var="updateLink" value="/user/update_character">
						<c:param name="userName" value="${set.userName}" />
			</c:url>
			<c:url var="enableLink" value="/user/enable">
						<c:param name="userName" value="${set.userName}" />
			</c:url>
			<tr>
        				<td> ${set.userName} </td>
        				<td> <c:choose><c:when test="${all.enabled>0}">Activ�(e) </c:when> <c:otherwise>D�sactiv�(e)</c:otherwise></c:choose></td>
						<td> ${set.connectionNumber} </td>
						<td> ${set.character} </td>
						<td> ${set.updatedDate} </td>
						<td> ${set.phoneNumber} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Mettre � jour</a>
							|
							<a href="${enableLink}"
							   onclick="if (!(confirm('Vous �tes s�r(e) et certain(e) que vous vouliez (d�s)activer cet utilisateur?'))) return false" >Autorisation</a>
						</td>
						
			</tr>
			</c:forEach>
			
			
			<c:forEach	items="${wholeList}" var="all" >
        	<c:url var="updateLink" value="/user/update_character">
						<c:param name="userName" value="${all.userName}" />
			</c:url>
			
			
			
			<c:url var="enableLink" value="/user/enable">
						<c:param name="userName" value="${all.userName}" />
			</c:url>
			        	
        	<tr>
        				<td> ${all.userName} </td>
        				<td> <c:choose><c:when test="${all.enabled>0}">Activ�(e) </c:when> <c:otherwise>D�sactiv�(e)</c:otherwise></c:choose></td>
						<td> ${all.connectionNumber} </td>
						<td> ${all.character} </td>
						<td> ${all.updatedDate} </td>
						<td> ${all.phoneNumber} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Mettre � jour</a>
							|
							<a href="${enableLink}"
							   onclick="if (!(confirm('Vous �tes s�r(e) et certain(e) que vous vouliez (d�s)activer cet utilisateur?'))) return false" >Autorisation</a>
						</td>
						
			</tr>
			</c:forEach>
    </table>
    <br>

</body>
</html>