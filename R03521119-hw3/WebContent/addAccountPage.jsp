<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>歡迎使用105人力公司網站</title>
    </head>
    <body>
        <h1>歡迎使用105人力公司網站來登錄您的個人資料 - page2</h1>
        <h3 style="color:red">${requestScope["errorCode"]}</h3>
        <form name="form1" method="post" action="<%=response.encodeURL("createAccount.do")%>">
            <table border="0">
                <tr>
                    <th style="text-align:left">新增帳戶名稱:</th>
                    <td><input type="text" name="accountName" required></td>
                </tr>
                <tr>
                    <th style="text-align:left">新增帳戶密碼:</th>
                    <td><input type="password" name="password" required></td>
                </tr>
            </table>
            <br><br>
            <input type="reset" name="reset" value="重設">
            <input type="submit" name="submit" value="送出">
        </form>
    </body>
</html>
