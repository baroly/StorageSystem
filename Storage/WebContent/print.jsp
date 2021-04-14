<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
<title>Print</title>
</head>
<body>
	<span style="width:100%;height:35px;float:left;text-align:center;">
		<input class="btn btn-primary btn6 mr10" type="button" value="列印" style="width:60px;s" onclick="javascript:window.print()">
	</span>
	<c:forEach var="p" items="${id}">
		<span style="width:50%;height:250px;float:left;text-align:center;">
		<h1>P/N</h1>
		<img src="<%=request.getContextPath() %>/barcode?msg=${p.productName}&barType=INTERLEAVED25&checkCharacter=n&checkCharacterInText=n" height="80px" width=260px/><br>
		
		<h1>S/N</h1>
		<img src="<%=request.getContextPath() %>/barcode?msg=${p.productSerialNum}&barType=INTERLEAVED25&checkCharacter=n&checkCharacterInText=n" height="80px" width=260px/>
		</span>
	</c:forEach>
</body>
</html>