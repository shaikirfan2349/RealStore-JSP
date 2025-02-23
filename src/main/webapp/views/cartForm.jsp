<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cart Form</title>
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
    <h1>Cart Form</h1>

    <table id="productTable">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Stock Quantity</th>
                <th>Confirm to Cart</th>
                <th>Remove</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through the productList to render products in the cart -->
            <c:forEach var="product" items="${selectedProductsOfUser}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>
                        <input type="number" id="stockQuantity_${product.productId}" name="stockQuantity_${product.productId}" min="1" value="1" required>
                    </td>
                    <td>
                        <form action="checkQuantity" onsubmit="return updateStockQuantity(${product.productId}, this)">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="stockQuantity" id="hiddenStockQuantity_${product.productId}">
                            <input type="hidden" name="productId" value="${product.productId}">
                            <c:forEach var="productId" items="${productIds}">
                                <input type="hidden" name="productIds" value="${productId}">
                            </c:forEach>
                            <button type="submit" <c:if test="${product.productId == productId}">disabled</c:if>>Confirm</button>
                        </form>
                    </td>

                    <td>
                       <form action="removeCartProduct">
                            <c:forEach var="selectedProduct" items="${productList}">
                                <input type="hidden" name="selectedProducts" value="${selectedProduct.productId}">
                            </c:forEach>
                            <input type="hidden" name="productId" value="${product.productId}">
                            <input type="hidden" name="userId" value="${userId}">
                            <button type="submit" <c:if test="${product.productId == productId}">disabled</c:if>>Remove</button>
                       </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>



    <script>
        function updateStockQuantity(productId, form) {
            // Get the entered stock quantity from the input field
            var enteredQuantity = document.getElementById('stockQuantity_' + productId).value;

            // Set the value of the hidden input field to the entered stock quantity
            document.getElementById('hiddenStockQuantity_' + productId).value = enteredQuantity;

            // Optional: perform any additional validation or checks before form submission
            // For example, if you want to disable the buttons after submission:
            var checkQuantity = true; // Mock the check for valid quantity (replace with actual logic)

            if (checkQuantity) {
                // Disable the confirm button and the remove button for this product
                form.querySelector('button[type="submit"]').disabled = true;  // Disable Confirm button
                form.closest('tr').querySelector('.remove-btn').disabled = true;  // Disable Remove button
            }

            // Return true to proceed with the form submission or false to prevent it
            return checkQuantity;
        }

    </script>

</body>
</html>
