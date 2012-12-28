<%-- 
    Document   : changeInfo
    Created on : 28.12.2012, 0:58:58
    Author     : Alina
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Change Info</title>
    </head>
    <body>
        <div id="regform">
            <form method="post" style="margin-left: 80px">
                <h1 style="margin-left: 50px">Change profile</h1>
                <table style="margin-left: 15px">
                    <tbody>
                        <tr> 
                            <c:out value="${wrong_pass}"/><br>
                            <td>Name</td> 
                            <td><input type="text" name="Name" value=<%=request.getAttribute("name")%>></td> 
                        </tr>
                        <tr> 
                            <td>Email</td> 
                            <td><input type="text" name="Email" value=<%=request.getAttribute("email")%>></td> 
                        </tr>
                        <tr> 
                            <tr> 
                            <td>Old password</td> 
                            <td><input type="password" name="Password_old" value=""></td>
                        </tr> 
                        </tr>
                        <tr> 
                            <td>New password</td> 
                            <td><input type="password" name="Password_new" value=""></td>
                        </tr>
                        <tr> 
                            <td>Country</td> 
                            <td><select name="Country">
                                    <option value="Россия">Россия</option>
                                    <option value="Австрия">Австрия</option>
                                    <option value="Белоруссия">Белоруссия</option>
                                    <option value="Болгария">Болгария</option>
                                    <option value="Великобритания">Великобритания</option>
                                    <option value="Венгрия">Венгрия</option>
                                    <option value="Германия">Германи</option>
                                    <option value="Египет">Египет</option>
                                    <option value="Испания">Испания</option>
                                    <option value="Италия">Италия</option>
                                    <option value="Казахстан">Казахстан</option>
                                    <option value="Канада">Канада</option>
                                    <option value="Китай">Китай</option>
                                    <option value="Норвегия">Норвегия</option>
                                    <option value="США">США</option>
                                    <option value="Украина">Украина</option>
                                    <option value="Финляндия">Финляндия</option>
                                    <option value="Франция">Франция</option>
                                    <option value="Южная Корея">Южная Корея</option>
                                    <option value="Япония">Япония</option>
                                    <option selected value=<%=request.getAttribute("country")%>><%=request.getAttribute("country")%></option>
                                </select></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" formaction="saveChanges" name="Reg" value="Save" style="margin-left: 75px; margin-top: 25px">
                <input type="submit" formaction="cancelChanges" name="Cancel" value="Cancel" style="margin-left: 5px; margin-top: 25px">
            </form>
        </div>
    </body>
</html>
