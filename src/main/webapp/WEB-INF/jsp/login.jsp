<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Login page</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/doLogin">
        <table border="solid 1px">
            <tr style="text-align: center">
                <td colspan="2">用户登录</td>
            </tr>
            <tr>
                <td>用户名 :</td>
                <td>
                    <input type="text" name="username"/>
                </td>
            </tr>
            <tr>
                <td>密  码 :</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    记住我:<input type="checkbox" name="rememberMe" />
                </td>
            </tr>
            <tr style="text-align: center">
                <td colspan="2"><input type="submit" value="登录"/></td>
            </tr>
            <tr>
                <td colspan="2">${message}</td>
            </tr>
        </table>
    </form>
</body>
</html>