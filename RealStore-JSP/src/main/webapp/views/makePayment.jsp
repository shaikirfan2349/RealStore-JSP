<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Payment Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 2px 2px 10px #aaa;
        }
        label, select, button, p {
            font-size: 16px;
            margin-top: 10px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Payment Form</h2>
        <form action="confirmPayment" method="post">
            <p>Total Amount: <strong>${totalAmount}</strong></p>
            <label for="paymentMethod">Select Payment Method:</label>
            <select name="paymentMethod" id="paymentMethod"  required>
                <option value="UPI">UPI</option>
                <option value="Debit">Debit Card</option>
                <option value="Credit">Credit Card</option>
            </select>
            <input type="hidden" name="userId" value="${userId}">
            <input type="hidden" name="orderId" value="${booking.orderId}">
            <input type="hidden" name="totalAmount" value="${totalAmount}">
            <input type="hidden" name="paymentMethod" value="${paymentMethod}">
            <button type="submit">Confirm Payment</button>
        </form>
    </div>
</body>
</html>
