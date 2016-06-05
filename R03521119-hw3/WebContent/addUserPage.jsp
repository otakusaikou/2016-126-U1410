<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>歡迎使用105人力公司網站</title>
    </head>
    <body>
        <h1>歡迎使用105人力公司網站來登錄您的個人資料 - page1</h1>
        <form name="form1" method="post" action="<%=response.encodeURL("createAccount.do")%>">
            <table border="0">
                <tr>
                    <th style="text-align:left">姓名:</th>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <th style="text-align:left">住址:</th>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <th style="text-align:left">電話:</th>
                    <td><input type="text" name="phoneNumber" required></td>
                </tr>
                <tr>
                    <th style="text-align:left">學歷:</th>
                    <td>
                        <input type="radio" name="education" value="高中職">高中職
                        <input type="radio" name="education" value="五專">五專
                        <input type="radio" name="education" value="四技二專">四技二專
                        <input type="radio" name="education" value="大學" checked>大學
                        <input type="radio" name="education" value="研究所"> 研究所
                    </td>
                </tr>
            </table>
            <br><br>
            <input type="reset" name="reset" value="重設">
            <input type="submit" name="submit" value="下一頁">
        </form>
    </body>
</html>
