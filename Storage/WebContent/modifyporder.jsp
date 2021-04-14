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
				<!-- <span>新增進貨單</span><span class="crumb-step">&gt;</span> -->
				<!-- <span>確認進貨單</span><span class="crumb-step">&gt;</span> -->
				<span>庫存狀況查詢</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="serchproduct" method="post">
				<table class="insert-tab" width="50%">
					<tbody>
						<tr>
							<td bgcolor="FFF6CE">進貨單號查詢:<input class="common-text required" id="productName"
								name="productName" style="width:80%" value="" type="text"></td>
							
						</tr>
						<tr>
							<th bgcolor="FFF6CE">
								<input class="btn btn-primary btn6 mr10" value="查詢" type="submit" name="serch" id="serch">
							</th>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="PorderSNAdd" method="post" id="form1" name="form1">
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
							<th bgcolor="#FFBFBF">產品編號</th>
							<th bgcolor="#FFBFBF">序號</th>
							<th bgcolor="#FFBFBF">內含量</th>
							<th bgcolor="#FFBFBF">狀態</th>
							<th bgcolor="#FFBFBF">負責人</th>
						</tr>
						
						<c:forEach var="p" items="${Porder}">
							<tr align="center">
								<th bgcolor="#FEF5ED"><input class="btn btn5"  value="入庫" type="button" style="width:80%"
								 onclick="print('SelectPorder?id=${p.companyOrderNum}')"></th>
								<th bgcolor="#FEF5ED">${p.shipmentVendorName}</th>
								<th bgcolor="#FEF5ED">${p.companyOrderNum}</th>
								<th bgcolor="#FEF5ED">${p.invoiceNo}</th>
								<th bgcolor="#FEF5ED">${p.trackingNum}</th>
								<th bgcolor="#FEF5ED">${p.orderNum}</th>
								<th bgcolor="#FEF5ED">${p.offshoreDate}</th>
								<th bgcolor="#FEF5ED">${p.arrivalDate}</th>
								<th bgcolor="#FEF5ED">${p.storageTime}</th>
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
	
	
</script>
</html>