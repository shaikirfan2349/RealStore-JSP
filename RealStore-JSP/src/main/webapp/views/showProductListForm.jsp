<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Real_Store.dto.ProductDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            line-height: 1.5;
        }

        h1, h2, p {
            margin: 0 0 10px 0;
            padding: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
            font-size: 16px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h1>Product List for Category: ${category.name}</h1>
    <h2>Category Description: ${category.description}</h2>

    <table>
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Stock Quantity</th>
                <th>Description</th>
                <th>Product Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.productid}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.stockQuantity}</td>
                    <td>${product.description}</td>
                    <td>${product.productStatus}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="adminDashboard?adminId=${adminId}">Back to Admin Dashboard</a>

    <form action="addProduct">
            <input type="hidden" name="categoryId" value="${category.categoryId}">
            <input type="hidden" name="adminId" value="${adminId}">
            <button type="submit">Add Product</button>
        </form>
</body>
</html>
