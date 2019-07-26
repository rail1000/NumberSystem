<%@page import="web.model.Numconti"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>XXX管理系统</title>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<%
	Numconti numconti = request.getAttribute("numconti") == null
			? new Numconti()
			: (Numconti) request.getAttribute("numconti");
%>

<style type="text/css">
table {
	border: 1px solid #9ACFEA;
	margin: 0 auto;
}

td {
	width: 350px;
	border: 1px solid #9ACFEA;
	text-align: center;
}
</style>
</head>

<body>
	<form action="NumcontiSaveServlet" method="post" id="myform">
		<table>
			<tr>
				<td colspan="2"><h1>
						信息编辑<input type="hidden" id="id" name="id"
							value="<%=numconti.getId()%>" readonly="readonly" />
					</h1></td>
			</tr>
			<tr>
				<td>第一级:</td>
				<td style="text-align: left;"><input type="text" id="typeA"
					name="typeA"
					value="<%=numconti.getTypeA() == null ? "" : numconti.getTypeA()%>"
					 /></td>
			</tr>

			<tr>
				<td>第二级:</td>
				<td style="text-align: left;"><input type="text" id="typeB"
					name="typeB"
					value="<%=numconti.getTypeB() == null ? "" : numconti.getTypeB()%>"
					 /></td>
			</tr>

			<tr>
				<td>第三级:</td>
				<td style="text-align: left;"><input type="text" id="typeC"
					name="typeC"
					value="<%=numconti.getTypeC() == null ? "" : numconti.getTypeC()%>"
					 /></td>
			</tr>

			<tr>
				<td>开始数:</td>
				<td style="text-align: left;"><input type="text" id="numBegin"
					name="numBegin"
					value="<%=numconti.getNumBegin() == null ? "" : numconti.getNumBegin()%>"
					 /></td>
			</tr>

			<tr>
				<td>结束数:</td>
				<td style="text-align: left;"><input type="text" id="numEnd"
					name="numEnd"
					value="<%=numconti.getNumEnd() == null ? "" : numconti.getNumEnd()%>"
					 /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="提交"
					onclick="save()" /> <input type="button" value="返回"
					onclick="goback()" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function save() {
			var typeA = document.getElementById("typeA").value;
			var typeB = document.getElementById("typeB").value;
			var typeC = document.getElementById("typeC").value;
			var numBegin = document.getElementById("numBegin").value;
			var numEnd = document.getElementById("numEnd").value;
			if ("" == typeA) {
				alert("第一级不能为空");
			} else if ("" == typeB) {
				alert("第二级不能为空");
			} else if ("" == typeC) {
				alert("第三级不能为空");
			} else if ("" == numBegin) {
				alert("开始数不能为空");
			} else if ("" == numEnd) {
				alert("结束数不能为空");
			} else {
				document.getElementById("myform").submit();
			}
		}
		function goback() {
			window.history.back(-1);
		}
	</script>
</body>
</html>