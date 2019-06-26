<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
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
    		<c:url var="cartLink" value="/cart/observation_phone">
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
                     <li>Disponibilité sur l'entrepôt
                        <input type="checkbox" name="available" value ='${available}'>
                    </li>
                    <li> Bluetooth  
                        <input type="checkbox" name="bluetooth" value ='${bluetooth}'>
                    </li> 
                    <li>OS
                        <select name='os'>
                            <option value='Android'>Android</option>
                            <option value='iOS'>iOS</option>
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
                                    <option value='6.3f'>6.3</option>
                                    <option value='6.0f'>6.0</option>
                                    <option value='5.0f'>5.0 </option>
                            </select> 
                    </li>
                    <li>RAM
                            <select name='ram'>
                                    <option value='512'>512</option>
                                    <option value='1024'>1024</option>
                                    <option value='2048'>2048</option>
                            </select> 
                    </li>
                    
                    <li>Processeur
                            <select name='cpu'>
                                    <option value='1.0f'>1.0</option>
                                    <option value='1.5f'>1.5</option>
                                    <option value='2.0f'>2.0</option>
                                    <option value='2.5f'>2.5</option>
                                    <option value='3.0f'>3.0</option>
                                    <option value='0.5f'>0.5</option>
                            </select> 
                    </li>
                    <li>Quantité de caméras
                             <select name='camera'>
                                     <option value='1'>1</option>
                                     <option value='2'>2</option>
                                     <option value='0'>0</option>
                            </select> 
                            
                     </li>
                    <li>Front-caméra
                            <select name='frontCamera'>
                                    <option value='1.0f'>1.0</option>
                                    <option value='2.0f'>2.0</option>
                                    <option value='3.0f'>3.0</option>
                                    <option value='5.0f'>5.0</option>
                            </select> 
                            </li>
                    <li>Back-caméra
                            <select name='backCamera'>
                                     <option value='1.0f'>1.0</option>
                                     <option value='2.0f'>2.0</option>
                                     <option value='3.0f'>3.0</option>
                                     <option value='5.0f'>5.0</option>
                                     <option value='8.0f'>8.0</option>
                                     <option value='12.0f'>12.0</option>
                             </select> 
                             </li>
                    <li>Mémoire
                        <input type="range" class='range'  name ='memory' value='${memory}' min='8' max='128' step='1' oninput="updateRangeInput(this)">
                        <output></output>    
                        </li> 
                    <li>Prix 
                        <input type="range" class='range' name ='price' value='${price}' min='100' max='800' step='1' oninput="updateRangeInput(this)">
                        <output></output>
                        
                   </li>
                   
                   <li>Réduction 
                        <input type="range"  class='range' name ='discount' value='${discount}' min='0' max='300' step='1' oninput="updateRangeInput(this)">
                        <output></output>  
                </li>
                </ul>
                <input type = 'submit' value='Chercher'>
        </form:form>    
        </body>
            
        </html>