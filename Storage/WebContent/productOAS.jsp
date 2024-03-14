<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
				
				<span>新增/修改 進貨單</span>
		</div>
	</div>
	
	<div class="result-wrap">
		<div class="result-content">
			<form action="productadd.jsp" method="post">
				<table class="insert-tab" width="30%">
					<tbody>
						<tr>
							<td bgcolor="#FFDEA1">
								<input class="btn btn-primary btn9" value="新增進貨單" type="button" 
								onclick="go('GetVendorName')">
							</td>
							
						</tr>
						<tr>
							<td bgcolor="#FFDEA1">
								<input class="btn btn-primary btn9" value="修改/儲存 進貨單" type="button" 
								onclick="go('modifyporderserch.jsp')">
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
	function addOrder(){
	
	}
	function alter(){
		
	}
	function go(url){
		location.href = url;
	}
</script>
</html>