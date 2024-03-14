<%@page import="com.Modal.ProductPS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="result-wrap">
		<div class="result-content">
			<form action="PorderSNAdd" method="post" id="form1" name="form1">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							以下未建立
						</tr>
						
						<c:forEach var="e" items="${error}">
							<tr>
								<td bgcolor="#FEF5ED">${e}</td>
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
</html>