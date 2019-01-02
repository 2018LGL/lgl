<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<html>
    <%@include file="/common/head.jsp"%>
<body>

<a href="${ctx}/localChange?locale=zh">中文</a>&nbsp;<a href="${ctx}/localChange?locale=en">英文</a>
<h2><t:message code="lable.msg1"/> </h2>
<a href="${ctx}/toHome"><t:message code="label.msg2"/> </a><br>
<a href="${ctx}/input/welcome"><t:message code="label.msg3"/> </a><br>
<a href="${ctx}/book/toadd"><t:message code="label.msg4"/></a><br>
<a href="${ctx}/book/bookList"><t:message code="label.msg5"/></a><br>
<a href="${ctx}/book/bookList1">查询书本信息返回Json数据</a><br>
<a href="${ctx}/book/SingleBook?id=1">查询单个书本信息返回Json数据</a>
</body>
</html>
