<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
				<a href="otherwork.jsp">其他作業</a><span class="crumb-step">&gt;</span>
				<span>新增廠商</span>
		</div>
	</div>
	
	<div class="result-wrap">
		<div class="result-content">
			<form action="VendorCreat" method="post" id="form1" name="form1">
				<table class="insert-tab" width="50%">
					<tbody>
						<tr>
							<th bgcolor="#FFDEA1" style="font-size:20px;" colspan="2">
								新增廠商
							</th>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE" style="font-size:15px;">
								廠商名稱
							</th>
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="vendorName" style="width:80%"
								value="" type="text" id="vendorName">
							</td>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE">廠商負責人</th>
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="vendorPrincipal" style="width:80%"
								value="" type="text" id="vendorPrincipal">
							</td>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE">廠商ID</th>
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="vendorID" style="width:80%"
								value="" type="text" id="vendorID">
							</td>
						</tr>
						<tr>
						 	<td colspan="2" bgcolor="#FFF6CE">
								<input class="btn btn-primary btn6 mr10" name="button" id="button" type="button" value="提交" 
								 onclick="submitForm()"> 
								<input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
							</td>
						 </tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	

</div>
<!--/main-->
</div>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" >
	
	function print(){
		window.open("https://google.com/");
	} 

	function submitForm(){
		
		var d = "false";
		var c = $("#vendorName").val();
		var vn = $("#vendorName").val;
		   // 2.
	   	$.ajax({
		    url:'VenderJudgeName',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	vendorName:c//想要传输过去的数据 key：value，另一个页面通过 key接收value的值
		    },
		    timeout:5000,    //超时时间
		    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值
		    	// 1. 判断后台返回的值是true还是false
		    	if($("#vendorName").val()===""){
		            alert("請正確填入廠商名稱");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#vendorPrincipal").val()===""){
		        	alert("請正確填入廠商負責人");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#vendorID").val()===""){
		        	alert("請正確填入廠商ID");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if(data === "true"){
		        	alert("廠商已存在");
		        	return false;
		        }else{
		        	document.form1.submit();
		        }
		    }
	   	});
	}
	
	
</script>
</html>