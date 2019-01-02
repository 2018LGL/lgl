<%--
  Created by IntelliJ IDEA.
  User: 2018121308
  Date: 2018/12/28
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
${bookId}
${param.id}
<body>
    <form action="${ctx}/bookFile/upload" method="post"
          enctype="multipart/form-data">
        <input type="hidden" name="bookId" value="${bookId}">
        <input type="file" name="img">
        <input type="submit" value="上传">

    </form>
</body>
</html>
