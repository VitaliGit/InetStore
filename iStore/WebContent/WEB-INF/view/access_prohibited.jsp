<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html >
<html lang="fr">
<head>
<meta charset="utf-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/resources/Denial.css'>
<script	src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script> 
<script type="text/javascript" src='${pageContext.request.contextPath}/resources/test.js'></script>

<title>No access</title>
</head>
<body>

<h1 id="message">Vous ne pouvez pas y accéder compte tenu que vous n'êtes pas autorisé(e). <a id='back' href="${pageContext.request.contextPath}/"> <br>Revenir? </a></h1>

</body>
</html>