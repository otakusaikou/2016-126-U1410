<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="loginUser" class="homework3.model.User" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>歡迎登入105人力公司網站</title>
    </head>
    <body>
        <h1>${loginUser["accountName"]}, 歡迎登入105人力公司網站</h1>
        <table border="0">
            <tr>
                <th style="text-align:left">姓名:</th>
                <td>${loginUser["name"]}</td>
            </tr>
            <tr>
                <th style="text-align:left">住址:</th>
                <td>${loginUser["address"]}</td>
            </tr>
            <tr>
                <th style="text-align:left">電話:</th>
                <td>${loginUser["phoneNumber"]}</td>
            </tr>
            <tr>
                <th style="text-align:left">學歷:</th>
                <td>${loginUser["education"]}</td>
            </tr>
        </table>
        <br>
        <a href="login.do?action=logout">登出</a>
    </body>
</html>
