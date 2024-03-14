<%@page import="com.Modal.ProductPS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%ProductPS pps = (ProductPS)session.getAttribute("PPS");%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i>
			<a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
			<a class="crumb-name" href="productorderadd.jsp">新增進貨單</a><span class="crumb-step">&gt;</span>
			<span>新增品項</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="ProductOrderAdd" method="post">
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
							<th colspan="8" bgcolor="#FFDEA1">進口資料表</th>
						</tr>
						<tr>
							<th width="120"><i class="require-red">*</i>編號：</th>
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
							<th width="120"><i class="require-red">*</i>輸入日期：</th>
							<td colspan="4"><%=pps.getFillingDate() %></td>
							<!-- 
							<td colspan="2"><input class="common-text required"
								id="title" name="title" size="50" value="" type="text"></td>
							-->
						</tr>
						<tr>
							<th><i class="require-red">*</i>出貨廠商：</th>
							<td colspan="2"><%=pps.getShipmentVendorName() %></td>
							<th width="120"><i class="require-red">*</i>公司訂單號碼：</th>
							<td colspan="4"><%=pps.getCompanyOrderNum() %></td>
						</tr>
						<tr>
							<th>提單號碼：</th>
							<td colspan="2"><%=pps.getTrackingNum() %></td>
							<th width="120"><i class="require-red">*</i>Invoice No：</th>
							<td colspan="4"><%=pps.getInvoiceNo()%></td>
						</tr>
						<tr>
							<th>報單號碼：</th>
							<td colspan="2"><%=pps.getOrderNum() %></td>
							<th width="120"><i class="require-red">*</i>匯率：</th>
							<td colspan="4"><%=pps.getExchangeRate() %></td>
						</tr>
						<tr>
							<th>離岸日期：</th>
							<td colspan="2"><%=pps.getOffshoreDate() %></td>
							<th width="120"><i class="require-red">*</i>到案日期：</th>
							<td colspan="4"><%=pps.getArrivalDate() %></td>
						</tr>
						<tr>
							<th>列印條碼日期：</th>
							<!-- 
							<td colspan="2"><input class="common-text" name="author" size="50"
								value="" type="text"></td>
							 -->
							 <td colspan="2">--</td>
							<th width="120"><i class="require-red">*</i>入庫日期：</th>
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
							<th bgcolor="#FFBFBF">產品編號</th>
							<th colspan="2" bgcolor="#FFBFBF">序號</th>
							<th bgcolor="#FFBFBF" colspan="3">內含量</th>
							<th bgcolor="#FFBFBF">庫存管制</th>
							<th bgcolor="#FFBFBF"></th>
						</tr>
						<tr id="tr">
							<td><input class="common-text" name="productNum" size="14"
								value="" type="text" id="productNum"></td>
							<td colspan="2"><input class="common-text" name="productSerialNum" size="50"
								value="" type="text" id="productSerialNum"></td>
							<td colspan="3"><input class="common-text" name="internalContent"
								size="20" value="" type="text" id="internalContent"></td>
							<td>不入庫<input type="checkbox" name="stroaging" id="stroaging"></td>
							<td><input class="btn btn-primary btn6 mr10" value="送出" type="button" onclick="check()"></td>
						</tr>
					
						
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
							<td>
								<input class="btn btn-primary btn6 mr10" value="提交" type="submit"> 
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
   	function check(){

	   // 1.判断三个输入框是否都填写了
	   if(productNum.val() === null || productNum.val() ==="" ){
		   alert("");
		   return;
	   }
	   
	   // 2.
    	
   		$.ajax({
	    url:'productJudge',
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	        name:'yang',age:25//想要传输过去的数据 key：value，另一个页面通过 key接收value的值
	    },
	    timeout:5000,    //超时时间
	    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值
	    	// 1. 判断后台返回的值是true还是false
	    	if(data === "true"){
	    		alert("成功！");
	    		add();
	    	}else{
	    		alert("失败");
	    	}
	    	
	        $("#my-content").val(data);//将返回成功的值展示到input里
	    }
   	});
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