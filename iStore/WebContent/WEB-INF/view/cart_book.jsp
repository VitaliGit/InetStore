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
					<th>Livre(s)</th>
					<th>Date</th>
					<th>Opération</th>
					<th>Avancement</th>
					</tr> 
			<c:forEach	items="${list}" var="list">
				<c:url var="paymentLink" value="/cart/payment_book">
					<c:param name="bookId" value="${list.id}" />
					<c:param name="userName" value="${userName}" />
				</c:url>
				<c:url var="removalLink" value="/cart/remove_book">
					<c:param name="bookId" value="${list.id}" />
					<c:param name="userName" value="${userName}" />
				</c:url>
				<tr>
        				<td> ${list.id} </td>
        				<td> ${list.totalPrice} </td>
						<td> ${list.idBook} </td>
						<td> ${list.orderDate} </td>
						<td>
							<a href="${removalLink}"
							   onclick="if (!(confirm('Vous êtes sûr(e) et certain(e) que vous souhaitiez l\'éliminer du panier?'))) return false" >Supprimer</a>
							|
							<a href="${paymentLink}"
							   onclick="if (!(confirm('Vous êtes sûr(e) et certain(e) que vous souhaitiez effectuer le paiement?'))) return false" >Payer</a>
						</td>
						<td><c:choose>
							<c:when test="${list.status eq 'UNCONFIRMED'}"> Non confirmé</c:when>
							<c:when test="${list.status eq 'PAID'}">Payé</c:when>
							<c:when test="${list.status eq 'COMPLETED'}"> Accompli</c:when>
						</c:choose></td>
						
						
			</tr>
			</c:forEach>
			 </table>
    </body>
    
</html>