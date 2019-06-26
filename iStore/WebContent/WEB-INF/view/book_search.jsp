<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
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
     	<security:authorize access="hasAnyRole('ADMIN', 'REGULAR')"> 	 
    		<security:authentication var="userName" property="principal.username"/>
    		<c:url var="cartLink" value="/cart/observation_book">
					<c:param name="userName" value="${userName}" /> 
			</c:url>
			<input type="hidden" name ="userName" id="userName" value="${userName}">
       
    	<button  style="height:50px;width:50px" onclick="location.href='${cartLink}'" > 
    	<img src="${pageContext.request.contextPath}/resources/shopping_cart.png" width="50" height="50"/>
		</button>
	<br>
	
	</security:authorize>
     <form:form action="search" method="POST">
        <ul>
            <li>  Disponibilité sur l'entrepôt
                <input type="checkbox" name ='available' value='${available}'>
            </li>
            <li>Auteur 
                    <input type="text" name ='author' value='${author}' >
               </li>
            <li>Titre 
                    <input type="text" name ='title' value='${title}' >
            </li>
            <li>Genre
                    <select name='genre'>
                             <option value='novel'>Roman</option>
                             <option value='fiction'>Science-fiction</option>
                             <option value='fairytale'>Сonte fé</option>
                     </select> 
            </li>
            
            <li>Catégorie d'âge
                    <select name='ageGroup'>
                             <option value='forAll'>Toutes les catégories</option>
                             <option value='adult'>Adult</option>
                             <option value='kids'>Enfant</option>
                     </select> 
                     </li>
                     <li>Prix 
                        <input type="range" class='range' name ='price' value='${price}' min='3' max='50' step='1' oninput="updateRangeInput(this)">
                        <output></output>
                        
                   </li>
                   
                   <li>Réduction 
                        <input type="range"  class='range' name ='discount' value='${discount}' min='0' max='10' step='1' oninput="updateRangeInput(this)">
                        <output></output>  
                </li>
        </ul>
<input type = 'submit' value='Chercher'>
        </form:form>    
        </body>
        </html>