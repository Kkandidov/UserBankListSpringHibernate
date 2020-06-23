<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
        <meta name="author" content="Konstantin Astashonok">
		
		<title>${title}</title>

		<script>
      	    window.contextRoot = '${contextRoot}'
        </script>
		
	</head>
	<body>
	
		<h1>Users and Accounts</h1>
		
        <!-- Loading the home content -->
        <c:if test="${homeClicked == true}">
            <%@include file="home.jsp"%>
        </c:if>

        <!-- Loading the 'task 5' content -->
        <c:if test="${task5Clicked == true}">
            <%@include file="task5.jsp"%>
        </c:if>

        <!-- Loading the 'task 8' content -->
        <c:if test="${task8Clicked == true}">
            <%@include file="task8.jsp"%>
        </c:if>

		<script src="${contextRoot}/js/app.js"></script>
	</body>
</html>