<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOC TYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    form {
        max-width: 400px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    label {
        display: block;
        margin-bottom: 5px;
        color: #333;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        color: #fff;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .error {
        color: #dc3545;
        font-size: 0.9em;
    }

    </style>
</head>
<body>
    <h1>Admin Registration Form</h1>
    <form:form action="/registerAdmin" modelAttribute="admin">

        <label for="adminName">AdminName:</label>
        <form:input path="adminName"/><br/>
        <form:errors path="adminName"/><br/>

        <label for="password">Password:</label>
        <form:input path="password" id="password"  type="password"/><br/>
        <form:errors path="password"/><br/>

        <label for="email">Email:</label>
        <form:input path="email" id="email"/><br/>
        <form:errors path="email"/><br/>

        <label for="mobile">Mobile:</label>
        <form:input path="mobile" id="mobile" type="number"/><br/>
        <form:errors path="mobile"/><br/>

        <input type="submit" value="Register Admin" />
    </form:form>


</body>
</html>