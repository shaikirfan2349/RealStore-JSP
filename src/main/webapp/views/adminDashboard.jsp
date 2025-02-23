<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Real_Store.entity.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<html>
<head>
    <title>Admin Dashboard</title>
    <style>
   body {
       font-family: Arial, sans-serif;
       margin: 20px;
       padding: 0;
       line-height: 1.5; /* Add space between lines */
   }

   h1, h2, p {
       margin: 0 0 10px 0; /* Add space below each heading and paragraph */
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
       font-size: 16px; /* Maintain font size */
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
    <h1>Welcome to the Admin Page</h1>
    <h2>Admin Information</h2>
    <p>Admin ID: ${admin.adminId}</p>
    <p>Admin Name: ${admin.adminName}</p>

    <h2>Available Categories</h2>
    <table>
        <thead>
            <tr>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Description</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="category" items="${categoryList}">
                <tr>
                    <td>${category.categoryId}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>
                        <form action="showProductList">
                            <input type="hidden" name="categoryId" value="${category.categoryId}">
                            <input type="hidden" name="adminId" value="${admin.adminId}">
                            <button type="submit">Available Products</button>

                        </form>
                    </td>

                </tr>
            </c:forEach>

        </tbody>
    </table>
    <form action="addCategory" >
        <input type="hidden" name="adminId" value="${admin.adminId}">
        <button type="submit">Add Category</button>
    </form>
    <form action="/">
             <input type="submit" value="LogOut">
    </form>
</body>
</html>