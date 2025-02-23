<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add to Cart</title>
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
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"],
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
            margin-bottom: 10px;
        }

        input[type="submit"]:hover,
        button:hover {
            background-color: #0056b3;
        }

        .secondary-button {
            background-color: #6c757d;
        }

        .secondary-button:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <h1>Add to Cart</h1>
    <form:form action="/addToCart">

        <label for="quantity">Quantity:</label>
        <form:input path="quantity" id="quantity" type="number" required="true" /><br/><br/>

        <input type="submit" value="Add to Cart">
    </form:form>
</body>
</html>
