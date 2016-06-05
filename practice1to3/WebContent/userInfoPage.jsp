<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歡迎登入105人力公司網站</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String phoneNumber = request.getParameter("phoneNumber");
    String education = request.getParameter("education");
%>
<div>
    <p>
    <strong>歡迎登入105人力公司網站!</strong>
    </p>
    <table width="500" border="0">
        <tr>
            <td width="70"><div align="left">姓名:</div></td>
            <td width="430"><div align="left"><%= name %></div></td>
        </tr>
        <tr>
            <td><div align="left">住址:</div></td>
            <td><div align="left"><%= address %></div></td>
        </tr>
        <tr>
            <td><div align="left">電話:</div></td>
            <td><div align="left"><%= phoneNumber %></div></td>
        </tr>
        <tr>
            <td><div align="left">學歷</div></td>
            <td><div align="left"><%= education %></div></td>
        </tr>
    </table>
    <p>
    <label> <a href='AddNewUser'>回新增資料頁面</a>
    </label>
    </p>
</div>
</body>
</html>
