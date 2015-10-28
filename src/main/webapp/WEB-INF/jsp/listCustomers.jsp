
<%--
  Created by IntelliJ IDEA.
  User: Lauri
  Date: 27.10.2015
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customers</title>
</head>
<body>
<h1>Customers Listing Page</h1>
<br>
<br>
<br>

<table>
  <tr>
    <td>First Name</td>
    <td>Last Name</td>
    <td>Date Of Birth</td>
    <td>Username</td>
    <td>Edit Customer</td>
    <td>Delete Customer</td>
  </tr>

  <c:forEach items="${listOfCustomersAttribute}" var="customer">
    <c:url var="editUrl" value="/editcustomer?id=${customer.id}" />
    <c:url var="deleteUrl" value="/deletecustomer?id=${customer.id}" />

    <tr>
      <td><c:out value="${customer.firstName}" /></td>
      <td><c:out value="${customer.lastName}" /></td>
      <td><c:out value="${customer.dateOfBirth}" /></td>
      <td><c:out value="${customer.userName}" /></td>
      <td><a href="${editUrl}">Edit</a></td>
      <td><a href="${deleteUrl}">Delete</a></td>
    </tr>
  </c:forEach>

</table>

<br>
<br>
<a href="/">back</a>
<br>
<br>

</body>
</html>
