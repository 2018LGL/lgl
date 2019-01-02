<%--
  Created by IntelliJ IDEA.
  User: 2018121308
  Date: 2018/12/26
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="/common/head.jsp"%>
<body>
<head>
    <h1>书本查询</h1>
    <form action="${ctx}/book/bookList" method="post">
        书本名称：<input type="text" name="bookname">
        <input type="submit" value="查询">
    </form>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>书本编号</td>
        <td>书本名称</td>
        <td>书本图片</td>
        <td>书本价格</td>
        <td>书本类型</td>
        <td>操作</td>
    </tr>


    <c:forEach items="${rows}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookname}</td>
            <td>
                <c:if test="${empty book.photo}">
                    未上传文件
                </c:if>
                <c:if test="${not empty book.photo}">
                    已上传文件
                </c:if>
            </td>
            <td>${book.price}</td>
            <td>${book.booktype}</td>
            <td>
                <c:if test="${empty book.photo}">
                    <a href="${ctx}/book/toUpload?id=${book.id}">上传图片</a>
                </c:if>
                <c:if test="${not empty book.photo}">
                    <a href="${ctx}/bookFile/download?fileId=${book.photo}">下载图片</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>

</table>
    ${pageBean}
</head>
</body>

</html>
