<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            background-color: #e9ecef; 
            font-family: Arial, sans-serif; 
        }

        .login-form {
            width: 400px; 
            margin: 100px auto; 
            padding: 30px;
            background-color: #ffffff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); 
            border-radius: 8px; /* Rounded corners */
        }

        h2 {
            text-align: center; /* Center the heading */
            color: #007bff; /* Bootstrap primary color */
        }

        .error {
            color: red; /* Error message in red */
            margin-bottom: 15px; /* Increased margin for spacing */
            font-weight: bold; /* Bold error message */
        }

        label {
            display: block; 
            margin-bottom: 5px; 
            color: #555; 
        }

        input[type="text"],
        input[type="password"] {
            width: 100%; 
            padding: 10px; 
            margin-bottom: 15px; 
            border: 1px solid #ccc; 
            border-radius: 4px; 
            box-sizing: border-box;
            font-size: 14px; 
        }

        button[type="submit"] {
            width: 100%; /* Full width button */
            padding: 10px; /* Padding for button */
            background-color: #007bff; /* Primary color */
            color: #ffffff; /* White text color */
            border: none; /* No border */
            border-radius: 4px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Slightly larger font size */
            transition: background-color 0.3s ease; /* Smooth transition for hover effect */
        }

        button[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        .forgot-password {
            text-align: center; /* Center align the link */
            margin-top: 15px; /* Spacing above the link */
        }

        .forgot-password a {
            color: #007bff; /* Link color */
            text-decoration: none; /* Remove underline */
            font-size: 14px; /* Font size for the link */
        }

        .forgot-password a:hover {
            text-decoration: underline; /* Underline on hover */
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

