<%-- 
    Document   : index
    Created on : 23.12.2012, 0:28:51
    Author     : Alina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration</title>
    </head>
    <body>
        <div><img src="images/logo.png" alt="Logo" id="image"></div>
        <c:out value="${loc}"/><br><br>
        <form method="post">
            Имя пользователя <input type="text" name="login" value=""><br><br>
            Пароль&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="pass" value=""><br>
            <input type="submit" formaction="autorization" name="Autorization" value="Login" style="margin-left: 75px; margin-top: 30px"> 
            <input type="submit" formaction="registration" name="Registration" value="Registration" style="margin-left: 5px; margin-top: 30px">
        </form>
    </body>
</html>
