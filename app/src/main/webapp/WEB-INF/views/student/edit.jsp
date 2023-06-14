<%--
  Created by IntelliJ IDEA.
  User: icom
  Date: 5/26/2023
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1 style="text-align: center; color: violet">================== Edit manage ==================</h1>
<form action="/update/${student.id}" method="post">
    <table border="1" style="width: 100%">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <tr>
            <td>
                <input type="text" value="${student.id}" disabled>
            </td>
            <td>
                <input name="name" type="text" value="${student.name}">
            </td>
            <td>
                <input name="email" type="email" value="${student.email}">++++++
            </td>
            <td>
                <input name="address" type="text" value="${student.address}">
            </td>
        </tr>
    </table>
    <button type="submit">Update</button>
</form>
</body>
</html>
