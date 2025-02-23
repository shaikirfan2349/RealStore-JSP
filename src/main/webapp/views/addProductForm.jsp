<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Real Story Category Form</title>
    <style>
    /* Style for form container */
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
        input[type="password"] {
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

        </style>
</head>
<body>
    <h1>Enter Product Details</h1>
    <form:form action="saveProduct"  modelAttribute="productDTO">
        <input type="hidden" name="categoryId" value="${categoryDTO.categoryId}">
        <input type="hidden" name="adminId" value="${adminId}">

        <h2>Category - ${categoryDTO.name}</h2>


        <label for="name">Product Name:</label>
        <form:input path="name" id="name"/><br/>
        <form:errors path="name" cssClass="error"/><br/>

        <label for="price">Price:</label>
        <form:input path="price" id="price"/><br/>
        <form:errors path="price" cssClass="error"/><br/>

        <label for="stockQuantity"> stockQuantity</label>
        <form:input path="stockQuantity" id="stockQuantity"/><br/>
        <form:errors path="stockQuantity" cssClas="error"/><br/>

        <label for="description">Description:</label>
        <form:input path="description" id="description"/><br/>
        <form:errors path="description" cssClass="error"/><br/>

        <input type="submit" value="Submit">
    </form:form>
</body>
</html>