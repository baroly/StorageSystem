<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<div class="main-wrap">
<div class="result-wrap">
		<div class="result-content">
			<form action="OutOrderDetailAdd" method="post" id="form1" name="form1">
				<table class="insert-tab" width="50%">
					<tbody>
						<tr>
							<th bgcolor="#FFDEA1" style="font-size:20px;" colspan="2">
								新增出庫單
							</th>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE" style="font-size:15px;">
								出庫類別
							</th>
							<td bgcolor="#FFF6CE">
								<select name="outType" id="outType" class="required">
									<option value="出貨">出貨</option>
									<option value="內部借出">內部借出</option>
									<option value="外部借出">外部借出</option>
								</select>
								<!-- <input class="common-text" name="productName" style="width:80%"
								value="" type="text" id="productName"> -->
							</td>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE" style="font-size:15px;">
								出貨/借出單號 : 
							</th>
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="outSerialNum" style="width:80%"
								value="" type="text" id="outSerialNum">
							</td>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE" style="font-size:15px;">
								填表人 : 
							</th>
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="fillingName" style="width:80%"
								value="" type="text" id="fillingName">
							</td>
						</tr>
						<tr>
							<th bgcolor="#FFF6CE" style="font-size:15px;">
								客戶 : 
							</th>
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="client" style="width:80%"
								value="" type="text" id="client">
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
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" >
	
	function print(url){
		window.open(url);
	} 
	
	function submitForm(){
		var d = "false";
		var c = $("#outSerialNum").val();
		   // 2.
	   	$.ajax({
		    url:'OutStorageSerialNumJudge',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	outSerialNum:c//想要传输过去的数据 key：value，另一个页面通过 key接收value的值
		    },
		    timeout:5000,    //超时时间
		    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值
		    	// 1. 判断后台返回的值是true还是false
		    	if($("#outSerialNum").val()===""){
		            alert("請正確填入出貨/借出單號");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#fillingName").val()===""){
		        	alert("請正確填入填表人姓名");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#client").val()===""){
		        	alert("請正確填入客戶名稱");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if(data === "true"){
		        	alert("進貨單已存在");
		        	return false;
		        }else{
		        	document.form1.submit();
		        }
		    }
	   	});
	}
   </script>
</html>