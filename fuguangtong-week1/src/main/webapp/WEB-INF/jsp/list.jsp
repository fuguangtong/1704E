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
		$("input[value='添加']").click(function(){
			location.href="/fuguangtong-week1/add.do";
		})
		//全选
		$("input[name='checkall']").click(function () {
			if($(this).is(":checked")){
				$("input[name='zid']").attr("checked",true)
			}else{
				$("input[name='zid']").attr("checked",false)
			}
		})
		//单删
		$("input[value='删除']").click(function(){
			var zid = $(this).prev().val();
			if(confirm("确定删除选择的内容吗")){
				
				$.post("/fuguangtong-week1/pldelete.do",{zid:zid},function(flag){
					if(flag){
						alert("删除成功");
						location.href="/fuguangtong-week1/list.do";
					}else{
						alert("删除失败")
					}
				},"json");
			}
		})
		//批量删除
		$("input[value='批量删除']").click(function() {
			var zid = "";
			$("input[name='zid']:checked").each(function(){
				zid+=","+$(this).val();
			})
			zid=zid.substring(1);
			if(zid.length>0){
				if(confirm("确定删除选择的内容吗")){
					
					$.post("/fuguangtong-week1/pldelete.do",{zid:zid},function(flag){
						if(flag){
							alert("删除成功");
							location.href="/fuguangtong-week1/list.do";
						}else{
							alert("删除失败")
						}
					},"json"); 
				}else{
					alert("取消删除成功");
				}
			}else{
				alert("至少选择一个进行删除");
			}
		})
		//修改
		$("input[value='修改']").click(function() {
			var zid =$(this).next().val();
			location.href="/fuguangtong-week1/update.do?zid="+zid;
		})
		//查看
		$("input[value='查看']").click(function() {
			var zid =$(this).next().next().val();
			location.href="/fuguangtong-week1/chakan.do?zid="+zid;
		})
	})
</script>
</head>
<body>
	<table>
		<tr>
			<td colspan="6">
				<form action="/fuguangtong-week1/list.do" method="post">
				<input type="button" value="添加">
					查询内容<input type="text" name="zname" value="${zname }">
					<input type="submit" value="搜索">
				</form>
			</td>
		</tr>
		<tr>
			<th>
				<input type="checkbox" name="checkall">全选
			</th>
			<th>序号</th>
			<th>植物名称</th>
			<th>描述</th>
			<th>类别</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${zlist }" var="z">
			<tr>
				<td>
					<input type="checkbox" name="zid" value="${z.zid }">
				</td>
				<td>${z.zid }</td>
				<td>${z.zname }</td>
				<td>${z.zms }</td>
				<td>${z.type.tname }</td>
				<td>
					<input type="button" value="查看">
					<input type="button" value="修改">
					<input type="hidden" value="${z.zid}">
					<input type="button" value="删除">
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="6">
					<input type="button" value="批量删除">
					 <a href="/fuguangtong-week1/list.do?pageNum=${plist.firstPage}">首页</a> 
					 <a href="/fuguangtong-week1/list.do?pageNum=${plist.prePage}">上一页</a> 
					 <a href="/fuguangtong-week1/list.do?pageNum=${plist.nextPage}">下一页</a> 
					 <a href="/fuguangtong-week1/list.do?pageNum=${plist.lastPage}">尾页</a> 
					 当前是第${plist.pageNum }/共${plist.pages }页
				</td>
			</tr>
	</table>
</body>
</html>