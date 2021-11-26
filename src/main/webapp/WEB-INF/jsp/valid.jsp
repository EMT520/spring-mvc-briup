<%--
  Created by IntelliJ IDEA.
  User: lining
  Date: 2021/11/26
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--添加spring 提供的标签--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <sf:form modelAttribute="teacher" method="post" action="/dataValidation/test2">
        <sf:label path="id">工号：</sf:label>
        <sf:input path="id"/>
        <sf:errors path="id" cssStyle="color:red"/><br>
        <sf:label path="name">用户名：</sf:label>
        <sf:input path="name"/>
        <sf:errors path="name" cssStyle="color:red"/><br>
        <sf:label path="age">年龄：</sf:label>
        <sf:input path="age"/>
        <sf:errors path="age" cssStyle="color:red"/><br>
        <sf:label path="dob">出生日期：</sf:label>
        <sf:input path="dob"/>
        <sf:errors path="dob" cssStyle="color:red"/><br>
    </sf:form>
</body>
</html>
