<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        .login-form {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="login-form">
        <h2>Login</h2>
        
        <c:if test="${not empty errorMessage}">
            <div class="error">${errorMessage}</div>
        </c:if>
        
        <form action="login" method="post">
            <div>
                <label>Username:</label>
                <input type="text" name="username" required>
            </div>
            <div>
                <label>Password:</label>
                <input type="password" name="password" required>
            </div>
            <div>
                <button type="submit">Login</button>
            </div>
        </form>
    </div>
</body>
</html>