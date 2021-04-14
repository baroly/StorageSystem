<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span>
				
				<span>其他作業</span>
		</div>
	</div>
	
	<div class="result-wrap">
		<div class="result-content">
			
				<table class="insert-tab" width="30%">
					<tbody>
						<tr>
							<td bgcolor="#FFDEA1">
								<input class="btn btn-primary btn9" value="新增出庫單" type="button" 
								onclick="go('outstorages.jsp')">
							</td>
							
						</tr>
						<tr>
							<td bgcolor="#FFDEA1">
								<input class="btn btn-primary btn9" value="修改/儲存 出庫單" type="button" 
								onclick="go('')">
							</td>
						</tr>

					</tbody>
				</table>
			
		</div>
	</div>
	

</div>
<!--/main-->
</div>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" >
	function go(url){
		location.href = url;
	}
</script>
</html>