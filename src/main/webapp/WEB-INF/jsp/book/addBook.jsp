<%--
  Created by IntelliJ IDEA.
  User: 2018121308
  Date: 2018/12/26
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/head.jsp"%>
<html>
<head>
    <h1>新增书本</h1>
    ${message}
    <f:form modelAttribute="book" action="${ctx}/book/addBook" method="post">
        书本名称：<f:input path="id"/><f:errors path="id"/><br>
        书本名称：<f:input path="bookname"/><f:errors path="bookname"/><br>
        书本价格：<f:input path="price"/><f:errors path="price"/><br>
        书本类型：<f:select path="booktype" items="${btypes}"
                  itemLabel="bname" itemValue="bvalue" cssStyle="width: 170px"/><br>
        <input type="submit" value="提交"/>
    </f:form>

</head>
<body>

</body>
</html>
