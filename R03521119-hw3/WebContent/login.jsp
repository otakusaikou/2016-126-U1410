<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <title>login</title>
    </head>
    <body>
        <h1>歡迎來到105人力公司,請輸入您的資料登入</h1>
        <h3 style="color:red">${requestScope["errorCode"]}</h3>
        <form action="login.do" method="post">
            <table border="0">
                <tr>
                    <th style="text-align:left">名稱:</th>
                    <td><input type="text" name="accountName" required></td>
                </tr>
                <tr>
                    <th style="text-align:left">密碼:</th>
                    <td><input type="password" name="password" required></td>
                </tr>
            </table>
            <br>
            自動登入:
            <input type="checkbox" name="autoLogin" value="true">
            <a href="createAccount.do">新使用者？</a>
            <br><br>
            <input type="submit" name="submit" value="送出">
        </form>
    </body>
</html>
