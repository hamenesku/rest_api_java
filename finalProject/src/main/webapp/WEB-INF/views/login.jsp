<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserLogin</title>
</head>
<body>

    <form action="/user/access" method="post">
        <input type="text" name="user">
        <input type="text" name="pass">

        <input type="submit" value="Login">
    </form>
     
</body>
</html>