<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload file to the server</title>
</head>
<body>
    <h1>Upload file to the server</h1>
    <form method="post" action="${pageContext.request.contextPath}/upload/uploadFile.do" enctype="multipart/form-data">
        <table border="1">
            <tr>
                <td>Text note:</td>
                <td><textarea type="text" name="textNote"></textarea></td>
            </tr>
            <tr>
                <td>Pick image:</td>
                <td><input type="file" name="fileUpload"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</body>
</html>