<%@page import="com.Modal.ProductPS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ProductPS pps = (ProductPS)session.getAttribute("PPS");
%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i>
			<a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
			<a class="crumb-name" href="productOAS.jsp">新增/修改 進貨單</a><span class="crumb-step">&gt;</span>
			<a class="crumb-name" href="modifyporderserch.jsp">查詢修改進貨單</a><span class="crumb-step">&gt;</span>
			<span>修改進貨單</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="PorderAdd" method="post" id="form1" name="form1">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr style="vivibility:hidden;">
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
							<th colspan="8" style="font-size:20px;" bgcolor="#FFDEA1">進口資料表 (修改)</th>
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
							<!-- 
							<td colspan="4"><input class="common-text required" id="companyOrderNum"
								name="companyOrderNum" size="50" value="" type="text"></td> -->
							<td colspan="4"><%=pps.getCompanyOrderNum() %></td>
						</tr>
						<tr>
							<th>提單號碼：</th>
							<td colspan="2"><input class="common-text" name="trackingNum" size="50"
								value="<%=pps.getTrackingNum() %>" type="text"></td>
							<th width="120"><i class="require-red">*</i>Invoice No：</th>
							<td colspan="4"><input class="common-text required" id="invoiceNo"
								name="invoiceNo" size="50" value="<%=pps.getInvoiceNo()%>" type="text"></td>
						</tr>
						<tr>
							<th>報單號碼：</th>
							<td colspan="2"><input class="common-text" name="orderNum" size="50"
								value="<%=pps.getOrderNum() %>" type="text"></td>
							<th width="120">匯率：</th>
							<td colspan="4"><input class="common-text required" id="exchangeRate"
								name="exchangeRate" size="50" value="<%=pps.getExchangeRate() %>" type="text" 
								onkeyup="value=value.replace(/[^\d.]/g,'')"></td>
						</tr>
						<tr>
							<th>離岸日期：</th>
							<td colspan="2"><input class="common-text" name="offshoreDate" size="50"
								value="<%=pps.getOffshoreDate() %>" type="text" placeholder="YYYYMMDD" 
								oninput="value=value.replace(/[^\d]/g,'');if(value.length>8)value=value.slice(0,8)"></td>
							<th width="120">到案日期：</th>
							<td colspan="4"><input class="common-text required" id="arrivalDate"
								name="arrivalDate" size="50" value="<%=pps.getArrivalDate() %>" 
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
						<tr>
							<td rowspan="3" colspan="8" >
								<input class="btn btn-primary btn6 mr10" value="提交" type="button" id="button"
								 onclick="checkInvoiceNO()"> 
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
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" >
	var productNum=$("#productNum");
		var productSerialNum=$("#productSerialNum");
		var stroaging=$("#stroaging");
		var internalContent=$("#internalContent");
   /* 	/servlet/Test2 */
   function checkInvoiceNO(){
	   if($("#invoiceNo").val()===""){
           alert("請正確填入公司訂單號碼");
           eval("document.form1['invoiceNo'].focus()");
           return false;
       }else{
    	   document.form1.submit();
       }
   }
   
   	
   
   	function add(){

   	   var  trZheh =document.createElement("tr");

   	    trZheh.id= new Date().getTime();
// 拼接参数
   	    //trZheh.innerHTML ="<br><tr><td>'"+productNum.val()+"'</td><td>2</td><td>3</td><td>4</td><td><input type="button" onclick="del(this)" value="刪除"></td></tr>";
   	    // 清空原有的数据
   	    productNum.val("");
   	 	productSerialNum.val("");
		internalContent.val("");
		var x = document.getElementsByName('stroaging');
		x[0].checked = false;
   	    document.getElementById("tr").append(trZheh);

   	} 

   	function del(Zheh ){
// ajax去后台删除
// 货物当前的元素下的
   	     var trid =Zheh.parentNode.parentNode.id;

   	      var trZheh =document.getElementById(trid);

   	      document.getElementById("tb").removeChild(trZheh);

   	}
   	
   
   
   </script>
</html>