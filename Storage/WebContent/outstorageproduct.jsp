<%@page import="com.Modal.ProductPS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String s = (String)session.getAttribute("serialNum");%>
<%String t = (String)session.getAttribute("type");%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
				<span>新增進貨單</span><span class="crumb-step">&gt;</span>
				<span>確認進貨單</span><span class="crumb-step">&gt;</span>
				<span>新增品項</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="index.jsp" method="post" id="form1" name="form1">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr style="visibility: collapse">
							<td width="10%"></td>
							<td width="20%"></td>
							<td width="10%"></td>
							<td width="20%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
						</tr>
						<tr bgcolor="#9DD6FF">
							
							<th colspan="8"><span style="font-size: 20px;"><%=t%>單號  :  <%=s%></span></th>
							
							
						</tr>
						<tr>
							<th colspan="3" bgcolor="#FFBFBF">產品編號</th>
							<th colspan="3" bgcolor="#FFBFBF">序號</th>
							<th bgcolor="#FFBFBF">內含量</th>
							<th bgcolor="#FFBFBF"></th>
						</tr>
						<tr id="tr">
							<td colspan="3" bgcolor="#FFDEA1">
								
								<input class="common-text" name="productNum" style="width:80%"
								value="" type="text" id="productNum"></td>
							<td colspan="3" bgcolor="#FFDEA1"><input class="common-text" name="serialNum"
								 style="width:80%" value="" type="text" id="serialNum"></td>
							<td bgcolor="#FFDEA1"><input class="common-text" name="internalContent"
								 style="width:80%" value="0" type="text" id="internalContent"
								  oninput="value=value.replace(/[^\d]/g,'');if(value.length>7)value=value.slice(0,7)"></td>
							<td bgcolor="#FFDEA1">
								<input class="btn btn-primary btn6 mr10" value="送出" type="button" id="pout" name="pout" onclick="submitForm()">
								<!-- <input class="btn btn-primary btn6 mr10" value="送出" type="pout" id="pout" onclick="submitForm()"> -->
								</td>
						</tr>
						<c:forEach var="u" items="${porder}">
							<tr>
								<td bgcolor="#FEF5ED">${u.productNum}</td>
								<td colspan="2" bgcolor="#FEF5ED">${u.productSerialNum} [共  ${u.amount} 件]</td>
								<td colspan="4" bgcolor="#FEF5ED"></td>
								<td bgcolor="#FEF5ED">
									<input class="btn btn6 mr10"  value="移除" type="button" onclick="deleteproduct('確定要刪除嗎',  'ProductDel?id=${u.productSerialNum}')">
								</td>
							</tr>
						</c:forEach>
						<tr>
							<th colspan="8" bgcolor="#9DD6FF">
								<input class="btn btn-primary btn6 mr10" value="儲存" type="button" name="save" id="save" onclick="deleteproduct('確定要儲存嗎',  'productSave')">
							</th>
						</tr>
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

	function call(e,input)
	{
	    var code = (e.keyCode ? e.keyCode : e.which);
	 	    
	}
	
	function submitForm(){
		var pn = $("#productNum").val();
		var sn = $("#serialNum").val();
		var ic = $("#internalContent").val();
		
		   // 2.
	   	$.ajax({
		    url:'CheckProductStatus',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	productNum:pn, serialNum:sn, internalContent:ic//想要传输过去的数据 key：value，另一个页面通过 key接收value的值
		    },
		    timeout:5000,    //超时时间
		    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值
		    	// 1. 判断后台返回的值是true还是false
		    	if($("#productNum").val()==="" && $("#SerialNum").val()===""){
		            alert("請輸入產品編號與序號");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#serialNum").val()===""){
		        	alert("請輸入序號");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if($("#productNum").val()===""){
		        	alert("請輸入產品編號");
		            eval("document.form1['name'].focus()");
		            return false;
		        }else if(data === "true"){
		        	alert("輸入錯誤或產品不存在");
		        	return false;
		        }else{
		        	document.form1.submit();
		        }
		    }
	   	});
	}
	
	function deleteproduct(mess, url){
		if(confirm(mess)){
			location.href = url;
		}
	} 
	
	
   </script>
</html>