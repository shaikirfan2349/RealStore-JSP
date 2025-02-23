<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        .container {
            display: flex;
            justify-content: space-around;
            margin-top: 50px;
        }

        .panel {
            width: 45%;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .panel h1 {
            font-size: 24px;
            margin-bottom: 10px;
            text-align:center;
        }

        .panel h2 {
            font-size: 20px;
            margin-bottom: 10px;
            text-align:center;
        }

        .panel p {
            margin-bottom: 5px;
        }

        .panel a {
            display: block;
            margin-top: 10px;
            text-decoration: none;
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border-radius: 3px;
            width: fit-content;
        }

        .panel a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Welcome to Real Store Application </h1>
    <div class="container">
        <div class="panel">
            <h2>This is User Panel</h2>
            <p>Register User</p>
            <a href="regUser"> Register </a>
            <p>Login User</p>
            <a href="userLogins"> Login </a>
        </div>
        <div class = "panel">
            <h2>This is Admin Panel</h2>
            <p>Register Admin</p>
            <a href="regAdmin"> Register </a>
            <p>Login Admin</p>
            <a href="adminLogins"> Login </a>
        </div>
    </div>
</body>
</html>