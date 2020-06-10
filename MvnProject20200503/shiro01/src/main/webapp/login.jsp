<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>login page........</h1>

<form action="shiro/login" method="POST">
    username：<input type="text" name="username">
<br>
    password：<input type="text" name="password">
    <br>
    <br>
    rememberMe:<input type="checkbox" name="rememberMe">
<br><br>
    <input type="submit" value="submit">
</form >


<form action="shiro/login2" method="POST">
    username：<input type="text" name="username">
<br>
    password：<input type="text" name="password">
    <br>
    <br>
    rememberMe:<input type="checkbox" name="rememberMe">
<br><br>
    <input type="submit" value="submit">
</form >



</body>
</html>
