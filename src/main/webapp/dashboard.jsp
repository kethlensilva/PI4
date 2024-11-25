<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
  <div>
    <h1>Cars</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="lar" items="${lars}">
            <tr>
                <td></td>
                <td>${lar.name}</td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="lar" items="${lars}">
            <tr>
                <td>${lar.id}</td>
                <td>${lar.name}</td>
                <td>
                    <form action="/delete-lar" method="post">
                        <input type="hidden" id="id" name="id" value="${lar.id}">
                        <button type="submit">Delete</button>
                        <span> | </span>
                        <a href="index.jsp?id=${lar.id}&name=${lar.name}">Update</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
  </div>
</body>
</html>