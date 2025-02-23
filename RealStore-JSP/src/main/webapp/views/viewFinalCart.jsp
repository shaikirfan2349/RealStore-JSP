<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Cart</title>
    <style>
       body {
           font-family: Arial, sans-serif;
           margin: 20px;
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
           background-color: #f9f9f9;
       }
       tr:hover {
           background-color: #ddd;
       }
       .remove-btn {
           background-color: #ff4d4d;
           color: white;
           padding: 5px 10px;
           border: none;
           cursor: pointer;
       }
    </style>
</head>
<body>
    <h1>Final Cart</h1>

    <table id="productTable">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Stock Quantity</th>
                <th>Product Amount</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through the productList to render products in the cart -->
            <c:forEach var="cart" items="${cartList}">
                <tr>
                    <td>${cart.productId}</td>
                    <td>${cart.productName}</td>
                    <td>${cart.price}</td>
                    <td>${cart.requiredQuantity}</td>
                    <td>${cart.totalAmount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Back to Cart Form -->
    <div style="margin-top: 20px;">
        <form action="submitSelectedProducts">
            <input type="hidden" name="userId" value="${userId}">
            <c:forEach var="productId" items="${productIds}">
                <input type="hidden" name="productIds" value="${productId}">
            </c:forEach>
            <button type="submit">Back To Cart Form</button>
        </form>
    </div>

    <!-- Form to submit the entire cart -->
        <div style="margin-top: 20px;">
            <form action="placeOrder" >
                <input type="hidden" name="userId" value="${userId}">
                <c:forEach var="cart" items="${cartList}">
                    <input type="hidden" name="cartList" value="${cart.cartId}">
                </c:forEach>
                <button type="submit">Place Order</button>
            </form>
        </div>
</body>
</html>
