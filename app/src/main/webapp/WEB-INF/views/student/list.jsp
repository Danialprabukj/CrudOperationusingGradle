<%--
  Created by IntelliJ IDEA.
  User: icom
  Date: 5/26/2023
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1 style="text-align: center; color: violet">================== Student manage ==================</h1>
<table border="1" style="width: 100%">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${listStudent}" var="st">
        <tr>
            <td>${st.id}</td>
            <td><a href="/student/${st.id}">${st.name}</a></td>
            <td>${st.email}</td>
            <td>${st.address}</td>
            <td><a href="/student/update/${st.id}">Edit</a></td>
            <td><a href="/student/delete/${st.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<button><a href="/student/create/">Create</a></button>
</body>
</html>
