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
				<span>新增進貨單</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="POrderJudge" method="post" id="form1" name="form1">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr style="visibility: collapse;">
							<td width="10%"></td>
							<td width="20%"></td>
							<td width="20%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
						</tr>
						<tr>
							<th colspan="8" bgcolor="#FFDEA1">
							<span style="font-size: 20px;">進口資料表</span>
							</th>
						</tr>
						<tr>
							<th width="120">編號：</th>
							<!-- 
							<td colspan="2"><input class="common-text required" id="title"
								name="title" size="50" value="" type="text"></td>
							 -->
							 <td colspan="2">--</td>
							<!--  <td><select name="colId" id="catid" class="required">
									<option value="">请选择</option>
									<option value="19">精品界面</option>
									<option value="20">推荐界面</option>
							</select></td>-->
							<th width="120">輸入日期：</th>
							<td colspan="4">--</td>
							<!-- 
							<td colspan="2"><input class="common-text required"
								id="title" name="title" size="50" value="" type="text"></td>
							-->
						</tr>
						<tr>
							<th><i class="require-red">*</i>出貨廠商：</th>
							<td colspan="2">
								<select name="shipmentVendorName" id="shipmentVendorName" class="required">
									<c:forEach var="p" items="${VendorName}">
										
										<option value="${p}">${p}</option>
									
									</c:forEach>
								</select>
								<!-- <input class="common-text required" id="shipmentVendorName"
								name="shipmentVendorName" size="50" value="" type="text"> --></td>
							<th width="120"><i class="require-red">*</i>公司訂單號碼：</th>
							<td colspan="4"><input class="common-text required" id="companyOrderNum"
								name="companyOrderNum" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th>提單號碼：</th>
							<td colspan="2"><input class="common-text" name="trackingNum" size="50"
								value="" type="text"></td>
							<th width="120"><i class="require-red">*</i>Invoice No：</th>
							<td colspan="4"><input class="common-text required" id="invoiceNo"
								name="invoiceNo" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th>報單號碼：</th>
							<td colspan="2"><input class="common-text" name="orderNum" size="50"
								value="" type="text"></td>
							<th width="120">匯率：</th>
							<td colspan="4"><input class="common-text required" id="exchangeRate"
								name="exchangeRate" size="50" value="1" type="text" 
								onkeyup="value=value.replace(/[^\d.]/g,'')"></td>
						</tr>
						<tr>
							<th>離岸日期：</th>
							<td colspan="2"><input class="common-text" name="offshoreDate" size="50"
								value="" type="text" placeholder="YYYYMMDD" 
								oninput="value=value.replace(/[^\d]/g,'');if(value.length>8)value=value.slice(0,8)"></td>
							<th width="120">到案日期：</th>
							<td colspan="4"><input class="common-text required" id="arrivalDate"
								name="arrivalDate" size="50" value="" 
								type="text" placeholder="YYYYMMDD"
								oninput="value=value.replace(/[^\d]/g,'');if(value.length>8)value=value.slice(0,8)"></td>
						</tr>
						<tr>
							<th>列印條碼日期：</th>
							<!-- 
							<td colspan="2"><input class="common-text" name="author" size="50"
								value="" type="text"></td>
							 -->
							 <td colspan="2">--</td>
							<th width="120">入庫日期：</th>
							<!-- 
							<td colspan="2"><input class="common-text required" id="title"
								name="title" size="50" value="" type="text"></td>
							 -->
							 <td colspan="4">--</td>
						</tr>
						<tr>
							<th>處理狀況</th>
							<td  colspan="7">--</td>
						</tr>
						<!--  
						<tr>
							<th><i class="require-red">*</i>缩略图：</th>
							<td><input name="smallimg" id="" type="file"><input type="submit" onclick="submitForm('/jscss/admin/design/upload')" value="上传图片"/></td>
						</tr>
						<tr>
							<th>内容：</th>
							<td><textarea name="content" class="common-textarea"
									id="content" cols="30" style="width: 98%;" rows="10"></textarea></td>
						</tr>
						-->
						<!-- 
						<tr>
							<th bgcolor="#FFBFBF">產品編號</th>
							<th colspan="2" bgcolor="#FFBFBF">序號</th>
							<th bgcolor="#FFBFBF" colspan="3">內含量</th>
							<th bgcolor="#FFBFBF">庫存管制</th>
							<th bgcolor="#FFBFBF"></th>
						</tr>
						 -->
						 <tr>
						 	<td colspan="8">
								<input class="btn btn-primary btn6 mr10" name="button" id="button" type="button" value="提交" 
								onclick="submitForm()"> 
								<input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
								
								<!-- 
								<input class="btn btn-primary btn6 mr10" value="提交" type="button" onclick="check()">  
								-->
							</td>
						 </tr>
						 <!-- 
						<tr>
							<td><input class="common-text" name="author" size="14"
								value="" type="text"></td>
							<td colspan="2"><input class="common-text" name="author" size="50"
								value="" type="text"></td>
							<td colspan="3"><input class="common-text" name="author"
								size="20" value="" type="text"></td>
							<td>不入庫<input type="checkbox" name="stroaging"></td>
							<td><input class="btn btn-primary btn6 mr10" value="送出" type="submit"></td>
						</tr>
						 -->
						<!-- 
						<tr>
							<td rowspan="3" colspan="6" >
								<input class="btn btn-primary btn6 mr10" value="提交" type="submit"> 
								<input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
							</td>
						</tr>
						 -->

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
	function submitForm(){
		var d = "false";
		var c = $("#companyOrderNum").val();
		   // 2.
	   	$.ajax({
		    url:'porderNumJudge',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		        companyOrderNum:c//想要传输过去的数据 key：value，另一个页面通过 key接收value的值
		    },
		    timeout:5000,    //超时时间
		    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值invoiceNo
		    	// 1. 判断后台返回的值是true还是false
		    	if($("#companyOrderNum").val()===""){
		            alert("請正確填入公司訂單號碼");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#invoiceNo").val()===""){
		        	alert("請正確填入invoiceNo");
		            eval("document.form1['invoiceNo'].focus()");
		            return false;
		        }else if($("#shipmentVendorName").val()==="--"){
		        	alert("請選擇出貨廠商");
		            eval("document.form1['shipmentVendorName'].focus()");
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