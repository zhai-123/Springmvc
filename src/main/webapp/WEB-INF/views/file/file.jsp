<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    描述：<input type="text" name="desc"/>
    <input type="file" name="file"/>
    <input type="submit" value="上传">
    <a href="/file/void">click</a>
</form>


</body>
</html>
