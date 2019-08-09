<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/index_work.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("/fuguangtong-week1/xiala.do",function(arr){
			for (var i = 0; i < arr.length; i++) {
				$("#tid").append("<option value='"+arr[i].tid+"'>"+arr[i].tname+"</option>")
			}
		},"json");	
		//修改回显
		$.post("/fuguangtong-week1/show.do",{zid:$("input[name='zid']").val()},function(obj){
			$("input[name='zname']").val(obj.zname)
			$("textarea[name='zms']").val(obj.zms)
			$("#tid option[value='"+obj.type.tid+"']").attr("selected",true);
		},"json");
		$("input[value='返回']").click(function() {
			location.href="/fuguangtong-week1/list.do";
		})
	})
</script>
</head>
<body>
	<h1>欢迎来到查看页面</h1>
	<form>
		<table>
			<tr>
				<td>植物名称</td>
				<td>
					<input type="hidden" name="zid" value="${zid }">
					<input type="text" name="zname">
				</td>
			</tr>
			<tr>
				<td>描述</td>
				<td>
					<textarea rows="4" cols="30" name="zms">
					
					</textarea>
				</td>
			</tr>
			<tr>
				<td>类别</td>
				<td>
					<select name="type.tid" id="tid">
						<option value="">请选择</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="返回">	
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>