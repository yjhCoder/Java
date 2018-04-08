<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Calendar.js"></script>
	
<script type="text/javascript">
	function getGender(){
		//得到性别
		var gender = "${staff.gender }";
		var genders = document.getElementsByName("gender");
		//进行判断 如果是男  第一个input 打上select
		if(gender=="男"){
			genders[0].checked = "checked";
		}
		if(gender=="女"){
			genders[1].checked = "checked";
		}
	}
	
	function getPostId(){
		//获取postId  postId
		var postid = "${staff.postid}";
		var select = document.getElementById("postSelectId");
		for(var i=0;i<select.options.length;i++){
			if(select.options[i].value==postid){
				select.options[i].selected=true;
			}
		}
		
	}
	
	function getDepId(){
		//通过ajax  用postid 查找  修改 部门
		var postid = "${staff.postid}";
		$.ajax({
		url:'${pageContext.request.contextPath}/post/findById.do?postid='+postid,
		type:'POST',	
		success:
			//设置回调函数
			function(post){
				var departementid = post.depid;
				var select = document.getElementById("depSelectId");
				for(var i=0;i<select.options.length;i++){
					if(select.options[i].value==departementid){
						select.options[i].selected=true;
					}
				}

			}
	});
	}
	
	
	function changePost(obj){
		//获得选中部门
		var depId = obj.value;
		//ajax 传pojo  返回json 
		$.ajax({
			url:'${pageContext.request.contextPath}/department/findById.do',
			type:'POST',	
			data:'depid='+depId,   //传一个pojo
			success:
				//设置回调函数
				function(department){
					//返回一个部门  包含了一个postSet
					var postSet = department.postSet;
					var postSelectElement = document.getElementById("postSelectId");
					postSelectElement.innerHTML ="<option value=''>--请选择职务--</option>";
					for (var index in postSet){
						var postObj = postSet[index];
						var postId = postObj.postid;
						var postName = postObj.postname;
						postSelectElement.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
					}
					
				}
		});
	}

	window.onload=function(){
		 getGender();
		 getDepId();
		 getPostId();
		 
	}
</script>
</head>

<body class="emp_body">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td class="topg"></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="0" class="wukuang"
		width="100%">
		<tr>
			<td width="1%"><img
				src="${pageContext.request.contextPath}/images/tleft.gif" /></td>
			<td width="44%" align="left">[员工管理]</td>

			<td width="52%" align="right">
				<!-- 提交表单 --> <a href="javascript:void(0)"
				onclick="document.forms[0].submit()"> <img
					src="${pageContext.request.contextPath}/images/button/save.gif" />
			</a> <!-- 执行js，进行返回 --> <a href="javascript:void(0)"
				onclick="window.history.go(-1)"><img
					src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>

			</td>
			<td width="3%" align="right"><img
				src="${pageContext.request.contextPath}/images/tright.gif" /></td>
		</tr>
	</table>

	<form action="${pageContext.request.contextPath}/staff/update.do" method="post">

		<input type="hidden" name="staffid" value="${staff.staffid }" />

		<table width="88%" border="0" class="emp_table" style="width: 80%;">
			<tr>
				<td>登录名：</td>
				<td><input type="text" name="loginname"
					value="${staff.loginname }" /></td>
				<td>密码：</td>
				<td><input type="password" name="loginpwd"
					value="${staff.loginpwd }" /></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="staffname"
					value="${staff.staffname }" /></td>
				<td>性别：</td>
				<td><input type="radio" id="manSelecet" name="gender"
					 value="男" />男 <input type="radio"
					id="womenSelecet" name="gender" value="女" />女</td>
			</tr>
			<tr>
				<td width="10%">所属部门：</td>
				<td width="20%"><select name="post.depid"
					id="depSelectId"
					onclick="changePost(this)">
						<option value="">----请--选--择----</option>
						<option value="2c9091c14c78e58b014c78e67de10001"
							>java学院</option>
						<option value="2c9091c14c78e58b014c78e68ded0002">咨询部</option>
				</select></td>
				<td width="8%">职务：</td>
				<td width="62%"><select name="postid" id="postSelectId">
						<option value="">----请--选--择----</option>
						<option hidden="true" value="2c9091c14c78e58b014c78e6b34a0003">总监</option>
						<option hidden="true" value="2c9091c14c78e58b014c78e6d4510004">讲师</option>
						<option hidden="true" value="2c9091c14c78e58b014c78e6f2340005">主管</option>
				</select></td>
			</tr>
			<tr>
				<td width="10%">入职时间：</td>
				<td width="20%">
					<fmt:formatDate var="patternDate" value="${staff.ondutydate}" pattern="yyyy-MM-dd"/>
					<input type="text" name="ondutydate"
						value="${patternDate}" readonly="readonly"
						onfocus="c.showMoreDay=true; c.show(this);" />
				</td>
				<td width="8%"></td>
				<td width="62%"></td>
			</tr>
		</table>
	</form>

</body>
</html>
