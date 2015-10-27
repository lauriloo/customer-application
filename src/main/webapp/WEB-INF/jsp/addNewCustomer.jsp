<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <script type="text/javascript" src="/resources/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-ui-1.11.3.js"></script>
    <script type="text/javascript" lnaguage="javascript">
        $(function()
        {
            $("#datepicker").datepicker(
                    {
                        showOn:"both",
                        dateFormat:"dd-mm-yy",
                        buttonImageOnly: false,
                        changeMonth: true,
                        changeYear: true,
                        yearRange: "1900:2015",
                        hideIfNoPrevNext: true,
                        buttonText: "Calendar"
                        //minDate:+0, //you do not want to show previous date.
                        //maxDate:+0   // you do not want to show next day.
                    });
        });
    </script>
</head>
<body>

<h1>Add New Customer:</h1>
<br>
<br>


<form:form modelAttribute="customerAttribute" method="POST" action="/addnewcustomer">
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
        <tr>
            <td>Re-Enter Password:</td>
            <td><form:password path="rePassword"/></td>
        </tr>
        <tr>
            <td>Date of Birth (dd-mm-yy):</td>
                <%--<td><form:input path="dateOfBirth"/><div id="datepicker"></div></td>--%>
            <td><form:input id="datepicker" path="dateOfBirth"/></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Register" />
</form:form>

<br>
<a href="/">back</a>
<br>
<br>
<%--<input type="text" name="calendar" id="datepicker">--%>

</body>
</html>