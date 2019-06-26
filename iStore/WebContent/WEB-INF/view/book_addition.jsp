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

<form:form action="addition" method="POST">
       				 <ul>
        			<li>Le numéro du bien
               			 <input type="text" name="id" value ='${id}'>
            		</li>
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
                             <option value='fairytale'>>Сonte fé</option>
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
             <input type="text" name ="price" value='${price}'>                 
           </li>
           <li>Réduction 
           <input type="text" name ="discount" value='${discount}'>                 

        </li>
        </ul>
        <input type = 'submit' value='Ajouter'>
</form:form>  
</body>
</html>