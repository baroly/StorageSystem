<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Storage</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">後台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首頁</a></li>
                <li><a href="#" target="_blank">網站首頁</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#"></a></li>
                <li><a href="#"></a></li>
                <li><a href="#"></a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>選單</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="productOAS.jsp">進口資料輸入</a></li>
                        <li><a href="GetPorder">進貨單號條碼列印</a></li><!-- barcodePrint.jsp -->
                        <li><a href="GetPorderToScan">入庫作業</a></li><!-- productin.jsp -->
                        <li><a href="outstorageOAS.jsp">出庫作業</a></li><!-- productout.jsp -->
                        <li><a href="productserch.jsp">庫存狀況查詢</a></li><!-- productSerch.jsp -->
                        <li><a href="otherwork.jsp">其他作業</a></li><!-- otherAction.jsp -->
                        <!--  <li><a href="productout.jsp"><i class="icon-font">&#xe033;</i>广告管理</a></li>-->
                    </ul>
                </li>
                <!--  
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href=""><i class="icon-font">&#xe017;</i>系统设置</a></li>
                        <li><a href=""><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                        <li><a href=""><i class="icon-font">&#xe046;</i>数据备份</a></li>
                        <li><a href=""><i class="icon-font">&#xe045;</i>数据还原</a></li>
                    </ul>
                </li>-->
            </ul>
        </div>
    </div>