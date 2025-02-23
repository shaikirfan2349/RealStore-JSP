<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
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
    <h1>Ordered products</h1>

    <table id="productTable">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Stock Quantity</th>
                <th>Total Amount</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through the productList to render products in the cart -->
            <c:forEach var="cart" items="${cartList}">
                <tr>
                    <td>${cart.productName}</td>
                    <td>${cart.price}</td>
                    <td>${cart.requiredQuantity}</td>
                    <td>${cart.totalAmount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h3> Total Amount to pay: ${totalAmount}</h3>



    <!-- Form to submit the entire cart -->
        <div style="margin-top: 20px;">
            <form action="makePayment" >
                <input type="hidden" name="userId" value="${userId}">
                <input type="hidden" name="totalAmount" value="${totalAmount}">
                <input type="hidden" name="orderId" value="${orderId.orderId}">
                <button type="submit">Make Payment</button>
            </form>
        </div>
</body>
</html>
