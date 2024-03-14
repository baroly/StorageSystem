<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main-wrap">
	<div class="result-wrap">
		<div class="result-content">
			<form action="productadd.jsp" method="post">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr style="visibility: collapse;">
							<td width="5%"></td>
							<td width="10%"></td>
							<td width="15%"></td>
							<td width="20%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
							<td width="10%"></td>
						</tr>
						<tr>
							<th colspan="9" bgcolor="#9DD6FF">
							<span style="font-size: 20px;">入庫作業</span>
							</th>
						</tr>
						<tr>
							<th bgcolor="#FFBFBF"></th>
							<th bgcolor="#FFBFBF">出貨廠商</th>
							<th bgcolor="#FFBFBF">公司訂單號</th>
							<th bgcolor="#FFBFBF">Invoice No#</th>
							<th bgcolor="#FFBFBF">提單號碼</th>
							<th bgcolor="#FFBFBF">報單號碼</th>
							<th bgcolor="#FFBFBF">離岸日期</th>
							<th bgcolor="#FFBFBF">到岸日期</th>
							<th bgcolor="#FFBFBF">入庫日期</th>
						</tr>
						<c:forEach var="p" items="${Porder}">
							<tr>
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
</div>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" >
	
	function print(url){
		location.href = url;
	}
	
</script>
</html>