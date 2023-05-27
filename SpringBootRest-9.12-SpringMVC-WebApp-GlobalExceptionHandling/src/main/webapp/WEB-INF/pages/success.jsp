<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h1>User Details</h1>
    <table>
        <tr>
            <th>User ID:</th>
            <td>${retrievedUser.userId}</td>
        </tr>
        <tr>
            <th>Username:</th>
            <td>${retrievedUser.username}</td>
        </tr>
        <tr>
            <th>Password:</th>
            <td>${retrievedUser.password}</td>
        </tr>
    </table>
</body>
</html>
