<%-- 
    Document   : registration
    Created on : 23.12.2012, 0:44:45
    Author     : Alina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Registration</title>
    </head>
    <body>
        <div id="regform">
            <form method="post" style="margin-left: 80px">
                <h1 style="margin-left: 50px">Welcome!</h1>
                <table style="margin-left: 15px">
                    <tbody>
                        <tr> 
                            <td>Name</td> 
                            <td><input type="text" name="Name" value=""></td> 
                        </tr>
                        <tr> 
                            <td>Email</td> 
                            <td><input type="text" name="Email" value=""></td> 
                        </tr>
                        <tr> 
                            <td>Login</td> 
                            <td><input type="text" name="Login" value=""></td> 
                        </tr>
                        <tr> 
                            <td>Password</td> 
                            <td><input type="text" name="Password" value=""></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" name="Reg" value="Send" style="margin-left: 75px; margin-top: 30px">
                <input type="submit" formaction="cancel" name="Cancel" value="Cancel" style="margin-left: 5px; margin-top: 30px">
            </form>
        </div>
    </body>
</html>
