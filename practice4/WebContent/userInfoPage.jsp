<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="practice0523.model.User" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<table width="500" border="0">
			<tr>
				<td width="70"><div align="left">姓名:</div></td>
				<td width="430"><div align="left"><jsp:getProperty name="user" property="name"/></div></td>
			</tr>
			<tr>
				<td><div align="left">住址:</div></td>
                <td><div align="left"></div><jsp:getProperty name="user" property="address"/></td>
			</tr>
			<tr>
				<td><div align="left">電話:</div></td>
				<td><div align="left"></div><jsp:getProperty name="user" property="phoneNumber"/></td>
			</tr>
			<tr>
				<td><div align="left">學歷</div></td>
				<td><div align="left"></div><jsp:getProperty name="user" property="education"/></td>
			</tr>
		</table>
		<p>
			<label> <a href='AddNewUser'>回新增資料頁面</a>
			</label>
		</p>
	</div>


</body>
</html>
