<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歡迎使用105人力公司網站</title>
</head>
<body>
<body>
<div>
    <p>
    <strong>歡迎使用105人力公司網站來登錄您的個人資料 (*為可複選)</strong>
    </p>
    <form name="form1" method="post" action="AddNewUser">
        <table width="600" border="0">
            <tr>
                <td width="150"><div align="left">姓名:</div></td>
                <td width="450"><div align="left">
                        <input name="name" type="text" id="name">
                </div></td>
            </tr>
            <tr>
                <td><div align="left">住址:</div></td>
                <td><div align="left">
                        <input name="address" type="text" id="address" size="45">
                </div></td>
            </tr>
            <tr>
                <td><div align="left">電話:</div></td>
                <td><div align="left">
                        <input name="phoneNumber" type="text" id="phoneNumber">
                </div></td>
            </tr>
            <tr>
                <td><div align="left">學歷:</div></td>
                <td><div align="left">
                        <input type="radio" name="education" value="高中職">高中職
                        <input type="radio" name="education" value="五專">五專
                        <input type="radio" name="education" value="四技二專">四技二專
                        <input type="radio" name="education" value="大學">大學
                        <input type="radio" name="education" value="研究所"> 研究所
                </div></td>
            </tr>
            <tr>
                <td><div align="left">運動:*</div></td>
                <td><div align="left">
                        <input type="checkbox" name="exercise" value="籃球">籃球
                        <input type="checkbox" name="exercise" value="網球">網球
                        <input type="checkbox" name="exercise" value="游泳">游泳
                        <input type="checkbox" name="exercise" value="單車">單車
                        <input type="checkbox" name="exercise" value="跑步">跑步
                </div></td>
            </tr>
            <tr>
                <td><div align="left">靜態休閒:*</div></td>
                <td><div align="left">
                        <select name="leisure" size="3" multiple>
                            <option value="閱讀">閱讀</option>
                            <option value="看電影">看電影</option>
                            <option value="看電視">看電視</option>
                            <option value="發呆">發呆</option>
                            <option value="看漫畫">看漫畫</option>
                        </select>
                </div></td>
            </tr>
        </table>
        <p>
        <label> <input type="reset" name="reset" value="重設">
            <input type="submit" name="submit" value="完成">
        </label>
        </p>
    </form>
</div>
</body>
</html>
