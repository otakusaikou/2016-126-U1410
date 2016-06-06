<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" class="practice0606.model.User" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歡迎登入105人力公司網站</title>
</head>
<body>

<div>
    <p>
    <strong>歡迎登入105人力公司網站!</strong>
    </p>
    <table width="600" border="0">
        <tr>
            <td width="100"><div align="left">姓名:</div></td>
            <td width="500"><div align="left">${user.name}</div></td>
        </tr>
        <tr>
            <td><div align="left">住址:</div></td>
            <td><div align="left">${user.address}</div></td>
        </tr>
        <tr>
            <td><div align="left">電話:</div></td>
            <td><div align="left">${user.phoneNumber}</div></td>
        </tr>
        <tr>
            <td><div align="left">學歷:</div></td>
            <td><div align="left">${user.education}</div></td>
        </tr>
        <tr>
            <td><div align="left">運動:</div></td>
            <td><div align="left">
                <c:forEach var="element" items="${user.exercise}">
                ${element}
                </c:forEach>
            </div></td>
        </tr>
        <tr>
            <td><div align="left">靜態休閒:</div></td>
            <td><div align="left">
                <c:forEach var="element" items="${user.leisure}">
                ${element}
                </c:forEach>
            </div></td>
        </tr>
    </table>
    <p>
    <label> <a href='AddNewUser'>回新增資料頁面</a>
    </label>
    </p>
</div>


</body>
</html>
