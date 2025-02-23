<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Real_Store.entity.Category" %>
<%@ page import="com.example.Real_Store.entity.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Dashboard</title>
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
    <h1>Welcome to the User Page</h1>
    <h2>User Information</h2>
    <p>User ID: ${user.userId}</p>
    <p>User Name: ${user.userName}</p>

    <h2>Available Categories and Products</h2>

    <form action="submitSelectedProducts">
        <c:forEach var="category" items="${categoryList}">
            <h3>Category: ${category.name}</h3>

            <table>
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>StockQuantity</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${category.productList}">
                        <tr>
                            <td>
                                <input type="checkbox" name="productIds" value="${product.productId}">
                            </td>
                            <td>${product.productId}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.stockQuantity}</td>
                            <td>${product.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:forEach>

        <!-- Submit Button for selected products -->
        <div style="margin-top: 20px;">
            <input type="hidden" name="userId" value="${user.userId}">
            <button type="submit">Submit Selected Products</button>
        </div>
    </form>

    <form action="/">
        <input type="submit" value="LogOut">
    </form>
</body>
</html>
