<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>XXX管理系统</title>
<style type="text/css">
table {
	border: 1px solid #9ACFEA;
	margin: 0 auto;
}

td {
	width: 200px;
	border: 1px solid #9ACFEA;
	text-align: center;
}
</style>
<%
	String cx_kszh = request.getAttribute("cx_kszh") == null ? "" : (String) request.getAttribute("cx_kszh");
	String cx_jszh = request.getAttribute("cx_jszh") == null ? "" : (String) request.getAttribute("cx_jszh");
%>
<%
	String info = request.getAttribute("info") == null ? "" : (String) request.getAttribute("info");
	if (!"".equals(info)) {
%>
<script type="text/javascript">
	alert("<%=info%>");
</script>
<%
	}
%>
</head>
<body>
	<table>
		<tr>
			<td colspan="6"><h1>信息查询</h1></td>
		</tr>

		<tr style="height: 50px">
			<td colspan="6" style="text-align: right;"><form id="cxform"
					action="NumcontiServlet">
					开始字号&nbsp;:&nbsp;<input id="cx_kszh" name="cx_kszh"
						style="height: 25px" value="<%=cx_kszh%>" />
					&nbsp;&nbsp;结束字号&nbsp;:&nbsp;<input id="cx_jszh" name="cx_jszh"
						style="height: 25px" value="<%=cx_jszh%>" />&nbsp;&nbsp;
					<button onclick="cx()">查询</button>&nbsp;&nbsp;
					<a href="NumcontiInitServlet?id=0">添加</a>&nbsp;&nbsp;
					<a href="login.jsp">重新登录</a>
				</form></td>
		</tr>
		<tr>
			<td>第一级</td>
			<td>第二级</td>
			<td>第三级</td>
			<td>开始字号</td>
			<td>结束字号</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.typeA }</td>
				<td>${item.typeB }</td>
				<td>${item.typeC }</td>
				<td>${item.numBegin }</td>
				<td>${item.numEnd }</td>
				<td><a href="NumcontiInitServlet?id=${item.id }">修改</a>&nbsp;&nbsp;<a
					href="NumcontiDelServlet?id=${item.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>