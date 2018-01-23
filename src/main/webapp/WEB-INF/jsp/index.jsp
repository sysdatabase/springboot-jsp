<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Index page</title>
</head>
<body>
    <h1>Hello ${name}</h1>
    ${cookie.JSESSIONID.value}<br>
    <shiro:hasPermission name="首页">
        <a href="${pageContext.request.contextPath}/logout">LogOut</a>
    </shiro:hasPermission>
</body>
</html>