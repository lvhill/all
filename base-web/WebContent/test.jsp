<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/tag/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>baseweb基础测试页面</title>
<script type="text/javascript" src="${webroot}/common/skin/js/jquery/jquery-1.11.1.js"></script>

<style type="text/css">
.formdata{
	height: 20px;
	float: left;
	width: 100%;
	margin-top: 5px;
}
.formdata i{
	font-size: 12px;
}
.formdata input{
	margin-top: 1px;
	margin-left: 5px;
	border: 1px solid #B3B3B3;
}
.formdata label{
	width: 70px;
	display: inline-block;
	text-align: right;
}

</style>
<script type="text/javascript">
	function query() {
		var url = "${webroot}/test/query";
		$.ajax({
			url : url,
			type : "post",
			dataType : "json",
			success : function(json) {
				var data = '';
				var obj = eval(json);
				$("#queryResult").empty();
				$(obj).each(function(index) {
					var val = obj[index];
					data += val.id+' ';
					data += val.name+' ';
					data += val.password;
					$("#queryResult").append("<p>"+data+"</p>");
					data = "";
				});
			},
		});
	}
	
	function deletById(){
		var url = "${webroot}/test/delete";
		var data = "id="+$("input[name='deletId']").val();
		$.ajax({
			url : url,
			data : data,
			type : "post",
			success : function(msg) {
				if(msg=="success"){
					alert("删除成功!");
				}else{
					alert("删除失败!");
				}
			}
		});
	}
	
	function insert(){
		var url = "${webroot}/test/insert";
		var data = "name="+$("input[name='name']").val()+"&password="+$("input[name='password']").val();
		$.ajax({
			url : url,
			data : data,
			type : "post",
			success : function(msg) {
				if(msg=="success"){
					alert("插入成功!");
				}else{
					alert("插入失败!");
				}
			}
		});
	}
	function jsonInsert(){
		var url = "${webroot}/test/jsonInsert";
		var name = $("input[name='jsonname']").val();
		var password = $("input[name='jsonpassword']").val();
		var data = "{'name':'"+name+"','password':'"+password+"'}";
		$.ajax({
			url : url,
			data : data,
			contentType:"application/json;charset=UTF-8",
			type : "post",
			success : function(msg) {
				if(msg=="success"){
					alert("插入成功!");
				}else{
					alert("插入失败!");
				}
			}
		});
	}
	
	function jsonStreamInsert(){
		var url = "${webroot}/test/jsonStreamInsert";
		var name = $("input[name='jsonstreamname']").val();
		var password = $("input[name='jsonstreampassword']").val();
		var data = "{'name':'"+name+"','password':'"+password+"'}";
		$.ajax({
			url : url,
			data : data,
			contentType:"application/json;charset=UTF-8",
			type : "post",
			success : function(msg) {
				if(msg=="success"){
					alert("插入成功!");
				}else{
					alert("插入失败!");
				}
			}
		});
	}
	$(function() {
		verifyCode();
	});
	function verifyCode() {
		var verifyCode = $("#verifyCode");
		verifyCode.onblur = function() {
			checkVerifyCode();
		}
		//
		var verifyCodeImg = $("#verifyCodeImg");
		verifyCodeImg.attr('src', "${webroot}/verify/verifyCode?random=" + Math.random());
		verifyCodeImg.attr("title", "点击换一张");
		verifyCodeImg.click(function() {//刷新验证码
			verifyCodeImg.attr('src', "${webroot}/verify/verifyCode?random=" + Math.random());
		});
	}

	function checkVerifyCode() {
		var url = "${webroot}/verify/checkVerifyCode";
		var data = "&verifyCode=" + $("#verifyCode").val();
		//
		$.ajax({
			type : "POST",
			url : url,
			data : data,
			async : false,
			success : function(msg) {
				if (msg.indexOf("success") != -1) {
					alert("验证码正确!");
					return;
				} else {
					alert("验证码错误!");
					return;
				}
			}
		});
	}
</script>

</head>
<body>
	<div style="float: left;width: 300px;height: 200px;margin: 10px;padding:0px 10px;;border: 1px solid;">
		<label style="float: left;display: block;margin: 5px auto;width: 100%; border-bottom: 1px solid;">
			查询test表:
			<button style="margin: 5px;" onclick="query()">查询</button>
		</label>
		<div id="queryResult" style="float: left;"></div>
	</div>
	<div style="float: left;width: 300px;height: 200px;margin: 10px;padding:0px 10px;;border: 1px solid;">
		<label style="float: left;display: block;margin: 5px auto;width: 100%; border-bottom: 1px solid;">
			删除test表:
			<button style="margin: 5px;" onclick="deletById()">删除</button>
		</label>
		<p class="formdata" style="margin-top: 20px;"><label>id:</label><input type="text" name = "deletId"></p>
	</div>
	<div style="float: left;width: 300px;height: 200px;margin: 10px;padding:0px 10px;;border: 1px solid;">
		<label style="float: left;display: block;margin: 5px auto;width: 100%; border-bottom: 1px solid;">
			插入test表:
			<button style="margin: 5px;" onclick="insert()">插入</button>
		</label>
		<p class="formdata"><label>id:</label><i>系统自动生成</i></p>
		<p class="formdata"><label>name:</label><input type="text" name = "name"></p>
		<p class="formdata"><label>password:</label><input type="text" name = "password"></p>
	</div>
	<div style="float: left;width: 300px;height: 200px;margin: 10px;padding:0px 10px;;border: 1px solid;">
		<label style="float: left;display: block;margin: 5px auto;width: 100%; border-bottom: 1px solid;">
			插入test表(将数据封装成json发送到后台):
			<button style="margin: 5px;" onclick="jsonInsert()">插入</button>
		</label>
		<p class="formdata"><label>id:</label><i>系统自动生成</i></p>
		<p class="formdata"><label>name:</label><input type="text" name = "jsonname"></p>
		<p class="formdata"><label>password:</label><input type="text" name = "jsonpassword"></p>
	</div>
	<div style="float: left;width: 300px;height: 200px;margin: 10px;padding:0px 10px;;border: 1px solid;">
		<label style="float: left;display: block;margin: 5px auto;width: 100%; border-bottom: 1px solid;">
			插入test表(将数据封装成json发送到后台,后台再读取报文解析json):
			<button style="margin: 5px;" onclick="jsonStreamInsert()">插入</button>
		</label>
		<p class="formdata"><label>id:</label><i>系统自动生成</i></p>
		<p class="formdata"><label>name:</label><input type="text" name = "jsonstreamname"></p>
		<p class="formdata"><label>password:</label><input type="text" name = "jsonstreampassword"></p>
	</div>
	<div style="float: left;width: 300px;height: 200px;margin: 10px;padding:0px 10px;;border: 1px solid;">
		<label style="float: left;display: block;margin: 5px auto;width: 100%; border-bottom: 1px solid;">
			验证码:<button style="margin: 8px;" onclick="checkVerifyCode()">验证</button>
		</label>
		<p class="formdata" style="margin-top: 30px;">
			<label style="float: left;text-align:left;">验证码:</label>
			<input id="verifyCode" style="width: 70px;float: left;margin-right: 10px;" type="text" name = "verifyCode">
			<img id="verifyCodeImg" style="margin-top: -5px;float: left;">
		</p>
	</div>
	
</body>
</html>