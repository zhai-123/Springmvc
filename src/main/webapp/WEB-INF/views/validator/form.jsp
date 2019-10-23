<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .errorMsg{
            color: red;
            size: 12px;
        }
    </style>
</head>
<body>
    <form:form action="/form/save" method="post" modelAttribute="user">
        <form:input path="username"></form:input><form:errors path="username" cssClass="errorMsg"/>
        <form:input path="pwd"></form:input><form:errors path="pwd" cssClass="errorMsg"/>
        <form:button>提交</form:button>
    </form:form>
</body>
</html>
