<%--
  Created by IntelliJ IDEA.
  User: icom
  Date: 5/26/2023
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1 style="text-align: center; color: violet">================== Create Form ==================</h1>
<form action="/create" method="post">
    <table border="1" style="width: 100%">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <tr>
            <td>
                <input name="name" type="text">
            </td>
            <td>
                <input name="email" type="text">
            </td>
            <td>
                <input name="address" type="text">
            </td>
        </tr>

    </table>
    <button type="submit">Update</button>
</form>
</body>
</html>
