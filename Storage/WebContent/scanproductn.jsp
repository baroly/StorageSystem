<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String c = (String)session.getAttribute("id");%>
<%String t = (String)session.getAttribute("total");%>
<%String l = (String)session.getAttribute("less");%>
<%String d = (String)session.getAttribute("done");%>
<div class="main-wrap">
<div class="result-wrap">
		<div class="result-content">
			<form action="SelectProduct" method="post" id="form1" name="form1">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr style="visibility: collapse;">
							<td width="40%"></td>
							<td width="40%"></td>
							<td width="20%"></td>
						</tr>
						<tr>
							<th bgcolor="#FFDEA1" style="font-size:15px;">
								產品編號<br>
								<input class="common-text required" id="productNum"
									name="productNum" size="50" value="" type="text">
							</th>
							<th bgcolor="#FFDEA1" style="font-size:15px;">
								產品序號<br>
								<input class="common-text required" id="productSerialNum"
									name="productSerialNum" size="50" value="" type="text">
							</th>
							<td bgcolor="#FFDEA1"><input class="btn btn8 mr10" type="button" value="送出" 
							onclick="submitForm()"></td>
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
						<tr style="visibility: collapse;">
							<td width="10%"></td>
							<td width="20%"></td>
							<td width="40%"></td>
							<td width="15%"></td>
							<td width="15%"></td>
						</tr>
						<tr>
							<th colspan="2" bgcolor="#9DD6FF" style="font-size: 20px;text-align:left;">
								進貨單號 : <%=c%>
							</th>
							<th colspan="3" bgcolor="#9DD6FF" align="right" style="font-size: 20px;text-align:right;">
								總件數:<%=t%>件,已入庫件數:<%=d%>件,多進貨:C件,缺:<%=l%>件
							</th>
						</tr>
						<tr>
							<th bgcolor="#FFBFBF">序號</th>
							<th bgcolor="#FFBFBF">產品編號</th>
							<th bgcolor="#FFBFBF">產品序號</th>
							<th bgcolor="#FFBFBF">內含量</th>
							<th bgcolor="#FFBFBF">狀況</th>
						</tr>
						<c:forEach var="p" items="${product}">
							<tr>
								<th bgcolor="#FEF5ED">${p.serial}</th>
								<th bgcolor="#FEF5ED">${p.productName}</th>
								<th bgcolor="#FEF5ED">${p.productSerialNum}</th>
								<th bgcolor="#FEF5ED">${p.internalContent}</th>
								<th bgcolor="#FEF5ED">${p.status}</th>
							</tr>
						</c:forEach>
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
		var c = $("#productNum").val();
		var s = $("#productSerialNum").val();
		   // 2.
	   	$.ajax({
		    url:'ScanStored',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	productNum:c,
		    	productSerialNum:s //想要传输过去的数据 key：value，另一个页面通过 key接收value的值
		    },
		    timeout:5000,    //超时时间
		    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){//data是成功后，接收的返回值
		    	// 1. 判断后台返回的值是true还是false
		    	if(data === "true"){
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