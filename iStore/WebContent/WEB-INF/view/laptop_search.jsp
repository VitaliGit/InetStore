<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang='fr'>
    <head>
        <meta charset='utf-8'>
	<script	src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>   
	        	<link rel='stylesheet' href='${pageContext.request.contextPath}/resources/ShoppingCart.css'>
	 
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/search.css'>
        <title>Choose options</title>
        <script src='${pageContext.request.contextPath}/resources/searchcxb.js' charset="utf-8"></script>
    </head>
    
    <body>
    <security:authorize access="hasAnyRole('ADMIN', 'REGULAR')"> 	 
    		<security:authentication var="userName" property="principal.username"/>
    		<c:url var="cartLink" value="/cart/observation_laptop">
					<c:param name="userName" value="${userName}" /> 
			</c:url>
			<input type="hidden" name ="userName" id="userName" value="${userName}">
   
    
    	<button  class="icon-cart" style="clear: left; float: left" onclick="location.href='${cartLink}' ">
	
    		<div class="cart-line-1" style="background-color: #60690a"></div>
    		<div class="cart-line-2" style="background-color: #60690a"></div>
   			 <div class="cart-line-3" style="background-color: #60690a"></div>
    		<div class="cart-wheel" style="background-color: #60690a"></div>
		</button>
		<br>
		</security:authorize>
    
     <form:form action="search" method="POST">
                <ul>
                     <li>Disponibilit� sur l'entrep�t
                        <input type="checkbox" name="available" value ='${available}'>
                    </li>
                    <li>OS
                        <select name='os'>
                            
                            <option value='Windows 10'>Windows 10</option>
                            <option value='Windows 8'>Windows 8</option>
                            <option value='MacOS'>MacOS</option>
                            <option value='Windows XP'>Windows XP</option>
                            
                        </select>    
                    </li>
                    <li>Marque
                            <select name='brand'>
                                <option value='Lenovo'>Lenovo</option>
                                <option value='Philips'>Philips</option>
                                <option value='Samsung'>Samsung</option>
                                <option value='Apple'>Apple</option>
                                <option value='Alcatel'>Alcatel</option>
                                <option value='LG'>LG</option>
                            </select>    
                    </li>
                    <li>Couleur
                            <select name='color'>
                                    <option value='Red'>Rouge</option>
                                    <option value='Black'>Noir</option>
                                    <option value='White'>Blanc </option>
                                    <option value='Yellow'>Jaune</option>
                                    <option value='Silver'>Gris</option>
                                </select> 
                    </li>
                    <li>Ecran
                            <select name='display'>
                                    <option value='15.0f'>15.0</option>
                                    <option value='17.3f'>17.3</option>
                                    <option value='18.5f'>18.5 </option>
                            </select> 
                    </li>
                    <li>RAM
                            <select name='ram'>
                                    <option value='4096'>4096</option>
                                    <option value='1024'>1024</option>
                                    <option value='2048'>2048</option>
                                    <option value='9192'>9192</option>
                            </select> 
                    </li>
                    
                    <li>Processeur
                            <select name='cpu'>
                                    <option value='4.0f'>4.0</option>
                                    <option value='4.5f'>4.5</option>
                                    <option value='5.0f'>5.0</option>
                                    <option value='2.5f'>2.5</option>
                                    <option value='3.0f'>3.0</option>
                                    <option value='3.5f'>3.5</option>
                            </select> 
                    </li>
                    <li>Quantit� de cam�ras
                             <select name='camera'>
                                     <option value='1'>1</option>
                                     <option value='0'>0</option>
                            </select> 
                            
                     </li>
                    <li>Front-cam�ra
                            <select name='frontCamera'>
                                    <option value='1.0f'>1.0</option>
                                    <option value='2.0f'>2.0</option>
                                    <option value='3.0f'>3.0</option>
                                    <option value='5.0f'>5.0</option>
                                    
                            </select> 
                            </li>
                   
                    <li>M�moire
                        <input type="range" class='range'  name ='memory' value='${memory}' min='64' max='1024' step='1' oninput="updateRangeInput(this)">
                        <output></output>    
                        </li> 
                    <li>Prix 
                        <input type="range" class='range' name ='price' value='${price}' min='400' max='2000' step='1' oninput="updateRangeInput(this)">
                        <output></output>
                        
                   </li>
                   
                   <li>R�duction 
                        <input type="range"  class='range' name ='discount' value='${discount}' min='0' max='600' step='1' oninput="updateRangeInput(this)">
                        <output></output>  
                </li>
                </ul>
                <input type = 'submit' value='Chercher'>
        </form:form>    
        </body>
        </html>