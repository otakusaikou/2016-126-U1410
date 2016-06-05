<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歡迎使用105人力公司網站</title>
</head>
<body>
<body>
<div>
    <p>
    <strong>歡迎使用105人力公司網站來登錄您的個人資料</strong>
    </p>
    <form name="form1" method="post" action="AddNewUser">
        <table width="450" border="0">
            <tr>
                <td width="40"><div align="left">姓名:</div></td>
                <td width="410"><div align="left">
                        <input name="name" type="text" id="name" required>
                </div></td>
            </tr>
            <tr>
                <td><div align="left">住址:</div></td>
                <td><div align="left">
                        <input name="address" type="text" id="address" size="45" required>
                </div></td>
            </tr>
            <tr>
                <td><div align="left">電話:</div></td>
                <td><div align="left">
                        <input name="phoneNumber" type="text" id="phoneNumber" required>
                </div></td>
            </tr>
            <tr>
                <td><div align="left">學歷</div></td>
                <td><div align="left">
                        <input type="radio" name="education" value="高中職">高中職
                        <input type="radio" name="education" value="五專">五專
                        <input type="radio" name="education" value="四技二專">四技二專
                        <input type="radio" name="education" value="大學" checked>大學
                        <input type="radio" name="education" value="研究所"> 研究所
                </div></td>
            </tr>
        </table>
        <p>
            <input type="reset" name="reset" value="重設">
            <input type="submit" name="submit" value="完成">
        </p>
    </form>
</div>
</body>
</html>
