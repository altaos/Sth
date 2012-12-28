<%-- 
    Document   : Error
    Created on : 28.12.2012, 13:05:36
    Author     : Alina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error</h1><br><br>
        <h3><c:out value="${error_text}"/></h3> 
    </body>
</html>
