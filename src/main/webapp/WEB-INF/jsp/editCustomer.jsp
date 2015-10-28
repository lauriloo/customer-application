<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lauri
  Date: 27.10.2015
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<h1>Edit Customer</h1>
<br>
<br>
<br>
<form:form modelAttribute="customerAttribute" method="POST" action="/editcustomer?id=${customerIdAttribute}">
  <table>

    <tr>
      <td>First name:</td>
      <td><form:input path="firstName"/></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><form:input path="lastName"/></td>
    </tr>

    <tr>
      <td>Username:</td>
      <td><form:input path="userName"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><form:password path="password"/></td>
    </tr>
      <%--<tr>
        <td>Re-Enter Password:</td>
        <td><form:password path="rePassword"/></td>
      </tr>--%>
    <tr>
      <td>Date of Birth (dd-mm-yy):</td>
      <td><form:input id="datepicker" path="dateOfBirth"/></td>
    </tr>
  </table>
  <br>
  <input type="submit" value="Save" />
</form:form>
<br>
<a href="/">back</a>
<br>
<br>

</body>
</html>
