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

		     	
<form action="tablet_for_admin_update" method="POST">
			<ol>
			
			<li>Disponibilité sur l'entrepôt
                <input type="text" name="available" value ='${available}'>
            </li>
			<li>Prix 
             <input type="text" name ="price" value='${price}'>                 
           </li>
           <li>Réduction 
           <input type="text" name ="discount" value='${discount}'>   </li>
           </ol>			
        <input type = 'submit' value='Mettre à jour'>
        <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
</form>  
</body>
</html>