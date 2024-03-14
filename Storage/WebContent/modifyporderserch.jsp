<%@page import="com.Modal.ProductPS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
			<a class="crumb-name" href="productOAS.jsp">新增/修改 進貨單</a><span class="crumb-step">&gt;</span>
				<!-- <span>新增/修改 進貨單</span><span class="crumb-step">&gt;</span> -->
				<!-- <span>確認進貨單</span><span class="crumb-step">&gt;</span> -->
				<span>查詢修改進貨單</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="GetPorderByName" method="post" id="form1" name="form1">
				<table class="insert-tab" width="50%">
					<tbody>
						<tr>
							<td bgcolor="FFF6CE">進貨單號查詢:<input class="common-tsext required" id="companyOrderNum"
								name="companyOrderNum" style="width:80%" value="" type="text"></td>
							
						</tr>
						<tr style="visibility: collapse;">
							<td bgcolor="#FFF6CE">
								<input class="common-text" name="productNamea" style="width:80%"
								value="" type="text" id="productNamea">
							</td>
						</tr>
						<tr>
							<th bgcolor="FFF6CE">
								<input class="btn btn-primary btn6 mr10" value="查詢" type="button"
								 name="serch" id="serch" onclick="submitForm()">
							</th>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="PorderSNAdd" method="post">
				<table class="insert-tab" width="50%">
					<tbody>
						<tr style="visibility: collapse">
							<td width="20%"></td>
							<td width="20%"></td>
							<td width="20%"></td>							
							<td width="20%"></td>
							<td width="20%"></td>
						</tr>
						
						<tr>
							<th bgcolor="#FFBFBF">進貨單號</th>
							<th bgcolor="#FFBFBF">廠商</th>
							<th bgcolor="#FFBFBF">填表日期</th>
							<th bgcolor="#FFBFBF"></th>
							<th bgcolor="#FFBFBF"></th>
						</tr>
						
						<c:forEach var="p" items="${Porder}">
							<tr align="center">
								<th bgcolor="#FEF5ED">${p.companyOrderNum}</th>
								<th bgcolor="#FEF5ED">${p.shipmentVendorName}</th>
								<th bgcolor="#FEF5ED">${p.fillingDate}</th>
								<th bgcolor="#FEF5ED"><input class="btn btn5"  value="修改" type="button" style="width:80%"
								 onclick="modifyOrder('確定要修改進貨單  ${p.companyOrderNum} ?', 'ModifyPorder?idm=${p.companyOrderNum}')"></th>
								 <th bgcolor="#FEF5ED"><input class="btn btn5"  value="刪除" type="button" style="width:80%"
								 onclick="deleteproduct('確定要刪除進貨單  ${p.companyOrderNum} ?', 'DelPorder?idd=${p.companyOrderNum}')"></th>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="productadd.jsp" method="post">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							
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
	
	function print(modify){
		window.open(url);
	} 
	
	function submitForm(){
		
		var d = "false";
		var c = $("#companyOrderNum").val();
		   // 2.
	   	$.ajax({
		    url:'PorderNumSerch',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	companyOrderNum:c//想要传输过去的数据 key：value，另一个页面通过 key接收value的值
		    },
		    timeout:5000,    //超时时间
		    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值
		    	// 1. 判断后台返回的值是true还是false
		    	if($("#companyOrderNum").val()===""){
		            alert("請正確填入廠商名稱");
		            eval("document.form1['companyOrderNum'].focus()");
		            return false;
		        }else if(data != "true"){
		        	alert("未找到進貨單號");
		            eval("document.form1['companyOrderNum'].focus()");
		            return false;
		        }else{
		        	document.form1.submit();
		        	
		        }
		    }
	   	});
	}
	
	function modifyOrder(mess, url){
		if(confirm(mess)){
			location.href = url;
		}
	}
	
	function deleteproduct(mess, url){
		if(confirm(mess)){
			location.href = url;
		}
	}
	
	
</script>
</html>